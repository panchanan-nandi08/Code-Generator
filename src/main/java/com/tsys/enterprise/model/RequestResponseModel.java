package com.tsys.enterprise.model;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author U68772-Shanij
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestResponseModel implements Serializable {

	private static final long serialVersionUID = 4413806317772382489L;
	private String requestResponseType;
	private String businessDescription;
	private String technicalDescription;
	private List<FieldsModel> fieldsModels;
}
