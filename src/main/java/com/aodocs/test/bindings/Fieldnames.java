/**
 * 
 */
package com.aodocs.test.bindings;

/**
 * @author Xavier Guillon
 *
 */
public class Fieldnames {
	public static final String FIRSTNAME = "hs_firstname";
	public static final String LASTNAME = "hs_lastname";
	public static final String EMAIL = "hs_email";
	public static final String PHONE = "hs_phone";
	public static final String COMPANY = "hs_company";
	public static final String COMPANY_SIZE = "hs_company_size__c";
	public static final String COUNTRY = "hs_country";
	public static final String REQUEST_TYPE = "hs_request_type";
	public static final String MESSAGE = "hs_your_request__c";
	public static final String HEAR = "hs_how_did_you_hear_about_us_";
	public static final String ERROR_TEXT_FIELD_MANDATORY = "Please complete this required field.";
	public static final String ERROR_DROPDOWN_MANDATORY = "Please select an option from the dropdown menu.";
	public static final String ERROR_EMAIL_FORMATY = "Email must be formatted correctly.";

	private Fieldnames() throws Exception {
		throw new Exception("do not instanciate class : only constants are present");
	}

}
