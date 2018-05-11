package step_definitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Keys;

public class Actionwords {
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


	public void go_to_Operations_menu(){
			StepDefinitions.driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[4]/div/span/strong")).click();
	}
	
	
	
	public void select_Add_A(){
		StepDefinitions.driver.findElement(By.xpath("/html/body/div/div[1]/div/main/div/div[2]/div[1]/div[1]/div/a/button")).click();
	}

	public void select_Add_B(){
		StepDefinitions.driver.findElement(By.xpath("/html/body/div/div[1]/div/main/div/div[1]/div[1]/div/a/button")).click();
	}
	
	public void fields_are_editable(){
		
	}
	
	public void select_Save(){
		StepDefinitions.driver.findElement(By.xpath("/html/body/div/div[1]/div/main/div/div[2]/div[2]/div/button[1]")).click();
	}

	public void new_x_is_created(){
		
	}
	
	//***********************EXPERIMENTAL METHODS FOR FORMS PAST THIS POINT, MAY NOT BE UNIVERSAL TO SITE**************
	
	public void codeIn(String in){
		StepDefinitions.driver.findElement(By.xpath("//*[@id='route-code']")).sendKeys(in);
	}
	
	public void nameIn(String in){
		StepDefinitions.driver.findElement(By.xpath("//*[@id='route-name']")).sendKeys(in);
	}
	
	public void productIn(String in){
		StepDefinitions.driver.findElement(By.xpath("//*[@id='ProductPicker']")).click();
		StepDefinitions.driver.findElement(By.xpath("//*[contains(text(), '"+in+"')]")).click();
	}
	
	public void statusIn(String in){
		StepDefinitions.driver.findElement(By.xpath("//*[@id='status']")).click();
		StepDefinitions.driver.findElement(By.xpath("//*[contains(text(), '"+in+"')]")).click();
	}
	
	public void sequenceIn(String in){
		StepDefinitions.driver.findElement(By.xpath("/html/body/div/div[1]/div/main/div/table/tbody/tr/td[1]/div/input[1]")).sendKeys(in);
	}
	
	public void opIn(String in){
		StepDefinitions.driver.findElement(By.xpath("/html/body/div/div[1]/div/main/div/table/tbody/tr/td[2]/div/div[1]/div[2]")).click();
		StepDefinitions.driver.findElement(By.xpath("//*[contains(text(), '"+in+"')]")).click();
	}
	
	public void op_quantIn(String in){
		StepDefinitions.driver.findElement(By.xpath("/html/body/div/div[1]/div/main/div/table/tbody/tr/td[3]/div/input[1]")).sendKeys(in);
	}


	public void tcodeIn(String in) {
		StepDefinitions.driver.findElement(By.xpath("//*[@id='task-code']")).sendKeys(in);
	}


	public void tnameIn(String in) {
		StepDefinitions.driver.findElement(By.xpath("//*[@id='task-name']")).sendKeys(in);
	}


	public void tunitIn(String in) {
		StepDefinitions.driver.findElement(By.xpath("//*[@id='task-time-unit']")).click();
		StepDefinitions.driver.findElement(By.xpath("//*[contains(text(), '"+in+"')]")).click();
	}

	public void tdurationIn(String in) {
		StepDefinitions.driver.findElement(By.xpath("//*[@id='task-time-duration']")).sendKeys(in);
	}
	
	public void resourceIn(String in){
		StepDefinitions.driver.findElement(By.xpath("/html/body/div/div[1]/div/main/div/table/tbody/tr/td[1]/div/div[1]/div[2]")).click();
		StepDefinitions.driver.findElement(By.xpath("//*[contains(text(), '"+in+"')]")).click();
	}
	
	public void resourceTimeQuantIn(String in){
		StepDefinitions.driver.findElement(By.cssSelector("#__BVID__134")).sendKeys(in);
	}


	public void go_to_connected_data() {
		StepDefinitions.driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div[6]/div/span/strong")).click();
	}


	public void sortColumns() {
		StepDefinitions.driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/main/div/div[2]/table/thead/tr/th[2]")).click();
		StepDefinitions.driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/main/div/div[2]/table/thead/tr/th[3]")).click();
		StepDefinitions.driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/main/div/div[2]/table/thead/tr/th[4]")).click();
		StepDefinitions.driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/main/div/div[2]/table/thead/tr/th[5]")).click();
		
	}
	
}