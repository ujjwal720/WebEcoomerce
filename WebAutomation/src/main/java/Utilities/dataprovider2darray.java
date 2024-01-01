package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataprovider2darray {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File files = new File("C:\\Users\\DELL\\Desktop\\search.xlsx");
		FileInputStream yu = new FileInputStream(files);
		XSSFWorkbook io = new XSSFWorkbook(yu);
		XSSFSheet iop = io.getSheetAt(0);
		int lastrows = iop.getLastRowNum() + 1;
		int col = iop.getRow(0).getLastCellNum();

		Object[][] array2D = new Object[lastrows][col];

		for (int i = 0; i <= lastrows - 1; i++) {

			XSSFRow rows = iop.getRow(i);

			
			
			
			for (int j = 0; j < col; j++) {

				Cell ui = rows.getCell(j);
				String resw = ui.toString();
				//System.out.println(resw);
				array2D[i][j] = resw;

			}

		}
		
		System.out.println(array2D[0][0]);
		System.out.println(array2D[1][0]);
		System.out.println(array2D[2][0]);

	}

}
