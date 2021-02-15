package com.tsys.enterprise.constant;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@PropertySource("classpath:application.yml")
@ConfigurationProperties
@Getter
@Setter
public class ApplicationProperties {

	/*
	 * @Value("${a.b.c}") private String abcd;
	 */

}
