package io.sample.bean.para;

import org.springframework.web.multipart.MultipartFile;

public class FilePara {

	private MultipartFile file;

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

}