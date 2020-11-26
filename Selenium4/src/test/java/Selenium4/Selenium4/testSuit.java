package Selenium4.Selenium4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.dragDropPage;
import pages.formPage;
import pages.herokuAppPage;
import pages.rahulShettyAcademyPage;

public class testSuit {
	
	public WebDriver driver;
	public herokuAppPage herokuapp;
	public rahulShettyAcademyPage rahulShettyAcademy;
	public dragDropPage dragDrop;
	public formPage form;
	public Properties prop;
	
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
		String projectPath = System.getProperty("user.dir");
		File file = new File(projectPath + "/src/main/java/datafile.properties");
		
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		prop = new Properties();
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void scenario1() {
		driver.get(prop.getProperty("herokuAppURL"));
		herokuapp = new herokuAppPage(driver);
		Assert.assertEquals(herokuapp.getSuccessMessageText(), prop.getProperty("herokuAppSuccessMessage"));
	}
	
	@Test
	public void scenario2() {
		driver.get(prop.getProperty("rahulshettyacademyURL"));
		rahulShettyAcademy = new rahulShettyAcademyPage(driver);
		rahulShettyAcademy.setSuggestionClass(prop.getProperty("rahulshettyCountry"));
	
		WebElement list1 = driver.findElement(By.cssSelector("#ui-id-1"));
		rahulShettyAcademy.sleep(3000);
		List<WebElement> list = list1.findElements(By.tagName("li"));
		rahulShettyAcademy.sleep(3000);
		for(int i = 0 ;i< list.size();i++) {
			rahulShettyAcademy.sleep(2000);
			if(list.get(i).getText().equals("India")) {
				list.get(i).click();
				break; }
			rahulShettyAcademy.sleep(5000);
		}
	}
	
	@Test
	public void scenario3() {
		driver.get(prop.getProperty("dragDropURL"));
		dragDrop = new dragDropPage(driver);
        dragDrop.dragAndDrop();
		Assert.assertEquals(dragDrop.getdroppedTextText(), prop.getProperty("droppedText"));
	}
	
	@Test
	public void scenario4() {
		
		driver.get(prop.getProperty("formURL"));
		form = new formPage(driver);
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
		//form.clickonSubmit();
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
