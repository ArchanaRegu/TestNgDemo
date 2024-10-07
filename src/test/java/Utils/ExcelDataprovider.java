package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataprovider {
		
	public String getData(int row,int col) throws IOException {
		File excelFile=new File("./src/test/resources/excel/Testdata.xlsx");
		FileInputStream fis=new FileInputStream(excelFile);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		int no_rows=sheet.getPhysicalNumberOfRows();
		int no_colms=sheet.getRow(0).getPhysicalNumberOfCells();
		String[][] data=new String[no_rows-1][no_colms];
		for(int i=0;i<no_rows-1;i++) {
			for(int j=0;j<no_colms;j++) {
				DataFormatter df=new DataFormatter();
				data[i][j]=df.formatCellValue(sheet.getRow(i).getCell(j));
			}
		}
		workbook.close();
		fis.close();
		String Data1=data[row][col];
//		for(String[] dataArr:data) {
//	System.out.println(Arrays.toString(dataArr));
		return Data1;
	}
	
}
