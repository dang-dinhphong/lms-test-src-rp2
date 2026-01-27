package jp.co.sss.lms.ct.f02_faq;

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
 * 結合テスト よくある質問機能
 * ケース06
 * @author holy
 */
@TestMethodOrder(OrderAnnotation.class)
@DisplayName("ケース06 カテゴリ検索 正常系")
public class Case06 {
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
		goTo("http://localhost:8080/lms/");
		locators.checkLoginScreen();
		pageLoadTimeout(10);
		getEvidence(new Object() {
		});
	}

	/**
	 * @author DangDinhPhong
	 */
	@Test
	@Order(2)
	@DisplayName("テスト02 初回ログイン済みの受講生ユーザーでログイン")
	void test02() {
		/** ログインID・パスワードを自動入力*/
		locators.login();
		pageLoadTimeout(10);
		locators.checkCourseName();
		getEvidence(new Object() {
		}, "コース名確認");
	}

	/**
	 * @author DangDinhPhong
	 */
	@Test
	@Order(3)
	@DisplayName("テスト03 上部メニューの「ヘルプ」リンクからヘルプ画面に遷移")
	void test03() {
		locators.clickHelp();
		pageLoadTimeout(10);
		getEvidence(new Object() {
		}, "ヘルプ画面タイトル確認");
	}

	/**
	 * @author DangDinhPhong
	 */
	@Test
	@Order(4)
	@DisplayName("テスト04 「よくある質問」リンクからよくある質問画面を別タブに開く")
	void test04() {
		locators.clickFAQ();
		pageLoadTimeout(10);
		getEvidence(new Object() {
		}, "よくある質問画面タイトル確認");
	}

	/**
	 * @author DangDinhPhong
	 */
	@Test
	@Order(5)
	@DisplayName("テスト05 カテゴリ検索で該当カテゴリの検索結果だけ表示")
	void test05() {

	}

	/**
	 * @author DangDinhPhong
	 */
	@Test
	@Order(6)
	@DisplayName("テスト06 検索結果の質問をクリックしその回答を表示")
	void test06() {

	}

}
