package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import commons.PageGeneratorManager;
import pageUIs.liveguru.DepositLiveGuruPageUI;
import pageUIs.liveguru.EditAccountLiveGuruPageUI;
import pageUIs.liveguru.FundTransferLiveGuruPageUI;
import pageUIs.liveguru.NewAccountLiveGuruPageUI;

public class FundTransferLiveGuruPageObjects extends AbstractPages{
	private WebDriver driver;

	public FundTransferLiveGuruPageObjects (WebDriver driver) {
		this.driver = driver;
	}

	public void inputToPayersAccNOTextbox(String accountID) {
		waitElementVisible(driver, FundTransferLiveGuruPageUI.PAYERS_ACCOUNT_NO);
		sendKeysToElement(driver, FundTransferLiveGuruPageUI.PAYERS_ACCOUNT_NO, accountID);
	}

	public void inputToPayeesAccNOTextbox(String payeesAccNo) {
		waitElementVisible(driver, FundTransferLiveGuruPageUI.PAYEE_ACCOUNT_NO);
		sendKeysToElement(driver, FundTransferLiveGuruPageUI.PAYEE_ACCOUNT_NO, payeesAccNo);
	}
	
}
