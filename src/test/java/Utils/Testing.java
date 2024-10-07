package Utils;

import java.io.IOException;

public class Testing {
public static void main(String[] args) throws IOException {
	String path=System.getProperty("user.dir")+"/src/test/resources/excel/Testdata.xlsx";
	ExcelUtil xlutil=new ExcelUtil(path);
	System.out.println(xlutil.getCellCount("Sheet1", 0));
	System.out.println(xlutil.getCellData("Sheet1", 1, 2));
}
}
