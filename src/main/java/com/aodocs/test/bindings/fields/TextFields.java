/**
 * 
 */
package com.aodocs.test.bindings.fields;

import com.aodocs.test.bindings.Bindings;
import com.aodocs.test.bindings.QueryTypes;

/**
 * @author Xavier Guillon
 *
 */
public enum TextFields implements Bindings {
	INPUT("div.{0} input", QueryTypes.CSS), // fieldname is considered as the classname. For example hs_firstname
	ERROR_MESSAGE("div.{0} label.hs-error-msg", QueryTypes.CSS);

	private String query = "";
	private String queryType = "";

	TextFields(String value, String type) {
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
