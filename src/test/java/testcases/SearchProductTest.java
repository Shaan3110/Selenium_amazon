package testcases;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class SearchProductTest extends BaseTest {

    @Test
    public void searchWithValidText() throws InterruptedException {
        driver.findElement(By.id(locatorsPropertiesAccess.getProperty("search_field"))).sendKeys("phones");
        driver.findElement(By.xpath(locatorsPropertiesAccess.getProperty("search_button"))).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorsPropertiesAccess.getProperty("search_results_text"))));

        Assert.assertTrue(driver.findElement(By.xpath(locatorsPropertiesAccess.getProperty("search_results_text"))).isDisplayed());
    }

}
