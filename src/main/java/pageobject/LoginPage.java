package pageobject;

import driversetup.BaseClass;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginPage extends BaseClass {

    public static WebElement element;
    public static List<WebElement> elements;
    static Logger log = Logger.getLogger(LandingPage.class.getName());

    public static Boolean LoginHepsiburada() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@id='myAccount']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@id='login']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='txtUserName']")).click();
        driver.findElement(By.xpath("//input[@id='txtUserName']")).sendKeys("cagataytok@windowslive.com");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).click();
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("sac021");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@id='btnLogin']")).click();
        Thread.sleep(3000);
        // login olduktan sonra kullanıcının ismini alan element
        element = driver.findElement(By.xpath("//span[contains(text(),'Mesut Çağatay Tok')]"));

        if (element.getText().equals("Mesut Çağatay Tok")) {
            log.debug("Hesaba başarılı giriş yapıldı.");
            return true;
        }else{
            log.debug("Hesaba başarılı giriş yapılamadı.");
        }
        return false;
    }
}
