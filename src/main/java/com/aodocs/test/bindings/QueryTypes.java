package com.aodocs.test.bindings;

public final class QueryTypes {
	/***
	 * css query
	 */
	public static final String CSS = "css";
	/***
	 * xpath query
	 */
	public static final String XPATH = "xpath";
	/***
	 * id
	 */
	public static final String ID = "id";
	/***
	 * class
	 */
	public static final String NAME = "name";

	/// only static constants. Constructor should not be used
	private QueryTypes() {
		throw new AssertionError();
	}
}
