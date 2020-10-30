package pageObjects.liveguru;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import commons.PageGeneratorManager;
import pageUIs.liveguru.AbstractPageUI;
import pageUIs.liveguru.AddCustomerLiveGuruPageUI;
import pageUIs.liveguru.LoginLiveGuruPageUI;

public class AddLiveGuruPageObjects extends AbstractPages {
	private WebDriver driver;

	public AddLiveGuruPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public ManagerLiveGuruPageObjects clickToSubmitButton() {
		waitElementClickable(driver, AddCustomerLiveGuruPageUI.SUBMIT_BUTTON);
		clickToElement(driver, AddCustomerLiveGuruPageUI.SUBMIT_BUTTON);
		return PageGeneratorManager.getManagerLiveGuruPage(driver);
	}

	public void inputToTextboxByClassName(String value, String className) {
		waitElementVisible(driver, AbstractPageUI.DYNAMIC_INPUT_TEXTBOX_BY_CLASS_NAME, className);
		sendKeysToElement(driver, AbstractPageUI.DYNAMIC_INPUT_TEXTBOX_BY_CLASS_NAME, value, className);

	}

	public void inputToDOBTextbox(String value) {
		waitElementVisible(driver, AbstractPageUI.DOB_TEXTBOX);
		removeAttributeInDOM(driver, AbstractPageUI.DOB_TEXTBOX, "type");
		sendKeysToElement(driver, AbstractPageUI.DOB_TEXTBOX, value);
	}

	public void inputToAddressTextbox(String address) {
		waitElementVisible(driver, AbstractPageUI.ADDRESS_TEXTBOX);
		sendKeysToElement(driver, AbstractPageUI.ADDRESS_TEXTBOX, address);
	}

	public void pressTabKeyboard(String className) {
		waitElementVisible(driver, AbstractPageUI.DYNAMIC_INPUT_TEXTBOX_BY_CLASS_NAME, className);
		clickToElement(driver, AbstractPageUI.DYNAMIC_INPUT_TEXTBOX_BY_CLASS_NAME, className);
		sendKeyBoardToElement(driver, AbstractPageUI.DYNAMIC_INPUT_TEXTBOX_BY_CLASS_NAME, Keys.TAB, className);
	}

	public boolean verifyErrorMessageDisplayed(String fieldName, String msg) {
		waitElementVisible(driver, AddCustomerLiveGuruPageUI.DYNAMIC_ERROR_MESSAGE, fieldName, msg);
		return isElementDisplayed(driver, AddCustomerLiveGuruPageUI.DYNAMIC_ERROR_MESSAGE, fieldName, msg);
	}

	public boolean isFieldNamesDisplayedByText(String label) {
		waitElementVisible(driver, AddCustomerLiveGuruPageUI.DYNAMIC_LABEL_FIELD, label);
		return isElementDisplayed(driver, AddCustomerLiveGuruPageUI.DYNAMIC_LABEL_FIELD, label);
	}

}
