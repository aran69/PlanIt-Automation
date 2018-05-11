Contents:
	.The Java project structure
		|	.TestRunner.
		|	.StepDefinition.
		|	.Actionwords.
		|	.Feature files.
	.Dependencies
	.Hiptest scenarios to automation, and sets of test data
	.To sum up
	.Contact me if you think I can be of assistance!


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

TestRunner:

-The file to run with Junit
-Runs all the other files in the project together
-Searches through all the folders and files in the "Feature Files" folder, and runs the steps in every file with a '.feature' suffix

@CucumberOptions() defines where the Feature files (the scenarios/instructions)
and step definitions (translation of feature file instructions into webdriver commands) are located.
Optionally ",dryrun = true" can be left in to check all the feature file steps have all their
 corresponding definitions.

Another optional line under @CucumberOptions() is ,dryRun = true
ive left this commented out in a single line comment, but you can uncomment this line to perform a "dry run" with junit, which will run the code without launching the 
webdriver, handy way to check everything is working.

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


StepDefinition:

-This file contains instructions for each step in the feature files, for example...

if there is a step in the feature files:
		"

		* See Purchase Order Records in View
							"

then there must be a corresponding step definition:
		"

		@Given("^See Purchase Order Records in View$")
				public void see_Purchase_Order_Records_in_View() {
	    			// Write in webdriver instructions here
			}
									"

IMPORTANT NOTE: If theres a step in the executed feature files that doesnt have a corresponding step definition, then the console will output a boilerplate that you
can copy into the step definition file, e.g:
	
	"
		You can implement missing steps with the snippets below:

		@Given("^See Purchase Order Records in View$")
			public void see_Purchase_Order_Records_in_View() {
		    		// Write code here that turns the phrase above into concrete actions
		   		 throw new PendingException();
			}
									"

-This file holds the WebDriver that performs actions in FireFox under the variable "driver"
to call the WebDriver to do some action in this file (i.e in the step definition) the code will be:
	"
		driver.findElement(/*element finding method*/).click();
										"

calling the driver from outside of this file (in Actionwords) then you must call the StepDefinition file in the code:
	"
		StepDefinitions.driver.findElement(/*element finding method*/).click();
											"

For the stepdefinion of the first step of every feature file ("Logon to PlanIT"), theres an if/else statement that checks if 
there's already an instance of the webDriver running, it looks like this:

		"    @Given("^Logon to PlanIT$")
		    public void logonToPlanIT() {
		    	if(driver==null){
		    		actionwords.logonToPlanIT();
		    	}
		    	else{
		    		driver.navigate().refresh();
		    	}
		    }						"

If theres already an instance of the webDriver open, then instruct the webDriver to refresh the page (this brings the browser back to
the dashboard tab and closes all dropdown menus in the side tab which is just handy for a couple of step definitions)
If theres no instance of a webDriver open then a method is called from Actionwords (which I'll go into more detail in a minute) like so:

"
public void logonToPlanIT() {
    	System.setProperty("webdriver.gecko.driver", "C:\\Users\\Aran\\Desktop\\work\\FeatureIT\\geckodriver\\geckodriver.exe");
		System.out.println("Driver is currently: "+StepDefinitions.driver);
		StepDefinitions.driver = new FirefoxDriver();
		StepDefinitions.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		StepDefinitions.driver.get("https://authtest.featureit.co.nz/auth/realms/planit_test/protocol/openid-connect/auth?client_id=planitv2&redirect_uri=https%3A%2F%2Fplanittest.featureit.co.nz%2F%23%2F&state=5334ee20-9cdc-469f-9fd3-4aa7876fb958&nonce=ee01cea6-afa7-46c3-b998-343c64e00cce&response_mode=query&response_type=code&scope=openid");
		StepDefinitions.driver.findElement(By.id("username")).sendKeys("administrator");
		StepDefinitions.driver.findElement(By.id("password")).sendKeys("gZv2VhT");
		StepDefinitions.driver.findElement(By.id("kc-login")).click();
    }
"

This prints out current status of the driver (always null since the step definition statement required it to be to execute this method, just a leftover from earlier testing)
It then initiates a new instance of FirefoxDriver, gives it a waiting time to terminate if theres an issue, it then gives a string of webDriver commands to open PlanIT,
 and log in as administrator.

other methods in the Actionwords file can be called by typing "actionwords.someMethod();", this saves a bit of time as some steps require actions that are
 repeated across other steps (e.g clicking "Connected data" to dropdown the menu to access different tabs occurs in all scenarios under "connected data").

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


Actionwords:

-This file contains actions that are repeated across different scenario steps so you can just call it each time in stepdefitions instead of typing the action out again
-Keeping them in a different file basically just keeps these 'actions' being  jumbled up with the stepDefinitions
-thats it really
-kept in same package as StepDefinitions

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

Feature Files:

-These are the files exported from the PlanIT's hiptest repository, they use the gherkin syntax which is plainly typed for the most part
-Each file is essentially just a list of pointers to the glue file's (Step Defitions) methods.
-Some files will contain datatables that are formatted like so:
	|parameter1|parameter2|parameter3| 	//first row is the names of the variable being passed
	|bash|zip|bang|				//all following rows contain a set of test parametre data
	|bosh|zoom|pow|				//etc.
The inclusion of a datatable will change the title tag of a scenario from "SCENARIO:" to "SCENARIO OUTLINE:" and will run said scenario multiple times, 
once for each set of data included

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

Dependencies:

Youll need the following libraries in the project's java buildpath (located under properties when you right click it in the dev environment of your choice):

cucumber-core
cucumber-java
cucumber-junit
cucumber-jvm-deps
cucumber-reporting
gherkin
junit
mockito-all
cobertura

The latest edition .jars of which can be searched and downloaded at https://search.maven.org.

You can also just download it by setting this project up as a maven project but im not wise enough for that yet :P

You'll also need the .jars for selenium webdriver which you can find in this link's file https://goo.gl/Us5DnZ
You can also just locate it from selenium's website https://www.seleniumhq.org/download/ beside "Java	3.11.0	2018-03-11" 
Personally I'm awful at dependencies and libraries and I'm sure yous know a better way to manage them all (like using maven) so sorry if this section is a bit wonky :(

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

Hiptest scenarios to automation, and sets of test data:

So, to get the scenarios from the hiptest website to the automation script follow these steps:
-in hiptest, while in the PlanIT project, select the 'Automation' tab on the side panel, select cucumber/java, this will download a zip folder called project_export, 
it contains every scenario on the project written in .feature format. Drag and drop the .feature files or folders of feature files into the "Feature" folder in 
the java automation project. When running the junit test on the testrunner class it will read through all scenarios (including ones inside folders) in the "Feature" 
folder.

Note: Editing/creating new scenarios in hiptest will require you to re-download the zip file and repeat the process but the zip file takes seconds to download so
thats alright i guess.

Depending on how thorough you are with integration testing going forward you may want to run scenarios with multiple inputs (i.e entering different inputs to forms
like 'create new route' etc.).
The the cucumber methods can do this but the feature file output has to be tailored for it, this can be done directly from hiptest:
	
	-In a scenario you want to pass multiple sets of parametres, open the datatable for that scenario in hiptest (dropdown tab just above the scenario steps)
	-The first row is the column titles, the name for the args that will be passed in the java project, you can add new rows with the '+' icon to the right of the title row
	-once you have the args titled appropriately (task_code, task_name etc.) you can fill in a set of data in each cell of the following rows
	-you can add a new dataset row using the 'Add new dataset' button below the datatable
	
	-once youve filled out the datatable enter the step definition you want to use the dataset with
	-the syntax for entering an arg is: Fill form fields with "task_code" "task_name" "etc."
	-the step can be written with plain text but the ar must be in double quotation marks with the "appropriate_datable_column_title"
	-make sure you click the "create action word button" for the step to be saved correctly
	-if done correctly the args should be displayed in the scenario step like:	'Fill form fields with
												=task_code
												=task_name
												=etc.            '

A working example of this scenario outline is on hiptest, F7.9 : Settings : Tasks : PlanIT > create Task : Create a Task

Once the scenario is exported from hiptest following the steps at the top of this section, the corresponding feature file will have the args and datatable syntax 
included in the file the java project will run that scenario multiple times with the different sets of data.


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


To sum up:

Okay, so I learned most of this stuff from a slightly outdated but nonetheless useful resource called toolsqa, heres the link: 

				http://toolsqa.com/cucumber/test-driven-development-tdd/

You have to pick through a bit of outdated stuff, but if you prefer this stuff explained in a more professional way instead of reading through a second year undergrad's 
readme file then I'd highly reccomend it.

Obviously getting this project to run smoothly along with the development process would require a good bit of tweaking, its far from being able to automate EVERY
scenario on hiptest at the moment, partially because most of the scenario steps werent written for the express purpose of automation (arguably a lot of redundant steps
and most of the form based scenarios dont have datatables and argument steps included), but mostly because the majority of every different step written in hiptest has
to have a unique webdriver command to have it function properly, hence why theres that handy actionwords file full of methods you can call in different steps to 
minimise retyping the same webdriver commands over and over again.


Improvements that can be made going forward:

 ̶O̶n̶e̶ ̶o̶p̶t̶i̶o̶n̶ ̶w̶o̶u̶l̶d̶ ̶b̶e̶ ̶t̶o̶ ̶r̶e̶-̶w̶r̶i̶t̶e̶ ̶a̶l̶l̶ ̶t̶h̶e̶ ̶s̶c̶e̶n̶a̶r̶i̶o̶s̶ ̶t̶o̶ ̶m̶o̶r̶e̶ ̶e̶a̶s̶i̶l̶y̶ ̶w̶r̶i̶t̶e̶ ̶s̶t̶e̶p̶d̶e̶f̶i̶n̶i̶t̶i̶o̶n̶s̶ ̶b̶u̶t̶ ̶I̶ ̶g̶e̶t̶ ̶t̶h̶e̶ ̶f̶e̶e̶l̶i̶n̶g̶ ̶n̶o̶ ̶o̶n̶e̶ ̶h̶a̶s̶ ̶t̶i̶m̶e̶ ̶f̶o̶r̶ ̶t̶h̶a̶t̶ ̶s̶o̶ ̶l̶e̶t̶s̶ ̶p̶r̶e̶t̶e̶n̶d̶ ̶I̶ ̶d̶i̶d̶n̶t̶ ̶s̶u̶g̶g̶e̶s̶t̶
̶t̶h̶a̶t̶.̶

 Obviously writing in webdriver commands for all of the step definitions would make it run smooth as raw meringue and integration test all the scenarios, could take a 
while though.

Re-purposing the code in the java project into a maven project would make handling the dependencies a lot easier and integrating it with development a lot easier (but 
I have no idea how to work with maven formatted projects yet so...), but it would also make the next imporvement easier:

Kane noticed a feature on hiptest that allows continuous automation but it require ruby-on-rails which scares me (Have i mentioned I'm an undergrad and my lecturers
have yet to teach me the basics of C/C#/C++ ?), also it involves bash commands and im not sure if anyone in the office has linux handy, but it seems like the optimal
way to integrate automation to the development cycle.



Guys, I feel like I havent contributed a bunch over the weeks I've been here, but it was great to have a goal I could work towards and gain knowledge to achieve.
Whats more is that this thing DOES work, if you're curious just open the folder this text file is in as a java project in your dev environment, get the dependnecies
added to the java build path, and junit test the testrunner class with just the scenario F7.9, you can find it in exported_features\features\Settings\Operations_Settings\ 
inside the exported_features file from hiptest automation tab (just delete scenarios F7.6-F7.8 and F7.10 inside the feature file with a text editor, im not sure if I 
filled all the step definitions for the others in that set of scenarios), just make sure you have firefox installed as thats the browser I wrote it for.


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

Contact me if you think I can be of assistance!:

At the end of the day, I would be thrilled to hear if any of my work gets put to good use or even just gives the PlanIT project a boost in the right direction by proxy,
I won't lose sleep over it if it goes unused, I came for the experience, and I leave with that experience and knowledge secured, and I'm happy to say that much at least.
That being said Kane seemed to be sinking his teeth right into it so who knows, something might come of that.

If you need to contact me clarifying any of this stuff:

Email me at aran.smeallie@gmail.com with a message title "FeatureIT Your Name: title e.g 'Send Help Pls' "

I check my emails semi-regularly but you can grab my attention faster if you have a twitter and tweet at me @TheJammyFuckr (excuse the profanity but that Fuckr with no 'e')  

And sure add me on facebook if you like, 'Aran Smeallie' my profile pic is a cartoony character with sunglasses.

And thats it. 
It's been a pleasure working with you all, I wish the best to all of you where ever yous go from here.
Take it easy.
-Aran

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


ALL CODE IN THIS PROJECT AND THE TEXT IN THIS README FILE WAS COMPOSED BY ARAN SMEALLIE, I EXTEND PERMISSION FOR IT TO BE USED BY "FeatureIT" 
AND ALL ITS CURRENT STAFF AS OF 09/05/2018 FOR ENTERPRISING AND PERSONAL USE.