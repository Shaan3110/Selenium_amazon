package pages;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchProductPage extends BaseTest {

    WebDriver driver;
    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchField;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement searchButton;

    @FindBy(xpath = "//h2[@class='a-size-medium-plus a-spacing-none a-color-base a-text-bold']")
    private WebElement searchResultsText;

    public SearchProductPage(WebDriver driver) {
        this.driver = driver;  // Initialize driver here
        PageFactory.initElements(driver, this);  // Initialize WebElements
    }

    public void searchProduct(String searchText) {
        searchField.clear();
        searchField.sendKeys(searchText);
        searchButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(searchResultsText));  // Correct usage
    }

    public String getSearchResultsText() {
        return searchResultsText.getText();
    }
}
