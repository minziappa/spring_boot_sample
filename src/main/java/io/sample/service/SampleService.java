package io.sample.service;

import java.io.File;

import io.sample.bean.para.FilePara;

public interface SampleService {

	public void readExcel(FilePara filePara) throws Exception;
	public void writeExcel() throws Exception;
	public void writeCsv() throws Exception;
	public void readCsv(File file) throws Exception;

}