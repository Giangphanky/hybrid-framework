package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import pageUIs.liveguru.DashboardLiveGuruPageUI;
import pageUIs.wordpress.admin.LoginPageUI;

public class DashboardLiveGuruPageObjects extends AbstractPages{
	private WebDriver driver;

	public DashboardLiveGuruPageObjects (WebDriver driver) {
		this.driver = driver;
	}

	public boolean isWelcomeMessageDisplayed() {
		waitElementVisible(driver, DashboardLiveGuruPageUI.WELCOME_MESSAGE);
		return isElementDisplayed(driver, DashboardLiveGuruPageUI.WELCOME_MESSAGE);
	}


}
