package com.tsys.enterprise.model;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author U68772-Shanij
 *
 */
@Getter
@Setter
@AllArgsConstructor
public class FieldsModel implements Serializable {


	private static final long serialVersionUID = 7024266892422078944L;
	public FieldsModel() {
	}

	private String contentType;
	private String version;
	private String dataType;
	private String ttlDigits;
	private String length;
	private boolean isMixedCase;
	private String pattern;
	private String occurance;
	private String requiredOptional;
	private String businessDescription;
	private String techDescription;
	private String tsysOnly;
	private String fieldSource;
	private String enumPossibleValues;
	private List<FieldLevelErrorsModel> fieldLevelErrors;

}
