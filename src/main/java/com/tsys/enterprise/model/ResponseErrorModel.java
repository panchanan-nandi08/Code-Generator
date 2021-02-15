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
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseErrorModel implements Serializable {

	private static final long serialVersionUID = 7763815762476253699L;
	private String code;
	private String status;
	private String name;
	private String description;
	private String possibleCauses;

}
