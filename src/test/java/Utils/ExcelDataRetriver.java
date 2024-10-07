package Utils;


import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelDataRetriver {
	
public String getExceldata(int RowNum,int colNum) throws IOException {
	String excelpath=System.getProperty("user.dir")+"/src/test/resources/excel/Testdata.xlsx";
	XSSFWorkbook workbook=new XSSFWorkbook(excelpath);
	XSSFSheet sheet=workbook.getSheet("Sheet1");
	String validInvalid=sheet.getRow(RowNum).getCell(colNum).getStringCellValue();
	workbook.close();
	return validInvalid;
}
}
