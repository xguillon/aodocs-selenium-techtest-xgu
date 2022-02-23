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
public enum SelectFields implements Bindings {
	INPUT("div.{0} select", QueryTypes.CSS), //
	;

	private String query = "";
	private String queryType = "";

	SelectFields(String value, String type) {
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
