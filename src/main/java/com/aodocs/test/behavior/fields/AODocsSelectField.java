/**
 * 
 */
package com.aodocs.test.behavior.fields;

import com.aodocs.test.bean.Field;
import com.aodocs.test.bindings.fields.SelectFields;
import com.aodocs.test.core.UIDesktopActions;

/**
 * @author Xavier Guillon
 *
 */
public class AODocsSelectField extends AODocsFields {
	private UIDesktopActions ui = new UIDesktopActions();

	@Override
	public boolean addFieldValue() {
		return ui.setSelectValue(getField().getValue(), SelectFields.INPUT, getField().getName());
	}

	public AODocsSelectField(Field field) {
		setField(field);
	}
}
