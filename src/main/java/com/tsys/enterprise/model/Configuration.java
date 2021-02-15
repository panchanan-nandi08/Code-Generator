package com.tsys.enterprise.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Configuration implements Serializable {

	private static final long serialVersionUID = -8780802485704884980L;
	private String inputDirectory;
	private String generatedFileType;
	private String outputDirectory;
}
