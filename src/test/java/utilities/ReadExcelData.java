package utilities;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class ReadExcelData {

    public static String[][] getData(String dataLocation, String sheetName) throws IOException {
        File file = new File(dataLocation);
        FileInputStream fileInputStream = new FileInputStream(file);
        Workbook wb = WorkbookFactory.create(fileInputStream);
        Sheet sheet = wb.getSheet(sheetName);
        int rows = sheet.getLastRowNum();
        int columns = sheet.getRow(0).getLastCellNum();

        DataFormatter formatter = new DataFormatter();

        String[][] excelData = new String[rows-2][columns];
        for(int i=3;i<=rows;i++)
        {
            for(int j=0;j<columns;j++)
            {
                    excelData[i-3][j]=formatter.formatCellValue(sheet.getRow(i).getCell(j));
            }
        }
        return excelData;
    }

    public static void main(String[] args) throws IOException {
        String[][] result =getData("src/test/resources/testData/SearchData.xlsx","Amazon Search Data");
        System.out.println(Arrays.deepToString(result));
    }
}
