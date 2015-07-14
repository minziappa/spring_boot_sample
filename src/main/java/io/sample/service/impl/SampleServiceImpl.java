package io.sample.service.impl;

import java.util.Iterator;

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

	@Override
	public void convertExcel(FilePara filePara) throws Exception {

		logger.info("abcd >>> " + filePara.getFile().getOriginalFilename());
		Workbook  wb = new XSSFWorkbook(filePara.getFile().getInputStream());
        // Get The workbook instance for XLS file.
        // Workbook wb = new HSSFWorkbook(filePara.getFile().getInputStream());
        // Get first sheet from the workbook
        Sheet sh = wb.getSheetAt(0);

        Row row = sh.getRow(386);
        logger.info("abcd >> " + sh.getLastRowNum());
        for(int i=6; i <= sh.getLastRowNum(); i++) {
            Iterator<Cell> cells = row.cellIterator();
            while(cells.hasNext()) {
            	Cell cell = cells.next();
            	logger.info(cell.getStringCellValue());
            }
        }

	}

}