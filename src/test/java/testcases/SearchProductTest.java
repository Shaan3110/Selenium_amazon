package testcases;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.SearchProductPage;
import utilities.ReadExcelData;

import java.io.IOException;

public class SearchProductTest extends BaseTest {

    private SearchProductPage searchProductPage ;

    @BeforeMethod
    public void setupPage() {
        // Initialize SearchProductPage after driver setup
        searchProductPage = new SearchProductPage(driver);
    }

    @Test(dataProvider = "testData")
    public void searchWithValidText(String searchText, String expectedResult) throws IOException {
//        SearchProductPage searchProductPage = new SearchProductPage(driver);
        searchProductPage.searchProduct(searchText);
        String actualResult = searchProductPage.getSearchResultsText();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @DataProvider(name = "testData")
    public Object[][] tData() throws IOException {
        return ReadExcelData.getData("src/test/resources/testData/SearchData.xlsx", "Amazon Search Data");
    }
}