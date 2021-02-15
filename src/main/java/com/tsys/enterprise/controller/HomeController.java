package com.tsys.enterprise.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.tsys.enterprise.model.Configuration;
import com.tsys.enterprise.service.FTLCodeGeneratorService;

import lombok.extern.slf4j.Slf4j;

/***
 * 
 * @author U68772-Shanij
 *
 */
@RestController
@Slf4j
public class HomeController {

	@Autowired
	FTLCodeGeneratorService ftlCodeGeneratorService;

	@GetMapping("home")
	public ModelAndView home(Principal principal) throws IOException {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home");
		return mav;
	}

	@PostMapping("/generateCode")
	public Map<String, String> generateCode(@ModelAttribute Configuration configuration) throws Exception {
		if (configuration != null) {
			Set<String> filesProcessed = ftlCodeGeneratorService.processFTLFiles(configuration);
			if (!filesProcessed.isEmpty()) {
				log.info("Follwing output files are generated successfully : ");
				filesProcessed.forEach(files -> {
					log.info(files);
				});
			} else {
				log.info("No output files are generated");
			}
		}
		return Collections.singletonMap("response", "success");
	}

}
