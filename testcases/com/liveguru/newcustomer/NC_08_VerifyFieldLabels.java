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

public class NC_08_VerifyFieldLabels extends AbstractTest {

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

	@Test(description = "NC30 - Check all Fields name (label) are as requirement")
	public void NC_30_Check_All_Fields_Name_Are_As_Requirement() {
		verifyTrue(addPage.isFieldNamesDisplayedByText(CustomerLiveGuruData.TitleTextboxNewCustomer.ADDRESS));
		verifyTrue(addPage.isFieldNamesDisplayedByText(CustomerLiveGuruData.TitleTextboxNewCustomer.CITY));
		verifyTrue(addPage.isFieldNamesDisplayedByText(CustomerLiveGuruData.TitleTextboxNewCustomer.CUSTOMER_NAME));
		verifyTrue(addPage.isFieldNamesDisplayedByText(CustomerLiveGuruData.TitleTextboxNewCustomer.MOBILE));
		verifyTrue(addPage.isFieldNamesDisplayedByText(CustomerLiveGuruData.TitleTextboxNewCustomer.PASSWORD));
		verifyTrue(addPage.isFieldNamesDisplayedByText(CustomerLiveGuruData.TitleTextboxNewCustomer.PIN));
		verifyTrue(addPage.isFieldNamesDisplayedByText(CustomerLiveGuruData.TitleTextboxNewCustomer.STATE));
		verifyTrue(addPage.isFieldNamesDisplayedByText(CustomerLiveGuruData.TitleTextboxNewCustomer.EMAIL));
		verifyTrue(addPage.isFieldNamesDisplayedByText(CustomerLiveGuruData.TitleTextboxNewCustomer.GENDER));
		verifyTrue(addPage.isFieldNamesDisplayedByText(CustomerLiveGuruData.TitleTextboxNewCustomer.DOB));
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
