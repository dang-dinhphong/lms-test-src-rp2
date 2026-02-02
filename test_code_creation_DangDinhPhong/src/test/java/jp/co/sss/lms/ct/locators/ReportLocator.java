package jp.co.sss.lms.ct.locators;

import static jp.co.sss.lms.ct.util.Constant.*;
import static jp.co.sss.lms.ct.util.WebDriverUtils.*;
import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReportLocator extends BaseLocator {

	public ReportLocator(WebDriver driver) {
		super(driver);
		// TODO 自動生成されたコンストラクター・スタブ
	}

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
}
