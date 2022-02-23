/**
 * 
 */
package com.aodocs.test.checkers;

import static com.aodocs.test.core.assertions.AODocsAssertions.assertEquals;
import static com.aodocs.test.core.assertions.AODocsAssertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.function.Executable;

import com.aodocs.test.bean.Field;
import com.aodocs.test.behavior.fields.AODocsFields;
import com.aodocs.test.behavior.fields.AODocsSelectField;
import com.aodocs.test.behavior.fields.AODocsTextAreaField;
import com.aodocs.test.behavior.fields.AODocsTextField;

import io.qameta.allure.Step;

/**
 * @author Xavier Guillon
 *
 */
public class FieldChecker {
	private Field field;

	/****
	 * All @Steps annotation have been removed. When they are present, an error
	 * occurs when launching command mvn test.
	 *
	 * if launching as a JUnit test, annotation can be present
	 */

	public FieldChecker(Field field) {
		setField(field);

	}

	public FieldChecker() {
		// nothing to do. To be used with method checkSeveralFieldsErrorMsg(List<Field)
	}

	/***
	 * 
	 * @throws Exception
	 */
	public void addFieldValue() throws Exception {
		addFieldValue(getField().getAllureLog().get(ADD_FIELD_VALUE_LOG));
	}

	/***
	 * 
	 * @throws Exception
	 */
	public void clearFieldValue() throws Exception {
		clearFieldValue(getField().getAllureLog().get(ADD_FIELD_VALUE_LOG));
	}

	/***
	 * 
	 * @throws Exception
	 */
	public void checkFieldErrorMsg() throws Exception {
		checkFieldErrorMsg(getField().getAllureLog().get(CHECK_ERROR_MSG_PRESENT_LOG));
	}

	/***
	 * 
	 * @param fields
	 * @throws Exception
	 */
	public void checkSeveralFieldsErrorMsg(List<Field> fields) throws Exception {
		List<AssertionError> assertionList = new ArrayList<>();

		for (Field field : fields) {
			setField(field);
			try {
				checkFieldErrorMsg();
			} catch (AssertionError error) {
				assertionList.add(error);
			}
		}

		List<Executable> exList = new ArrayList<>();
		for (AssertionError ae : assertionList) {
			exList.add(() -> assertNull(ae, "Checking error msg for different fields"));
		}
		assertAll(exList);
	}

	/***
	 * define which type of field can be used.
	 * 
	 * @return
	 * @throws Exception
	 */
	private AODocsFields getFieldImplementation() throws Exception {
		switch (field.getFieldType()) {
		case TEXT:
			return new AODocsTextField(getField());
		case TEXTAREA:
			return new AODocsTextAreaField(getField());
		case SELECT:
			return new AODocsSelectField(getField());
		default:
			throw new Exception("Type of field not specified");

		}

	}

	/***
	 * method present only to have some clean allure logs
	 * 
	 * @param allureLog
	 * @throws Exception
	 */
	@Step("{0}")
	private void addFieldValue(String allureLog) throws Exception {
		boolean res = getFieldImplementation().addFieldValue();

		assertTrue(res, MessageFormat.format("Adding value to field {0}", getField().getName()));

	}

	/***
	 * method present only to have some clean allure logs
	 * 
	 * @param allureLog
	 * @throws Exception
	 */
	@Step("{0}")
	private void clearFieldValue(String allureLog) throws Exception {
		boolean res = getFieldImplementation().clearFieldValue();

		assertTrue(res, MessageFormat.format("Clearing field {0} value", getField().getName()));

	}

	/***
	 * method present only to have some clean allure logs
	 * 
	 * @param allureLog
	 * @throws Exception
	 */
	@Step("{0}")
	private void checkFieldErrorMsg(String allureLog) throws Exception {
		String errorMsg = getFieldImplementation().getErrorMsg();

		assertEquals(getField().getErrorMsg(), errorMsg,
				MessageFormat.format("Checking field {0} error message", getField().getName()));

	}

	public void setField(Field field) {
		this.field = field;
	}

	public Field getField() {
		return field;
	}

	public static final String ADD_FIELD_VALUE_LOG = "addFieldValue";
	public static final String CHECK_FIELD_VALUE_LOG = "getFieldValue";
	public static final String CHECK_ERROR_MSG_PRESENT_LOG = "errorMsgPresent";

}
