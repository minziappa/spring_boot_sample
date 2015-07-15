package io.sample.controller;

import io.sample.bean.para.FilePara;
import io.sample.service.SampleService;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
// @RestController
public class SampleController {
//  private static final String template = "Hello, %s!";
//  private final AtomicLong counter = new AtomicLong();

	@Autowired
    private SampleService sampleService;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping(value = {"/uploadFiles"})
	public String handleUploadFiles(@Valid FilePara filePara, ModelMap model) throws Exception {

		sampleService.readExcel(filePara);

		return "redirect:/uploadComplete";
	}

	@RequestMapping("/uploadComplete")
	public String uploadComplete() {
		return "uploadComplete";
	}

}