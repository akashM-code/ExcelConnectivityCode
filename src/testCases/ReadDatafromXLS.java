package testCases;

import org.testng.annotations.Test;

import utilities.ExcelFileReader;

public class ReadDatafromXLS {
	
	@Test
	public void readTestData() {
		
		ExcelFileReader excel= new ExcelFileReader("./src/files/excelFileData.xlsx");
		
		//Total rows and columns
		System.out.println("Print number of Rows:" + excel.totalRow("testData"));
		System.out.println("Print number of Columns:"+ excel.totalColumn("testData"));
		
	
		System.out.println("-- 	------------------------------------------------------------------------");
		//Get Data from the specific cell
		
		String cellData= excel.getData("testData", 3, 1);
		System.out.println("Data at 3rd row and 1st column is \n-->>"+cellData);
		
		System.out.println("-- 	------------------------------------------------------------------------");

		System.out.println("-- 	------------------------------------------------------------------------");
		
		System.out.println("-- 	------------------------------------------------------------------------");

		
		//Set Data onto the Row
		System.out.println("data set on the row is:");
//		excel.setData("testData", 5, 3, "hello");
		excel.setData("testData", 5, 2, "5thRow 2ndColumn");
		
	}

}
