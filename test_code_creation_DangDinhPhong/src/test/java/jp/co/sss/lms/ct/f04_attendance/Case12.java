package jp.co.sss.lms.ct.f04_attendance;

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
 * 結合テスト 勤怠管理機能
 * ケース12
 * @author holy
 */
@TestMethodOrder(OrderAnnotation.class)
@DisplayName("ケース12 受講生 勤怠直接編集 入力チェック")
public class Case12 {

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

	/**
	 * @author DangDinhPhong
	 */
	@Test
	@Order(3)
	@DisplayName("テスト03 上部メニューの「勤怠」リンクから勤怠管理画面に遷移")
	void test03() {
		locators.gotoAttendanceDetail();
		getEvidence(new Object() {
		}, "勤怠管理画面");
	}

	/**
	 * @author DangDinhPhong
	 */
	@Test
	@Order(4)
	@DisplayName("テスト04 「勤怠情報を直接編集する」リンクから勤怠情報直接変更画面に遷移")
	void test04() {
		locators.gotoDirectAttendanceFix();
		getEvidence(new Object() {
		}, "勤怠情報直接変更画面");
	}

	@Test
	@Order(5)
	@DisplayName("テスト05 不適切な内容で修正してエラー表示：出退勤の（時）と（分）のいずれかが空白")
	void test05() {
		locators.doChangeMixedEmptyHourAndMinute();
		getEvidence(new Object() {
		}, "勤怠情報直接変更画面_出退勤_空白");
	}

	@Test
	@Order(6)
	@DisplayName("テスト06 不適切な内容で修正してエラー表示：出勤が空白で退勤に入力あり")
	void test06() {
		locators.doChangeEmptyPunchIn();
		getEvidence(new Object() {
		}, "勤怠情報直接変更画面_出勤空白_退勤あり");
	}

	@Test
	@Order(7)
	@DisplayName("テスト07 不適切な内容で修正してエラー表示：出勤が退勤よりも遅い時間")
	void test07() {
		locators.doChangeWrongLogicTime();
		getEvidence(new Object() {
		}, "勤怠情報直接変更画面_出勤が退勤よりも遅い時間");
	}

	@Test
	@Order(8)
	@DisplayName("テスト08 不適切な内容で修正してエラー表示：出退勤時間を超える中抜け時間")
	void test08() {
		locators.doChangeTooLongIntermission();
		getEvidence(new Object() {
		}, "勤怠情報直接変更画面_勤怠時間を超える中抜け時間");
	}

	@Test
	@Order(9)
	@DisplayName("テスト09 不適切な内容で修正してエラー表示：備考が100文字超")
	void test09() {
		locators.doLongNote();
		getEvidence(new Object() {
		}, "勤怠情報直接変更画面_備考が100文字超");
	}

}
