package com.IOUtils;

import java.io.*;
import java.util.Iterator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFTableColumn;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	// private static BufferedInputStream file;
	private static InputStream file;
	private static XSSFWorkbook workbook;
	private static XSSFSheet sheet;
	private static int rowIndex, cellIndex;
	private static XSSFCell cell;

	public static void openFile(String path, String sheetName) throws IOException {
		// file = new FileInputStream(new File(path));
		file = new BufferedInputStream(new FileInputStream(System.getProperty("user.dir") + "\\" + path));
		// Get the workbook instance for XLSX file
		workbook = new XSSFWorkbook(file);
		// Get first sheet from the workbook
		sheet = workbook.getSheet(sheetName);

	}

	public static String readData(String scenarioName, String columnName) throws IOException {

		XSSFRow rw;
		int r = 0, c = 0;
		int lastRow = sheet.getLastRowNum();
		int lastCol = sheet.getRow(0).getLastCellNum();
		rw = sheet.getRow(r);
		cell = rw.getCell(c);

		// Find the Correct Row
		while (cellToString(cell).equalsIgnoreCase(scenarioName) == false && r <= lastRow) {
			rw = sheet.getRow(r);
			cell = rw.getCell(0);
			r++;
		}
		while (cellToString(cell).equalsIgnoreCase(columnName) == false && c <= lastCol) {
			rw = sheet.getRow(0);
			cell = rw.getCell(c);
			c++;
		}

		rw = sheet.getRow(r - 1);
		cell = rw.getCell(c - 1);
		System.out.println(cellToString(cell));
		return cellToString(cell);
	}

	private static String cellToString(XSSFCell cell1) {

		Object result;

		switch (cell1.getCellType()) {
		case NUMERIC:
			result = cell1.getNumericCellValue();
			break;

		case STRING:
			result = cell1.getStringCellValue();
			break;

		case BOOLEAN:
			result = cell1.getBooleanCellValue();
			break;

		case FORMULA:
			result = cell1.getCellFormula();
			break;

		default:
			throw new RuntimeException("Unknown Cell Type");
		}

		return result.toString();
	}

}
