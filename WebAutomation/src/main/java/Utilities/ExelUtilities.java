package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExelUtilities {

	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public File files;
	public FileInputStream is;

	public String ReadExcelFile(File Filename, int i, int j) throws IOException {

		is = new FileInputStream(Filename);
		workbook = new XSSFWorkbook(is);
		sheet = workbook.getSheetAt(0);
		Cell a = sheet.getRow(i).getCell(j);
		String ui = a.toString();
		return ui;

	}

	public int getrowno(File filename) throws IOException {

		File a = filename;
		FileInputStream b = new FileInputStream(a);
		XSSFWorkbook c = new XSSFWorkbook(b);
		XSSFSheet d = c.getSheetAt(0);
		int rows = d.getLastRowNum();
		c.close();
		return rows;

	}

	public int getcolno(File filename) throws IOException {

		File a = filename;
		FileInputStream b = new FileInputStream(a);
		XSSFWorkbook c = new XSSFWorkbook(b);
		XSSFSheet d = c.getSheetAt(0);
		int col = d.getRow(0).getLastCellNum();
		c.close();
		return col;

	}

}
