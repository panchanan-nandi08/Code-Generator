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
public class HTMLmodel implements Serializable {

	private static final long serialVersionUID = -5421299920564185692L;
	private RequestResponseModel requestModel;
	private RequestResponseModel responseModel;
	private List<ResponseErrorModel> errorModels;
	private GeneralDataModel generalDataModel;
}
