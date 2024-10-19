package Utils;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataproviderSupplier {
	@DataProvider(name="Arraysdatapro")
	public String[] dpA() {
		  
		String[] data=new String[] {
				"Arrays in Python",
				"Arrays Using List",
			      "Basic Operations in Lists",
			     "Applications of Array"		};
		return data;
	}
	@DataProvider(name="Graphsdatapro")
	public String[][] getvalidinvaliddata() throws Exception{
	File excelFile=new File("./src/test/resources/excel/Testdata.xlsx");
	FileInputStream fis=new FileInputStream(excelFile);
	XSSFWorkbook workbook=new XSSFWorkbook(fis);
	XSSFSheet sheet=workbook.getSheet("Sheet2");
	int no_rows=sheet.getPhysicalNumberOfRows();
	int no_colms=sheet.getRow(0).getPhysicalNumberOfCells();
	String[][] data=new String[no_rows-1][no_colms];
	for(int i=0;i<no_rows-1;i++) {
		for(int j=0;j<no_colms;j++) {
			DataFormatter df=new DataFormatter();
			data[i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j));
		}}
	workbook.close();
	fis.close();

return data;
}
	
	@DataProvider(name="QueuesTopics",indices = {0,1,2,3})
	public String[][] getdataLogin() throws Exception {
		File excelFile=new File("./src/test/resources/excel/Testdata.xlsx");
		FileInputStream fis=new FileInputStream(excelFile);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("Sheet3");
		int no_rows=sheet.getPhysicalNumberOfRows();
		int no_colms=sheet.getRow(0).getPhysicalNumberOfCells();
		String[][] data=new String[no_rows-1][no_colms];
		for(int i=0;i<no_rows-1;i++) {
			for(int j=0;j<no_colms;j++) {
				DataFormatter df=new DataFormatter();
				data[i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j));
			}
		}
		workbook.close();
		fis.close();

	return data;
	}
	
	
	@DataProvider(name="LinkedTopics",indices = {0,1,2,3,4,5,6})
	public String[][] getdataLinkedList() throws Exception {
		File excelFile=new File("./src/test/resources/excel/Testdata.xlsx");
		FileInputStream fis=new FileInputStream(excelFile);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("Sheet5");
		int no_rows=sheet.getPhysicalNumberOfRows();
		int no_colms=sheet.getRow(0).getPhysicalNumberOfCells();
		String[][] data=new String[no_rows-1][no_colms];
		for(int i=0;i<no_rows-1;i++) {
			for(int j=0;j<no_colms;j++) {
				DataFormatter df=new DataFormatter();
				data[i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j));
			}
		}
		workbook.close();
		fis.close();
	return data;
	}
	
	@DataProvider(name="StacksTopics",indices = {0,1,2})
	public String[][] getdataStacksTopics() throws Exception {
		File excelFile=new File("./src/test/resources/excel/Testdata.xlsx");
		FileInputStream fis=new FileInputStream(excelFile);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("Sheet7");
		int no_rows=sheet.getPhysicalNumberOfRows();
		int no_colms=sheet.getRow(0).getPhysicalNumberOfCells();
		String[][] data=new String[no_rows-1][no_colms];
		for(int i=0;i<no_rows-1;i++) {
			for(int j=0;j<no_colms;j++) {
				DataFormatter df=new DataFormatter();
				data[i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j));
			}
		}
		workbook.close();
		fis.close();

	return data;
	}
	
	@DataProvider(name="TreesTopics")
	public String[][] getdataTreesTopics() throws Exception {
		File excelFile=new File("./src/test/resources/excel/Testdata.xlsx");
		FileInputStream fis=new FileInputStream(excelFile);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("Sheet6");
		int no_rows=sheet.getPhysicalNumberOfRows();
		int no_colms=sheet.getRow(0).getPhysicalNumberOfCells();
		String[][] data=new String[no_rows-1][no_colms];
		for(int i=0;i<no_rows-1;i++) {
			for(int j=0;j<no_colms;j++) {
				DataFormatter df=new DataFormatter();
				data[i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j));
			}
		}
		workbook.close();
		fis.close();

	return data;
	}
	
	
	@DataProvider(name="Registationdatapro",indices = {0})
	public String[][] getRegistrationdata() throws Exception{
	File excelFile=new File("./src/test/resources/excel/Testdata.xlsx");
	FileInputStream fis=new FileInputStream(excelFile);
	XSSFWorkbook workbook=new XSSFWorkbook(fis);
	XSSFSheet sheet=workbook.getSheet("Sheet2");
	int no_rows=sheet.getPhysicalNumberOfRows();
	int no_colms=sheet.getRow(0).getPhysicalNumberOfCells();
	String[][] data=new String[no_rows-1][no_colms];
	for(int i=0;i<no_rows-1;i++) {
		for(int j=0;j<no_colms;j++) {
			DataFormatter df=new DataFormatter();
			data[i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j));
		}}
	workbook.close();
	fis.close();

return data;
}
	
	
}