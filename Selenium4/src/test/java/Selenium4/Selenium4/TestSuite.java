package Selenium4.Selenium4;

import java.util.List;

import BaseClass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.DragDropPage;
import pages.FormPage;
import pages.HerokuAppPage;
import pages.RahulShettyAcademyPage;

public class TestSuite extends BaseClass {

    private HerokuAppPage herokuapp;
    private RahulShettyAcademyPage rahulShettyAcademy;
    private DragDropPage dragDrop;
    private FormPage form;

    @Test
    public void scenario1() {
        driver.get(prop.getProperty("herokuAppURL"));
        herokuapp = new HerokuAppPage(driver);
        Assert.assertEquals(herokuapp.getSuccessMessageText(), prop.getProperty("herokuAppSuccessMessage"));
    }

    @Test
    public void scenario2() {
        driver.get(prop.getProperty("rahulshettyacademyURL"));
        rahulShettyAcademy = new RahulShettyAcademyPage(driver);
        rahulShettyAcademy.setSuggestionClass(prop.getProperty("rahulshettyCountry"));

        rahulShettyAcademy.sleep(1000);
        List<WebElement> list = rahulShettyAcademy.getDrpDown().findElements(By.tagName("li"));
        rahulShettyAcademy.sleep(1000);
        for (WebElement element : list) {
            if (element.getText().equals("India")) {
                element.click();
                break;
            }
        }
        rahulShettyAcademy.sleep(500);
        String value = driver.findElement(By.className("ui-autocomplete-input")).getAttribute("value");
        Assert.assertEquals(value, "India");
    }

    @Test
    public void scenario3() {
        driver.get(prop.getProperty("dragDropURL"));
        dragDrop = new DragDropPage(driver);
        dragDrop.dragAndDrop();
        Assert.assertEquals(dragDrop.getdroppedTextText(), prop.getProperty("droppedText"));
    }

    @Test
    public void scenario4() {
        driver.get(prop.getProperty("formURL"));
        form = new FormPage(driver);
        form.setFirstName(prop.getProperty("firstName"));
        form.setLastName("Soni");
        form.setemailId("sonijigar94@gmail.com");
        form.setPhone("9033573270");
        form.setAddress("Road No 4");
        form.setCity("Idar");
        form.setState();
        form.setZip("383430");
        form.setWebsite("https://jigarsony.github.io/");
        form.setComment("Hi I'm Jigar");
        form.clickonNoDomain();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
