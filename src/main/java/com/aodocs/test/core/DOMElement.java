/**
 * 
 */
package com.aodocs.test.core;

import org.openqa.selenium.By;

import com.aodocs.test.bindings.QueryTypes;

/**
 * @author Xavier Guillon
 *
 */
public class DOMElement {
	private String queryType;
	private String query;
	private By by;

	public DOMElement(String query, String queryType) {
		this.queryType = queryType;
		this.query = query;
		autosetBy();
	}

	public void autosetBy() {
		switch (queryType) {
		case QueryTypes.XPATH:
			this.by = By.xpath(query);
			break;
		case QueryTypes.ID:
			this.by = By.id(query);
			break;
		case QueryTypes.CSS:
			this.by = By.cssSelector(query);
			break;
		case QueryTypes.NAME:
			this.by = By.name(query);
			break;
		default:
			this.by = By.cssSelector(query);
			break;

		}

	}

	/**
	 * @return the queryType
	 */
	public String getQueryType() {
		return queryType;
	}

	/**
	 * @param queryType the queryType to set
	 */
	public void setQueryType(String queryType) {
		this.queryType = queryType;
	}

	/**
	 * @return the query
	 */
	public String getQuery() {
		return query;
	}

	/**
	 * @param query the query to set
	 */
	public void setQuery(String query) {
		this.query = query;
	}

	/**
	 * @return the by
	 */
	public By getBy() {
		return by;
	}

	/**
	 * @param by the by to set
	 */
	public void setBy(By by) {
		this.by = by;
	}

}
