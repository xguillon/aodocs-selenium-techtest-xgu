/**
 * 
 */
package com.aodocs.test.core.setup;

import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

/**
 * @author Xavier Guillon
 *
 */
public abstract class TestSuiteAbstract {

	@BeforeAll
	public static void setUp() throws IOException {
		SetUp.setUp();
	}

	@AfterAll
	public static void tearDown() {
		SetUp.tearDown();
	}

}
