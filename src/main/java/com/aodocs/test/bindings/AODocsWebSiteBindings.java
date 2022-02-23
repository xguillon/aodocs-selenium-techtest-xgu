/**
 * 
 */
package com.aodocs.test.bindings;

/**
 * @author Xavier Guillon
 * 
 *         All queries needed to interact with AODocs website
 *
 */
public enum AODocsWebSiteBindings implements Bindings {
	REQUEST_DEMO("//a[text()='Request a demo']", QueryTypes.XPATH), //
	SUBMIT("input[type='submit']", QueryTypes.CSS), //
	REJECT_COOKIES("ccc-notify-reject", QueryTypes.ID),//
	;

	private String query = "";
	private String queryType = "";

	AODocsWebSiteBindings(String value, String type) {
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
