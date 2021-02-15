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
public class GeneralDataModel implements Serializable {

	private static final long serialVersionUID = -5164513338238362376L;
	private String packetName;
	private String packetPrefix;
	private String platform;
	private String packetFunction;
	private String paging;
	private String smlVersion;
	private String prodCodeVersion;
	private String smlLink;
}
