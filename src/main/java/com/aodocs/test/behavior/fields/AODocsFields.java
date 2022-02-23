/**
 * 
 */
package com.aodocs.test.behavior.fields;

import com.aodocs.test.bean.Field;
import com.aodocs.test.bindings.fields.TextFields;
import com.aodocs.test.core.UIDesktopActions;

/**
 * @author Xavier Guillon
 *
 */
public abstract class AODocsFields {
	protected Field field;
	private UIDesktopActions ui = new UIDesktopActions();

	public boolean addFieldValue() {
		System.out.print("method not implemented");
		return false;
	}

	public boolean clearFieldValue() {
		System.out.print("method not implemented");
		return false;
	}

	public boolean grabFieldValue() {
		System.out.print("method not implemented");
		return false;
	}

	/***
	 * error message are always displayed in the same way for all fields types
	 * 
	 * @return
	 */
	public String getErrorMsg() {
		return ui.getText(TextFields.ERROR_MESSAGE, getField().getName());

	}

	public void setField(Field field) {
		this.field = field;
	}

	public Field getField() {
		return field;
	}

}
