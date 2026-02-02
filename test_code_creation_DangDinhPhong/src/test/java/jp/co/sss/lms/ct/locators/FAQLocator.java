package jp.co.sss.lms.ct.locators;

import static jp.co.sss.lms.ct.util.Constant.*;
import static jp.co.sss.lms.ct.util.WebDriverUtils.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FAQLocator extends BaseLocator {

	/** 上部のメニュー > 機能ボタン*/
	@FindBy(xpath = "//a[@class = 'dropdown-toggle' and contains(text(),'機能')]")
	private WebElement featureBtn;

	/** ヘルプURLリンク*/
	@FindBy(css = "a[href='/lms/help']")
	private WebElement helpLink;

	/** ヘルプタイトル*/
	@FindBy(xpath = "//h2[contains(text(),'ヘルプ')]")
	private WebElement helpTitle;

	/** よくある質問タイトル*/
	@FindBy(xpath = "//h2[contains(text(),'よくある質問')]")
	private WebElement faqTitle;

	/** h4タグ*/
	@FindBy(tagName = "h4")
	private WebElement h4Title;

	/** 「よくある質問」URLリンク*/
	@FindBy(css = "a[href='/lms/faq']")
	private WebElement faqLink;

	/** よくある質問>キーワード検索欄に自動入力*/
	@FindBy(css = "input[name='keyword']")
	private WebElement faqKeywordInput;

	/** よくある質問>キーワード検索ボタン*/
	@FindBy(css = "input[type='submit'][value='検索']")
	private WebElement keywordSearchBtn;

	/** よくある質問>キーワード検索結果に使用*/
	@FindBy(xpath = "//dd//span")
	private List<WebElement> spans;

	@FindBy(css = "td[class = 'dataTables empty']")
	private List<WebElement> emptyMsg;

	/** よくある質問 > カテゴリ検索 > 【研修関係】*/
	@FindBy(css = "a[href='/lms/faq?frequentlyAskedQuestionCategoryId=1']")
	private WebElement categoryJobTraining;

	/** よくある質問 > カテゴリ検索 > 【研修関係】の2番目の結果*/
	@FindBy(css = "tbody tr:nth-child(2) dt span:nth-child(2)")
	private WebElement jobTrainingSecondResult;

	/** よくある質問 > カテゴリ検索 > 【研修関係】の2番目の結果*/
	@FindBy(css = "tbody tr:nth-child(2) dd span:nth-child(2)")
	private WebElement jobTrainingSecondResultDetail;

	/** よくある質問 > カテゴリ検索 > 【研修関係】 > 検索結果数のメッセージ*/
	@FindBy(id = "DataTables_Table_0_info")
	private WebElement jobTrainingResultsMsg;

	public FAQLocator(WebDriver driver) {
		super(driver);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	/** 上部メニュー > 機能ボタン押下 > ヘルプボタン押下*/
	public void clickHelp() {
		/** 上部メニュー > 機能ボタン押下*/
		tryClick(featureBtn);

		/** ヘルプボタン名確認*/
		waitVisible(helpLink);
		assertEquals("ヘルプ", helpLink.getText());

		/** ヘルプボタン押下*/
		waitVisible(helpLink);
		tryClick(helpLink);

		/** ヘルプタイトル確認*/
		waitVisible(helpTitle);
		assertEquals("ヘルプ", helpTitle.getText());

		/** ヘルプタイトル確認*/
		waitVisible(h4Title);
		assertEquals("※操作方法が不明な場合はマニュアルをご参照ください。", h4Title.getText());
		pageLoadTimeout(10);
	}

	/** よくある質問URLリンクを押下し、遷移したか確認*/
	public void clickFAQ() {
		tryClick(faqLink);

		//ヘルプ画面を（遷移する前に）検証する
		String originalWindow = webDriver.getWindowHandle();
		//別の画面に開くまで待つ
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		//遷移前＞＜遷移後の画面が内容違うか確認
		for (String windowHandle : driver.getWindowHandles()) {
			if (!originalWindow.contentEquals(windowHandle)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}

		//よくある質問タイトル確認
		waitVisible(faqTitle);
		assertEquals("よくある質問", faqTitle.getText());
		pageLoadTimeout(10);
	}

	/**
	 * よくある質問 > キーワード検索欄の自動入力 > 「検索」ボタン押下
	 * @param keyword 検索キーワード
	 */
	public void keywordSearch() {
		String keyword = "手続き";
		faqKeywordInput.clear();
		faqKeywordInput.sendKeys(keyword);

		/** キーワード検索時「検索」ボタン押下*/
		tryClick(keywordSearchBtn);

		/** 検索結果を検証するメソッド*/
		//リストが空（検索結果ゼロ）でないことを確認
		if (!emptyMsg.isEmpty()) {
			return;
		}

		/** 各要素の中にキーワードが入っているか確認*/
		for (WebElement result : spans) {
			String actualText = result.getText();
			if (!actualText.isEmpty()) {
				assertTrue(actualText.contains(keyword));
			}
		}
		/** 下部にスクロール*/
		scrollTo("500");
		pageLoadTimeout(10);

	}

	/** よくある質問 > キーワード検索の「クリア」ボタン押下*/
	public void clearKeyword() {
		/** キーワード検索欄を空にする*/
		faqKeywordInput.clear();
		assertEquals(EMPTY, faqKeywordInput.getText());
	}

	/** 【研修関係】リンクを押下 > 検索結果を確認*/
	public void testCategory() {
		waitVisible(categoryJobTraining);
		categoryJobTraining.click();

		scrollTo("500");
		waitVisible(jobTrainingSecondResult);

		assertEquals("研修の申し込みはどのようにすれば良いですか？", jobTrainingSecondResult.getText());
		assertEquals("2 件中 1 件から 2 件までを表示", jobTrainingResultsMsg.getText());

		pageLoadTimeout(10);
	}

	/** 【研修関係】リンクを押下 > 検索結果を確認*/
	public void testCategoryDetailCheck() {
		jobTrainingSecondResult.click();
		scrollTo("500");
		waitVisible(jobTrainingSecondResultDetail);
		assertEquals("営業担当がいる場合は、営業担当までご連絡ください。 申し込み方法についてご案内させていただきます。 なお、弊社営業営業がいない場合は、東京ITスクール運営事務局までご連絡いただけると幸いです。",
				jobTrainingSecondResultDetail.getText());
		pageLoadTimeout(10);
	}

}
