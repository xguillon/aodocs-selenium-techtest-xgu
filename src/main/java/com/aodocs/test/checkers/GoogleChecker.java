/**
 * 
 */
package com.aodocs.test.checkers;

import static com.aodocs.test.core.assertions.AODocsAssertions.assertEquals;
import static com.aodocs.test.core.assertions.AODocsAssertions.assertTrue;

import com.aodocs.test.behavior.Google;

import io.qameta.allure.Step;

/**
 * @author Xavier Guillon
 *
 */
public class GoogleChecker {
	private Google google = new Google();

	/****
	 * All @Steps annotation have been removed. When they are present, an error
	 * occurs when launching command mvn test.
	 *
	 * if launching as a JUnit test, annotation can be present
	 */

	@Step("Searching {0} in Google")
	public void search(String query) {
		boolean res = google.setSearchQuery(query);

		assertTrue(res, "Setting Google query search");

		res = google.launchSearch();
		assertTrue(res, "Launching Google search");
	}

	/***
	 * 
	 */
	@Step("Loaging Google home page")
	public void loadHomePage() {
		boolean res = google.loadGoogleHomePage();
		assertTrue(res, "Loading Google homapage");
	}

	@Step("Agree Google CGU")
	public void agreeCGU() {
		boolean res = google.agreeCGU();
		assertTrue(res, "Agreeing CGU");
	}

	/***
	 * 
	 * @param position    starts at 1
	 * @param expectedUrl
	 */

	@Step("Check {0}th result URL")
	public void checkResultURL(int position, String expectedUrl) {
		String url = google.getResultUrl(position);

		assertEquals(expectedUrl, url, "Checking Google result URL");
	}

	/***
	 * 
	 * Open any result in Google. Define the position of the link
	 * 
	 * @param position starts at 1
	 */
	@Step("Open link at position {0}")
	public void openLink(int position) {
		boolean res = google.openLink(1);
		assertTrue(res, "Opening google link");
	}
}
