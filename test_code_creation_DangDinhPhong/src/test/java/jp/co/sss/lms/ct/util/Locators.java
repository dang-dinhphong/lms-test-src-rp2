package jp.co.sss.lms.ct.util;

import static jp.co.sss.lms.ct.util.Constant.*;
import static jp.co.sss.lms.ct.util.WebDriverUtils.*;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
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
	@FindBy(css = "tbody tr:nth-child(2) dt span:nth-child(2)")
	private WebElement jobTrainingSecondResult;

	/** よくある質問 > カテゴリ検索 > 【研修関係】の2番目の結果*/
	@FindBy(css = "tbody tr:nth-child(2) dd span:nth-child(2)")
	private WebElement jobTrainingSecondResultDetail;

	/** よくある質問 > カテゴリ検索 > 【研修関係】 > 検索結果数のメッセージ*/
	@FindBy(id = "DataTables_Table_0_info")
	private WebElement jobTrainingResultsMsg;

	/** Case07*/
	/** 「未提出」ステータス*/
	/** 一度テスト行うと「提出済」となる
	 *  > テストに失敗しないようにDB初期化が必要*/
	@FindBy(xpath = "((//*[@id='main']//table)[2]//span[text()='未提出'])[1]")
	private WebElement notSubmitStatus;

	/** 「提出済」ステータスの研修日の「詳細」ボタン*/
	@FindBy(xpath = "(//tr[descendant::span[text()='未提出']]//input[@value='詳細'])[1]")
	private WebElement notSubmitDetailBtn;

	/** 上部_タイトル:コース詳細*/
	@FindBy(css = "a[href='/lms/course/detail?courseId=1']")
	private WebElement courseTitle;

	/** 上部_タイトル:セクション詳細*/
	@FindBy(css = "li[class ='active']")
	private WebElement sectionTitle;

	/** 未提出：   「日報【デモ】を提出する」ボタン*/
	/** 提出後： > 「提出済み【デモ】を確認する」ボタン*/
	@FindBy(css = "input[type = 'submit']")
	private WebElement submitDailyReportBtn;

	/** レポート提出画面の上部タイトル*/
	@FindBy(xpath = "//*[@id='main']//h2")
	private WebElement mainTopTitle;

	/** 画面の上部H3見出し*/
	@FindBy(xpath = "//*[@id='main']//h3")
	private WebElement subTopTitle;

	/** 日報レポート登録の入力欄*/
	@FindBy(id = "content_0")
	private WebElement dailyReportForm;

	/** 未提出：   「提出」ボタン*/
	@FindBy(css = "button[type='submit']")
	private WebElement submitBtn;

	/** Case08*/
	/** 「提出済み」ステータス*/
	@FindBy(xpath = "((//*[@id='main']//table)[1]//span[text()='提出済み'])[2]")
	private WebElement submittedStatus;

	/** 「提出済」ステータスの研修日の「詳細」ボタン*/
	@FindBy(xpath = "(//tr[descendant::span[text()='提出済み']]//input[@value='詳細'])[2]")
	private WebElement submittedDetailBtn;

	@FindBy(css = "input[type='submit'][value*='週報']")
	private WebElement submitWeeklyReportBtn;

	/**************************** 週報の修正項目ロケータ*******************************/
	/** Case09入力チェックにも使用*/

	/** 学習項目入力欄*/
	@FindBy(id = "intFieldName_0")
	private WebElement curriculum;

	/** 理解度ドロップダウンリスト*/
	@FindBy(id = "intFieldValue_0")
	private WebElement understandingList;

	/** 理解度選択肢3*/
	@FindBy(css = "option[value = '3']")
	private WebElement understanding;

	/** 理解度選択肢未選択*/
	@FindBy(css = "option[value = '']")
	private WebElement understandingEmpty;

	/** 目標の達成度*/
	@FindBy(id = "content_0")
	private WebElement achieveLvl;

	/** 所感*/
	@FindBy(id = "content_1")
	private WebElement impression;

	/** 一週間の振り返り*/
	@FindBy(id = "content_2")
	private WebElement weeklyRevision;

	/** Case09入力チェック・エラーメッセージロケータ*/
	/** エラーメッセージ*/
	@FindBy(xpath = "//p[descendant::span[1]]")
	private WebElement errorMsg;

	/** エラーメッセージ（複数ある場合）*/
	@FindBy(xpath = "(//p[descendant::span[1]])[2]")
	private WebElement errorMsgPlus;

	/** ようこそ、○○さんボタン*/
	@FindBy(css = "a[href='/lms/user/detail']")
	private WebElement userDetailBtn;

	/** ユーザ詳細画面 > 週報【デモ】*/
	/** 同じ日付を持つのは2行（週報と日報） > 「週報」とリンクする日付のロケータ指定*/
	@FindBy(xpath = "//td[contains(text(), '週報【デモ】')]/ancestor::tr/td[1]")
	private WebElement userWeeklyReportDate;

	/** ユーザ詳細画面 > 週報【デモ】*/
	@FindBy(xpath = "//td[contains(text(), '週報【デモ】')]")
	private WebElement userWeeklyReportName;

	/** ユーザ詳細画面 > 週報【デモ】 > 「詳細」ボタン*/
	@FindBy(xpath = "//tr[descendant::td[contains(text(), '週報【デモ】')]]//input[@value='詳細']")
	private WebElement userWeeklyDetailBtn;

	/** 週報【デモ】詳細画面 > 理解度（1段階評価）*/
	@FindBy(xpath = "(//table[@class = 'table table-hover'])[2]//td[2]/p")
	private WebElement understandingCheck;

	/** 週報【デモ】詳細画面 > 目標達成度*/
	@FindBy(xpath = "(//table[@class = 'table table-hover'])[3]//tr[1]/td")
	private WebElement achieveLvlCheck;

	/** 週報【デモ】詳細画面 > 所感*/
	@FindBy(xpath = "(//table[@class = 'table table-hover'])[3]//tr[2]/td")
	private WebElement impressCheck;

	/** 週報【デモ】詳細画面 > 一週間の振り返り*/
	@FindBy(xpath = "(//table[@class = 'table table-hover'])[3]//tr[3]/td")
	private WebElement weekRevisionCheck;

	/** Case09*/
	/** ユーザ詳細画面 > 「週報【デモ】 の同じ行の「修正する」ボタン」*/
	@FindBy(xpath = "//tr[descendant::td[contains(text(), '週報【デモ】')]]//input[@value='修正する']")
	private WebElement weekReportFixBtn;

	/** Case10*/
	/** 上部メニュ勤怠管理画面ボタン*/
	@FindBy(css = "a[href='/lms/attendance/detail']")
	private WebElement attendanceDetail;

	/** 勤怠管理画面の「出勤」ボタン*/
	@FindBy(name = "punchIn")
	private WebElement punchInBtn;

	/** 勤怠管理画面の「退勤」ボタン*/
	@FindBy(name = "punchOut")
	private WebElement punchOutBtn;

	/** 研修日程の横の「出勤時間」にあたる箇所*/
	/** 出勤ボタンを押下後、押下した時間が反映される*/
	@FindBy(xpath = "//td[contains(text(),'2026年1月29日(木)')]/following-sibling::td[@class='w80'][1]")
	private WebElement punchInCheck;

	/** 研修日程の横の「退勤時間」にあたる箇所*/
	/** 退勤ボタンを押下後、押下した時間が反映される*/
	@FindBy(xpath = "//td[contains(text(),'2026年1月29日(木)')]/following-sibling::td[@class='w80'][2]")
	private WebElement punchOutCheck;

	/** 出勤もしくは退勤ボタンを押下後、成功時に表示する上部のメッセージ*/
	@FindBy(xpath = "//div[@id='main']//span[not(ancestor::button)]")
	private WebElement punchSuccessMsg;

	/** 勤怠直接変更リンク*/
	@FindBy(css = "a[href='/lms/attendance/update']")
	private WebElement directAttendanceFixLink;

	/** 勤怠直接変更画面の「定時」ボタン*/
	@FindBy(xpath = "(//*[@class='btn btn-success default-button'])[1]")
	private WebElement doFixedTimeBtn;

	/** 勤怠直接変更画面の「定時」ボタン*/
	@FindBy(xpath = "(//*[@class='btn btn-success default-button'])[2]")
	private WebElement doFixedTimeBtnSecond;

	/** 勤怠直接変更画面の「定時」ボタン*/
	@FindBy(name = "complete")
	private WebElement doAttendanceDirectUpdateBtn;

	/** Case12*/
	/** 勤怠入力チェック*/

	@FindBy(id = "startHour0")
	private WebElement punchInHour;

	@FindBy(xpath = "//select[@id='startHour0']/option[@value='']")
	private WebElement punchInHourEmpty;

	@FindBy(xpath = "//select[@id='startHour0']/option[@value='20']")
	private WebElement punchInHourLate;

	@FindBy(xpath = "//select[@id='startHour0']/option[@value='10']")
	private WebElement punchInHourTenAM;

	@FindBy(id = "startMinute0")
	private WebElement punchInMinute;

	@FindBy(xpath = "//select[@id='startMinute0']/option[@value='0']")
	private WebElement punchInMinuteZero;

	@FindBy(xpath = "//select[@id='startMinute0']/option[@value='']")
	private WebElement punchInMinuteEmpty;

	@FindBy(id = "endHour0")
	private WebElement punchOutHour;

	@FindBy(xpath = "//select[@id='endHour0']/option[@value='18']")
	private WebElement punchOutHourFixed;

	@FindBy(xpath = "//select[@id='endHour0']/option[@value='12']")
	private WebElement punchOutHourNoon;

	@FindBy(id = "endMinute0")
	private WebElement punchOutMinute;
	@FindBy(xpath = "//select[@id='endMinute0']/option[@value='']")
	private WebElement punchOutMinuteEmpty;

	@FindBy(xpath = "//select[@id='endMinute0']/option[@value='0']")
	private WebElement punchOutMinuteZero;

	@FindBy(name = "attendanceList[0].blankTime")
	private WebElement intermissionList;

	@FindBy(xpath = "//select[@name='attendanceList[0].blankTime']/option[@value='420']")
	private WebElement intermissionHour;

	@FindBy(xpath = "//select[@name='attendanceList[0].blankTime']/option[@value='']")
	private WebElement intermissionEmpty;

	@FindBy(name = "attendanceList[1].note")
	private WebElement attendanceNote;

	@FindBy(xpath = "(//*[@class = 'help-inline error'])[1]")
	private WebElement attendanceErrorOne;

	@FindBy(xpath = "(//*[@class = 'help-inline error'])[2]")
	private WebElement attendanceErrorTwo;

	/**
	 * 初期化用コントラクター
	 * WebDriverUtilsで生成されたインスタンスをローカル保存し、下記メソッドを使えるようにする
	 * 
	 * @param driver WebDriver
	 */
	public Locators(WebDriver driver) {
		this.driver = driver;
		this.driver.manage().window().maximize();//画面フルサイズする
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));//waitをインスタンス化

		//アノテーションを有効化する
		PageFactory.initElements(driver, this);
	}

	void waitVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * 入力
	 * 
	 * @param element 入力したい要素
	 * @param key 入力内容
	 */
	void doSendKeys(WebElement element, String key) {
		element.clear();
		element.sendKeys(key);
	}

	/**
	 * 各ボタンおよびURLリンクのJS強制押下
	 * 
	 * @param button ボタンやリンクなど
	 */
	void tryClick(WebElement button) {
		try {
			button.click();
		} catch (Exception e) {
			//JavaScriptでボタン強制押下
			org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", button);
		}
	}

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
		assertEquals("DEMOコース 2026年1月28日(水)～2026年1月29日(木)", courseName.getText());
	}

	/** 上部メニュー > 機能ボタン押下 > ヘルプボタン押下*/
	public void clickHelp() {
		/** 上部メニュー > 機能ボタン押下*/
		tryClick(featureBtn);

		/** ヘルプボタン名確認*/
		waitVisible(helpLink);
		assertEquals("ヘルプ", helpLink.getText());

		/** ヘルプボタン押下*/
		waitVisible(helpLink);
		tryClick(helpLink);

		/** ヘルプタイトル確認*/
		waitVisible(helpTitle);
		assertEquals("ヘルプ", helpTitle.getText());

		/** ヘルプタイトル確認*/
		waitVisible(h4Title);
		assertEquals("※操作方法が不明な場合はマニュアルをご参照ください。", h4Title.getText());
		pageLoadTimeout(10);
	}

	/** よくある質問URLリンクを押下し、遷移したか確認*/
	public void clickFAQ() {
		tryClick(faqLink);

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
		waitVisible(faqTitle);
		assertEquals("よくある質問", faqTitle.getText());
		pageLoadTimeout(10);
	}

	/**
	 * よくある質問 > キーワード検索欄の自動入力 > 「検索」ボタン押下
	 * @param keyword 検索キーワード
	 */
	public void keywordSearch() {
		String keyword = "手続き";
		faqKeywordInput.clear();
		faqKeywordInput.sendKeys(keyword);

		/** キーワード検索時「検索」ボタン押下*/
		tryClick(keywordSearchBtn);

		/** 検索結果を検証するメソッド*/
		//リストが空（検索結果ゼロ）でないことを確認
		if (!emptyMsg.isEmpty()) {
			return;
		}

		/** 各要素の中にキーワードが入っているか確認*/
		for (WebElement result : spans) {
			String actualText = result.getText();
			if (!actualText.isEmpty()) {
				assertTrue(actualText.contains(keyword));
			}
		}
		/** 下部にスクロール*/
		scrollTo("500");
		pageLoadTimeout(10);

	}

	/** よくある質問 > キーワード検索の「クリア」ボタン押下*/
	public void clearKeyword() {
		/** キーワード検索欄を空にする*/
		faqKeywordInput.clear();
		assertEquals(EMPTY, faqKeywordInput.getText());
	}

	/** 【研修関係】リンクを押下 > 検索結果を確認*/
	public void testCategory() {
		waitVisible(categoryJobTraining);
		categoryJobTraining.click();

		scrollTo("500");
		waitVisible(jobTrainingSecondResult);

		assertEquals("研修の申し込みはどのようにすれば良いですか？", jobTrainingSecondResult.getText());
		assertEquals("2 件中 1 件から 2 件までを表示", jobTrainingResultsMsg.getText());

		pageLoadTimeout(10);
	}

	/** 【研修関係】リンクを押下 > 検索結果を確認*/
	public void testCategoryDetailCheck() {
		jobTrainingSecondResult.click();
		scrollTo("500");
		waitVisible(jobTrainingSecondResultDetail);
		assertEquals("営業担当がいる場合は、営業担当までご連絡ください。 申し込み方法についてご案内させていただきます。 なお、弊社営業営業がいない場合は、東京ITスクール運営事務局までご連絡いただけると幸いです。",
				jobTrainingSecondResultDetail.getText());
		pageLoadTimeout(10);
	}

	/** Case07*/
	/** 未提出「日報」登録*/
	/** 「未提出」ステータスの日付の「詳細」ボタン押下*/
	public void clickUnsubmitted() {
		waitVisible(notSubmitStatus);
		assertEquals("未提出", notSubmitStatus.getText());
		assertEquals("詳細", notSubmitDetailBtn.getAttribute("value"));

		tryClick(notSubmitDetailBtn);
		waitVisible(courseTitle);
		assertEquals("コース詳細", courseTitle.getText());
		assertEquals("セクション詳細", sectionTitle.getText());
		assertEquals("日報【デモ】を提出する", submitDailyReportBtn.getAttribute("value"));

		pageLoadTimeout(10);
	}

	/** 「日報【デモ】を提出する」ボタン押下*/
	public void clickDailyReportSubmitBtn() {
		waitVisible(submitDailyReportBtn);
		tryClick(submitDailyReportBtn);

		assertEquals("日報【デモ】 2022年10月5日", mainTopTitle.getText());
	}

	/**
	 * 未提出の日報を登録
	 * @param report 日報内容
	 */
	public void submitDailyReport() {
		String report = "本日の研修を終了します";
		doSendKeys(dailyReportForm, report);
		tryClick(submitBtn);
		waitVisible(submitDailyReportBtn);

		/** 「日報【デモ】を提出する」ボタン > 「提出済み【デモ】を確認する」ボタン*/
		assertEquals("提出済み日報【デモ】を確認する", submitDailyReportBtn.getAttribute("value"));
		pageLoadTimeout(10);
	}

	/** Case08*/
	/** 提出済み週報の確認と変更*/
	public void clickSubmitted() {
		waitVisible(submittedStatus);
		assertEquals("提出済み", submittedStatus.getText());
		assertEquals("詳細", submittedDetailBtn.getAttribute("value"));

		tryClick(submittedDetailBtn);
		waitVisible(courseTitle);
		assertEquals("コース詳細", courseTitle.getText());
		assertEquals("セクション詳細", sectionTitle.getText());
		assertEquals("提出済み週報【デモ】を確認する", submitWeeklyReportBtn.getAttribute("value"));
		pageLoadTimeout(10);
	}

	/** 「提出済み週報【デモ】を提出する」ボタン押下*/
	public void clickWeeklyReportSubmitBtn() {
		waitVisible(submitWeeklyReportBtn);
		tryClick(submitWeeklyReportBtn);

		assertEquals("週報【デモ】 2022年10月2日", mainTopTitle.getText());
		pageLoadTimeout(10);
	}

	/**
	 * 提出済みの週報を変更
	 * @param report 日報内容
	 */
	public void submitWeeklyReport() {
		waitVisible(understandingList);
		;
		/** 理解度*/
		/** 理解度ドロップダウンリスト押下*/
		tryClick(understandingList);
		/** 理解度選択肢押下*/
		tryClick(understanding);

		scrollTo("500");
		/** 所感*/
		String impress = "【変更】週報の変更です。";
		/** 一週間の振り返り*/
		String weekly = "【変更】日報・週報などの入力項目は管理者権限で変更することが可能です。"
				+ "「週報」の入力項目は管理画面のレポート作成機能を用いて設定し、変更されたレポートのフォーマットはデータベースの「m_weekly_report」テーブルに登録されています。";

		/** 目標達成度*/
		doSendKeys(achieveLvl, ACHIEVE);
		/** 所感*/
		doSendKeys(impression, impress);
		/** 一週間の振り返り*/
		doSendKeys(weeklyRevision, weekly);
		tryClick(submitBtn);

		waitVisible(courseTitle);
		assertEquals("コース詳細", courseTitle.getText());
		assertEquals("セクション詳細", sectionTitle.getText());
		assertEquals("アルゴリズム、フローチャート 2022年10月2日", mainTopTitle.getText());
		pageLoadTimeout(10);
	}

	/**
	 * 「ようこそ、○○さん」ボタン押下し、ユーザ詳細画面に遷移
	 */
	public void gotoUserDetail() {
		waitVisible(userDetailBtn);
		/** 「ようこそ、○○さん」ボタン押下*/
		tryClick(userDetailBtn);

		waitVisible(subTopTitle);
		assertEquals("ユーザー詳細", mainTopTitle.getText());
		assertEquals("基本情報", subTopTitle.getText());
		pageLoadTimeout(10);
	}

	/**
	 * 修正した週報は反映されたか確認
	 */
	public void checkWeeklyReportChange() {
		scrollTo("500");
		assertEquals("2022年10月2日(日)", userWeeklyReportDate.getText());
		assertEquals("週報【デモ】", userWeeklyReportName.getText());
		assertEquals("詳細", userWeeklyDetailBtn.getAttribute("value"));

		tryClick(userWeeklyDetailBtn);

		/** レポート詳細画面遷移*/
		assertEquals(COMPRE_LVL, understandingCheck.getText());
		assertEquals(ACHIEVE, achieveLvlCheck.getText());
		assertEquals("【変更】週報の変更です。", impressCheck.getText());
		assertEquals(
				"【変更】日報・週報などの入力項目は管理者権限で変更することが可能です。「週報」の入力項目は管理画面のレポート作成機能を用いて設定し、変更されたレポートのフォーマットはデータベースの「m_weekly_report」テーブルに登録されています。",
				weekRevisionCheck.getText());
		pageLoadTimeout(10);
	}

	/** Case09*/
	/** 入力チェック*/
	/** コース詳細画面から「ようこそ、○○さん」ボタンを押下し、ユーザ詳細画面に遷移*/
	public void gotoUserDetailFromCourse() {
		waitVisible(courseName);
		assertEquals("DEMOコース 2022年10月1日(土)～2022年10月31日(月)", courseName.getText());

		tryClick(userDetailBtn);

		waitVisible(subTopTitle);
		assertEquals("ユーザー詳細", mainTopTitle.getText());
		assertEquals("基本情報", subTopTitle.getText());

		pageLoadTimeout(10);
	}

	/** ユーザ詳細画面から「週報【デモ】」の同じ行の「修正する」ボタンを押下し、レポート登録画面に遷移*/
	public void gotoWeeklyReportChange() {
		tryClick(weekReportFixBtn);

		assertEquals("週報【デモ】 2022年10月2日", mainTopTitle.getText());
		pageLoadTimeout(10);
	}

	/** Case09*/
	/** 各テスト実施前各項目をデフォルトにする*/
	public void setDefault() {
		waitVisible(weeklyRevision);
		doSendKeys(curriculum, CURRICULUM_DEF);

		tryClick(understandingList);
		tryClick(understanding);

		doSendKeys(achieveLvl, ACHIEVE_DEF);
		doSendKeys(impression, IMPRESS_DEF);
		doSendKeys(weeklyRevision, WEEKLY_REVISION_DEF);

		tryClick(userDetailBtn);
		tryClick(weekReportFixBtn);

	}

	/** Case09Test5*/
	/** 学習項目が未入力*/
	public void inputCheckCurriculum() {
		waitVisible(curriculum);
		curriculum.clear();
		curriculum.sendKeys(EMPTY);

		tryClick(submitBtn);
		waitVisible(errorMsg);
		;
		assertEquals("* 理解度を入力した場合は、学習項目は必須です。", errorMsg.getText());
	}

	/** Case09Test6*/
	/** 理解度が未入力*/
	public void inputCheckUnderstanding() {
		waitVisible(understandingList);
		tryClick(understandingList);
		tryClick(understandingEmpty);
		tryClick(submitBtn);

		waitVisible(errorMsg);
		assertEquals("* 学習項目を入力した場合は、理解度は必須です。", errorMsg.getText());
	}

	/** テスト07,08の共通部分*/
	/**
	 * @param achieveKey 目標達成度の入力内容
	 * @param achieveErrorMsg 目標達成度の入力内容によるエラーメッセージ
	 */
	void inputCheckAchieve(String achieveKey, String achieveErrorMsg) {
		waitVisible(achieveLvl);
		;
		doSendKeys(achieveLvl, achieveKey);

		tryClick(submitBtn);

		waitVisible(errorMsg);
		assertEquals(achieveErrorMsg, errorMsg.getText());
	}

	/** Case09Test7*/
	/** 目標の達成度が数値以外*/
	public void inputCheckAchieveNotNum() {
		String errMsg = "* 目標の達成度は半角数字で入力してください。";
		inputCheckAchieve(ACHIEVE_NOT_NUM, errMsg);
	}

	/** Case09Test8*/
	/** 目標の達成度が範囲外*/
	public void inputCheckAchieveOutOfRange() {
		String errMsg = "* 目標の達成度は、半角数字で、1～10の範囲内で入力してください。";
		inputCheckAchieve(ACHIEVE_OUT_OF_RANGE, errMsg);
	}

	/** Case09Test9*/
	/** 目標の達成度・所感が未入力*/
	public void inputCheckBothAchieveAndImpressEmpty() {
		waitVisible(impression);

		doSendKeys(achieveLvl, EMPTY);
		doSendKeys(impression, EMPTY);

		tryClick(submitBtn);
		scrollTo("300");

		String achieveErrorMsg = "* 目標の達成度は半角数字で入力してください。";
		String impressErrorMsg = "* 所感は必須です。";
		waitVisible(errorMsg);
		assertEquals(achieveErrorMsg, errorMsg.getText());
		assertEquals(impressErrorMsg, errorMsgPlus.getText());

	}

	/** Case09Test10*/
	/** 所感・一週間の振り返りが2000文字超*/
	public void inputCheckBothImpresssionAndWeekReportTooLong() {
		waitVisible(weeklyRevision);

		doSendKeys(impression, TOO_LONG);
		doSendKeys(weeklyRevision, TOO_LONG);

		tryClick(submitBtn);

		/** scrollBy()scrollTo()でうまく画面ボトムまでいかないため、Jsで強制スクロール*/
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

		waitVisible(errorMsgPlus);
		String impressErrorMsg = "* 所感の長さが最大値(2000)を超えています。";
		String weekReportErrorMsg = "* 一週間の振り返りの長さが最大値(2000)を超えています。";

		assertEquals(impressErrorMsg, errorMsg.getText());
		assertEquals(weekReportErrorMsg, errorMsgPlus.getText());
	}

	/** Case10*/
	/**　勤怠管理画面に遷移*/
	public void gotoAttendanceDetail() {
		waitVisible(attendanceDetail);
		tryClick(attendanceDetail);

		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();

		waitVisible(mainTopTitle);
		;
		assertEquals("勤怠管理", mainTopTitle.getText());
	}

	/**
	 * 勤怠打刻
	 * 
	 * @param punchBtn 打刻ボタン（出勤もしくは退勤ボタン）
	 * @param punchCheck 打刻成功時のメッセージ
	 */
	void doPunch(WebElement punchBtn, WebElement punchCheck) {
		waitVisible(punchBtn);
		tryClick(punchBtn);

		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();

		waitVisible(punchCheck);
		assertNotNull(punchCheck.getText());
		assertEquals("勤怠情報の登録が完了しました。", punchSuccessMsg.getText());
	}

	/** 出勤ボタン押下*/
	public void doPunchIn() {
		doPunch(punchInBtn, punchInCheck);
	}

	/**　退勤ボタン押下*/
	public void doPunchOut() {
		doPunch(punchOutBtn, punchOutCheck);
	}

	/** Case11*/
	/** 勤怠直接変更リンク押下*/
	public void gotoDirectAttendanceFix() {
		waitVisible(directAttendanceFixLink);
		tryClick(directAttendanceFixLink);

		waitVisible(doFixedTimeBtn);
		assertEquals("定時", doFixedTimeBtn.getText());
	}

	/** 正しく勤怠時間登録*/
	public void doFixedTime() {
		tryClick(doFixedTimeBtn);
		tryClick(doFixedTimeBtnSecond);
		tryClick(doAttendanceDirectUpdateBtn);

		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();

		waitVisible(punchSuccessMsg);
		assertEquals("勤怠情報の登録が完了しました。", punchSuccessMsg.getText());

	}

	void setDefaultTime() {
		tryClick(doFixedTimeBtn);
		tryClick(intermissionList);
		tryClick(intermissionEmpty);
		doSendKeys(attendanceNote, EMPTY);
	}

	/** 出退勤の（時）と（分）のいずれかが空白*/
	public void doChangeMixedEmptyHourAndMinute() {
		/** 出退勤をデフォルトにする*/
		setDefaultTime();
		;

		/** 出勤時間：[(空):00]*/
		tryClick(punchInHour);
		tryClick(punchInHourEmpty);
		tryClick(punchInMinute);
		tryClick(punchInMinuteZero);

		/** 退勤時間：[18:(空)]*/
		tryClick(punchOutHour);
		tryClick(punchOutHourFixed);
		tryClick(punchOutMinute);
		tryClick(punchOutMinuteEmpty);

		tryClick(doAttendanceDirectUpdateBtn);
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();

		waitVisible(attendanceErrorOne);
		assertEquals("* 出勤時間が正しく入力されていません。", attendanceErrorOne.getText());
		assertEquals("* 退勤時間が正しく入力されていません。", attendanceErrorTwo.getText());
	}

	/** 出勤が空白で退勤に入力あり*/
	public void doChangeEmptyPunchIn() {
		/** 出退勤をデフォルトにする*/
		setDefaultTime();

		/** 出勤時間：[(空):(空)]*/
		tryClick(punchInHour);
		tryClick(punchInHourEmpty);
		tryClick(punchInMinute);
		tryClick(punchInMinuteEmpty);

		/** 出勤時間：[18:00]*/
		tryClick(punchOutHour);
		tryClick(punchOutHourFixed);
		tryClick(punchOutMinute);
		tryClick(punchOutMinuteZero);

		tryClick(doAttendanceDirectUpdateBtn);
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();

		waitVisible(attendanceErrorOne);
		assertEquals("* 出勤情報がないため退勤情報を入力出来ません。", attendanceErrorOne.getText());
	}

	/** 出勤が退勤よりも遅い時間*/
	public void doChangeWrongLogicTime() {
		/** 出退勤をデフォルトにする*/
		setDefaultTime();

		/** 出勤時間：[20:00]*/
		tryClick(punchInHour);
		tryClick(punchInHourLate);
		tryClick(punchInMinute);
		tryClick(punchInMinuteZero);

		/** 退勤時間：[18:00]*/
		tryClick(punchOutHour);
		tryClick(punchOutHourFixed);
		tryClick(punchOutMinute);
		tryClick(punchOutMinuteZero);

		tryClick(doAttendanceDirectUpdateBtn);
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();

		waitVisible(attendanceErrorOne);
		assertEquals("* 退勤時刻[0]は出勤時刻[0]より後でなければいけません。", attendanceErrorOne.getText());
	}

	/** 出退勤時間を超える中抜け時間*/
	public void doChangeTooLongIntermission() {
		/** 出退勤をデフォルトにする*/
		setDefaultTime();

		/** 出勤時間：[10:00]*/
		tryClick(punchInHour);
		tryClick(punchInHourTenAM);
		tryClick(punchInMinute);
		tryClick(punchInMinuteZero);

		/** 退勤時間：[12:00]*/
		tryClick(punchOutHour);
		tryClick(punchOutHourNoon);
		tryClick(punchOutMinute);
		tryClick(punchOutMinuteZero);

		/** 中抜け時間：7時間*/
		tryClick(intermissionList);
		tryClick(intermissionHour);

		tryClick(doAttendanceDirectUpdateBtn);
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();

		waitVisible(attendanceErrorOne);
		assertEquals("* 中抜け時間が勤務時間を超えています。", attendanceErrorOne.getText());
	}

	public void doLongNote() {
		/** 出退勤をデフォルトにする*/
		setDefaultTime();

		doSendKeys(attendanceNote, TOO_LONG);
		tryClick(doAttendanceDirectUpdateBtn);
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();

		waitVisible(attendanceErrorOne);
		assertEquals("* 備考の長さが最大値(100)を超えています。", attendanceErrorOne.getText());
	}
}
