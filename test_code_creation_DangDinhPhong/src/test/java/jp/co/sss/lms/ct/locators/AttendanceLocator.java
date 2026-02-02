package jp.co.sss.lms.ct.locators;

import static jp.co.sss.lms.ct.util.Constant.*;
import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AttendanceLocator extends BaseLocator {

	public AttendanceLocator(WebDriver driver) {
		super(driver);
		// TODO 自動生成されたコンストラクター・スタブ
	}

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
	@FindBy(xpath = "//td[contains(text(),'2026年2月1日(日)')]/following-sibling::td[@class='w80'][1]")
	private WebElement punchInCheck;

	/** 研修日程の横の「退勤時間」にあたる箇所*/
	/** 退勤ボタンを押下後、押下した時間が反映される*/
	@FindBy(xpath = "//td[contains(text(),'2026年2月2日(月)')]/following-sibling::td[@class='w80'][2]")
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

		doSendKeys(attendanceNote, LONG_NOTE);
		tryClick(doAttendanceDirectUpdateBtn);
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();

		waitVisible(attendanceErrorOne);
		assertEquals("* 備考の長さが最大値(100)を超えています。", attendanceErrorOne.getText());
	}

}
