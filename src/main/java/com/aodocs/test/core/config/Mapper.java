/**
 * 
 */
package com.aodocs.test.core.config;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Xavier Guillon
 *
 */
public enum Mapper {
	INSTANCE;

	private final ObjectMapper mapper = new ObjectMapper();
	/*
	 * private Mapper() { mapper.registerModule(new JavaTimeModule());
	 * mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
	 * 
	 * }
	 */

	public ObjectMapper getObjectMapper() {
		return mapper;
	}
}
