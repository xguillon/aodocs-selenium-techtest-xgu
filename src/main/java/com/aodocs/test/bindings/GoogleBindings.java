/**
 * 
 */
package com.aodocs.test.bindings;

/**
 * @author Xavier Guillon
 *
 *         All queries needed to interact with Google website
 */
public enum GoogleBindings implements Bindings {
	SEARCH_FIELD("input[name='q']", QueryTypes.CSS), //
	AGREE_CGU("//div[text()='I agree']", QueryTypes.XPATH), //
	RESULT("#search h1 + div>div:nth-of-type({0})", QueryTypes.CSS), // Not sure with this query : works with
																		// the first elements, but should be
																		// tested for more results
	RESULT_URL(" link", QueryTypes.CSS), // relative to RESULT
	RESULT_LINK(" a", QueryTypes.CSS), // relative to RESULT
	;

	private String query = "";
	private String queryType = "";

	GoogleBindings(String value, String type) {
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
