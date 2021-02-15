package com.tsys.enterprise.config;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tsys.enterprise.model.Configuration;
import com.tsys.enterprise.service.FTLCodeGeneratorService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AppStartUpRunner implements CommandLineRunner {

	@Value("${ftl.config.location}")
	private String ftlConfigLocation;

	@Autowired
	FTLCodeGeneratorService service;

	@Override
	public void run(String... args) throws Exception {

		Configuration config = readConfiguration();
		if (config != null) {
			if (!ObjectUtils.isEmpty(config.getInputDirectory()) && !ObjectUtils.isEmpty(config.getGeneratedFileType())
					&& !ObjectUtils.isEmpty(config.getOutputDirectory())) {
				Set<String> filesProcessed = service.processFTLFiles(config);
				if (!filesProcessed.isEmpty()) {
					log.info("Follwing output files are generated successfully : ");
					filesProcessed.forEach(files -> {
						log.info(files);
					});
				}else {
					log.info("No output files are generated");
				}

			} else {
				log.info("Either FTL template or Json input source directory is null or empty");

			}
		}

	}

	private Configuration readConfiguration() {

		ObjectMapper mapper = new ObjectMapper();
		Configuration config = null;
		try {
			config = mapper.readValue(new File(ftlConfigLocation), Configuration.class);
		} catch (IOException e) {
			log.error(e.getMessage());
		}
		return config;
	}

}
