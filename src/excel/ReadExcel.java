package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static void main(String[] args) throws IOException {
		
		String fileName = "E:\\Workspace\\eclipse\\SeleniumConcepts\\src\\excel\\data.xlsx";
		
		/*
		ChromeOptions chromeOptions= new ChromeOptions();
		chromeOptions.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
		
		String exePath = "E:\\Selenium\\Drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		
		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		*/
		File file =    new File(fileName);
		FileInputStream f = new FileInputStream(file);
		
		Workbook wb = null;
		
		String fileExtensionName = fileName.substring(fileName.indexOf("."));
		
		 if(fileExtensionName.equals(".xlsx")){

			    //If it is xlsx file then create object of XSSFWorkbook class

			    wb = new XSSFWorkbook(f);

			    }

			    //Check condition if the file is xls file

		 else if(fileExtensionName.equals(".xls")){

			        //If it is xls file then create object of XSSFWorkbook class

			    wb = new HSSFWorkbook(f);

			    }

		 Sheet sh = wb.getSheet("Sheet1");
		 int rows = sh.getFirstRowNum() - sh.getLastRowNum();
		 
		 for(int i = 0; i < rows + 1; i ++){
			 
			 Row row = sh.getRow(i);
			 for (int j = 0; j < row.getLastCellNum(); j++) {

		            //Print Excel data in console

		            System.out.print(row.getCell(j).getStringCellValue()+"|| ");

		        }

		        System.out.println();
			 
		 }
	}

}
