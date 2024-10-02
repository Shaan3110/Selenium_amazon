package testcases;

import base.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.SearchProductPage;
import utilities.ReadExcelData;

import java.io.IOException;


public class SearchProductTest extends BaseTest {

    private final SearchProductPage searchProductPage = new SearchProductPage();

    @Test (dataProvider = "testData")
    public void searchWithValidText(String searchText, String result) throws InterruptedException {
        searchProductPage.searchProduct(searchText,result);
    }

    @DataProvider (name="testData")
    public Object[][] tData () throws IOException {
        return ReadExcelData.getData("src/test/resources/testData/SearchData.xlsx","Amazon Search Data");
    }
}