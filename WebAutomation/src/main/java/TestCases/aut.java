package TestCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class aut {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		/*
		 * write using the xcel in selenium
		 */

		File a = new File("C:\\Users\\DELL\\Desktop\\users.xlsx");
		FileInputStream b = new FileInputStream(a);
		XSSFWorkbook lm = new XSSFWorkbook(b);
		XSSFSheet yu = lm.getSheetAt(0);
		int rows = yu.getLastRowNum() + 1;
		int cols = yu.getRow(0).getLastCellNum();
		System.out.println(rows);
		System.out.println(cols);

		for (int i = 0; i <= rows - 1; i++) {

			XSSFRow mi = yu.getRow(i);

			for (int j = 0; j <= cols - 1; j++) {

				String io = mi.getCell(j).toString();
				
				mi.createCell(1).setCellValue("Shrivasta");
				
				
				

			}
			
			
			
			

		}
		
		b.close();
		FileOutputStream outputStream = new FileOutputStream(a);
		lm.write(outputStream);

	}

}
