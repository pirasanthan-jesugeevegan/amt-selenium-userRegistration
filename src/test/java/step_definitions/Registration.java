package step_definitions;

import java.util.concurrent.TimeUnit;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Registration {
	
	WebDriver driver;
   
	
	@Given("the user is on registration page")
	public void the_user_is_on_registration_page() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pjes0001\\Desktop\\WorkShop\\Selenium Installers\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();		
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.linkText("Sign in")).click();

	}

	 @When("^the user enters \"([^\"]*)\" and click submit$") 
	   public void I_enter_Username_as_and_Password_as(String email) {
		 
		 driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		 driver.findElement(By.cssSelector("#email_create")).sendKeys(email);
		 driver.findElement(By.xpath("//button[@name=\"SubmitCreate\"]")).click();
	   } 
	 
	 @And ("^the user enter \"([^\"]*)\" in the field \"([^\"]*)\"$") 
	 public void the_user_enters(String string, String string1) {
		 if(string1.contains("firstname")) {
			 driver.findElement(By.name("customer_firstname")).sendKeys(string);
			  }
		 else if(string1.contains("lastname")) {
			 driver.findElement(By.name("customer_lastname")).sendKeys(string);
		 }
		 else if(string1.contains("password")) {
			 driver.findElement(By.id("passwd")).sendKeys(string);
		 }
		 else if(string1.contains("company")) {
			 driver.findElement(By.id("company")).sendKeys(string);
		 }
		 else if(string1.contains("address")) {
			 driver.findElement(By.id("address1")).sendKeys(string);
		 }
		 else if(string1.contains("city")) {
			 driver.findElement(By.id("city")).sendKeys(string);
		 }
		 else if(string1.contains("mobile")) {
			  driver.findElement(By.id("phone_mobile")).sendKeys(string);
		 }
		 else if(string1.contains("postcode")) {
			  driver.findElement(By.id("postcode")).sendKeys(string);
		 }
		 else if(string1.contains("alias")) {
			 driver.findElement(By.xpath("//input[@name=\"alias\"]")).clear();
			  driver.findElement(By.xpath("//input[@name=\"alias\"]")).sendKeys(string);
		 }
		
	 }
	 
	 @And ("^the user select \"([^\"]*)\" in the field \"([^\"]*)\"$") 
	 public void the_user_select(String string, String string1) {
		 if(string1.contains("state")) {
			 WebElement statedropdown=driver.findElement(By.name("id_state"));
			  Select oSelect=new Select(statedropdown);
			  oSelect.selectByValue(string);
			  }
		 else if(string1.contains("country")) {
			 WebElement countrydropDown=driver.findElement(By.name("id_country"));
			  Select oSelectC=new Select(countrydropDown);
			  oSelectC.selectByVisibleText(string);
		 }		 
		 else if(string1.contains("title")) {
			 if(string.contains("male")) {
					 WebElement countrydropDown=driver.findElement(By.xpath("//input[@id=\"id_gender1\"]"));
					 countrydropDown.click();
			 }else if(string.contains("female"))
			 {
				 WebElement countrydropDown=driver.findElement(By.xpath("//input[@id=\"id_gender2\"]"));
				countrydropDown.click();
			 }
				 
		 }
	 }

	 @And("user submit regristration form") 
	 public void user_submit_regristration_form() {
		  driver.findElement(By.name("submitAccount")).click();
	 }
	
	@Then("your is successfully registered")
	public void your_is_successfully_registered() {
		  driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		  String bodyText = driver.findElement(By.tagName("body")).getText();
		  Assert.assertTrue("Text not found!", bodyText.contains("MY ACCOUNT"));
		  driver.close();
	}
	

	@Then("user is dispayed with an invalid email error message")
	public void user_is_dispayed_with_an_invalid_email_error_message() {
		String bodyText = driver.findElement(By.xpath("//*[@id=\"create_account_error\"]/ol/li")).getText();
		Assert.assertTrue("Text not found!", bodyText.contains("An account using this email address has already been registered. Please enter a valid password or request a new one."));
		driver.close();
	}


	@Then("user is dispayed with a required error message")
	public void user_is_dispayed_with_a_required_error_message() {
		String phoneNumber = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/ol/li[1]")).getText();
		String lastname = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/ol/li[2]")).getText();
		String firstname = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/ol/li[3]")).getText();
		String password = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/ol/li[4]")).getText();
		String address = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/ol/li[5]")).getText();
		String city = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/ol/li[6]")).getText();
		String postcode = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/ol/li[7]")).getText();
		String country = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/ol/li[8]")).getText();
		
		Assert.assertTrue("Text not found!", phoneNumber.contains("You must register at least one phone number."));
		Assert.assertTrue("Text not found!", lastname.contains("lastname is required."));
		Assert.assertTrue("Text not found!", firstname.contains("firstname is required."));
		Assert.assertTrue("Text not found!", password.contains("passwd is required."));
		Assert.assertTrue("Text not found!", address.contains("address1 is required."));
		Assert.assertTrue("Text not found!", city.contains("city is required."));
		Assert.assertTrue("Text not found!", postcode.contains("The Zip/Postal code you've entered is invalid. It must follow this format: 00000"));
		Assert.assertTrue("Text not found!", country.contains("This country requires you to choose a State."));
		driver.close();
	}
	
	@Then("user is displayed with a invalid error message")
	public void user_is_displayed_with_a_invalid_error_message() {
		String phoneNumber = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/ol/li[7]")).getText();
		String lastname = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/ol/li[1]")).getText();
		String firstname = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/ol/li[2]")).getText();
		String password = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/ol/li[3]")).getText();
		String address = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/ol/li[4]")).getText();
		String city = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/ol/li[6]")).getText();
		String postcode = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/ol/li[5]")).getText();
		String zip = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/ol/li[8]")).getText();
		
		Assert.assertTrue("Text not found!", phoneNumber.contains("phone_mobile is invalid."));
		Assert.assertTrue("Text not found!", lastname.contains("lastname is invalid."));
		Assert.assertTrue("Text not found!", firstname.contains("firstname is invalid."));
		Assert.assertTrue("Text not found!", password.contains("passwd is invalid."));
		Assert.assertTrue("Text not found!", address.contains("address1 is invalid."));
		Assert.assertTrue("Text not found!", city.contains("city is invalid."));
		Assert.assertTrue("Text not found!", postcode.contains("postcode is invalid"));
		Assert.assertTrue("Text not found!", zip.contains("The Zip/Postal code you've entered is invalid. It must follow this format: 00000"));
		driver.close();
	
	}


	
}
