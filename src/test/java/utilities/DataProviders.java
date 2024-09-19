package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	//DataProvider1
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException {
		
		String path=".\\testData\\Opencart_LoginData.xlsx"; //takingxl file from testData
		
		ExcelUtility xlutil=new ExcelUtility(path); //creatingan object forExcelYtility
		
		int totalrows = xlutil.getRowCount("Sheet1");
		int totalcols = xlutil.getCellCount("Sheet1", 1);
		
		String logindata[][] = new String[totalrows][totalcols]; //create for 2-D array which can store data
		
		for(int i=1; i<=totalrows; i++)
		{
			for(int j=0; j<totalcols; j++)
			{
				logindata[i-1][j] = xlutil.getCellData("Sheet1", i, j); //1,0
			}
			
		}
		
		return logindata; //returning @-D array
	}

}
