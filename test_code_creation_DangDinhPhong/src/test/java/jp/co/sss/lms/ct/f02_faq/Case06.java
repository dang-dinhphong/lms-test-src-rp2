package jp.co.sss.lms.ct.f02_faq;

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

import jp.co.sss.lms.ct.locators.FAQLocator;
import jp.co.sss.lms.ct.locators.LoginLocator;

/**
 * 結合テスト よくある質問機能
 * ケース06
 * @author holy
 */
@TestMethodOrder(OrderAnnotation.class)
@DisplayName("ケース06 カテゴリ検索 正常系")
public class Case06 {
	private LoginLocator login;
	private FAQLocator faq;

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
		this.login = new LoginLocator(webDriver);
		this.faq = new FAQLocator(webDriver);
	}

	/**
	 * @author DangDinhPhong
	 */
	@Test
	@Order(1)
	@DisplayName("テスト01 トップページURLでアクセス")
	void test01() {
		login.checkLoginScreen();
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
		login.login();
		getEvidence(new Object() {
		}, COURSE_DETAIL);
	}

	/**
	 * @author DangDinhPhong
	 */
	@Test
	@Order(3)
	@DisplayName("テスト03 上部メニューの「ヘルプ」リンクからヘルプ画面に遷移")
	void test03() {
		faq.clickHelp();
		getEvidence(new Object() {
		}, "ヘルプ画面");
	}

	/**
	 * @author DangDinhPhong
	 */
	@Test
	@Order(4)
	@DisplayName("テスト04 「よくある質問」リンクからよくある質問画面を別タブに開く")
	void test04() {
		faq.clickFAQ();
		getEvidence(new Object() {
		}, "よくある質問画面");
	}

	/**
	 * @author DangDinhPhong
	 */
	@Test
	@Order(5)
	@DisplayName("テスト05 カテゴリ検索で該当カテゴリの検索結果だけ表示")
	void test05() {
		faq.testCategory();
		getEvidence(new Object() {
		}, "よくある質問画面_カテゴリ検索_結果");
	}

	/**
	 * @author DangDinhPhong
	 */
	@Test
	@Order(6)
	@DisplayName("テスト06 検索結果の質問をクリックしその回答を表示")
	void test06() {
		faq.testCategoryDetailCheck();
		getEvidence(new Object() {
		}, "よくある質問画面_カテゴリ検索_結果詳細");
	}

}
