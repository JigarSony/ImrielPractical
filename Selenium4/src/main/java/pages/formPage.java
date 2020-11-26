package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class formPage{
	
	 public WebDriver driver;
	
	public formPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(name="first_name")
	WebElement firstName;
	
	@FindBy(name="last_name")
	WebElement lastName;
	
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="phone")
	WebElement phone;
	
	@FindBy(name="address")
	WebElement address;
	
	@FindBy(name="city")
	WebElement city;
	
	@FindBy(name="state")
	WebElement state;
	
	@FindBy(name="zip")
	WebElement zip;
	
	@FindBy(name="website")
	WebElement website;
	
	@FindBy(name="comment")
	WebElement comment;
	
	@FindBy(xpath="//*[@id='contact_form']/fieldset/div[10]/div/div[2]/label/input")
	WebElement rbNo;
	
	@FindBy(css="btn.btn-default")
	WebElement btnSubmit;
	
	public void setFirstName(String firstname) {
		firstName.sendKeys(firstname);
	}
	public void setLastName(String lastname) {
		lastName.sendKeys(lastname);
	}
	public void setemailId(String emailId) {
		email.sendKeys(emailId);
	}
	public void setPhone(String phoneNumber) {
		phone.sendKeys(phoneNumber);
	}
	public void setAddress(String addressText) {
		address.sendKeys(addressText);
	}
	public void setCity(String cityName) {
		city.sendKeys(cityName);
	}

	public void setState() {
		Select se = new Select(state);
		se.selectByIndex(3); }
	
	public void setZip(String zipcode) {
		zip.sendKeys(zipcode);
	}
	
	public void setWebsite(String websiteText) {
		website.sendKeys(websiteText);
	}
	
	public void setComment(String commentText) {
		comment.sendKeys(commentText);
	}
	
	public void clickonNoDomain() {
		rbNo.click();
	}
	
	public void clickonSubmit() {
		btnSubmit.click();
	}
}
