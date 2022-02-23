/**
 * 
 */
package com.aodocs.test.core.setup;

import java.io.IOException;

import com.aodocs.test.core.Environment;
import com.aodocs.test.core.config.ConfigSerializer;

import selenium.driver.WebDriverUtility;

/**
 * @author Xavier Guillon
 *
 */
public class SetUp {

	public static void setUp() throws IOException {
		ConfigSerializer confSerializer = new ConfigSerializer();

		Environment.setConfig(confSerializer.deserialize(System.getProperty("config")));

		Environment.setDriver();
	}

	public static void tearDown() {
		WebDriverUtility.closeWebDriver(Environment.getDriver());
		;
	}
}
