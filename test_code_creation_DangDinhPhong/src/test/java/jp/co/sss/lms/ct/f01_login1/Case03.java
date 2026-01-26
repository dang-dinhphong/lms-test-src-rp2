package jp.co.sss.lms.ct.f01_login1;

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
 * 結合テスト ログイン機能①
 * ケース03
 * @author holy
 */
@TestMethodOrder(OrderAnnotation.class)
@DisplayName("ケース03 受講生 ログイン 正常系")
public class Case03 {

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

}
