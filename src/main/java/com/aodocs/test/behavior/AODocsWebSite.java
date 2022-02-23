/**
 * 
 */
package com.aodocs.test.behavior;

import com.aodocs.test.bindings.AODocsWebSiteBindings;
import com.aodocs.test.core.UIDesktopActions;

/**
 * @author Xavier Guillon
 *
 */
public class AODocsWebSite {
	UIDesktopActions ui = new UIDesktopActions();

	public boolean requestDemo() {
		return ui.click(AODocsWebSiteBindings.REQUEST_DEMO);
	}

	public boolean submitForm() {
		return ui.click(AODocsWebSiteBindings.SUBMIT);
	}

	public boolean rejectCookies() {
		return ui.click(AODocsWebSiteBindings.REJECT_COOKIES);
	}
}
