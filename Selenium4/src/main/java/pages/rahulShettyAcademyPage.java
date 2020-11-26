package pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class rahulShettyAcademyPage{
	
	 public WebDriver driver;
	
	public rahulShettyAcademyPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(id="autocomplete")
	WebElement ddSuggestionClass;
	
	@FindBy(css ="#ui-id-1")
	List<WebElement> listId;
	
	public void setSuggestionClass(String str) {
		ddSuggestionClass.sendKeys(str);
	}
	
	public void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}