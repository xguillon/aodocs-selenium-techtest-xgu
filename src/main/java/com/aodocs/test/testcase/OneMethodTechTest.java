/**
 * 
 */
package com.aodocs.test.testcase;

import java.util.Arrays;
import java.util.Random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.aodocs.test.bean.Field;
import com.aodocs.test.bean.enums.EmployeeSize;
import com.aodocs.test.bean.enums.FieldType;
import com.aodocs.test.bindings.Fieldnames;
import com.aodocs.test.checkers.AODocsChecker;
import com.aodocs.test.checkers.FieldChecker;
import com.aodocs.test.checkers.GoogleChecker;
import com.aodocs.test.core.setup.TestCaseAbstract;
import com.github.javafaker.Faker;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;

/**
 * @author Xavier Guillon
 *
 */
@Epic("Technical tests")
@DisplayName("Test created in 1 method")
public class OneMethodTechTest extends TestCaseAbstract {
	private GoogleChecker googleChecker = new GoogleChecker();
	private AODocsChecker aodocsChecker = new AODocsChecker();

	@Test
	@TmsLink("1234") // fictive id of testcase
	@Description("Open Google, search AODocs, request demo, check form errors")
	@DisplayName("Technical test - 1 method")
	@Feature("All in one method")
	public void testSimple() throws Exception {
		googleChecker.loadHomePage();

		googleChecker.agreeCGU();
		googleChecker.search("AODocs");
		googleChecker.checkResultURL(1, "https://www.aodocs.com/");
		googleChecker.openLink(1);

		/// cookies banner must be closed to avoid false negative results when ///
		// submitting form
		aodocsChecker.rejectCookies();
		aodocsChecker.requestDemo();

		Faker faker = new Faker();

		Field firstname = new Field(Fieldnames.FIRSTNAME, FieldType.TEXT);
		firstname.setValue(faker.name().firstName());
		new FieldChecker(firstname).addFieldValue();

		Field lastname = new Field(Fieldnames.LASTNAME, FieldType.TEXT);
		new FieldChecker(lastname).clearFieldValue();

		Field email = new Field(Fieldnames.EMAIL, FieldType.TEXT);
		email.setValue(faker.name().lastName());
		new FieldChecker(email).addFieldValue();

		Field employees = new Field(Fieldnames.COMPANY_SIZE, FieldType.SELECT);
		employees.setValue(getRandomEmployeeSize().getSize());
		new FieldChecker(employees).addFieldValue();

		aodocsChecker.submitForm();

		lastname.setErrorMsg(Fieldnames.ERROR_TEXT_FIELD_MANDATORY);
		email.setErrorMsg(Fieldnames.ERROR_EMAIL_FORMATY);

		Field country = new Field(Fieldnames.COUNTRY, FieldType.SELECT);
		country.setErrorMsg(Fieldnames.ERROR_DROPDOWN_MANDATORY);

		Field hear = new Field(Fieldnames.HEAR, FieldType.SELECT);
		hear.setErrorMsg(Fieldnames.ERROR_DROPDOWN_MANDATORY);

		Field phone = new Field(Fieldnames.PHONE, FieldType.TEXT);

		Field companyName = new Field(Fieldnames.COMPANY, FieldType.TEXT);
		companyName.setErrorMsg(Fieldnames.ERROR_TEXT_FIELD_MANDATORY);

		Field requestType = new Field(Fieldnames.REQUEST_TYPE, FieldType.SELECT);

		Field message = new Field(Fieldnames.MESSAGE, FieldType.TEXTAREA);
		message.setErrorMsg(Fieldnames.ERROR_TEXT_FIELD_MANDATORY);

		new FieldChecker().checkSeveralFieldsErrorMsg(Arrays.asList(firstname, lastname, email, employees, country,
				hear, phone, companyName, requestType, message));
	}

	private EmployeeSize getRandomEmployeeSize() {
		int pick = new Random().nextInt(EmployeeSize.values().length);
		return EmployeeSize.values()[pick];
	}
}
