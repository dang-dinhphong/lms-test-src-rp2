package jp.co.sss.lms.ct.f03_report;

import static jp.co.sss.lms.ct.util.Constant.*;
import static jp.co.sss.lms.ct.util.WebDriverUtils.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import jp.co.sss.lms.ct.util.Locators;

/**
 * 結合テスト レポート機能
 * ケース09
 * @author holy
 */
@TestMethodOrder(OrderAnnotation.class)
@DisplayName("ケース09 受講生 レポート登録 入力チェック")
public class Case09 {

	public Locators locators;

	/** 前処理 */
	@BeforeAll
	static void before() {
		createDriver();
	}

	/** 後処理 */
	@AfterAll
	static void after() {
		closeDriver();
	}

	/** 初期化
	 * 
	 * @author DangDinhPhong
	 * */
	@BeforeEach
	void setUp() {
		//webDriverをLocatorsに渡して、ページ要素をいつでも使えるように準備
		this.locators = new Locators(webDriver);
	}

	/**
	 * @author DangDinhPhong
	 */
	@Test
	@Order(1)
	@DisplayName("テスト01 トップページURLでアクセス")
	void test01() {
		locators.checkLoginScreen();
		getEvidence(new Object() {
		}, ACCESS_LMS);
	}

	/**
	 * @author DangDinhPhong
	 */
	@Test
	@Order(2)
	@DisplayName("テスト02 初回ログイン済みの受講生ユーザーでログイン")
	void test02() {
		locators.login();
		getEvidence(new Object() {
		}, COURSE_DETAIL);
	}

	@Test
	@Order(3)
	@DisplayName("テスト03 上部メニューの「ようこそ○○さん」リンクからユーザー詳細画面に遷移")
	void test03() {
		locators.gotoUserDetailFromCourse();
		getEvidence(new Object() {
		}, "ユーザ詳細画面");

	}

	@Test
	@Order(4)
	@DisplayName("テスト04 該当レポートの「修正する」ボタンを押下しレポート登録画面に遷移")
	void test04() {
		locators.gotoWeeklyReportChange();
		getEvidence(new Object() {
		}, "レポート登録画面_週報_修正");
	}

	@Test
	@Order(5)
	@DisplayName("テスト05 報告内容を修正して「提出する」ボタンを押下しエラー表示：学習項目が未入力")
	void test05() {
		/** 週報項目を一旦デフォルトにする*/
		locators.setDefault();

		locators.inputCheckCurriculum();
		getEvidence(new Object() {
		}, "レポート登録画面_週報_修正_学習項目_未入力_エラーメッセージ");
	}

	@Test
	@Order(6)
	@DisplayName("テスト06 不適切な内容で修正して「提出する」ボタンを押下しエラー表示：理解度が未入力")
	void test06() {
		/** 週報項目を一旦デフォルトにする*/
		locators.setDefault();

		locators.inputCheckUnderstanding();
		getEvidence(new Object() {
		}, "レポート登録画面_週報_修正_理解度_未入力_エラーメッセージ");
	}

	@Test
	@Order(7)
	@DisplayName("テスト07 不適切な内容で修正して「提出する」ボタンを押下しエラー表示：目標の達成度が数値以外")
	void test07() {
		/** 週報項目を一旦デフォルトにする*/
		locators.setDefault();

		locators.inputCheckAchieveNotNum();
		getEvidence(new Object() {
		}, "レポート登録画面_週報_修正_目標達成度_数値以外_エラーメッセージ");
	}

	@Test
	@Order(8)
	@DisplayName("テスト08 不適切な内容で修正して「提出する」ボタンを押下しエラー表示：目標の達成度が範囲外")
	void test08() {
		/** 週報項目を一旦デフォルトにする*/
		locators.setDefault();

		locators.inputCheckAchieveOutOfRange();
		getEvidence(new Object() {
		}, "レポート登録画面_週報_修正_目標達成度_範囲外_エラーメッセージ");
	}

	@Test
	@Order(9)
	@DisplayName("テスト09 不適切な内容で修正して「提出する」ボタンを押下しエラー表示：目標の達成度・所感が未入力")
	void test09() {
		/** 週報項目を一旦デフォルトにする*/
		locators.setDefault();

		locators.inputCheckBothAchieveAndImpressEmpty();
		getEvidence(new Object() {
		}, "レポート登録画面_週報_修正_目標の達成度・所感_未入力_エラーメッセージ");
	}

	@Test
	@Order(10)
	@DisplayName("テスト10 不適切な内容で修正して「提出する」ボタンを押下しエラー表示：所感・一週間の振り返りが2000文字超")
	void test10() {
		/** 週報項目を一旦デフォルトにする*/
		locators.setDefault();

		locators.inputCheckBothImpresssionAndWeekReportTooLong();
		getEvidence(new Object() {
		}, "レポート登録画面_週報_修正_所感・一週間の振り返り_2000文字超_エラーメッセージ");

	}

}
