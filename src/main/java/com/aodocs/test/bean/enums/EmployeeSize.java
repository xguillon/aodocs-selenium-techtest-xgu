/**
 * 
 */
package com.aodocs.test.bean.enums;

/**
 * @author Xavier Guillon
 *
 */
public enum EmployeeSize {

	EMPLOYEES_0_4("0-4 employees"), //
	EMPLOYEES_5_50("5-50 employees"), //
	EMPLOYEES_51_350("51-350 employees"), //
	EMPLOYEES_351_1000("351-1,000 employees"), //
	EMPLOYEES_1001_3000("1,001-3,000 employees"), //
	EMPLOYEES_3001_5000("3,001-5,000 employees"), //
	EMPLOYEES_5001(">5,000 employees"),//
	;

	private String value = "";

	private EmployeeSize(String value) {
		this.value = value;
	}

	public String getSize() {
		return value;
	}
}
