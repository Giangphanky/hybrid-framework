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

public class NC_01_VerifyNameField extends AbstractTest {

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

	@Test(description = "NC01 - Login with empty user ")
	public void NC_01_Name_Can_Not_Be_Empty() {
		addPage.pressTabKeyboard(CustomerLiveGuruData.ClassNameAddTable.CUSTOMER_NAME);
		verifyTrue(addPage.verifyErrorMessageDisplayed(CustomerLiveGuruData.TitleTextboxNewCustomer.CUSTOMER_NAME,
				CustomerLiveGuruData.NCMessage.CUSTOMER_NAME_BLANK));
	}

	@Test(description = "NC02 - Name cannot have special characters")
	public void NC_02_Name_Can_Not_Have_Special_Characters() {
		addPage.inputToTextboxByClassName(CustomerLiveGuruData.InvalidNCRegister.NAME_SPECIAL_CHAR,
				CustomerLiveGuruData.ClassNameAddTable.CUSTOMER_NAME);
		verifyTrue(addPage.verifyErrorMessageDisplayed(CustomerLiveGuruData.TitleTextboxNewCustomer.CUSTOMER_NAME,
				CustomerLiveGuruData.NCMessage.CUSTOMER_NAME_SPECIAL_CHAR));
	}

	@Test(description = "NC03 - Name cannot have first character as blank space")
	public void NC_03_Name_Can_Not_Have_First_Character_As_Blank() {
		addPage.inputToTextboxByClassName(CustomerLiveGuruData.InvalidNCRegister.NAME_BLANK_FIRST,
				CustomerLiveGuruData.ClassNameAddTable.CUSTOMER_NAME);
		verifyTrue(addPage.verifyErrorMessageDisplayed(CustomerLiveGuruData.TitleTextboxNewCustomer.CUSTOMER_NAME,
				CustomerLiveGuruData.NCMessage.CUSTOMER_NAME_BLANK_FIRST));
	}

	@Test(description = "NC04 - Name cannot be numberic")
	public void NC_04_Name_Can_Not_Be_Numberic() {
		addPage.inputToTextboxByClassName(CustomerLiveGuruData.InvalidNCRegister.NAME_NUMBERIC,
				CustomerLiveGuruData.ClassNameAddTable.CUSTOMER_NAME);
		verifyTrue(addPage.verifyErrorMessageDisplayed(CustomerLiveGuruData.TitleTextboxNewCustomer.CUSTOMER_NAME,
				CustomerLiveGuruData.NCMessage.CUSTOMER_NAME_NUMBER));
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
