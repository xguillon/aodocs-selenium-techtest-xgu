/**
 * 
 */
package com.aodocs.test.bindings.fields;

import com.aodocs.test.bindings.Bindings;

/**
 * @author Xavier Guillon
 *
 */
public enum TextAreaFields implements Bindings {
	;

	private String query = "";
	private String queryType = "";

	TextAreaFields(String value, String type) {
		this.query = value;
		this.queryType = type;
	}

	@Override
	public String getQuery() {
		return query;
	}

	@Override
	public String getQueryType() {
		return queryType;
	}

}
