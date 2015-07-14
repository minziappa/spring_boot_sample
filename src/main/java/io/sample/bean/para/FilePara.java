package io.sample.bean.para;

import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

public class FilePara {

	@NotNull(message = "file")
	private MultipartFile file;

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

}