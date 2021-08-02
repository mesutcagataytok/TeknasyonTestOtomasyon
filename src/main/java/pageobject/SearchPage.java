package pageobject;

import driversetup.BaseClass;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Base64;
import java.util.List;

public class SearchPage extends BaseClass {
    public static WebElement element;
    public static List<WebElement> elements;
    static Logger log = Logger.getLogger(SearchPage.class.getName());
    //Iphone kelimesi aranır.
    public static void MakeProductSearch(String searchKeyWord) throws InterruptedException {
        //search box text elementi
        element = driver.findElement(By.xpath("//div[@id='SearchBoxOld']/div/div[1]/div[1]"));
        element.click();
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
        actions.sendKeys(searchKeyWord).build().perform();
        //search box ara butonu
        element = driver.findElement(By.xpath("//div[contains(text(),'ARA')]"));
        element.click();
    }
    //Iphone kelimesi aratıldığında kontrol edilir.
    public static List<WebElement> GetSearchResultList() {
        elements = driver.findElements(By.xpath("//h3[@class='product-title title']/div/p/span"));
        if(elements.size()>=1){
            log.debug("Aranan ürünle ilgili sonuç bulundu.");
        }
        else{
            log.debug("Aranan ürünle ilgili sonuç bulunamadı.");
        }
        return elements;
    }

    public static String GetSearchResult() {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'iphone')]")));
        //arama yaptıktan sonra yapılan aramanın yazdığı text element
        element = driver.findElement(By.xpath("//h1[contains(text(),'iphone')]"));
        String iphone = element.getText();
        if(iphone.equals("iphone")){
            log.debug("iphone araması yapıldığı doğrulanıyor");
        }
        else{
            log.debug("iphone araması yapılamadı");
        }
        return iphone;
    }

    public static WebElement GetCommentTabLabel() {
        // değerlendirmeler tabının elementi
        element = driver.findElement(By.xpath("//a[@id='productReviewsTab']"));
        if(element != null){
            log.debug("Değerlendirmeler alanı bulunmuştur.");
        }
        else{
            log.debug("Değerlendirmeler alanı bulunamamıştır.");
        }
        return element;
    }
    //get "Teşekkür ederiz." text
    public static String GetThankYouText() {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='hermes-ReviewCard-module-1ZiTv']")));
        //Like butonuna tıkladıktan sonra gözüken "Teşekkür ederiz." yazısını alan element
        elements = driver.findElements(By.xpath("//span[@class='hermes-ReviewCard-module-1ZiTv']"));
        String thankYou = elements.get(0).getText();
        if(thankYou.equals("Teşekkür Ederiz.")){
            log.debug("Teşekkür Ederiz yazısı doğru şekilde gösteriliyor.");
        }
        else{
            log.debug("Teşekkür Ederiz yazısı doğru şekilde gösterilemedi.");
        }
        return thankYou;
    }

    public static void  ClickToLikeButton() {
        //like butonunun elementi
        elements = driver.findElements(By.xpath("//div[@class='hermes-ReviewCard-module-3DD_U']/div[1]/div[1]"));
        if(elements.size()>=1){
            log.debug("Like butonu gözükmektedir.");
        }
        else{
            log.debug("Like butonu gözükmemektedir.");
        }
        elements.get(0).click();
        elements.get(0).click();
    }

    public static WebElement CickToCommentsTab() {
        //değerlendiremler tabının elementi
        element = driver.findElement(By.xpath("//a[@id='productReviewsTab']"));
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
        element.click();
        return element;
    }

    public static String GetClickedItemProductName() {
        //search sonucunda listeden ilk ürüne tıkladıktan sonra açılan pencerede ürünün ismini alan element
        element = driver.findElement(By.xpath("//h1[@id='product-name']"));
        return element.getText();
    }

    public static void ClickFirstProduct() {
        elements = driver.findElements(By.xpath("//h3[@class='product-title title']/div/p/span"));
        elements.get(0).click();
    }
}
