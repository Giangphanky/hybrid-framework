package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import commons.PageGeneratorManager;
import pageUIs.liveguru.NewAccountLiveGuruPageUI;

public class NewAccountLiveGuruPageObjects extends AbstractPages{
	private WebDriver driver;

	public NewAccountLiveGuruPageObjects (WebDriver driver) {
		this.driver = driver;
	}

	public void inputCustomerIDToTextbox(String customerID) {
		waitElementVisible(driver, NewAccountLiveGuruPageUI.CUSTOMER_ID_TEXTBOX);
		sendKeysToElement(driver, NewAccountLiveGuruPageUI.CUSTOMER_ID_TEXTBOX, customerID);
	}

	public void inputToInitDepositTextbox(String balance) {
		waitElementVisible(driver, NewAccountLiveGuruPageUI.INIT_DEPOSIT_TEXTBOX);
		sendKeysToElement(driver, NewAccountLiveGuruPageUI.INIT_DEPOSIT_TEXTBOX, balance);
	}

	public ManagerLiveGuruPageObjects clickToSubmitButton() {
		waitElementClickable(driver, NewAccountLiveGuruPageUI.SUBMIT_BUTTON);
		clickToElement(driver, NewAccountLiveGuruPageUI.SUBMIT_BUTTON);
		return PageGeneratorManager.getManagerLiveGuruPage(driver);
	}

	
}
