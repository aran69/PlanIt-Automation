package step_definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class StepDefinitions {
public Actionwords actionwords = new Actionwords();
    
    static WebDriver driver;
    public static String data;
    
    @Given("^Logon to PlanIT$")
    public void logonToPlanIT() {
    	if(driver==null){
    		actionwords.logonToPlanIT();
    	}
    	else{
    		driver.navigate().refresh();
    	}
    }

	@Given("^Go to Operations menu - Route$")
	public void go_to_Operations_menu_Route() {
	    actionwords.go_to_Operations_menu();
		driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[4]/div/div/ul/li[1]/a")).click();
	}

	@Given("^Select \\+Add$")
	public void select_Add() {
		actionwords.select_Add_B();
	}
	
	@Given("^Select \\+Add route$")
	public void select_Add_route(){
		actionwords.select_Add_A();
	}
	
	@Given("^Route fields are editable$")
	public void route_fields_are_editable() {
		actionwords.fields_are_editable();
	}

	@When("^User enters data \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
	public void user_enters_data(String code, String name, String product, String status, String sequence, String op, String op_quant) {
	    actionwords.codeIn(code);
	    actionwords.nameIn(name);
	    actionwords.productIn(product);
	    actionwords.statusIn(status);
	    actionwords.sequenceIn(sequence);
	    actionwords.opIn(op);
	    actionwords.op_quantIn(op_quant);
	}

	@When("^Select Save$")
	public void select_Save() {
		actionwords.select_Save();
	}

	@Then("^New Route is created$")
	public void new_Route_is_created() {
		actionwords.new_x_is_created();
	}
	
	@Given("^Go to Operations menu - Tasks$")
	public void go_to_Operations_menu_Tasks() {
		actionwords.go_to_Operations_menu();
		driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[4]/div/div/ul/li[3]/a")).click();
	}

	@Given("^Task fields are editable$")
	public void task_fields_are_editable() {
	    actionwords.fields_are_editable();
	}

	

	@Then("^new Task is created$")
	public void new_Task_is_created() {
		actionwords.new_x_is_created();
	}
	
	@Then("^Fill task fields with \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void fill_task_fields_with(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7) {
		actionwords.tcodeIn(arg1);
	    actionwords.tnameIn(arg2);
	    actionwords.tunitIn(arg3);
	    actionwords.tdurationIn(arg4);
	    actionwords.statusIn(arg5);
	}

	
	//new step definitions
	@Given("^Go to Connected Data - View Purchase Order Menu Option$")
	public void go_to_Connected_Data_View_Purchase_Order_Menu_Option() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^Checklist View$")
	public void checklist_View(String arg1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^See Purchase Order Records in View$")
	public void see_Purchase_Order_Records_in_View() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^Order records are visible$")
	public void order_records_are_visible() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^sorting on columns$")
	public void sorting_on_columns(String arg1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^Sorting on all columns is successful you will see records in correct order of column sort$")
	public void sorting_on_all_columns_is_successful_you_will_see_records_in_correct_order_of_column_sort() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^filtering on a column using the correct input$")
	public void filtering_on_a_column_using_the_correct_input(String arg1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^only records relevant to the filter should be on display$")
	public void only_records_relevant_to_the_filter_should_be_on_display() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^select record from list \"([^\"]*)\" \"([^\"]*)\"$")
	public void select_record_from_list(String arg1, String arg2) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^record should be displayed$")
	public void record_should_be_displayed(String arg1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
	//////////////////////////////////////////////////////////////////////
	//      Connected data definitions
	//////////////////////////////////////////////////////////////////////
	
	@Given("^Go to Connected Data - View BOMs Menu Option$")
	public void go_to_Connected_Data_View_BOMs_Menu_Option() {
	    actionwords.go_to_connected_data();
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div[6]/div/div/ul/li[4]/a")).click();
	}

	@Given("^See BOM Records in View$")
	public void see_BOM_Records_in_View() {
		int row = driver.findElements( By.xpath("/html/body/div[1]/div[1]/div/main/div/div[2]/table/tbody/tr[1]") ).size();
		if (row == 0){
			System.out.println("No BOM records found");
		}
	}

	@Given("^BOM records are visible$")
	public void bom_records_are_visible() {
		int row = driver.findElements( By.xpath("/html/body/div[1]/div[1]/div/main/div/div[2]/table/tbody/tr[1]") ).size();
		if (row == 0){
			System.out.println("No BOM records found");
		}
	}

	@Given("^See BOMs Records in View$")
	public void see_BOMs_Records_in_View() {
		int row = driver.findElements( By.xpath("/html/body/div[1]/div[1]/div/main/div/div[2]/table/tbody/tr[1]") ).size();
		if (row == 0){
			System.out.println("No BOM records found");
		}
	}

	@Given("^Go to Connected Data - View Customers Menu Option$")
	public void go_to_Connected_Data_View_Customers_Menu_Option() {
	    actionwords.go_to_connected_data();
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div[6]/div/div/ul/li[1]/a")).click();
	}

	@Given("^See Customers Records in View$")
	public void see_Customers_Records_in_View() {
		int row = driver.findElements( By.xpath("/html/body/div/div[1]/div/main/div/div[3]/table/tbody/tr[1]") ).size();
		if (row == 0){
			System.out.println("No Customer records found");
		}
	}

	@Given("^Customer records are visible$")
	public void customer_records_are_visible() {
		int row = driver.findElements( By.xpath("/html/body/div/div[1]/div/main/div/div[3]/table/tbody/tr[1]") ).size();
		if (row == 0){
			System.out.println("No Customer records found");
		}
	}

	@Given("^See Customer Records in View$")
	public void see_Customer_Records_in_View() {
		int row = driver.findElements( By.xpath("/html/body/div/div[1]/div/main/div/div[3]/table/tbody/tr[1]") ).size();
		if (row == 0){
			System.out.println("No Customer records found");
		}
	}

	@Then("^record Details tab should be displayed$")
	public void record_Details_tab_should_be_displayed(String arg1) {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@When("^select record Contact Tab$")
	public void select_record_Contact_Tab() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@Then("^record Contact Tab should be displayed$")
	public void record_Contact_Tab_should_be_displayed(String arg1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^select record Addresses Tab$")
	public void select_record_Addresses_Tab() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^record Addresses Tab should be displayed$")
	public void record_Addresses_Tab_should_be_displayed(String arg1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^select record Delivery tab$")
	public void select_record_Delivery_tab() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^view list of customer delivery addresses$")
	public void view_list_of_customer_delivery_addresses() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^select record Sales tab$")
	public void select_record_Sales_tab() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^view list of sales for Customer$")
	public void view_list_of_sales_for_Customer() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^Go to Connected Data - View Products Menu Option$")
	public void go_to_Connected_Data_View_Products_Menu_Option(String arg1) {
	    actionwords.go_to_connected_data();
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div[6]/div/div/ul/li[3]/a")).click();
	}

	

	@Given("^See Products Records in View$")
	public void see_Products_Records_in_View() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@Given("^Products records are visible$")
	public void products_records_are_visible() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^Product records are visible$")
	public void product_records_are_visible() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^Go to Connected Data - View Quotes Menu Option$")
	public void go_to_Connected_Data_View_Quotes_Menu_Option() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^there are Quote records with status \"([^\"]*)\" in view$")
	public void there_are_Quote_records_with_status_in_view(String arg1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^Checklist Form$")
	public void checklist_Form() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^See Quote Records in View$")
	public void see_Quote_Records_in_View() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^Quote records are visible$")
	public void quote_records_are_visible() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^record must have status processing and incorrect product line item set$")
	public void record_must_have_status_processing_and_incorrect_product_line_item_set() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^quote line Product in quote not available in stock management solution$")
	public void quote_line_Product_in_quote_not_available_in_stock_management_solution() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^flag for product error should be set$")
	public void flag_for_product_error_should_be_set() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^new product is selected from dropdown list for line item$")
	public void new_product_is_selected_from_dropdown_list_for_line_item() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^new product detail should be displayed and  unit price should be updated to correct unit price for new product and line item subtotal as well as quote subtotals and totals should be adjusted for new product$")
	public void new_product_detail_should_be_displayed_and_unit_price_should_be_updated_to_correct_unit_price_for_new_product_and_line_item_subtotal_as_well_as_quote_subtotals_and_totals_should_be_adjusted_for_new_product() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^quote is saved after changes$")
	public void quote_is_saved_after_changes() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^quote is updated with correct product and flag for product error will be removed from quot$")
	public void quote_is_updated_with_correct_product_and_flag_for_product_error_will_be_removed_from_quot() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^record must have status prior to be sent to stock management solution$")
	public void record_must_have_status_prior_to_be_sent_to_stock_management_solution() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^update the Dispatch Date to new date$")
	public void update_the_Dispatch_Date_to_new_date() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^Save Quote$")
	public void save_Quote() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^quote should be viewable in Quote with new Dispatch Date$")
	public void quote_should_be_viewable_in_Quote_with_new_Dispatch_Date() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^Go to Dashboards - Stock Planner option$")
	public void go_to_Dashboards_Stock_Planner_option() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^reviewing product forecast for related to quote line items$")
	public void reviewing_product_forecast_for_related_to_quote_line_items() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^- forecast for quote product should reflect updated delivery date \\(i\\.e\\. product quote qty should be in correct weekly net total for updated dispatch date\\)$")
	public void forecast_for_quote_product_should_reflect_updated_delivery_date_i_e_product_quote_qty_should_be_in_correct_weekly_net_total_for_updated_dispatch_date() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^update the quote classification to new classification$")
	public void update_the_quote_classification_to_new_classification() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^quote should be viewable in Quote with new classification$")
	public void quote_should_be_viewable_in_Quote_with_new_classification() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^- forecast for quote product should reflect only quotes with filtered classification$")
	public void forecast_for_quote_product_should_reflect_only_quotes_with_filtered_classification() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}


	@Given("^See Order Records in View$")
	public void see_Order_Records_in_View() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^See Sales Order Records in View$")
	public void see_Sales_Order_Records_in_View() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^Login to Stock Managment Solution$")
	public void login_to_Stock_Managment_Solution() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^Locate \"([^\"]*)\"$")
	public void locate(String arg1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^Delete \"([^\"]*)\"$")
	public void delete(String arg1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^Go to Connected Data - View Sales Order Menu Option$")
	public void go_to_Connected_Data_View_Sales_Order_Menu_Option() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^Find \"([^\"]*)\"  in Sales Order view$")
	public void find_in_Sales_Order_view(String arg1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^\"([^\"]*)\" show show status as \"([^\"]*)\" \\(same as stock management solution and will not be included in Stock Planner view\\)$")
	public void show_show_status_as_same_as_stock_management_solution_and_will_not_be_included_in_Stock_Planner_view(String arg1, String arg2) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^Go to Connected Data - View Suppliers Menu Option$")
	public void go_to_Connected_Data_View_Suppliers_Menu_Option() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^See Supplier Records in View$")
	public void see_Supplier_Records_in_View() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^Supplier records are visible$")
	public void supplier_records_are_visible() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^select record Purchases tab$")
	public void select_record_Purchases_tab() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^view list of Purchases for Supplier$")
	public void view_list_of_Purchases_for_Supplier() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^Go to Connected Data - View Warehouses Menu Option$")
	public void go_to_Connected_Data_View_Warehouses_Menu_Option() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^See Warehouse Records in View$")
	public void see_Warehouse_Records_in_View() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^Warehouse records are visible$")
	public void warehouse_records_are_visible() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	

	@Given("^See Task Records in View$")
	public void see_Task_Records_in_View() {
	    // Write code here that turns the phrase above into concrete actions
	}

	@Given("^Task Records are viewable$")
	public void task_Records_are_viewable() {
	    // Write code here that turns the phrase above into concrete actions
	}

	@Then("^Sorting on all columns is successful you will see tasks in correct order of column sort$")
	public void sorting_on_all_columns_is_successful_you_will_see_tasks_in_correct_order_of_column_sort() {
	    actionwords.sortColumns();
	}

	@When("^filtering results$")
	public void filtering_results(String arg1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^Displayed Tasks should match the logic/parameters of each given filter$")
	public void displayed_Tasks_should_match_the_logic_parameters_of_each_given_filter() {
	    // Write code here that turns the phrase above into concrete actions
	}

	@Given("^See Task records in view$")
	public void see_Task_records_in_view() {
	    // Write code here that turns the phrase above into concrete actions
	}

	@Given("^Resource Task are viewable$")
	public void resource_Task_are_viewable() {
	    // Write code here that turns the phrase above into concrete actions
	}

	@When("^Viewing a Task Record$")
	public void viewing_a_Task_Record() {
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/main/div/div[2]/table/tbody/tr[1]/td[1]/a/button")).click();
	}

	@Then("^Task Record is displayed on screen$")
	public void task_Record_is_displayed_on_screen() {
	    // Write code here that turns the phrase above into concrete actions
	}
	
}