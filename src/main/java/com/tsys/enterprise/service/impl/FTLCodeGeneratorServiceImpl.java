package com.tsys.enterprise.service.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tsys.enterprise.constant.ApplicationConstants;
import com.tsys.enterprise.model.HTMLmodel;
import com.tsys.enterprise.service.FTLCodeGeneratorService;

import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.TemplateNotFoundException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FTLCodeGeneratorServiceImpl implements FTLCodeGeneratorService {

	@Override
	@SuppressWarnings("unchecked")
	/***
	 * 
	 * @param config
	 * @return
	 */
	public Set<String> processFTLFiles(com.tsys.enterprise.model.Configuration config) {

		final String inputDirectory = config.getInputDirectory();
		Configuration freeMarkerConfiguration = getFreeMarkerConfig(inputDirectory);
		final Set<String> filesProcessed = new HashSet<>();
		File folder = new File(inputDirectory);

		for (File file : folder.listFiles()) {
			final String fileName = file.getName();
			final String fileNameWithoutExtension = fileName.substring(0, fileName.lastIndexOf("."));
			if (filesProcessed.contains(fileNameWithoutExtension)) {
				continue;
			}
			final String filePath = file.getAbsolutePath();
			String jsonFilePath = filePath.substring(0, filePath.lastIndexOf("."))
					+ ApplicationConstants.JSON_EXTENSION;
			HTMLmodel model = null;
			try {
				model = readHtmlModel(jsonFilePath);
				processFTLFile(model, freeMarkerConfiguration, config.getGeneratedFileType(),
						config.getOutputDirectory(), fileNameWithoutExtension);
				filesProcessed.add(fileNameWithoutExtension);
			} catch (IOException | TemplateException e) {
				log.error("Could not process the file: {}", fileNameWithoutExtension);
				log.error(e.getMessage());
			}
		}
		return filesProcessed;

	}

	/***
	 * 
	 * @param model
	 * @param freeMarkerConfiguration
	 * @param generatedFileType
	 * @param outputDirectory
	 * @param fileName
	 * @throws TemplateNotFoundException
	 * @throws MalformedTemplateNameException
	 * @throws freemarker.core.ParseException
	 * @throws IOException
	 * @throws TemplateException
	 */
	private void processFTLFile(HTMLmodel model, Configuration freeMarkerConfiguration, String generatedFileType,
			String outputDirectory, String fileName) throws TemplateNotFoundException, MalformedTemplateNameException,
			freemarker.core.ParseException, IOException, TemplateException {
		Template template = freeMarkerConfiguration.getTemplate(fileName + ApplicationConstants.FTL_EXTENSION);
		File outputFile = new File(outputDirectory + fileName + "." + generatedFileType);
		log.info("Writing to output file : {}", outputFile);
		Writer writer = new FileWriter(outputFile);
		template.process(model, writer);
		writer.flush();

	}

	/***
	 * 
	 * @param templateSourceDirectory
	 * @return
	 */

	private Configuration getFreeMarkerConfig(String templateSourceDirectory) {
		Configuration config = new Configuration(Configuration.VERSION_2_3_30);

		try {
			config.setDirectoryForTemplateLoading(new File(templateSourceDirectory));
		} catch (IOException e) {
			log.error(e.getMessage());
		}
		config.setDefaultEncoding("UTF-8");
		config.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		return config;
	}

	/***
	 * 
	 * @param filePath
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	private HTMLmodel readHtmlModel(String filePath) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		HTMLmodel config = null;
		config = mapper.readValue(new File(filePath), HTMLmodel.class);
		return config;
	}

	/**
	 * 
	 * @param filePath
	 * @return
	 */
	public Configuration readConfiguration(String filePath) {
		ObjectMapper mapper = new ObjectMapper();
		Configuration config = null;
		try {
			config = mapper.readValue(new File(filePath), Configuration.class);
		} catch (IOException e) {
			log.error(e.getMessage());
		}
		return config;
	}

}
