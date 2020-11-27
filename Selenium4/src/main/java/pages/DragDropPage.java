package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DragDropPage {

    private WebDriver driver;

    public DragDropPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "draggable")
    private WebElement draggableBox;

    @FindBy(css = "#droppable > p")
    private WebElement droppedText;

    public String getdroppedTextText() {
        return droppedText.getText();
    }

    public void dragAndDrop() {
        Actions act = new Actions(driver);
        act.dragAndDropBy(draggableBox, 290, 50).perform();
    }
}