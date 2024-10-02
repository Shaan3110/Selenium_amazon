package testcases;

import base.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.SearchProductPage;


public class SearchProductTest extends BaseTest {

    private final SearchProductPage searchProductPage = new SearchProductPage();

    @Test (dataProvider = "testData")
    public void searchWithValidText(String searchText, String result) throws InterruptedException {
        SearchProductPage.searchProduct(searchText,result);
    }

    @DataProvider (name="testData")
    public Object[][] tData ()
    {
        return new Object[][] {
                {"phones","Results"},
                {"smart phones","Results"}
        };
    }
}