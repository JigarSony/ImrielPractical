package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RahulShettyAcademyPage {

    private WebDriver driver;

    public RahulShettyAcademyPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "autocomplete")
    private WebElement ddSuggestionClass;

    @FindBy(css = "#ui-id-1")
    private WebElement dropdown;

    public void setSuggestionClass(String str) {
        ddSuggestionClass.sendKeys(str);
    }

    public void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            System.out.println("Reason for exception is "+ e.getCause());
        }
    }

    public WebElement getDrpDown() {
        return dropdown;
    }
}