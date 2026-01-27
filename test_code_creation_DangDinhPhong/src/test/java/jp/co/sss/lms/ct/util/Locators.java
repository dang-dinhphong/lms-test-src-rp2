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
 * ロケータのユーティリティー
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

	/** コース名確認*/
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

	/** よくある質問 > カテゴリ検索 > 【研修関係】*/
	@FindBy(css = "a[href='/lms/faq?frequentlyAskedQuestionCategoryId=1']")
	private WebElement categoryJobTraining;

	/** よくある質問 > カテゴリ検索 > 【研修関係】の2番目の結果*/
	@FindBy(xpath = "//tbody//tr:ntn-of-child(2)//")
	private WebElement jobTrainingSecondResult;

	/** よくある質問 > カテゴリ検索 > 【研修関係】 > 検索結果数のメッセージ*/
	@FindBy(css = "div[class = 'dataTables info']")
	private WebElement jobTrainingResultsMsg;

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

	/** ログインラベル確認*/
	public void checkLoginScreen() {
		wait.until(ExpectedConditions.visibilityOf(loginLabel));
		assertEquals("ログインID", loginLabel.getText());
		/** パスワードラベル確認*/
		wait.until(ExpectedConditions.visibilityOf(passwordLabel));
		assertEquals("パスワード", passwordLabel.getText());
		/** ログインボタン名確認*/
		wait.until(ExpectedConditions.visibilityOf(loginBtn));
		//inputタグのvalueの値を取得
		assertEquals("ログイン", loginBtn.getAttribute("value"));
	}

	/**
	 * ログインIDとパスワード自動入力し、ログインボタン押下
	 * ログイン失敗
	 * 
	 * @param id ログインID
	 * @param pass パスワード
	 */
	public void loginFail(String id, String pass) {
		wait.until(ExpectedConditions.visibilityOf(loginIdInput));
		loginIdInput.clear();
		loginIdInput.sendKeys(id);
		passwordInput.clear();
		passwordInput.sendKeys(pass);

		try {
			loginBtn.click();
		} catch (Exception e) {
			//JavaScriptでボタン強制押下
			org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", loginBtn);
		}
	}

	/** ログイン失敗時、エラーメッセージ表示確認*/
	public void checkLoginErrorMsg() {
		wait.until(ExpectedConditions.visibilityOf(loginErrorMsg));
		assertEquals("* ログインに失敗しました。", loginErrorMsg.getText());
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

		wait.until(ExpectedConditions.visibilityOf(loginIdInput));
		loginIdInput.clear();
		loginIdInput.sendKeys(id);
		passwordInput.clear();
		passwordInput.sendKeys(password);

		try {
			loginBtn.click();
		} catch (Exception e) {
			//JavaScriptでボタン強制押下
			org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", loginBtn);
		}
	}

	/** コース名確認*/
	public void checkCourseName() {
		wait.until(ExpectedConditions.visibilityOf(courseName));
		assertEquals("DEMOコース 2022年10月1日(土)～2022年10月31日(月)", courseName.getText());
	}

	/** 上部メニュー > 機能ボタン押下 > ヘルプボタン押下*/
	public void clickHelp() {
		/** 上部メニュー > 機能ボタン押下*/
		try {
			featureBtn.click();
		} catch (Exception e) {
			//JavaScriptでボタン強制押下
			org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", featureBtn);
		}

		/** ヘルプボタン名確認*/
		wait.until(ExpectedConditions.visibilityOf(helpLink));
		assertEquals("ヘルプ", helpLink.getText());

		/** ヘルプボタン押下*/
		wait.until(ExpectedConditions.visibilityOf(helpLink));
		try {
			helpLink.click();
		} catch (Exception e) {
			//JavaScriptでボタン強制押下
			org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", helpLink);
		}

		/** ヘルプタイトル確認*/
		wait.until(ExpectedConditions.visibilityOf(helpTitle));
		assertEquals("ヘルプ", helpTitle.getText());

		/** ヘルプタイトル確認*/
		wait.until(ExpectedConditions.visibilityOf(h4Title));
		assertEquals("※操作方法が不明な場合はマニュアルをご参照ください。", h4Title.getText());
	}

	/** よくある質問URLリンクを押下し、遷移したか確認*/
	public void clickFAQ() {
		try {
			faqLink.click();
		} catch (Exception e) {
			//JavaScriptでボタン強制押下
			org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", faqLink);
		}

		//ヘルプ画面を（遷移する前に）検証する
		String originalWindow = webDriver.getWindowHandle();
		//別の画面に開くまで待つ
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		//遷移前＞＜遷移後の画面が内容違うか確認
		for (String windowHandle : driver.getWindowHandles()) {
			if (!originalWindow.contentEquals(windowHandle)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}

		//よくある質問タイトル確認
		wait.until(ExpectedConditions.visibilityOf(faqTitle));
		assertEquals("よくある質問", faqTitle.getText());
	}

	/**
	 * よくある質問 > キーワード検索欄の自動入力 > 「検索」ボタン押下
	 * @param keyword 検索キーワード
	 */
	public void keywordSearch(String keyword) {
		faqKeywordInput.clear();
		faqKeywordInput.sendKeys(keyword);

		/** キーワード検索時「検索」ボタン押下*/
		try {
			keywordSearchBtn.click();
		} catch (Exception e) {
			//JavaScriptでボタン強制押下
			org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", keywordSearchBtn);
		}

		/** 検索結果を検証するメソッド*/
		//リストが空（検索結果ゼロ）でないことを確認
		if (!emptyMsg.isEmpty()) {
			return;
		}

		//各要素の中にキーワードが入っているか確認
		for (WebElement result : spans) {
			String actualText = result.getText();
			//シンプルに「キーワードが含まれていること」だけを検証
			if (!actualText.isEmpty()) {
				assertTrue(actualText.contains(keyword));
			}
		}

		/** 下部にスクロール*/
		scrollTo("500");

	}

	public void clearKeyword() {
		/** キーワード検索欄を空にする*/
		faqKeywordInput.clear();
		assertEquals("", faqKeywordInput.getText());
	}

	/** 【研修関係】リンクを押下 > 検索結果を確認*/
	public void testCategory() {
		wait.until(ExpectedConditions.visibilityOf(categoryJobTraining));
		categoryJobTraining.click();

		scrollTo("500");

		wait.until(ExpectedConditions.visibilityOf(jobTrainingResultsMsg));
		assertEquals("2 件中 1 件から 2 件までを表示", jobTrainingResultsMsg.getText());

	}
}
