/**
 * 
 */
package com.aodocs.test.behavior;

import org.openqa.selenium.Keys;

import com.aodocs.test.bindings.BindingsParams;
import com.aodocs.test.bindings.GoogleBindings;
import com.aodocs.test.core.UIDesktopActions;

/**
 * @author Xavier Guillon
 *
 */
public class Google {
	private UIDesktopActions ui = new UIDesktopActions();

	/***
	 * search any query in google
	 * 
	 * @param query
	 * @return
	 */
	public boolean setSearchQuery(String query) {
		return ui.addTextFieldValue(query, GoogleBindings.SEARCH_FIELD);
	}

	/***
	 * position of result inside list
	 * 
	 * @param position. Starts at 1
	 * @return
	 */
	public boolean launchSearch() {
		return ui.pressKey(Keys.ENTER);
	}

	public boolean loadGoogleHomePage() {
		return ui.loadURL("https://www.google.com");

	}

	public boolean agreeCGU() {
		return ui.click(GoogleBindings.AGREE_CGU);
	}

	public String getResultUrl(int position) {
		BindingsParams child = new BindingsParams(GoogleBindings.RESULT_URL);
		BindingsParams parent = new BindingsParams(new BindingsParams(GoogleBindings.RESULT, position), child);
		return ui.getAttribute("href", parent);
	}

	public boolean openLink(int position) {
		BindingsParams child = new BindingsParams(GoogleBindings.RESULT_LINK);
		BindingsParams parent = new BindingsParams(new BindingsParams(GoogleBindings.RESULT, position), child);
		return ui.click(parent);
	}
}
