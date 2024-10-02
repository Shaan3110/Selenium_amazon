package pages;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class SearchProductPage extends BaseTest {


    public static void searchProduct(String searchText, String result)
    {
        WebElement searchField = driver.findElement(By.id(locatorsPropertiesAccess.getProperty("search_field")));
        searchField.clear(); // This clears the existing text in the field

        searchField.sendKeys(searchText);
        driver.findElement(By.xpath(locatorsPropertiesAccess.getProperty("search_button"))).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorsPropertiesAccess.getProperty("search_results_text"))));

        Assert.assertEquals(driver.findElement(By.xpath(locatorsPropertiesAccess.getProperty("search_results_text"))).getText(), result);

    }
}
