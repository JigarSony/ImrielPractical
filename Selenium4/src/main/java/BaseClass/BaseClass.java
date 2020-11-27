package BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    public WebDriver driver;
    public Properties prop;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

        String projectPath = System.getProperty("user.dir");
        File file = new File(projectPath + "/src/main/java/Resources/datafile.properties");

        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
            prop = new Properties();
            prop.load(fileInput);
        } catch (FileNotFoundException e) {
            System.out.println("Reason of exception is "+ e.getCause());
        } catch (IOException e) {
            System.out.println("Reason of exception is "+ e.getCause());
        }
    }
}
