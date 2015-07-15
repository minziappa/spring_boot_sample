package io.sample.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import io.sample.bean.para.FilePara;
import io.sample.service.SampleService;

@Service
public class SampleServiceImpl implements SampleService{

	final Logger logger = LoggerFactory.getLogger(SampleServiceImpl.class);

    private Row getRow(Sheet sh, int i){
        Row row = sh.getRow(i);
        if(row==null) {
            row = sh.createRow(i);
        }
        return row;
    }

    private Cell getCell(Sheet sh, int row,int cells){
        Row r = getRow(sh, row);
        Cell cell = r.getCell(cells);
        if(cell==null) {
            cell = r.createCell(cells);
        }
        return cell;
    }

    private void setCellValue(Sheet sh, int rows, int cells, String cellvalue){
        Cell cell = getCell(sh, rows, cells);
        cell.setCellValue(cellvalue);
    }

	@Override
	public void readExcel(FilePara filePara) throws Exception {

		logger.info("abcd 1 >>> " + filePara.getFile().getOriginalFilename());
		InputStream is = filePara.getFile().getInputStream();
		Workbook  wb = new XSSFWorkbook(is);
        Sheet sh = wb.getSheetAt(0);

        Iterator<Row> itr = sh.iterator();

        int k=0;
        while(itr.hasNext()) {
        	Row row = itr.next();

            logger.info("abcd 2 >> " + sh.getLastRowNum() + " k=" + k);
            //for(int i=0; i < sh.getLastRowNum(); i++) {
                Iterator<Cell> cells = row.cellIterator();
                while(cells.hasNext()) {
                	Cell cell = cells.next();

                	switch(cell.getCellType()) {
                	case Cell.CELL_TYPE_BOOLEAN:
                		System.out.print(cell.getBooleanCellValue() + "\t");
                		break;
                	case Cell.CELL_TYPE_NUMERIC:
                		System.out.print(cell.getNumericCellValue() + "\t");
                		break;
                	case Cell.CELL_TYPE_STRING:
                		System.out.print(cell.getStringCellValue() + "\t");
                		break;
                	}

                }
            //}

        }

        if(wb != null) {
        	wb.close();
        }
        if(is != null) {
        	is.close();
        }

	}

	public void writeExcel() throws Exception {

        Workbook wb = new HSSFWorkbook();
        Sheet sh = wb.createSheet("sample Sheet");
        for(int i=0;i<10;i++){
            setCellValue(sh, i, 0, "title1"+i);
            setCellValue(sh, i, 1, "title2"+i);
            setCellValue(sh, i, 2, "title3"+i);
        }
        FileOutputStream os = new FileOutputStream("write.xls");
        wb.write(os);

        if(wb != null) {
        	wb.close();
        }
        if(os != null) {
        	os.close();
        }

        System.out.println("Finished");

	}

	public void writeCsv() throws Exception {

		StringBuffer sb = new StringBuffer();

		File file = new File("test.csv");
        FileOutputStream os = new FileOutputStream(file);

		for(int i=0; i<50000; i++) {
			sb.append(i).append("aaaaaaaaaaaaa,")
				.append(i).append("bbbbbbbbbbbbbbbb,")
				.append(i).append("cccccccccceeee")
				.append("\n");
			os.write(sb.toString().getBytes());
			os.flush();
			sb.delete(0, sb.length());
		}

        if(os != null) {
        	os.close();
        }
        System.out.println("Finished");

	}

	public void readCsv(File file) throws Exception {

		String strReadResult = null;

		if(!file.exists()) {
			return;
		}

		FileInputStream fis = new FileInputStream(file); 
		InputStreamReader isr = new InputStreamReader(fis,"Shift_JIS"); 
		BufferedReader bfReader = new BufferedReader(isr);

		int cnt = 0;
		while((strReadResult = bfReader.readLine()) != null) {
			cnt++;
			if(cnt == 1) {
				continue;
			}

			Map<String,Object> mapData = new HashMap<String,Object>();
			mapData.put("fileName", "test");

			String[] strCell = strReadResult.split(",");
			for(int i=0; i < strCell.length; i++) {
 				mapData.put("test1", strCell[0]);
 				if (strCell[1].equals("男性")) {
 					mapData.put("sex", 1);
  				} else if (strCell[1].equals("女性")){
  					mapData.put("sex", 2);
  				} else {
  					mapData.put("sex", 0);
  				}
			}
			for(String key : mapData.keySet()) {
				System.out.print(key+ " = " + mapData.get(key) + " ");
				System.out.println("");
			}
			break;
		}

		if(fis != null) {
			fis.close();
		}
		if(isr != null) {
			isr.close();
		}
		if(bfReader != null) {
			bfReader.close();
		}
	}

}