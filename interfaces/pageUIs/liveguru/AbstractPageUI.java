package pageUIs.liveguru;

public abstract class AbstractPageUI {
	public static final String LIVEGURU_DYNAMIC_LINK = "//ul[@class='menusubnav']/li/a[text()='%s']";
	
	public static final String UP_LOAD_FILE_TYPE = "//input[@type='file']";
	public static final String DYNAMIC_INPUT_TEXTBOX_BY_CLASS_NAME = "//*[@name='%s']";
	public static final String DOB_TEXTBOX = "//input[@name='dob']";
	public static final String ADDRESS_TEXTBOX = "//textarea[@name='addr']";
	
	public static final String DYNAMIC_HEADER_BY_FORM_NAME = "//p[@class='heading3' and text()='%s']";
	
	public static final String ACCOUNT_NO_TEXTBOX = "//input[@name='accountno']";
	public static final String AMOUNT_TEXTBOX = "//input[@name='ammount']";
	public static final String DESCRIPTION_TEXTBOX = "//input[@name='desc']";
	public static final String SUBMIT_BUTTON = "//input[@name='AccSubmit']";
	
	public static final String CUSTOMER_ID_TEXTBOX = "//input[@name='cusid']";
}
