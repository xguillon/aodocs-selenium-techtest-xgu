/**
 * 
 */
package com.aodocs.test.core;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;

import com.aodocs.test.core.config.Config;

import selenium.driver.WebDriverUtility;

/**
 * @author Xavier Guillon
 *
 */
public class Environment {
	private static WebDriver driver;
	private static Config config;

	/**
	 * @return the driver
	 */
	public static WebDriver getDriver() {
		return driver;
	}

	/**
	 * @param driver the driver to set
	 * @throws MalformedURLException
	 */
	public static void setDriver() throws MalformedURLException {
		Environment.driver = instanciateDriver();
	}

	/**
	 * @return the config
	 */
	public static Config getConfig() {
		return config;
	}

	/**
	 * @param config the config to set
	 */
	public static void setConfig(Config config) {
		Environment.config = config;
	}

	private static WebDriver instanciateDriver() throws MalformedURLException {

		if (getConfig().isGrid()) {
			return WebDriverUtility.getGridWebDriver(Environment.getConfig().getBrowserEnum());
		} else {
			return WebDriverUtility.getWebDriver(Environment.getConfig().getBrowserEnum());
		}
	}

}
