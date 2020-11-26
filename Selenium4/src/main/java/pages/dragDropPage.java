package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class dragDropPage{
	
	 public WebDriver driver;
	
	public dragDropPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(id="draggable")
	WebElement draggableBox;
	
	@FindBy(css="#droppable > p")
	WebElement droppedText;
	
	public String getdroppedTextText() {
		return droppedText.getText();
	}
	
	public void dragAndDrop() {
		Actions act = new Actions(driver);
        act.dragAndDropBy(draggableBox, 290, 50).perform();
	}
}