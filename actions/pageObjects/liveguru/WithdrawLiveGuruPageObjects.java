package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import commons.PageGeneratorManager;
import pageUIs.liveguru.DepositLiveGuruPageUI;
import pageUIs.liveguru.EditAccountLiveGuruPageUI;
import pageUIs.liveguru.NewAccountLiveGuruPageUI;
import pageUIs.liveguru.WithdrawLiveGuruPageUI;

public class WithdrawLiveGuruPageObjects extends AbstractPages{
	private WebDriver driver;

	public WithdrawLiveGuruPageObjects (WebDriver driver) {
		this.driver = driver;
	}
	
}
