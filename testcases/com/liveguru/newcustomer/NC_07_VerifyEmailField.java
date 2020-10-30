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

public class NC_07_VerifyEmailField extends AbstractTest {

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

	@Test(description = "NC26 - Email cannot be empty")
	public void NC_26_Email_Can_Not_Be_Empty() {
		addPage.pressTabKeyboard(CustomerLiveGuruData.ClassNameAddTable.EMAIL);
		verifyTrue(addPage.verifyErrorMessageDisplayed(CustomerLiveGuruData.TitleTextboxNewCustomer.EMAIL,
				CustomerLiveGuruData.NCMessage.EMAIL_BLANK));
	}
	@Test(description = "NC27 - Email must be in correct format")
	public void NC_27_Email_Must_Be_In_Correct_Format() {
		addPage.inputToTextboxByClassName(CustomerLiveGuruData.InvalidNCRegister.EMAIL_INCORRECT_FORMAT,
				CustomerLiveGuruData.ClassNameAddTable.EMAIL);
		verifyTrue(addPage.verifyErrorMessageDisplayed(CustomerLiveGuruData.TitleTextboxNewCustomer.EMAIL,
				CustomerLiveGuruData.NCMessage.EMAIL_INCORRECT_FORMAT));
	}
	
	@Test(description = "NC28 - Email have first blank")
	public void NC_28_Email_Have_First_Blank() {
		addPage.inputToTextboxByClassName(CustomerLiveGuruData.InvalidNCRegister.EMAIL_BLANK_FIRST,
				CustomerLiveGuruData.ClassNameAddTable.EMAIL);
		verifyTrue(addPage.verifyErrorMessageDisplayed(CustomerLiveGuruData.TitleTextboxNewCustomer.EMAIL,
				CustomerLiveGuruData.NCMessage.EMAIL_BLANK_FIRST));
	}
	@Test(description = "NC29 - Email cannot have space")
	public void NC_29_Email_Can_Not_Have_Spaces() {
		addPage.inputToTextboxByClassName(CustomerLiveGuruData.InvalidNCRegister.EMAIL_HAVE_SPACE,
				CustomerLiveGuruData.ClassNameAddTable.EMAIL);
		verifyTrue(addPage.verifyErrorMessageDisplayed(CustomerLiveGuruData.TitleTextboxNewCustomer.EMAIL,
				CustomerLiveGuruData.NCMessage.EMAIL_HAVE_SPACE));
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
