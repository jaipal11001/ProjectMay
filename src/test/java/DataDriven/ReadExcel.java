package DataDriven;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcel {
	@Test
	void ExcelRead() throws IOException  {
		//open file
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\TestData\\JS4U_Sprint2_TC.xlsx");
		
		//open workbook
				XSSFWorkbook workbook=new XSSFWorkbook(file);
				
				//goto sheet
				XSSFSheet sheet=workbook.getSheet("US 1  Admin Login Functionality");//or getSheetAt(0) by index
				
				//goto row
				int rows=sheet.getLastRowNum(); 
				int cells=sheet.getRow(0).getLastCellNum();
				
				System.out.println(rows);
				System.out.println(cells);
				
				for(int r=0;r<=rows;r++) {
					XSSFRow currentrow=sheet.getRow(r);
					for(int c=0;c<cells;c++) {
					
						String value=currentrow.getCell(c).toString();
						
						System.out.print(value+" ");
	}
					System.out.println();
				}
				workbook.close();
				file.close();
				}}
