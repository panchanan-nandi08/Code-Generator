package com.tsys.enterprise.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/***
 * 
 * @author U68772-Shanij
 *
 */
@Controller
public class IndexController {

	@GetMapping("/")
	public String index() throws Exception {
		return "redirect:/home";
	}

}
