package com.tsys.enterprise.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tsys.enterprise.model.Configuration;

@RestController
public class FTLController {

	@GetMapping("/getConfig")
	public Configuration getConfiguration() {
		Configuration config = new Configuration();
		config.setInputDirectory("D:/CodeGen/Input");
		config.setGeneratedFileType("java");
		config.setOutputDirectory("D:/CodeGen/Output");
		return config;
	}

}
