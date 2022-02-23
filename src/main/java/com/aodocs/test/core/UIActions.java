/**
 * 
 */
package com.aodocs.test.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aodocs.test.bindings.Bindings;

/**
 * Methods to be implemented on DomActions + some usefull methods but not to be
 * used alone (findElement, waitElementClickable, etc...)
 * 
 * @author Xavier Guillon
 *
 */
public abstract class UIActions {

	protected Logger log;

	/**
	 * @param b
	 * @param args
	 * @return
	 */
	public abstract boolean click(Bindings b, Object... args);

	public abstract boolean addTextFieldValue(String value, Bindings b, Object... args);

	public abstract boolean clearTextFieldValue(Bindings b, Object... args);

	public abstract String grabTextFieldValue(Bindings b, Object... args);

	public abstract boolean setSelectValue(String value, Bindings b, Object... args);

	public abstract boolean loadURL(String url);

	public abstract String getAttribute(String attibuteName, Bindings b, Object... args);

	public WebDriverWait getWebDriverWait(WebDriver wd) {
		return new WebDriverWait(wd, Environment.getConfig().getTimeout());
	}

	public void waitElementClickable(DOMElement e) {
		getWebDriverWait(Environment.getDriver()).until(ExpectedConditions.elementToBeClickable(e.getBy()));
	}

	public void waitElementPresent(DOMElement e) {
		getWebDriverWait(Environment.getDriver()).until(ExpectedConditions.presenceOfElementLocated(e.getBy()));
	}

	public void waitElementPresent(DOMElement parent, DOMElement child) {
		getWebDriverWait(Environment.getDriver())
				.until(ExpectedConditions.presenceOfNestedElementLocatedBy(parent.getBy(), child.getBy()));
	}

	/**
	 * findElement method Calls the findElement method of WebDriver. Allows to
	 * search and locate an element on a webpage.
	 *
	 * @param by a By Object, allowing to locate an element within a document.
	 * @return a WebElement object
	 */
	public WebElement findElement(By by) {
		return Environment.getDriver().findElement(by);
	}

	public void waitElementPresentWithAttribute(DOMElement e, String attribute) {
		waitElementPresent(e);
		WebDriverWait wait = getWebDriverWait(Environment.getDriver());
		try {
			wait.until(ExpectedConditions.attributeToBeNotEmpty(findElement(e.getBy()), attribute));
		} catch (Exception ex) {
			warn(ex);
		}

	}

	public void waitElementPresentWithAttribute(DOMElement parent, DOMElement child, String attribute) {
		waitElementPresent(parent, child);
		WebDriverWait wait = getWebDriverWait(Environment.getDriver());
		try {
			WebElement we = findElement(parent.getBy()).findElement(child.getBy());
			wait.until(ExpectedConditions.attributeToBeNotEmpty(we, attribute));
		} catch (Exception ex) {
			warn(ex);
		}

	}

	/**
	 * @return the logger
	 */

	public Logger getLogger() {
		return log;
	}

	public void setLogger(Logger log) {
		this.log = log;
	}

	public void error(String message) {
		getLogger().error(message);
	}

	public void error(Exception e) {
		getLogger().error(e);
	}

	public void debug(String message) {
		getLogger().debug(message);
	}

	public void info(String message) {
		getLogger().info(message);
	}

	public void warn(String message) {
		getLogger().warn(message);
	}

	public void warn(Exception e) {
		getLogger().warn(e);
	}

	public void trace(String message) {
		getLogger().trace(message);
	}

	public UIActions() {
		setLogger(LogManager.getLogger(this.getClass().getName()));

	}

}
