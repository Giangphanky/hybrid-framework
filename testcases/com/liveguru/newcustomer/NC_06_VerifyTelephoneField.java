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

public class NC_06_VerifyTelephoneField extends AbstractTest {

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

	@Test(description = "NC22 - Telephone cannot be empty ")
	public void NC_22_Telephone_Can_Not_Be_Empty() {
		addPage.pressTabKeyboard(CustomerLiveGuruData.ClassNameAddTable.TELEPHONE);
		verifyTrue(addPage.verifyErrorMessageDisplayed(CustomerLiveGuruData.TitleTextboxNewCustomer.MOBILE,
				CustomerLiveGuruData.NCMessage.MOBILE_BLANK));
	}
	@Test(description = "NC23 - Telephone cannot have first character as blank space")
	public void NC_23_Telephone_Can_Not_Have_First_Blank() {
		addPage.inputToTextboxByClassName(CustomerLiveGuruData.InvalidNCRegister.MOBILE_BLANK_FIRST,
				CustomerLiveGuruData.ClassNameAddTable.TELEPHONE);
		verifyTrue(addPage.verifyErrorMessageDisplayed(CustomerLiveGuruData.TitleTextboxNewCustomer.MOBILE,
				CustomerLiveGuruData.NCMessage.MOBILE_BLANK_FIRST));
	}
	@Test(description = "NC24 - Telephone cannot have spaces")
	public void NC_24_Telephone_Can_Not_Have_Spaces() {
		addPage.inputToTextboxByClassName(CustomerLiveGuruData.InvalidNCRegister.MOBILE_HAVE_BLANK,
				CustomerLiveGuruData.ClassNameAddTable.TELEPHONE);
		verifyTrue(addPage.verifyErrorMessageDisplayed(CustomerLiveGuruData.TitleTextboxNewCustomer.MOBILE,
				CustomerLiveGuruData.NCMessage.MOBILE_HAVE_BLANK));
	}
	@Test(description = "NC25 - Telephone cannot have special character")
	public void NC_25_Telephone_Can_Not_Have_Special_Character() {
		addPage.inputToTextboxByClassName(CustomerLiveGuruData.InvalidNCRegister.MOBILE_SPECIAL_CHAR,
				CustomerLiveGuruData.ClassNameAddTable.TELEPHONE);
		verifyTrue(addPage.verifyErrorMessageDisplayed(CustomerLiveGuruData.TitleTextboxNewCustomer.MOBILE,
				CustomerLiveGuruData.NCMessage.MOBILE_SPECIAL_CHAR));
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
