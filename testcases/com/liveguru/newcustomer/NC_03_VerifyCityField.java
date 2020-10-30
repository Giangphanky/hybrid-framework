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

public class NC_03_VerifyCityField extends AbstractTest {

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

	@Test(description = "NC08 - City cannot be empty ")
	public void NC_08_City_Can_Not_Be_Empty() {
		addPage.pressTabKeyboard(CustomerLiveGuruData.ClassNameAddTable.CITY);
		verifyTrue(addPage.verifyErrorMessageDisplayed(CustomerLiveGuruData.TitleTextboxNewCustomer.CITY,
				CustomerLiveGuruData.NCMessage.CITY_BLANK));
	}
	@Test(description = "NC09 - City cannot be numberic ")
	public void NC_09_City_Can_Not_Be_Numberic() {
		addPage.inputToTextboxByClassName(CustomerLiveGuruData.InvalidNCRegister.CITY_NUMBERIC,
				CustomerLiveGuruData.ClassNameAddTable.CITY);
		verifyTrue(addPage.verifyErrorMessageDisplayed(CustomerLiveGuruData.TitleTextboxNewCustomer.CITY,
				CustomerLiveGuruData.NCMessage.CITY_NUMBER));
	}
	@Test(description = "NC10 - City cannot have special character")
	public void NC_10_City_Can_Not_Have_Special_Character() {
		addPage.inputToTextboxByClassName(CustomerLiveGuruData.InvalidNCRegister.CITY_SPECIAL_CHAR,
				CustomerLiveGuruData.ClassNameAddTable.CITY);
		verifyTrue(addPage.verifyErrorMessageDisplayed(CustomerLiveGuruData.TitleTextboxNewCustomer.CITY,
				CustomerLiveGuruData.NCMessage.CITY_SPECIAL_CHAR));
	}
	@Test(description = "NC11 - City cannot have first blank space")
	public void NC_11_City_Can_Not_Have_First_Blank() {
		addPage.inputToTextboxByClassName(CustomerLiveGuruData.InvalidNCRegister.CITY_BLANK_FIRST,
				CustomerLiveGuruData.ClassNameAddTable.CITY);
		verifyTrue(addPage.verifyErrorMessageDisplayed(CustomerLiveGuruData.TitleTextboxNewCustomer.CITY,
				CustomerLiveGuruData.NCMessage.CITY_BLANK_FIRST));
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
