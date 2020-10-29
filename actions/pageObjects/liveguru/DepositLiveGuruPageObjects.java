package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import commons.PageGeneratorManager;
import pageUIs.liveguru.DepositLiveGuruPageUI;
import pageUIs.liveguru.EditAccountLiveGuruPageUI;
import pageUIs.liveguru.NewAccountLiveGuruPageUI;

public class DepositLiveGuruPageObjects extends AbstractPages{
	private WebDriver driver;

	public DepositLiveGuruPageObjects (WebDriver driver) {
		this.driver = driver;
	}
	
}
