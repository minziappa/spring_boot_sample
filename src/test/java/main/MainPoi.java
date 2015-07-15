package main;

import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class MainPoi {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {

		// Create a new workbook
		Workbook wb = new HSSFWorkbook();
		// Create a new sheet
		Sheet s = wb.createSheet();
		// Declare a row object reference
		Row r = null;
		// Declare a cell object reference
		Cell c = null;
		// Create 3 cell styles
		CellStyle cs = wb.createCellStyle();
		CellStyle cs2 = wb.createCellStyle();
		CellStyle cs3 = wb.createCellStyle();
		DataFormat df = wb.createDataFormat();
		// create 2 fonts objects
		Font f = wb.createFont();
		Font f2 = wb.createFont();
		
		// Set font 1 to 12 point type
		f.setFontHeightInPoints((short) 12);
		// Make it blue
		f.setColor((short)0xc);
		// Make it bold
		// Arial is the default font
		f.setBoldweight(Font.BOLDWEIGHT_BOLD);
		
		// Set font 2 to 10 point type
		f2.setFontHeightInPoints((short) 10);
		// Make it red
		f2.setColor((short)Font.COLOR_RED);
		// Make it bold
		f2.setBoldweight(Font.BOLDWEIGHT_BOLD);
		
		f2.setStrikeout(true);
		
		// Set cell style
		cs.setFont(f);
		// Set the cell format
		cs.setDataFormat(df.getFormat("#.##0.0"));
		
		// Set a thin border
		cs2.setBorderBottom(cs2.BORDER_THIN);
		// Fill w fg fill color
		cs2.setFillPattern((short) CellStyle.SOLID_FOREGROUND);
		// Set the cell format to text set DataFormat for a full list
		cs2.setDataFormat(HSSFDataFormat.getBuiltinFormat("text"));
		
		// Set the font
		cs2.setFont(f2);
		
		// Set the sheet name in Unicode
		wb.setSheetName(0, "\u0422\u0435\u0441\u0442\u043E\u0432\u0430\u044F " + 
                "\u0421\u0442\u0440\u0430\u043D\u0438\u0447\u043A\u0430" );

		// In case of plain ascii
		// wb.setSheetName(0, "HSSF Test");
		// create a sheet with 30 rows (0-29)
		int rownum;
		for (rownum = (short) 0; rownum < 30; rownum++) {
			// Create a row
			r = s.createRow(rownum);
			// On every other row
			if ((rownum %2) == 0) {
				// Make the row height bigger (in twips - 1/20 of a point)
				r.setHeight((short) 0x249);
			}
			// r.setRowNum(( short ) rownum);
			// create 10 cells (0-9) (the += 2 becomes apparent later
			for (short cellnum = (short)0; cellnum < 10; cellnum += 2) {
				// Create a numeric cell
				c = r.createCell(cellnum);
				// Do some goofy math to demonstrate decimals
				c.setCellValue(rownum * 10000 + cellnum
						+ (((double) rownum / 1000)
						+ ((double) cellnum / 10000)));
				String cellValue;
				
				// Create a string cell (see why += 2 in the
				c = r.createCell((short) (cellnum + 1));
				
				// On evvery other row
				if ((rownum % 2) == 0) {
					// Set this cell to the first cell style we defined
					c.setCellStyle(cs);
					// Set the cell's string value to "Test"
					c.setCellValue( "Test" );
				} else {
					c.setCellStyle(cs2);
					// Set the cell's string value to "\u0422\u0435\u0441\u0442"
					c.setCellValue( "\u0422\u0435\u0441\u0442" );
				}
				
				// Make this column a bit wider
				s.setColumnWidth((short) (cellnum + 1), (short) ((50 * 8) / ((double) 1 / 20)));
			}
			// draw a thick black border on the row at the bottom using BLANKS
			// Advance 2 rows
			rownum++;
			rownum++;
			
			r = s.createRow(rownum);
			
			// Define the third style to be the default
			// Except with a thick black border at the bottom
			cs3.setBorderBottom(cs3.BORDER_THICK);
			
			// Create 50 cells
			for (short cellnum = (short) 0; cellnum < 50; cellnum++) {
				// Create a blank type cell (no value)
				c = r.createCell(cellnum);
				// Set it to the thick black border style
				c.setCellStyle(cs3);
			}
			// End draw thick black border
			
			// Demonstrate adding/naming and deleting a sheet
			// Create a sheet, set its title then dlete it
			s = wb.createSheet();
			wb.setSheetName(1, "DeletedSheet");
			wb.removeSheetAt(1);
			// End deleted sheet
		}

		// Create a new file
		FileOutputStream os = new FileOutputStream("workbook.xls");
		
		// Write the workbook to the output stream
		// Close our file (don't blow out our file handles
		wb.write(os);
		if(os != null) {
			os.close();
		}

	}

}
