package com.IOUtils;

import java.io.*;
import java.util.Iterator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	// private static BufferedInputStream file;
	private static InputStream file;
	private static XSSFWorkbook workbook;
	private static XSSFSheet sheet;
	private static int rowIndex, cellIndex;
	private static Cell cell;

	public static void openFile(String path, String sheetName) throws IOException {

		// file = new FileInputStream(new File(path));
		file = new BufferedInputStream(new FileInputStream(System.getProperty("user.dir") + "\\TestData.xlsx"));
		// Get the workbook instance for XLSX file
		workbook = new XSSFWorkbook(file);
		// Get first sheet from the workbook
		sheet = workbook.getSheet(sheetName);

	}

	@SuppressWarnings("deprecation")
	public String readData(String scenarioName, String columnName) throws IOException {

		String a = null;
		Iterator<Row> rowIterator = sheet.iterator();
		int n = 0;

		while (rowIterator.hasNext()) {

			Row row = rowIterator.next();
			Iterator<Cell> cellIterator = row.cellIterator();
			cell = cellIterator.next();

			if (cell.getRowIndex() == 0) {
				while (cellIterator.hasNext()) {

					if (cell.getStringCellValue().equals(columnName)) {
						System.out.println(cell.getColumnIndex() + "Column  :" + n + " : " + cell.getStringCellValue());
						break;
					}
					n = n + 1;
					cell = cellIterator.next();

				}

			}

		}

		Iterator<Row> rowIterator1 = sheet.iterator();
		Row row = rowIterator1.next();
		do {

			Iterator<Cell> cellIterator1 = row.cellIterator();
			row = rowIterator1.next();
			cell = cellIterator1.next();

			if (cell.getStringCellValue().equals(scenarioName)) {
				while (cellIterator1.hasNext()) {

					cell = cellIterator1.next();
					rowIndex = cell.getRowIndex();
					cellIndex = cell.getColumnIndex();

					if (cellIndex == n) {
						if (cell.getCellType()==Cell.CELL_TYPE_STRING) {
							a = cell.getStringCellValue();
							System.out.println("rowIndex  :" + rowIndex + "  Cell : " + cellIndex + " : " + a);
							break;

						} else if (cell.getCellType() == 0)

						{
							a = Double.toString((int) cell.getNumericCellValue());
							System.out.println("rowIndex  :" + rowIndex + "  Cell : " + cellIndex + " : " + a);
							break;

						}
					}
				}

			}

		} while (rowIterator1.hasNext());
		return a;
	}

}
