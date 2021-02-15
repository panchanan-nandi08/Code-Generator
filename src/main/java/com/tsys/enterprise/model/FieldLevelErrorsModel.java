package com.tsys.enterprise.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author U68772-Shanij
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FieldLevelErrorsModel implements Serializable {

	private static final long serialVersionUID = 7501586703169973707L;
	private String code;
	private String status;
	private String name;
	private String description;
	private String possibleCauses;
}
