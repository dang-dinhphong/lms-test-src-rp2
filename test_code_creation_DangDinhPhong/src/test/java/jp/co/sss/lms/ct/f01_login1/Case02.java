package jp.co.sss.lms.ct.f01_login1;

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

import jp.co.sss.lms.ct.locators.LoginLocator;

/**
 * 結合テスト ログイン機能①
 * ケース02
 * @author holy
 */
@TestMethodOrder(OrderAnnotation.class)
@DisplayName("ケース02 受講生 ログイン 認証失敗")
public class Case02 {

	private LoginLocator login;

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
		this.login = new LoginLocator(webDriver);
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
	@DisplayName("テスト02 DBに登録されていないユーザーでログイン")
	void test02() {
		//DBに存在しないID・パスワードをそのまま渡します
		//Case03からは環境変数使用予定
		String id = "StudentAA100";
		String pass = "StudentAA100";
		login.loginFail(id, pass);
		getEvidence(new Object() {
		}, "ログイン画面_エラーメッセージ表示");
	}

}
