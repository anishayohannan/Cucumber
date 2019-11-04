package StepDefinitions;

	import cucumber.api.java.en.Given;

	import cucumber.api.java.en.When;
	import cucumber.api.junit.Cucumber;
	import cucumber.api.java.en.Then;
	import cucumber.api.java.en.And;

	import org.junit.runner.RunWith;
	import org.openqa.selenium.By;
	import org.testng.AssertJUnit;

	import NewProject.Base;
	import Resources.Customer;
	import Resources.LoginPage;
	import Resources.NewLead;
	import Resources.NewLeadForm;

	@RunWith(Cucumber.class)
	public class StepDefinition extends Base{

	    @Given("^Initialize the browser with chrome$")
	    public void initialize_the_browser_with_chrome() throws Throwable {
	    	driver=InitializeBrowser();
	    	
	    }
	    @And("^Navigate to \"([^\"]*)\" site$")
	    public void navigate_to_something_site(String strArg1) throws Throwable {
	    	driver.get(strArg1);
	    }

	    @And("^User enters the login Page$")
	    public void user_enters_the_login_page() throws Throwable {
	        System.out.println("succesfully enters the page");
	    }

	    @When("^User logins to the application with \"([^\"]*)\" and \"([^\"]*)\"$")
	    public void user_logins_to_the_application_with_something_and_something(String strArg1, String strArg2) throws Throwable {
	    	LoginPage Lp=new LoginPage(driver);
	    	Lp.getEmail().sendKeys(strArg1);
			Lp.getpass().sendKeys(strArg2);
			Lp.getLogin().click();
	    }
	    @And("^Direct to new lead Page$")
	    public void direct_to_new_lead_page() throws Throwable {
	    	NewLead nl=new NewLead(driver);
			nl.getnewLead().click();
	    }

	    @Then("^Type all the informations$")
	    public void type_all_the_informations() throws Throwable {
	    	NewLeadForm nf= new NewLeadForm(driver);
			Customer customer=new Customer();
			String variable=customer.output();
			nf.getcustomername().sendKeys("AnishaMY"+variable);
			nf.getaddress1().sendKeys("Vakkayil House");
			nf.getaddress2().sendKeys("Kizhavalloor");
			nf.getcity().sendKeys(customer.City);
			nf.getstate();
			nf.getpincode().sendKeys("689703");
			nf.getemail().sendKeys("ani@gmail.com");
			nf.getphoneNo().sendKeys(customer.phoneNo);
			nf.getlead().sendKeys("john");
			nf.getproduct();
			nf.getleadsource();
			nf.getemployment();
			nf.submit().submit();

	    }

	    @And("^Validate the entered datas$")
	    public void validate_the_entered_datas() throws Throwable {
	    	//ValidateFormSubmission vf=new ValidateFormSubmission();
			//vf.basePageNavigation();
		
	    	AssertJUnit.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[1]/div/strong")).getText(),"Lead saved successfully! Congratulations on the new lead!");
	    	System.out.println("Successfully validated the current entry");
	    	
	    }

	}

