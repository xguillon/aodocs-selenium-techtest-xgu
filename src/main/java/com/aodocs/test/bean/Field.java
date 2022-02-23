/**
 * 
 */
package com.aodocs.test.bean;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

import com.aodocs.test.bean.enums.FieldType;
import com.aodocs.test.checkers.FieldChecker;

/**
 * @author Xavier Guillon
 *
 */
public class Field {
	private String name;
	private String value;
	private String errorMsg;
	private FieldType fieldType;

	public Field(String name, FieldType fieldType) {
		this.name = name;
		this.fieldType = fieldType;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the fieldType
	 */
	public FieldType getFieldType() {
		return fieldType;
	}

	/**
	 * @param fieldType the fieldType to set
	 */
	public void setFieldType(FieldType fieldType) {
		this.fieldType = fieldType;
	}

	/**
	 * @return the errorMsg
	 */
	public String getErrorMsg() {
		return errorMsg;
	}

	/**
	 * @param errorMsg the errorMsg to set
	 */
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	public Map<String, String> getAllureLog() {
		Map<String, String> logAllure = new HashMap<>();
		logAllure.put(FieldChecker.ADD_FIELD_VALUE_LOG, MessageFormat.format("Add field {0} value", getName()));
		logAllure.put(FieldChecker.CHECK_FIELD_VALUE_LOG,
				MessageFormat.format("Checking if field {0} value", getName()));
		logAllure.put(FieldChecker.CHECK_ERROR_MSG_PRESENT_LOG,
				MessageFormat.format("Checking if error message is not present for field {0}", getName()));

		return logAllure;
	}
}
