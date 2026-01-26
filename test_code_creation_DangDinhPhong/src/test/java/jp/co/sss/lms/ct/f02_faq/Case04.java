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
 * ケース04
 * @author holy
 */
@TestMethodOrder(OrderAnnotation.class)
@DisplayName("ケース04 よくある質問画面への遷移")
public class Case04 {
	private Locators locators;

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
		locators.checkLoginBtn();
		locators.checkLoginLabel();
		locators.checkPasswordLabel();
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
		/** 環境変数を取得*/
		String id = System.getenv("MY_LMS_AUTOTEST_LOGIN_ID");
		String password = System.getenv("MY_LMS_AUTOTEST_PASSWORD");
		if (id == null || password == null) {
			System.out.println("環境変数が存在しません。確認してください。");
			return;
		}
		/** ログインID・パスワードを自動入力*/
		locators.typeLoginId(id);
		locators.typePassword(password);
		getEvidence(new Object() {
		}, "入力済");

		pageLoadTimeout(10);
		locators.clickLoginBtn();

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
		/** 詳細画面 > 上部メニューの「機能」押下*/
		locators.clickFeatureBtn();
		/** 「機能」ボタンが展開し、ヘルプボタンが表示されるかチェック*/
		locators.checkHelpBtn();
		pageLoadTimeout(10);
		getEvidence(new Object() {
		}, "機能ボタン展開・ヘルプボタン確認");

		locators.clickHelpLink();
		pageLoadTimeout(10);
		locators.checkHelpTitle();
		locators.checkHelpMsg();
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

		locators.clickFAQLink();
		pageLoadTimeout(10);
		locators.checkFAQTitle();
		getEvidence(new Object() {
		}, "よくある質問画面タイトル確認");
	}

}
