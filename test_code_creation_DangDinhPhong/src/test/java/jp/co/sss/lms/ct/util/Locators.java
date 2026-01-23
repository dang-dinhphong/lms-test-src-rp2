package jp.co.sss.lms.ct.util;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * ロケータUtil
 * @author DangDinhPhong
 */
public class Locators {
	private WebDriver driver;
	private WebDriverWait wait;

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

	/** コース名チェック*/
	@FindBy(xpath = "//h2[contains(text(),'DEMOコース')]")
	private WebElement courseName;

	@FindBy(xpath = "//[contains(text(),'DEMOコース')]")
	private WebElement helpLink;

	/** 初期化用コントラクター*/
	public Locators(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		PageFactory.initElements(driver, this);
	}

	/** ログインラベルチェック*/
	public void checkLoginLabel() {
		wait.until(ExpectedConditions.visibilityOf(loginLabel));
		assertEquals("ログインID", loginLabel.getText());
	}

	/** パスワードラベルチェック*/
	public void checkPasswordLabel() {
		wait.until(ExpectedConditions.visibilityOf(passwordLabel));
		assertEquals("パスワード", passwordLabel.getText());
	}

	/** ログインボタン名チェック*/
	public void checkLoginBtn() {
		wait.until(ExpectedConditions.visibilityOf(loginBtn));
		//inputタグのvalueの値を取得
		assertEquals("ログイン", loginBtn.getAttribute("value"));
	}

	/** ログインID自動入力*/
	public void typeLoginId(String text) {
		wait.until(ExpectedConditions.visibilityOf(loginIdInput));
		loginIdInput.clear();
		loginIdInput.sendKeys(text);
	}

	/** パスワード自動入力*/
	public void typePassword(String text) {
		passwordInput.clear();
		passwordInput.sendKeys(text);
	}

	/** ログインボタン自動押下*/
	public void clickLoginBtn() {
		try {
			loginBtn.click();
		} catch (Exception e) {
			//JavaScriptでボタン強制押下
			org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", loginBtn);
		}
	}

	/** エラーメッセージ表示チェック*/
	public void checkLoginErrorMsg() {
		wait.until(ExpectedConditions.visibilityOf(loginErrorMsg));
		assertEquals("* ログインに失敗しました。", loginErrorMsg.getText());
	}

	/** コース名チェック*/
	public void checkCourseName() {
		wait.until(ExpectedConditions.visibilityOf(courseName));
		assertEquals("DEMOコース 2022年10月1日(土)～2022年10月31日(月)", courseName.getText());
	}

}
