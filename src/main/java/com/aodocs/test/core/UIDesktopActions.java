/**
 * 
 */
package com.aodocs.test.core;

import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.aodocs.test.bindings.Bindings;
import com.aodocs.test.bindings.BindingsParams;

/**
 * @author Xavier Guillon
 * 
 *         Action to be performed on elements : click, hover, isPresent, etc....
 * 
 *         actions on fields are not present (present in UIFieldActions
 *
 */
public class UIDesktopActions extends UIActions {
	@Override
	public boolean click(Bindings b, Object... args) {
		DOMElement e = QueryBuilder.getQuery(b, args);

		try {
			debug("click on button : Waiting on visibility of button ");

			waitElementClickable(e);

			WebElement el = findElement(e.getBy());
			performClick(el);

			return true;

		} catch (StaleElementReferenceException stale) {// In case of a stale Element, a second try is done to avoid
														// errors
			warn("stale element found, new attempt to click");
			try {

				WebElement el = findElement(e.getBy());
				performClick(el);

				debug("click ok");
				return true;

			} catch (Exception ex) {
				error("error while clicking on button (Element was stale");
				error(ex);

				return false;
			}

		} catch (Exception ex) {
			error("error while clicking on button");
			error(ex);

			return false;
		}

	}

	public boolean click(BindingsParams b) {
		DOMElement parent = QueryBuilder.getQuery(b.getB(), b.getArgs());
		DOMElement child = QueryBuilder.getQuery(b.getChild().getB(), b.getChild().getArgs());

		try {
			debug("click on button : Waiting on visibility of button ");

			WebElement we = findElement(parent.getBy()).findElement(child.getBy());
			waitElementPresent(parent);

			performClick(we);

			return true;

		} catch (StaleElementReferenceException stale) {// In case of a stale Element, a second try is done to avoid
														// errors
			warn("stale element found, new attempt to click");
			try {

				WebElement we = findElement(parent.getBy()).findElement(child.getBy());
				performClick(we);

				debug("click ok");
				return true;

			} catch (Exception ex) {
				error("error while clicking on button (Element was stale");
				error(ex);

				return false;
			}

		} catch (Exception ex) {
			error("error while clicking on button");
			error(ex);

			return false;
		}
	}

	@Override
	public boolean addTextFieldValue(String value, Bindings b, Object... args) {

		DOMElement e = QueryBuilder.getQuery(b, args);

		try {
			findElement(e.getBy()).sendKeys(value);

			debug("Value setted to " + value);
			return true;
		} catch (Exception ex) {
			error("error while setting text field value ");
			error(ex);
			return false;
		}
	}

	@Override
	public boolean clearTextFieldValue(Bindings b, Object... args) {

		DOMElement e = QueryBuilder.getQuery(b, args);

		try {
			findElement(e.getBy()).clear();

			debug("Value cleared to ");
			return true;
		} catch (Exception ex) {
			error("error while clearing text field value ");
			error(ex);
			return false;
		}
	}

	@Override
	public String grabTextFieldValue(Bindings b, Object... args) {
		DOMElement e = QueryBuilder.getQuery(b, args);

		try {
			waitElementPresent(e);

			String value = findElement(e.getBy()).getAttribute("value");
			debug("Value is : " + value);
			return value;
		} catch (Exception ex) {
			error("error while retrieving field value : ");
			error(ex);
			return null;
		}
	}

	@Override
	public boolean setSelectValue(String value, Bindings b, Object... args) {
		DOMElement e = QueryBuilder.getQuery(b, args);
		try {

			Select selectElement = new Select(findElement(e.getBy()));
			selectElement.selectByValue(value);

			debug("value selected");
			return true;
		} catch (Exception ex) {
			error("error while selecting element on menu : ");
			error(ex);
			return false;
		}
	}

	@Override
	public boolean loadURL(String url) {
		try {
			Environment.getDriver().get(url);
			debug("url loaded");
			return true;
		} catch (Exception e) {
			error("Unable to connect to " + url);
			error(e.toString());
			return false;
		}
	}

	/***
	 * get text of any element : div, li, etc... /!\ don't get input value
	 * 
	 * @param b
	 * @param args
	 * @return
	 */
	public String getText(Bindings b, Object... args) {
		DOMElement e = QueryBuilder.getQuery(b, args);
		try {
			debug("Get text of of any element ");

			waitElementPresent(e);

			debug("Get textof button : getting attribute of button ");
			WebElement elt = findElement(e.getBy());

			return elt.getText().trim();
		} catch (Exception ex) {

			error("Impossible to get element's text");
			error(ex);
			return null;
		}
	}

	private void performClick(WebElement el) {

		debug("Trying to Click on button ");
		el.click();
		debug("click ok");

	}

	/***
	 * will probably not work on remote.
	 * 
	 * @param keys
	 * @return
	 */
	public boolean pressKey(Keys... keys) {
		try {
			Actions act = new Actions(Environment.getDriver());
			act.sendKeys(Keys.chord(keys)).perform();
			return true;
		} catch (Exception e) {
			error("error while pressing key(s)");
			error(e.toString());
			return false;

		}

	}

	@Override
	public String getAttribute(String attributeName, Bindings b, Object... args) {
		String attr = null;

		boolean elementFound;

		DOMElement e = QueryBuilder.getQuery(b, args);

		debug("Get Attribute : Waiting for presence of element");

		try {
			waitElementPresentWithAttribute(e, attributeName);
			elementFound = true;
		} catch (Exception ex) {
			warn("Element not present with attribute");
			warn(ex);
			elementFound = false;
		}

		if (elementFound) {
			debug("Get Attribute : getting attribute of element");

			attr = findElement(e.getBy()).getAttribute(attributeName);

		}

		return attr;
	}

	public String getAttribute(String attributeName, BindingsParams b) {

		String attr = null;

		boolean elementFound;

		debug("Get Attribute : Waiting for presence of element");

		DOMElement parent = QueryBuilder.getQuery(b.getB(), b.getArgs());
		DOMElement child = QueryBuilder.getQuery(b.getChild().getB(), b.getChild().getArgs());

		try {
			waitElementPresentWithAttribute(parent, child, attributeName);
			elementFound = true;
		} catch (Exception ex) {
			warn("Element not present with attribute");
			warn(ex);
			elementFound = false;
		}

		if (elementFound) {
			debug("Get Attribute : getting attribute of element");

			attr = findElement(parent.getBy()).findElement(child.getBy()).getAttribute(attributeName);

		}

		return attr;
	}

}
