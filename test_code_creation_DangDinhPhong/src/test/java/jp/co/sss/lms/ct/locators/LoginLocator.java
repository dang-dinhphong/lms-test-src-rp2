package jp.co.sss.lms.ct.locators;

import static jp.co.sss.lms.ct.util.WebDriverUtils.*;
import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginLocator extends BaseLocator {
	public LoginLocator(WebDriver driver) {
		super(driver);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	/** ログイン入力欄のラベル*/
	@FindBy(css = "label[for='loginId']")
	private WebElement loginLabel;

	/** パスワード入力欄のラベル*/
	@FindBy(css = "label[for='password']")
	private WebElement passwordLabel;

	/** ログイン入力欄*/
	@FindBy(name = "loginId")
	private WebElement loginIdInput;

	/** パスワード入力欄*/
	@FindBy(name = "password")
	private WebElement passwordInput;

	/** ログインボタン*/
	@FindBy(css = "input[type='submit'][value='ログイン']")
	private WebElement loginBtn;

	/** ログインエラーメッセージ*/
	@FindBy(css = "span[class='help-inline error']")
	private WebElement loginErrorMsg;

	/** コース名確認*/
	@FindBy(xpath = "//h2[contains(text(),'DEMOコース')]")
	private WebElement courseName;

	/** ログインラベル確認*/
	public void checkLoginScreen() {
		goTo("http://localhost:8080/lms/");

		waitVisible(loginLabel);
		assertEquals("ログインID", loginLabel.getText());
		/** パスワードラベル確認*/
		waitVisible(passwordLabel);
		assertEquals("パスワード", passwordLabel.getText());
		/** ログインボタン名確認*/
		waitVisible(loginBtn);
		//inputタグのvalueの値を取得
		assertEquals("ログイン", loginBtn.getAttribute("value"));
		pageLoadTimeout(10);
	}

	/**
	 * ログインIDとパスワード自動入力し、ログインボタン押下
	 * ログイン失敗
	 * 
	 * @param id ログインID
	 * @param pass パスワード
	 */
	public void loginFail(String id, String pass) {
		waitVisible(loginIdInput);

		doSendKeys(loginIdInput, id);
		doSendKeys(passwordInput, pass);
		tryClick(loginBtn);

		/** ログイン失敗時、エラーメッセージ表示確認*/
		waitVisible(loginErrorMsg);
		assertEquals("* ログインに失敗しました。", loginErrorMsg.getText());

		pageLoadTimeout(10);
	}

	/**
	 * ログインIDとパスワード自動入力し、ログインボタン押下
	 * ログイン成功
	 */
	public void login() {
		/** 環境変数を取得*/
		String id = System.getenv("MY_LMS_AUTOTEST_LOGIN_ID");
		String password = System.getenv("MY_LMS_AUTOTEST_PASSWORD");
		if (id == null || password == null) {
			System.out.println("環境変数が存在しません。確認してください。");
			return;
		}

		waitVisible(loginIdInput);

		doSendKeys(loginIdInput, id);
		doSendKeys(passwordInput, password);
		tryClick(loginBtn);

		/** コース名確認*/
		wait.until(ExpectedConditions.visibilityOf(courseName));
		/** Case01~Case09用*/
		//		assertEquals("DEMOコース 2022年10月1日(土)～2022年10月31日(月)", courseName.getText());

		/** Case10用*/
		assertEquals("DEMOコース 2026年2月1日(日)～2026年2月2日(月)", courseName.getText());
	}
}
