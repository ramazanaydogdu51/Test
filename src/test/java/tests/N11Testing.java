package tests;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.N11Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;
import java.util.Random;
public class N11Testing extends TestBaseRapor {
    @Test
    public void test01()  {
        extentTest=extentReports.createTest("test","n11 e gidilip urun secilir");
        JavascriptExecutor jse= (JavascriptExecutor) Driver.getDriver();
        N11Page n11 =new N11Page();
        Actions actions=new Actions(Driver.getDriver());
        Driver.getDriver().get(ConfigReader.getProperty("n11Url"));
        extentTest.info("N11 sitesine gidildi.");
        n11.aydinlatmaMetniOk.click();
        n11.girisButonu.click();
        actions.sendKeys(ConfigReader.getProperty("n11Email")).perform();
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(ConfigReader.getProperty("n11Sifre")).perform();
        actions.sendKeys(Keys.ENTER).perform();
        extentTest.info("Kullanıcı hesabina giris yapildi");
        n11.hesabim.click();
        n11.uyelikBilgileri.click();
        Assert.assertEquals(n11.gercekEpostaAdersi.getAttribute("value"),ConfigReader.getProperty("n11Email"));
        extentTest.pass("Dogru kullanıciya giris yapildigi dogrulandı");
        n11.aramaButonu.sendKeys("telefon"+Keys.ENTER);
        extentTest.info("Arama butonuna 'telefon' kelimesi yazildi");
        jse.executeScript("arguments[0].click();",n11.sayfa2);
        extentTest.info("2. sayfa gecis yapildi");
        Assert.assertEquals(n11.sayfa2.getAttribute("class"),"active ");
        extentTest.pass("2. sayfaya gecis yapildigi dogrulandi");
        Random rndm=new Random();
        n11.tumUrunler.get(rndm.nextInt(n11.tumUrunler.size())).click();
        jse.executeScript("arguments[0].click();",n11.sepeteEkleButonu);
         extentTest.info("Rastgele bir urun secildi");
        String secilenUrununUrlsi=Driver.getDriver().getCurrentUrl();
        n11.sepeteGit.click();
        extentTest.info("Sepete gidildi");
        Assert.assertEquals(secilenUrununUrlsi,n11.sepettekiUrunBasligiElementi.getAttribute("href"));
        extentTest.pass("Secilen urun ile sepetteki urunun ayni oldugu dogrulandi");
        n11.urunuSil.click();
        n11.urunuSilOnayla.click();
        extentTest.info("Secilen urun silindi");
        Assert.assertTrue(n11.sepetBos.isDisplayed());
        extentTest.pass("Sepetin bos oldugu dogrulandi");
        Driver.getDriver().close();
    }
}
