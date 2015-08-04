package io.sample.controller;

import java.util.Locale;

import io.sample.bean.para.FilePara;
import io.sample.service.SampleService;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // - This is page name
// @RestController - return text directly
public class SampleController {

	final Logger logger = LoggerFactory.getLogger(SampleController.class);
	
	final Locale LOCALE = Locale.JAPAN;
	@Autowired
    private MessageSource messages;
	@Autowired
    private SampleService sampleService;

	@RequestMapping("/")
	public String index() {
		logger.info("message >> " + messages.getMessage("sample.parameter.error.message", null, LOCALE));
		return "index";
	}

	@RequestMapping(value = {"/uploadFiles"})
	public String uploadFiles(@Valid FilePara filePara, ModelMap model) throws Exception {
		logger.info("-->>> uploadFiles <<<<----");
		sampleService.readExcel(filePara);
		return "redirect:/uploadComplete";
	}

	@RequestMapping("/uploadComplete")
	public String uploadComplete() {
		return "uploadComplete";
	}

}