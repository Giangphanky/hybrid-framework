package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import commons.PageGeneratorManager;
import pageUIs.liveguru.AbstractPageUI;
import pageUIs.liveguru.DepositLiveGuruPageUI;
import pageUIs.liveguru.EditAccountLiveGuruPageUI;
import pageUIs.liveguru.NewAccountLiveGuruPageUI;
import pageUIs.liveguru.WithdrawLiveGuruPageUI;

public class DeleteAccountLiveGuruPageObjects extends AbstractPages{
	private WebDriver driver;

	public DeleteAccountLiveGuruPageObjects (WebDriver driver) {
		this.driver = driver;
	}

	public void clickToSubmitButton() {
		waitElementClickable(driver, AbstractPageUI.SUBMIT_BUTTON);
		clickToElement(driver, AbstractPageUI.SUBMIT_BUTTON);
	}

	
}
