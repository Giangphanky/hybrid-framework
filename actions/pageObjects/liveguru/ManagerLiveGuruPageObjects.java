package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import commons.PageGeneratorManager;
import pageUIs.liveguru.AbstractPageUI;
import pageUIs.liveguru.AddLiveGuruPageUI;
import pageUIs.liveguru.ManagerLiveGuruPageUI;

public class ManagerLiveGuruPageObjects extends AbstractPages{
	private WebDriver driver;

	public ManagerLiveGuruPageObjects (WebDriver driver) {
		this.driver = driver;
	}

	public boolean isInformationDisplayedByText(String columnName, String value) {
		waitElementVisible(driver, ManagerLiveGuruPageUI.DYNAMIC_CUSTOMER_VALUE_BY_COLUMN_NAME_AND_TEXT, columnName, value);
		return isElementDisplayed(driver, ManagerLiveGuruPageUI.DYNAMIC_CUSTOMER_VALUE_BY_COLUMN_NAME_AND_TEXT, columnName, value);
	}

	public boolean isMessageSuccessDisplayed(String msg) {
		waitElementVisible(driver, ManagerLiveGuruPageUI.DYNAMIC_MESSAGE, msg);
		return isElementDisplayed(driver, ManagerLiveGuruPageUI.DYNAMIC_MESSAGE, msg);
	}

	public String getDataFromTableByColumnName(String columnName) {
		waitElementVisible(driver, ManagerLiveGuruPageUI.DYNAMIC_DATA_BY_COLUMN_NAME, columnName);
		return getElementText(driver, ManagerLiveGuruPageUI.DYNAMIC_DATA_BY_COLUMN_NAME, columnName);
	}

	public DeleteAccountLiveGuruPageObjects accecptDeleteSuccessAlert() {
		accecptAlert(driver);
		return PageGeneratorManager.getDeleteAccountLiveGuruPage(driver);
	}

	
}
