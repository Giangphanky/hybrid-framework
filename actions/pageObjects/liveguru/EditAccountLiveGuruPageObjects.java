package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import commons.PageGeneratorManager;
import pageUIs.liveguru.EditAccountLiveGuruPageUI;
import pageUIs.liveguru.NewAccountLiveGuruPageUI;

public class EditAccountLiveGuruPageObjects extends AbstractPages{
	private WebDriver driver;

	public EditAccountLiveGuruPageObjects (WebDriver driver) {
		this.driver = driver;
	}

	public void inputAccountIDToAccountNoTextbox(String accountID) {
		waitElementVisible(driver, EditAccountLiveGuruPageUI.ACCOUNT_NO_TEXTBOX);
		sendKeysToElement(driver, EditAccountLiveGuruPageUI.ACCOUNT_NO_TEXTBOX, accountID);
	}

	public void clickToSubmitButton() {
		waitElementClickable(driver, EditAccountLiveGuruPageUI.SUBMIT_BUTTON);
		clickToElement(driver, EditAccountLiveGuruPageUI.SUBMIT_BUTTON);
	}

	public ManagerLiveGuruPageObjects clickToSubmitButtonOnEntryForm() {
		waitElementClickable(driver, EditAccountLiveGuruPageUI.SUBMIT_ENTRY_FORM_BUTTON);
		clickToElement(driver, EditAccountLiveGuruPageUI.SUBMIT_ENTRY_FORM_BUTTON);
		return PageGeneratorManager.getManagerLiveGuruPage(driver);
	}
	
}
