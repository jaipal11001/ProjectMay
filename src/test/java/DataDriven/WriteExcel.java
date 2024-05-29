package DataDriven;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class WriteExcel {
	@Test
	void ExcelWrite() throws IOException {
		//open file to write
		FileOutputStream file=new FileOutputStream(System.getProperty("user.dir")+"\\TestData\\WriteData.xlsx");
		//Open workbook
		XSSFWorkbook workbook=new XSSFWorkbook();
		//Create Sheet
		XSSFSheet sheet=workbook.createSheet();
		XSSFRow row1=sheet.createRow(0);
		row1.createCell(0).setCellValue("India");
		row1.createCell(1).setCellValue("England");
		row1.createCell(2).setCellValue("Australia");
		row1.createCell(3).setCellValue("Afganistan");
		
		XSSFRow row2=sheet.createRow(1);
		row2.createCell(0).setCellValue("India Vs Ireland");
		row2.createCell(1).setCellValue("England Vs Pakistan");
		row2.createCell(2).setCellValue("Australia Vs USA");
		row2.createCell(3).setCellValue("Afganistan Vs W.Indies");
		
		XSSFRow row3=sheet.createRow(2);
		row3.createCell(0).setCellValue("IPL");
		row3.createCell(1).setCellValue("BBL");
		row3.createCell(2).setCellValue("PSL");
		row3.createCell(3).setCellValue("BPL");
		
		workbook.write(file);
		workbook.close();
		file.close();
		System.out.println("Writing completed");
	}
	

}
