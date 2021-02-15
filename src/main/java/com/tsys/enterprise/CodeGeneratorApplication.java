package com.tsys.enterprise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CodeGeneratorApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(CodeGeneratorApplication.class, args);
		context.close();
	}

}
