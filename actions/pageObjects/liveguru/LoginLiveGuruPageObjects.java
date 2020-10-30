package pageObjects.liveguru;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.seleniumhq.jetty9.http.PreEncodedHttpField;

import commons.AbstractPages;
import commons.PageGeneratorManager;
import pageObjects.wordpress.admin.DashboardPageObjects;
import pageUIs.liveguru.AbstractPageUI;
import pageUIs.liveguru.LoginLiveGuruPageUI;
import pageUIs.wordpress.admin.LoginPageUI;

public class LoginLiveGuruPageObjects extends AbstractPages{
	private WebDriver driver;

	public LoginLiveGuruPageObjects (WebDriver driver) {
		this.driver = driver;
	}

	public DashboardLiveGuruPageObjects clickLoginButton() {
		waitElementVisible(driver, LoginLiveGuruPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginLiveGuruPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getDashboardLiveGuruPage(driver);
	}

	public void inputToEmailTextbox(String userName) {
		waitElementVisible(driver, LoginLiveGuruPageUI.USER_ID_TEXTBOX);
		sendKeysToElement(driver, LoginLiveGuruPageUI.USER_ID_TEXTBOX, userName);
	}

	public void inputToPaswordTextbox(String password) {
		waitElementVisible(driver, LoginLiveGuruPageUI.PASSWORD_TEXTBOX);
		sendKeysToElement(driver, LoginLiveGuruPageUI.PASSWORD_TEXTBOX, password);
	}

}
