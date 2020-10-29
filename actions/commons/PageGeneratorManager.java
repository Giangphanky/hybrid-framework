package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.liveguru.AddLiveGuruPageObjects;
import pageObjects.liveguru.BalanceInquiriLiveGuruPageObjects;
import pageObjects.liveguru.DashboardLiveGuruPageObjects;
import pageObjects.liveguru.DeleteAccountLiveGuruPageObjects;
import pageObjects.liveguru.DeleteCustomerLiveGuruPageObjects;
import pageObjects.liveguru.DepositLiveGuruPageObjects;
import pageObjects.liveguru.EditAccountLiveGuruPageObjects;
import pageObjects.liveguru.EditCustomerLiveGuruPageObjects;
import pageObjects.liveguru.FundTransferLiveGuruPageObjects;
import pageObjects.liveguru.LoginLiveGuruPageObjects;
import pageObjects.liveguru.ManagerLiveGuruPageObjects;
import pageObjects.liveguru.NewAccountLiveGuruPageObjects;
import pageObjects.liveguru.WithdrawLiveGuruPageObjects;
import pageObjects.wordpress.admin.DashboardPageObjects;
import pageObjects.wordpress.admin.LoginPageObjects;
import pageObjects.wordpress.admin.MediaPageObjects;
import pageObjects.wordpress.admin.NewEditPostPageObjects;
import pageObjects.wordpress.admin.PagesPageObjects;
import pageObjects.wordpress.admin.PostsPageObjects;
import pageObjects.wordpress.user.HomePageObjects;
import pageObjects.wordpress.user.PostDetailPageObjects;
import pageObjects.wordpress.user.SearchResultPageObjects;

public class PageGeneratorManager {
	
	public static PostDetailPageObjects getUserPostDetailPage(WebDriver driver) {
		return new PostDetailPageObjects(driver);
	}
	public static LoginPageObjects getLoginAdminPage(WebDriver driver) {
		return new LoginPageObjects(driver);
	}
	public static DashboardPageObjects getDashboardAdminPage(WebDriver driver) {
		return new DashboardPageObjects(driver);
	}
	public static MediaPageObjects getMediaAdminPage(WebDriver driver) {
		return new MediaPageObjects(driver);
	}
	public static NewEditPostPageObjects getNewEditPostAdminPage(WebDriver driver) {
		return new NewEditPostPageObjects(driver);
	}
	public static PagesPageObjects getPagesAdminPage(WebDriver driver) {
		return new PagesPageObjects(driver);
	}
	public static PostsPageObjects getPostAdminPage(WebDriver driver) {
		return new PostsPageObjects(driver);
	}
	public static HomePageObjects getUserHomePage(WebDriver driver) {
		return new HomePageObjects(driver);
	}
	public static SearchResultPageObjects getUserSearchResultPage(WebDriver driver) {
		return new SearchResultPageObjects(driver);
	}
	public static LoginLiveGuruPageObjects getLoginLiveGuruPage(WebDriver driver) {
		return new LoginLiveGuruPageObjects(driver);
	}
	public static DashboardLiveGuruPageObjects getDashboardLiveGuruPage(WebDriver driver) {
		return new DashboardLiveGuruPageObjects(driver);
	}
	public static AddLiveGuruPageObjects getAddLiveGuruPage(WebDriver driver) {
		return new AddLiveGuruPageObjects(driver);
	}
	public static ManagerLiveGuruPageObjects getManagerLiveGuruPage(WebDriver driver) {
		return new ManagerLiveGuruPageObjects(driver);
	}
	public static EditCustomerLiveGuruPageObjects getEditCustomerLiveGuruPage(WebDriver driver) {
		return new EditCustomerLiveGuruPageObjects(driver);
	}
	public static NewAccountLiveGuruPageObjects getNewAccountLiveGuruPage(WebDriver driver) {
		return new NewAccountLiveGuruPageObjects(driver);
	}
	public static EditAccountLiveGuruPageObjects getEditAccountLiveGuruPage(WebDriver driver) {
		return new EditAccountLiveGuruPageObjects(driver);
	}
	public static DepositLiveGuruPageObjects getDepositLiveGuruPage(WebDriver driver) {
		return new DepositLiveGuruPageObjects(driver);
	}
	public static WithdrawLiveGuruPageObjects getWithdrawLiveGuruPage(WebDriver driver) {
		return new WithdrawLiveGuruPageObjects(driver);
	}
	public static FundTransferLiveGuruPageObjects getFundTransferLiveGuruPage(WebDriver driver) {
		return new FundTransferLiveGuruPageObjects(driver);
	}
	public static BalanceInquiriLiveGuruPageObjects getBalanceInquiriLiveGuruPage(WebDriver driver) {
		return new BalanceInquiriLiveGuruPageObjects(driver);
	}
	public static DeleteAccountLiveGuruPageObjects getDeleteAccountLiveGuruPage(WebDriver driver) {
		return new DeleteAccountLiveGuruPageObjects(driver);
	}
	public static DeleteCustomerLiveGuruPageObjects getDeleteCustomerLiveGuruPage(WebDriver driver) {
		return new DeleteCustomerLiveGuruPageObjects(driver);
	}
}
