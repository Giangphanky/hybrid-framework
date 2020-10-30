package com.liveguru.payment;

import org.testng.annotations.Test;

import com.liveguru.CustomerLiveGuruData;
import com.liveguru.CustomerLiveGuruData.EditCustomer;

import commons.AbstractTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObjects.liveguru.AddLiveGuruPageObjects;
import pageObjects.liveguru.BalanceInquiriLiveGuruPageObjects;
import pageObjects.liveguru.DashboardLiveGuruPageObjects;
import pageObjects.liveguru.DeleteAccountLiveGuruPageObjects;
import pageObjects.liveguru.DeleteCustomerLiveGuruPageObjects;
import pageObjects.liveguru.DepositLiveGuruPageObjects;
import pageObjects.liveguru.EditAccountLiveGuruPageObjects;
import pageObjects.liveguru.EditCustomerLiveGuruPageObjects;
import pageObjects.liveguru.FundTransferLiveGuruPageObjects;
import pageObjects.liveguru.LoginLiveGuruPageObjects;
import pageObjects.liveguru.ManagerLiveGuruPageObjects;
import pageObjects.liveguru.NewAccountLiveGuruPageObjects;
import pageObjects.liveguru.WithdrawLiveGuruPageObjects;
import pageObjects.wordpress.admin.DashboardPageObjects;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.annotations.AfterClass;

public class Payment extends AbstractTest {
	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		log.info("Pre-condition Step 1: Open browser with url");
		driver = getBrowserDriver(browserName);

	}

	@BeforeMethod
	public void beforeMethod() {
		// login
		loginPage = PageGeneratorManager.getLoginLiveGuruPage(driver);
		loginPage.openLoginLiveGuruPage(driver);

		loginPage.inputToEmailTextbox(GlobalConstants.USER_NAME);
		loginPage.inputToPaswordTextbox(GlobalConstants.PASSWORD);
		dashboardPage = loginPage.clickLoginButton();
		verifyTrue(dashboardPage.isWelcomeMessageDisplayed());
	}

	@Test(description = "Create_New_Account_And_Check_Create_Successfully")
	public void TC_01_Create_New_Account_And_Check_Create_Successfully() {
		// define ở abstract
		loginPage.openLiveGuruMenuPageByName(driver, CustomerLiveGuruData.PageName.NEW_CUSTOMER);
		addPage = PageGeneratorManager.getAddLiveGuruPage(driver);
		verifyTrue(addPage.isHeaderDisplayedByFormName(driver, CustomerLiveGuruData.TitleForm.ADD_NEW_CUSTOMER_FORM));

		// fill in customer page
		addPage.inputToTextboxByClassName(CustomerLiveGuruData.NewCustomer.CUSTOMER_NAME,
				CustomerLiveGuruData.ClassNameAddTable.CUSTOMER_NAME);
		addPage.inputToDOBTextbox(CustomerLiveGuruData.NewCustomer.DOB);
		addPage.inputToAddressTextbox(CustomerLiveGuruData.NewCustomer.ADDRESS);
		addPage.inputToTextboxByClassName(CustomerLiveGuruData.NewCustomer.CITY,
				CustomerLiveGuruData.ClassNameAddTable.CITY);
		addPage.inputToTextboxByClassName(CustomerLiveGuruData.NewCustomer.STATE,
				CustomerLiveGuruData.ClassNameAddTable.STATE);
		addPage.inputToTextboxByClassName(CustomerLiveGuruData.NewCustomer.PIN,
				CustomerLiveGuruData.ClassNameAddTable.PIN);
		addPage.inputToTextboxByClassName(CustomerLiveGuruData.NewCustomer.MOBILE_NUMBER,
				CustomerLiveGuruData.ClassNameAddTable.TELEPHONE);
		addPage.inputToTextboxByClassName(CustomerLiveGuruData.NewCustomer.EMAIL + formatEmail,
				CustomerLiveGuruData.ClassNameAddTable.EMAIL);
		addPage.inputToTextboxByClassName(GlobalConstants.PASSWORD, CustomerLiveGuruData.ClassNameAddTable.PASSWORD);

		managerPage = addPage.clickToSubmitButton();

		// verify create success
		verifyTrue(managerPage.isInformationDisplayedByText(CustomerLiveGuruData.CollumNameRegistered.CUSTOMER_NAME,
				CustomerLiveGuruData.NewCustomer.CUSTOMER_NAME));
		verifyTrue(managerPage.isInformationDisplayedByText(CustomerLiveGuruData.CollumNameRegistered.DOB,
				CustomerLiveGuruData.NewCustomer.DOB));
		verifyTrue(managerPage.isInformationDisplayedByText(CustomerLiveGuruData.CollumNameRegistered.ADDRESS,
				CustomerLiveGuruData.NewCustomer.ADDRESS));
		verifyTrue(managerPage.isInformationDisplayedByText(CustomerLiveGuruData.CollumNameRegistered.CITY,
				CustomerLiveGuruData.NewCustomer.CITY));
		verifyTrue(managerPage.isInformationDisplayedByText(CustomerLiveGuruData.CollumNameRegistered.STATE,
				CustomerLiveGuruData.NewCustomer.STATE));
		verifyTrue(managerPage.isInformationDisplayedByText(CustomerLiveGuruData.CollumNameRegistered.PIN,
				CustomerLiveGuruData.NewCustomer.PIN));
		verifyTrue(managerPage.isInformationDisplayedByText(CustomerLiveGuruData.CollumNameRegistered.MOBILE,
				CustomerLiveGuruData.NewCustomer.MOBILE_NUMBER));
		verifyTrue(managerPage.isInformationDisplayedByText(CustomerLiveGuruData.CollumNameRegistered.EMAIL,
				CustomerLiveGuruData.NewCustomer.EMAIL + formatEmail));

		customerID = managerPage.getDataFromTableByColumnName(CustomerLiveGuruData.CollumNameRegistered.CUSTOMER_ID);

		verifyTrue(managerPage.isMessageSuccessDisplayed(CustomerLiveGuruData.Message.REGISTERED_SUCCESS_MESSAGE));
	}

	@Test(description = "TC_02_Edit_Customer_Account_And_Check_Edit_Successfully")
	public void TC_02_Edit_Customer_Account_And_Check_Edit_Successfully() {
		// define ở abstract
		loginPage.openLiveGuruMenuPageByName(driver, CustomerLiveGuruData.PageName.EDIT_CUSTOMER);
		editCustomerPage = PageGeneratorManager.getEditCustomerLiveGuruPage(driver);
		verifyTrue(editCustomerPage.isHeaderDisplayedByFormName(driver, CustomerLiveGuruData.TitleForm.EDIT_CUSTOMER_FORM));
		
		editCustomerPage.inputToCustomerIDTextbox(driver, customerID);
		editCustomerPage.clickSubmitButtonOnCustomer(driver);
		
		verifyTrue(editCustomerPage.isHeaderDisplayedByFormName(driver, CustomerLiveGuruData.TitleForm.EDIT_CUSTOMER_ENTRY_FORM));
		
		// fill in customer page
		editCustomerPage.inputToAddressTextbox(CustomerLiveGuruData.EditCustomer.EDIT_ADDRESS);
		editCustomerPage.inputToTextboxByClassName(CustomerLiveGuruData.EditCustomer.EDIT_CITY,
				CustomerLiveGuruData.ClassNameAddTable.CITY);
		editCustomerPage.inputToTextboxByClassName(CustomerLiveGuruData.EditCustomer.EDIT_STATE,
				CustomerLiveGuruData.ClassNameAddTable.STATE);
		editCustomerPage.inputToTextboxByClassName(CustomerLiveGuruData.EditCustomer.EDIT_PIN,
				CustomerLiveGuruData.ClassNameAddTable.PIN);
		editCustomerPage.inputToTextboxByClassName(CustomerLiveGuruData.EditCustomer.EDIT_MOBILE_NUMBER,
				CustomerLiveGuruData.ClassNameAddTable.TELEPHONE);
		editCustomerPage.inputToTextboxByClassName(CustomerLiveGuruData.EditCustomer.EDIT_EMAIL + formatEmail,
				CustomerLiveGuruData.ClassNameAddTable.EMAIL);
		
		managerPage = editCustomerPage.clickToSubmitButton();
		
		verifyTrue(managerPage.isMessageSuccessDisplayed(CustomerLiveGuruData.Message.UPDATED_SUCCESS_MESSAGE));
		// verify edit success
		verifyTrue(managerPage.isInformationDisplayedByText(CustomerLiveGuruData.CollumNameRegistered.CUSTOMER_NAME,
				CustomerLiveGuruData.NewCustomer.CUSTOMER_NAME));
		verifyTrue(managerPage.isInformationDisplayedByText(CustomerLiveGuruData.CollumNameRegistered.DOB,
				CustomerLiveGuruData.NewCustomer.DOB));
		verifyTrue(managerPage.isInformationDisplayedByText(CustomerLiveGuruData.CollumNameRegistered.ADDRESS,
				CustomerLiveGuruData.EditCustomer.EDIT_ADDRESS));
		verifyTrue(managerPage.isInformationDisplayedByText(CustomerLiveGuruData.CollumNameRegistered.CITY,
				CustomerLiveGuruData.EditCustomer.EDIT_CITY));
		verifyTrue(managerPage.isInformationDisplayedByText(CustomerLiveGuruData.CollumNameRegistered.STATE,
				CustomerLiveGuruData.EditCustomer.EDIT_STATE));
		verifyTrue(managerPage.isInformationDisplayedByText(CustomerLiveGuruData.CollumNameRegistered.PIN,
				CustomerLiveGuruData.EditCustomer.EDIT_PIN));
		verifyTrue(managerPage.isInformationDisplayedByText(CustomerLiveGuruData.CollumNameRegistered.MOBILE,
				CustomerLiveGuruData.EditCustomer.EDIT_MOBILE_NUMBER));
		verifyTrue(managerPage.isInformationDisplayedByText(CustomerLiveGuruData.CollumNameRegistered.EMAIL,
				CustomerLiveGuruData.EditCustomer.EDIT_EMAIL + formatEmail));
	}
	@Test(description = "TC 03 Add new account and check created successfully, then verify 'Current Amount' and 'Initial Deposit' are equal")
	public void TC_03_Add_Account_And_Verify_Amount() {
		// define ở abstract
		loginPage.openLiveGuruMenuPageByName(driver, CustomerLiveGuruData.PageName.NEW_ACCOUNT);
		newAccountPage = PageGeneratorManager.getNewAccountLiveGuruPage(driver);
		verifyTrue(newAccountPage.isHeaderDisplayedByFormName(driver, CustomerLiveGuruData.TitleForm.ADD_NEW_ACCOUNT_FORM));
		
		newAccountPage.inputCustomerIDToTextbox(customerID);
		newAccountPage.selectAccountTypeByTitile(driver, CustomerLiveGuruData.AccountType.SAVINGS);
		newAccountPage.inputToInitDepositTextbox(CustomerLiveGuruData.DepositWithDrawalData.INIT_BALANCE);
		
		managerPage = newAccountPage.clickToSubmitButton();
		
		//verify generate
		verifyTrue(managerPage.isMessageSuccessDisplayed(CustomerLiveGuruData.Message.GENERATE_ACCOUNT_SUCCESS_MESSAGE));
		verifyTrue(managerPage.isInformationDisplayedByText(CustomerLiveGuruData.CollumNameRegistered.CURRENT_AMOUNT_WHEN_ADD,
				CustomerLiveGuruData.DepositWithDrawalData.INIT_BALANCE));
		accountID = managerPage.getDataFromTableByColumnName(CustomerLiveGuruData.CollumNameRegistered.ACCOUNT_ID);
	}
	
	@Test(description = "TC 04 Edit account anh check type of Account is 'Current'")
	public void TC_04_Edit_Account_And_Check_Type_Is_Current() {
		loginPage.openLiveGuruMenuPageByName(driver, CustomerLiveGuruData.PageName.EDIT_ACCOUNT);
		editAccountPage = PageGeneratorManager.getEditAccountLiveGuruPage(driver);
		verifyTrue(editAccountPage.isHeaderDisplayedByFormName(driver, CustomerLiveGuruData.TitleForm.EDIT_ACCOUNT_FORM));
		
		editAccountPage.inputAccountIDToAccountNoTextbox(accountID);
		editAccountPage.clickToSubmitButton();
		
		verifyTrue(editAccountPage.isHeaderDisplayedByFormName(driver, CustomerLiveGuruData.TitleForm.EDIT_ACCOUNT_ENTRY_FORM));
		
		editAccountPage.selectAccountTypeByTitile(driver, CustomerLiveGuruData.AccountType.CURRENT);
		managerPage = editAccountPage.clickToSubmitButtonOnEntryForm();
		
		verifyTrue(managerPage.isMessageSuccessDisplayed(CustomerLiveGuruData.Message.UPDATED_ACCOUNT_SUCCESS_MESSAGE));
		
		// verify edit success
		verifyTrue(managerPage.isInformationDisplayedByText(CustomerLiveGuruData.CollumNameRegistered.ACCOUNT_TYPE,
				CustomerLiveGuruData.AccountType.CURRENT));
	}
	@Test(description = "TC 05 Transfer money into a current account and check account balance equal 55,000")
	public void TC_05_Transfer_Money_To_Current_Account_And_Check_Balance() {
		loginPage.openLiveGuruMenuPageByName(driver, CustomerLiveGuruData.PageName.DEPOST);
		depositPage = PageGeneratorManager.getDepositLiveGuruPage(driver);
		verifyTrue(depositPage.isHeaderDisplayedByFormName(driver, CustomerLiveGuruData.TitleForm.DEPOSIT_FORM));
		
		depositPage.inputAccountIDToAccountNoTextbox(driver, accountID);
		depositPage.inputAmountToTextbox(driver, CustomerLiveGuruData.DepositWithDrawalData.DEPOSIT_AMOUNT);
		depositPage.inputDescriptionToTextbox(driver, CustomerLiveGuruData.DepositWithDrawalData.DEPOSIT_DESCRIPTION);
		managerPage = depositPage.clickToSubmitButton(driver);
		
		verifyTrue(managerPage.isMessageSuccessDisplayed(CustomerLiveGuruData.Message.DEPOSIT_SUCCESS_MESSAGE+accountID));
		
		// verify edit success
		verifyTrue(managerPage.isInformationDisplayedByText(CustomerLiveGuruData.CollumNameRegistered.CURRENT_BALANCE,
				CustomerLiveGuruData.DepositWithDrawalData.BALANCE_AFTER_DEPOSIT));
	}
	
	@Test(description = "TC 06 Withdraw money from current account and check account balance equal 40,000")
	public void TC_06_Withdraw_Money_From_Current_Account_And_Check_Balance() {
		loginPage.openLiveGuruMenuPageByName(driver, CustomerLiveGuruData.PageName.WITHDRAWAL);
		withdrawPage = PageGeneratorManager.getWithdrawLiveGuruPage(driver);
		verifyTrue(withdrawPage.isHeaderDisplayedByFormName(driver, CustomerLiveGuruData.TitleForm.WITHDRAW_FORM));
		
		withdrawPage.inputAccountIDToAccountNoTextbox(driver, accountID);
		withdrawPage.inputAmountToTextbox(driver, CustomerLiveGuruData.DepositWithDrawalData.WITHDRAW_AMOUNT);
		withdrawPage.inputDescriptionToTextbox(driver, CustomerLiveGuruData.DepositWithDrawalData.WITHDRAW_DESCRIPTION);
		managerPage = withdrawPage.clickToSubmitButton(driver);
		
		verifyTrue(managerPage.isMessageSuccessDisplayed(CustomerLiveGuruData.Message.WITHDRAW_SUCCESS_MESSAGE+accountID));
		
		// verify edit success
		verifyTrue(managerPage.isInformationDisplayedByText(CustomerLiveGuruData.CollumNameRegistered.CURRENT_BALANCE,
				CustomerLiveGuruData.DepositWithDrawalData.BALANCE_AFTER_WITHDRAW));
	}
	
	@Test(description = "TC 07 Transfer the money into another account and check amount equal 10,000")
	public void TC_07_Transfer_Money_Into_Another_Account_And_Check_Balance() {
		loginPage.openLiveGuruMenuPageByName(driver, CustomerLiveGuruData.PageName.FUNTRANSFER);
		funTransferPage = PageGeneratorManager.getFundTransferLiveGuruPage(driver);
		verifyTrue(funTransferPage.isHeaderDisplayedByFormName(driver, CustomerLiveGuruData.TitleForm.FUNTRANSFER_FORM));
		
		funTransferPage.inputToPayersAccNOTextbox(accountID);
		funTransferPage.inputToPayeesAccNOTextbox(CustomerLiveGuruData.DepositWithDrawalData.PAYEES_ACC_NO);
		funTransferPage.inputAmountToTextbox(driver, CustomerLiveGuruData.DepositWithDrawalData.AMOUNT_TRANSFER);
		funTransferPage.inputDescriptionToTextbox(driver, CustomerLiveGuruData.DepositWithDrawalData.TRANSFER_DESCRIPTION);
		managerPage = funTransferPage.clickToSubmitButton(driver);
		
		verifyTrue(managerPage.isMessageSuccessDisplayed(CustomerLiveGuruData.Message.FUNDTRANSFER_SUCCESS_MESSAGE));
		
		// verify edit success
		verifyTrue(managerPage.isInformationDisplayedByText(CustomerLiveGuruData.CollumNameRegistered.AMOUNT_FUNTRANSFER,
				CustomerLiveGuruData.DepositWithDrawalData.AMOUNT_TRANSFER));
	}
	
	@Test(description = "TC 08 Check current account balance equal 30,000")
	public void TC_08_Check_Current_Amount() {
		loginPage.openLiveGuruMenuPageByName(driver, CustomerLiveGuruData.PageName.BALANCE_ENQUIRY);
		balancePage = PageGeneratorManager.getBalanceInquiriLiveGuruPage(driver);
		verifyTrue(balancePage.isHeaderDisplayedByFormName(driver, CustomerLiveGuruData.TitleForm.BALANCE_INQUIRY_FORM));
		
		balancePage.inputAccountIDToAccountNoTextbox(driver, accountID);
		managerPage = balancePage.clickToSubmitButton(driver);
		
		verifyTrue(managerPage.isMessageSuccessDisplayed(CustomerLiveGuruData.Message.BALANCE_INQUIRY_MESSAGE + accountID));
		
		// verify edit success
		verifyTrue(managerPage.isInformationDisplayedByText(CustomerLiveGuruData.CollumNameRegistered.BALANCE_INQUIRY,
				CustomerLiveGuruData.DepositWithDrawalData.BALANCE_INQUIRY));
	}
	
	@Test(description = "TC 09 Delete all account of this customer account and check deleted successfully")
	public void TC_09_Delete_All_Account_This_Customer_And_Check_Deleted_Successfully() {
		
		loginPage.openLiveGuruMenuPageByName(driver, CustomerLiveGuruData.PageName.DELETE_ACCOUNT);
		deleteAccountPage = PageGeneratorManager.getDeleteAccountLiveGuruPage(driver);
		verifyTrue(deleteAccountPage.isHeaderDisplayedByFormName(driver, CustomerLiveGuruData.TitleForm.DELETE_ACCOUNT_FORM));
		
		deleteAccountPage.inputAccountIDToAccountNoTextbox(driver, accountID);
		deleteAccountPage.clickToSubmitButton();
		deleteAccountPage.accecptConfirmAlert(driver);
		managerPage = PageGeneratorManager.getManagerLiveGuruPage(driver);
		verifyTrue(managerPage.isAlertMessageDisplayed(driver, CustomerLiveGuruData.Message.ACCOUNT_DELETED_SUCCESS_MESSAGE ));
		
		deleteAccountPage = managerPage.accecptDeleteSuccessAlert();
		
		deleteAccountPage.openLiveGuruMenuPageByName(driver, CustomerLiveGuruData.PageName.EDIT_ACCOUNT);
		editAccountPage = PageGeneratorManager.getEditAccountLiveGuruPage(driver);
		verifyTrue(editAccountPage.isHeaderDisplayedByFormName(driver, CustomerLiveGuruData.TitleForm.EDIT_ACCOUNT_FORM));
		
		editAccountPage.inputAccountIDToAccountNoTextbox(accountID);
		editAccountPage.clickToSubmitButton();
		verifyTrue(editAccountPage.isAlertMessageDisplayed(driver, CustomerLiveGuruData.Message.ACCOUNT_NOT_EXIST_MESSAGE));
		editAccountPage.accecptAlert(driver);
	}
	
	@Test(description = "TC 10 Delete exist customer account and check deleted successfully ")
	public void TC_10_Delete_Existed_Customer_Account_And_Checkk_Deleted_Successfullu() {
		loginPage.openLiveGuruMenuPageByName(driver, CustomerLiveGuruData.PageName.DELETE_CUSTOMER);
		deleteCustomerPage = PageGeneratorManager.getDeleteCustomerLiveGuruPage(driver);
		verifyTrue(deleteCustomerPage.isHeaderDisplayedByFormName(driver, CustomerLiveGuruData.TitleForm.DELETE_CUSTOMER_FORM));

		deleteCustomerPage.inputToCustomerIDTextbox(driver, customerID);
		deleteCustomerPage.clickSubmitButtonOnCustomer(driver);
		
		deleteCustomerPage.accecptConfirmAlert(driver);
				
		verifyTrue(deleteCustomerPage.isAlertMessageDisplayed(driver, CustomerLiveGuruData.Message.CUSTOMER_DELETED_SUCCESS_MESSAGE ));
		
		deleteCustomerPage.accecptAlert(driver);
		
		managerPage = PageGeneratorManager.getManagerLiveGuruPage(driver);
		
		managerPage.openLiveGuruMenuPageByName(driver, CustomerLiveGuruData.PageName.EDIT_CUSTOMER);
		editCustomerPage = PageGeneratorManager.getEditCustomerLiveGuruPage(driver);
		verifyTrue(editCustomerPage.isHeaderDisplayedByFormName(driver, CustomerLiveGuruData.TitleForm.EDIT_CUSTOMER_FORM));
		
		editCustomerPage.inputToCustomerIDTextbox(driver, customerID);
		editCustomerPage.clickSubmitButtonOnCustomer(driver);
		verifyTrue(editAccountPage.isAlertMessageDisplayed(driver, CustomerLiveGuruData.Message.ACCOUNT_NOT_EXIST_MESSAGE));
		editAccountPage.accecptAlert(driver);
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		log.info("Post-Condition Close browser");
		closeBrowserAndDriver(driver);
	}

	private WebDriver driver;
	public static String customerID;
	public static String accountID;
	private int fakeNumber = randomData();
	private String formatEmail = fakeNumber + "@gmail.com";
	LoginLiveGuruPageObjects loginPage;
	DashboardLiveGuruPageObjects dashboardPage;
	AddLiveGuruPageObjects addPage;
	ManagerLiveGuruPageObjects managerPage;
	EditCustomerLiveGuruPageObjects editCustomerPage;
	NewAccountLiveGuruPageObjects newAccountPage;
	EditAccountLiveGuruPageObjects editAccountPage;
	DepositLiveGuruPageObjects depositPage;
	WithdrawLiveGuruPageObjects withdrawPage;
	FundTransferLiveGuruPageObjects funTransferPage;
	BalanceInquiriLiveGuruPageObjects balancePage;
	DeleteAccountLiveGuruPageObjects deleteAccountPage;
	DeleteCustomerLiveGuruPageObjects deleteCustomerPage;
}
