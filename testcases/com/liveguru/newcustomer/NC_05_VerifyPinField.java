package com.liveguru.newcustomer;

import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.liveguru.CustomerLiveGuruData;
import com.liveguru.LoginData;

import commons.AbstractPages;
import commons.AbstractTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObjects.liveguru.AddLiveGuruPageObjects;
import pageObjects.liveguru.DashboardLiveGuruPageObjects;
import pageObjects.liveguru.EditCustomerLiveGuruPageObjects;
import pageObjects.liveguru.LoginLiveGuruPageObjects;
import pageObjects.liveguru.ManagerLiveGuruPageObjects;
import pageObjects.wordpress.admin.LoginPageObjects;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class NC_05_VerifyPinField extends AbstractTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		log.info("Pre-condition Step 1: Open browser with url");
		driver = getBrowserDriver(browserName);

		loginPage = PageGeneratorManager.getLoginLiveGuruPage(driver);
		loginPage.openLoginLiveGuruPage(driver);

		loginPage.inputToEmailTextbox(GlobalConstants.USER_NAME);
		loginPage.inputToPaswordTextbox(GlobalConstants.PASSWORD);
		dashboardPage = loginPage.clickLoginButton();
		verifyTrue(dashboardPage.isWelcomeMessageDisplayed());
	}

	@BeforeMethod
	public void beforeTest() {
		loginPage.openLiveGuruMenuPageByName(driver, CustomerLiveGuruData.PageName.NEW_CUSTOMER);
		addPage = PageGeneratorManager.getAddLiveGuruPage(driver);
		verifyTrue(addPage.isHeaderDisplayedByFormName(driver, CustomerLiveGuruData.TitleForm.ADD_NEW_CUSTOMER_FORM));
	}

	@Test(description = "NC16 - PIN cannot be empty ")
	public void NC_16_PIN_Can_Not_Be_Empty() {
		addPage.pressTabKeyboard(CustomerLiveGuruData.ClassNameAddTable.PIN);
		verifyTrue(addPage.verifyErrorMessageDisplayed(CustomerLiveGuruData.TitleTextboxNewCustomer.PIN,
				CustomerLiveGuruData.NCMessage.PIN_BLANK));
	}
	@Test(description = "NC17 - PIN must be numberic ")
	public void NC_17_PIN_Must_Be_Numberic() {
		addPage.inputToTextboxByClassName(CustomerLiveGuruData.InvalidNCRegister.PIN_NOT_NUMBERIC,
				CustomerLiveGuruData.ClassNameAddTable.PIN);
		verifyTrue(addPage.verifyErrorMessageDisplayed(CustomerLiveGuruData.TitleTextboxNewCustomer.PIN,
				CustomerLiveGuruData.NCMessage.PIN_CHARACTERS));
	}
	@Test(description = "NC18 - PIN must have 6 digits ")
	public void NC_18_PIN_Must_Have_6_Digits() {
		addPage.inputToTextboxByClassName(CustomerLiveGuruData.InvalidNCRegister.PIN_LESS_THAN_6_DIGITS,
				CustomerLiveGuruData.ClassNameAddTable.PIN);
		verifyTrue(addPage.verifyErrorMessageDisplayed(CustomerLiveGuruData.TitleTextboxNewCustomer.PIN,
				CustomerLiveGuruData.NCMessage.PIN_MUST_HAVE_6_DIGITS));
	}
	@Test(description = "NC19 - PIN cannot have special character")
	public void NC_19_PIN_Can_Not_Have_Special_Character() {
		addPage.inputToTextboxByClassName(CustomerLiveGuruData.InvalidNCRegister.PIN_SPECIAL_CHAR,
				CustomerLiveGuruData.ClassNameAddTable.PIN);
		verifyTrue(addPage.verifyErrorMessageDisplayed(CustomerLiveGuruData.TitleTextboxNewCustomer.PIN,
				CustomerLiveGuruData.NCMessage.PIN_SPECIAL_CHAR));
	}
	@Test(description = "NC20 - PIN cannot have first blank space")
	public void NC_20_PIN_Can_Not_Have_First_Blank() {
		addPage.inputToTextboxByClassName(CustomerLiveGuruData.InvalidNCRegister.PIN_BLANK_FIRST,
				CustomerLiveGuruData.ClassNameAddTable.PIN);
		verifyTrue(addPage.verifyErrorMessageDisplayed(CustomerLiveGuruData.TitleTextboxNewCustomer.PIN,
				CustomerLiveGuruData.NCMessage.PIN_BLANK_FIRST));
	}
	@Test(description = "NC21 - PIN cannot have blank space")
	public void NC_21_PIN_Can_Not_Have_Blank_Space() {
		addPage.inputToTextboxByClassName(CustomerLiveGuruData.InvalidNCRegister.PIN_HAVE_BLANK,
				CustomerLiveGuruData.ClassNameAddTable.PIN);
		verifyTrue(addPage.verifyErrorMessageDisplayed(CustomerLiveGuruData.TitleTextboxNewCustomer.PIN,
				CustomerLiveGuruData.NCMessage.PIN_HAVE_BLANK));
	}


	@AfterClass(alwaysRun = true)
	public void afterClass() {
		log.info("Post-Condition Close browser");
		closeBrowserAndDriver(driver);
	}

	private WebDriver driver;
	LoginLiveGuruPageObjects loginPage;
	DashboardLiveGuruPageObjects dashboardPage;
	AddLiveGuruPageObjects addPage;
	ManagerLiveGuruPageObjects managerPage;
	EditCustomerLiveGuruPageObjects editCustomerPage;
}
