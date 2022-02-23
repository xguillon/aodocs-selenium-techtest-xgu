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
public class AODocsTextField extends AODocsFields {
	UIDesktopActions ui = new UIDesktopActions();

	@Override
	public boolean addFieldValue() {
		return ui.addTextFieldValue(getField().getValue(), TextFields.INPUT, getField().getName());
	}

	@Override
	public boolean clearFieldValue() {
		return ui.clearTextFieldValue(TextFields.INPUT, getField().getName());

	}

	public AODocsTextField(Field field) {
		setField(field);
	}
}
