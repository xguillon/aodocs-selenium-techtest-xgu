/**
 * 
 */
package com.aodocs.test.core.setup;

import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

/**
 * @author Xavier Guillon
 *
 */
public abstract class TestCaseAbstract {

	@BeforeEach
	public void setUp() throws IOException {
		SetUp.setUp();
	}

	@AfterEach
	public void tearDown() {
		SetUp.tearDown();
	}

}
