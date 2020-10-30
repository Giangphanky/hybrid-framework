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

public class NC_04_VerifyStateField extends AbstractTest {

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

	@Test(description = "NC12 - State cannot be empty ")
	public void NC_12_State_Can_Not_Be_Empty() {
		addPage.pressTabKeyboard(CustomerLiveGuruData.ClassNameAddTable.STATE);
		verifyTrue(addPage.verifyErrorMessageDisplayed(CustomerLiveGuruData.TitleTextboxNewCustomer.STATE,
				CustomerLiveGuruData.NCMessage.STATE_BLANK));
	}
	@Test(description = "NC13 - State cannot be numberic ")
	public void NC_13_State_Can_Not_Be_Numberic() {
		addPage.inputToTextboxByClassName(CustomerLiveGuruData.InvalidNCRegister.STATE_NUMBERIC,
				CustomerLiveGuruData.ClassNameAddTable.STATE);
		verifyTrue(addPage.verifyErrorMessageDisplayed(CustomerLiveGuruData.TitleTextboxNewCustomer.STATE,
				CustomerLiveGuruData.NCMessage.STATE_NUMBER));
	}
	@Test(description = "NC14 - State cannot have special character")
	public void NC_14_State_Can_Not_Have_Special_Character() {
		addPage.inputToTextboxByClassName(CustomerLiveGuruData.InvalidNCRegister.STATE_SPECIAL_CHAR,
				CustomerLiveGuruData.ClassNameAddTable.STATE);
		verifyTrue(addPage.verifyErrorMessageDisplayed(CustomerLiveGuruData.TitleTextboxNewCustomer.STATE,
				CustomerLiveGuruData.NCMessage.STATE_SPECIAL_CHAR));
	}
	@Test(description = "NC15 - State cannot have first blank space")
	public void NC_15_State_Can_Not_Have_First_Blank() {
		addPage.inputToTextboxByClassName(CustomerLiveGuruData.InvalidNCRegister.STATE_BLANK_FIRST,
				CustomerLiveGuruData.ClassNameAddTable.STATE);
		verifyTrue(addPage.verifyErrorMessageDisplayed(CustomerLiveGuruData.TitleTextboxNewCustomer.STATE,
				CustomerLiveGuruData.NCMessage.STATE_BLANK_FIRST));
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
