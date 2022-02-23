/**
 * 
 */
package com.aodocs.test.core.config;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import selenium.driver.Browser;

/**
 * @author Xavier Guillon
 *
 */
@JsonIgnoreProperties
public class Config {
	private Long timeout;
	private String isGrid;
	private String gridServer;
	private String browser;
	private String screenshot; // available values are NONE|ALL|FAIL

	/**
	 * @return the timeout
	 */
	public Long getTimeout() {
		return timeout;
	}

	/**
	 * @param timeout the timeout to set
	 */
	public void setTimeout(Long timeout) {
		this.timeout = timeout;
	}

	/**
	 * @return the gridServer
	 */
	public String getGridServer() {
		return gridServer;
	}

	/**
	 * @param gridServer the gridServer to set
	 */
	public void setGridServer(String gridServer) {
		this.gridServer = gridServer;
	}

	/**
	 * @return the browser
	 */
	public String getBrowser() {
		return browser;
	}

	/**
	 * @param browser the browser to set
	 */
	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public Browser getBrowserEnum() {
		return Browser.valueOf(getBrowser());
	}

	/**
	 * @return the screenshot
	 */
	public String getScreenshot() {
		return screenshot;
	}

	/**
	 * @param screenshot the screenshot to set
	 */
	public void setScreenshot(String screenshot) {
		this.screenshot = screenshot;
	}

	/**
	 * @return the isGrid
	 */
	public boolean isGrid() {
		return Boolean.valueOf(getIsGrid());
	}

	public String getIsGrid() {
		return isGrid;
	}

	/**
	 * @param isGrid the isGrid to set
	 */
	public void setIsGrid(String isGrid) {
		this.isGrid = isGrid;
	}

}
