/**
 * 
 */
package com.aodocs.test.checkers;

import static com.aodocs.test.core.assertions.AODocsAssertions.assertTrue;

import com.aodocs.test.behavior.AODocsWebSite;

import io.qameta.allure.Step;

/**
 * @author Xavier Guillon
 *
 */
public class AODocsChecker {
	private AODocsWebSite aodocs = new AODocsWebSite();

	/****
	 * All @Steps annotation have been removed. When they are present, an error
	 * occurs when launching command mvn test.
	 *
	 * if launching as a JUnit test, annotation can be present
	 */

	@Step("Opening request a demo form")
	public void requestDemo() {
		boolean res = aodocs.requestDemo();

		assertTrue(res, "Opening Request a demo form");
	}

	@Step("Submit contact form")
	public void submitForm() {
		boolean res = aodocs.submitForm();
		assertTrue(res, "submitting request form");
	}

	@Step("Reject cookies")
	public void rejectCookies() {
		boolean res = aodocs.rejectCookies();
		assertTrue(res, "rejecting cookies");
	}
}
