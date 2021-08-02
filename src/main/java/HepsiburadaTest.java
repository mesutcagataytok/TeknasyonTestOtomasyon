import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;
import driversetup.BaseClass;
import pageobject.LandingPage;
import pageobject.LoginPage;
import pageobject.SearchPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HepsiburadaTest {
	// Ana sayfanın açıldığı kontrol edilir.
	@Test
	public void test1_IsHepsiburadaPageCorrect(){
		BaseClass.SetUpBrowser();
		Assert.assertEquals(LandingPage.GetPageLogoLabel().getAttribute("title"),"Hepsiburada");
	}
	// "hepsiburada.com" sitesine login olunur.
	@Test
	public void test2_HepsiburadaLoginValidation() throws InterruptedException {
		Assert.assertTrue(LoginPage.LoginHepsiburada());
	}
	// iphone araması yapılır ve "iphone" kelimesinin arandığı doğrulanır.
	@Test
	public void test3_IsIphoneResultSame() throws InterruptedException{
		String searchWord = "iphone" ;
		SearchPage.MakeProductSearch(searchWord);
		String wordIsAfterSearch = SearchPage.GetSearchResult();
		Assert.assertEquals(searchWord, wordIsAfterSearch);
	}
	// Bulunan ürünlerden ilk ürün seçilir ve seçilen ürünün aynı ürün olup olmadığı kontrol edilir.
	@Test
	public void test4_IsMyProductNameTrue() throws InterruptedException {
		String firstSelectedProductName = SearchPage.GetSearchResultList().get(0).getText();
		SearchPage.ClickFirstProduct();
		String productNameAfterClicked = SearchPage.GetClickedItemProductName();
		Assert.assertEquals(firstSelectedProductName, productNameAfterClicked);
	}
	// Yorumlar tabına tıklanır ve yorumlar tabının gelip gelmediği kontrol edilir.
	@Test
	public void test5_CheckToCommentsTab() {
		SearchPage.CickToCommentsTab();
		Assert.assertTrue(SearchPage.GetCommentTabLabel().isDisplayed());
	}
	// Gelen yorumlar içerisinden ilk yorumun "Evet" butonuna tıklanır ve kullanıcı "Teşekkür ederiz." yazısını görür.
	@Test
	public void test6_CheckToThankYouText() {
		SearchPage.ClickToLikeButton();
		Assert.assertEquals(SearchPage.GetThankYouText(), "Teşekkür Ederiz.");
	}
	@AfterClass
	public static void QuitBrowser(){
	BaseClass.CloseBrowser();
	}
}
