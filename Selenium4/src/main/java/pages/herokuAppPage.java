package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class herokuAppPage{
	
	 public WebDriver driver;
	
	public herokuAppPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
		
	@FindBy(css="#content > div > p")
	WebElement successMessage;
	
	public String getSuccessMessageText() {
		return successMessage.getText();
	}
}