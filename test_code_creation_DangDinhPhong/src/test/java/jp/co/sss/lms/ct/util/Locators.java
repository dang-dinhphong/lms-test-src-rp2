package jp.co.sss.lms.ct.util;

import static jp.co.sss.lms.ct.util.WebDriverUtils.*;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.List;

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

	/** 上部のメニュー > 機能ボタン*/
	@FindBy(xpath = "//a[@class = 'dropdown-toggle' and contains(text(),'機能')]")
	private WebElement featureBtn;

	/** ヘルプURLリンク*/
	@FindBy(css = "a[href='/lms/help']")
	private WebElement helpLink;

	/** ヘルプタイトル*/
	@FindBy(xpath = "//h2[contains(text(),'ヘルプ')]")
	private WebElement helpTitle;

	/** よくある質問タイトル*/
	@FindBy(xpath = "//h2[contains(text(),'よくある質問')]")
	private WebElement faqTitle;

	/** h4タグ*/
	@FindBy(tagName = "h4")
	private WebElement h4Title;

	/** 「よくある質問」URLリンク*/
	@FindBy(css = "a[href='/lms/faq']")
	private WebElement faqLink;

	/** よくある質問>キーワード検索欄に自動入力*/
	@FindBy(css = "input[name='keyword']")
	private WebElement faqKeywordInput;

	/** よくある質問>キーワード検索ボタン*/
	@FindBy(css = "input[type='submit'][value='検索']")
	private WebElement keywordSearchBtn;

	/** よくある質問>キーワード検索結果に使用*/
	@FindBy(xpath = "//dd//span")
	private List<WebElement> spans;

	@FindBy(css = "td[class = 'dataTables empty']")
	private List<WebElement> emptyMsg;

	/** よくある質問 > カテゴリ検索 > 【人材開発支援助成金】*/
	@FindBy(css = "a[href='/lms/faq?frequentlyAskedQuestionCategoryId=2']")
	private WebElement categoryHRDepSupportGrant;

	/**
	 * 初期化用コントラクター
	 * WebDriverUtilsで生成されたインスタンスをローカル保存し、下記メソッドを使えるようにする
	 * 
	 * @param driver
	 */
	public Locators(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));//waitをインスタンス化

		//アノテーションを有効化する
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

	/**
	 * ログインID自動入力
	 * 
	 * @param text ログインID
	 */
	public void typeLoginId(String text) {
		wait.until(ExpectedConditions.visibilityOf(loginIdInput));
		loginIdInput.clear();
		loginIdInput.sendKeys(text);
	}

	/**
	 * パスワード自動入力
	 * @param text ログインパスワード
	 */
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

	/** 上部メニュー > 機能ボタンを押下*/
	public void clickFeatureBtn() {
		try {
			featureBtn.click();
		} catch (Exception e) {
			//JavaScriptでボタン強制押下
			org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", featureBtn);
		}
	}

	/** ヘルプボタン名チェック*/
	public void checkHelpBtn() {
		wait.until(ExpectedConditions.visibilityOf(helpLink));
		assertEquals("ヘルプ", helpLink.getText());
	}

	public void clickHelpLink() {
		wait.until(ExpectedConditions.visibilityOf(helpLink));
		try {
			helpLink.click();
		} catch (Exception e) {
			//JavaScriptでボタン強制押下
			org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", helpLink);
		}
	}

	/** ヘルプタイトルチェック*/
	public void checkHelpTitle() {
		wait.until(ExpectedConditions.visibilityOf(helpTitle));
		assertEquals("ヘルプ", helpTitle.getText());
	}

	/** ヘルプタイトルチェック*/
	public void checkHelpMsg() {
		wait.until(ExpectedConditions.visibilityOf(h4Title));
		assertEquals("※操作方法が不明な場合はマニュアルをご参照ください。", h4Title.getText());
	}

	/** よくある質問URLリンクをクリック*/
	public void clickFAQLink() {
		try {
			faqLink.click();
		} catch (Exception e) {
			//JavaScriptでボタン強制押下
			org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", faqLink);
		}
	}

	/** よくある質問タイトルチェック*/
	public void checkFAQTitle() {
		//ヘルプ画面を（遷移する前に）検証する
		String originalWindow = webDriver.getWindowHandle();
		//別の画面に開くまで待つ
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		//遷移前＞＜遷移後の画面が内容違うかチェック
		for (String windowHandle : driver.getWindowHandles()) {
			if (!originalWindow.contentEquals(windowHandle)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}
		wait.until(ExpectedConditions.visibilityOf(faqTitle));
		assertEquals("よくある質問", faqTitle.getText());
	}

	/**
	 * よくある質問 > キーワード検索欄の自動入力
	 * @param text 検索キーワード
	 */
	public void typeFAQKeyword(String text) {
		faqKeywordInput.clear();
		faqKeywordInput.sendKeys(text);
	}

	/** よくある質問URLリンクをクリック*/
	public void clickKeywordSearch() {
		try {
			keywordSearchBtn.click();
		} catch (Exception e) {
			//JavaScriptでボタン強制押下
			org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", keywordSearchBtn);
		}
	}

	/**
	 * 検索結果を検証するメソッド
	 * @param keyword 検索したワード（"し"など）
	 */
	public void verifySearchFilter(String keyword) {
		//リストが空（検索結果ゼロ）でないことを確認
		if (!emptyMsg.isEmpty()) {
			return;
		}

		//各要素の中にキーワードが入っているかチェック
		for (WebElement result : spans) {
			String actualText = result.getText();
			//シンプルに「キーワードが含まれていること」だけを検証
			if (!actualText.isEmpty()) {
				assertTrue(actualText.contains(keyword));
			}

		}
	}

	public void clearSearch() {
		faqKeywordInput.clear();
		assertEquals("", faqKeywordInput.getText());
	}

	public void checkCategoryNo2() {

	}
}
