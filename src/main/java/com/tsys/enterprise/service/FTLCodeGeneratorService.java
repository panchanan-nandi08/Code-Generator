package com.tsys.enterprise.service;

import java.util.Set;

import com.tsys.enterprise.model.Configuration;

public interface FTLCodeGeneratorService {

	Set<String> processFTLFiles(Configuration config);

}
