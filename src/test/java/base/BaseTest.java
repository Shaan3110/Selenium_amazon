package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    public static WebDriver driver;
    public static Properties configPropertiesAccess = new Properties();
    public static Properties locatorsPropertiesAccess = new Properties();
    public static FileReader configProperties ;
    public static FileReader locators ;

    @BeforeTest
    public void setup() throws IOException {
        if(driver == null)
        {
            configProperties = new FileReader("src/test/resources/configFiles/Config.properties");
            locators = new FileReader("src/test/resources/configFiles/Locators.properties");
            configPropertiesAccess.load(configProperties);
            locatorsPropertiesAccess.load(locators);
        }

        if(configPropertiesAccess.getProperty("browser").equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        if(configPropertiesAccess.getProperty("browser").equalsIgnoreCase("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.get(configPropertiesAccess.getProperty("testurl"));

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
        System.out.println("Tear Down Successful");
    }
}
