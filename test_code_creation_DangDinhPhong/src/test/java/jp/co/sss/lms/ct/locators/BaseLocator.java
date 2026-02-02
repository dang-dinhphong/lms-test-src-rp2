package jp.co.sss.lms.ct.locators;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BaseLocator {
	protected WebDriver driver;
	protected WebDriverWait wait;

	/** コース名確認*/
	@FindBy(xpath = "//h2[contains(text(),'DEMOコース')]")
	protected WebElement courseName;

	/** レポート提出画面の上部タイトル*/
	@FindBy(xpath = "//*[@id='main']//h2")
	protected WebElement mainTopTitle;

	public BaseLocator(WebDriver driver) {
		this.driver = driver;
		this.driver.manage().window().maximize();//画面フルサイズする
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));//waitをインスタンス化

		//アノテーションを有効化する
		PageFactory.initElements(driver, this);
	}

	protected void waitVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * 入力
	 * 
	 * @param element 入力したい要素
	 * @param key 入力内容
	 */
	protected void doSendKeys(WebElement element, String key) {
		element.clear();
		element.sendKeys(key);
	}

	/**
	 * 各ボタンおよびURLリンクのJS強制押下
	 * 
	 * @param button ボタンやリンクなど
	 */
	protected void tryClick(WebElement button) {
		try {
			button.click();
		} catch (Exception e) {
			//JavaScriptでボタン強制押下
			org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", button);
		}
	}
}
