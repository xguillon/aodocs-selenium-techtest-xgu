/**
 * 
 */
package com.aodocs.test.core;

import java.text.MessageFormat;

import com.aodocs.test.bindings.Bindings;

/**
 * @author Xavier Guillon
 *
 */
public class QueryBuilder {

	/***
	 * 
	 * @param e
	 * @param args only primitive objects (String, boolean, int, float, etc...
	 *             should be used
	 * @return
	 */
	public static synchronized DOMElement getQuery(Bindings e, Object... args) {

		return new DOMElement(MessageFormat.format(e.getQuery().trim().replace("'", "''"), args), e.getQueryType());

	}

}
