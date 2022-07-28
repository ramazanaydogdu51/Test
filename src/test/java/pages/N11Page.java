package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class N11Page {
    public N11Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@class='btnSignIn']")
    public WebElement girisButonu;

    @FindBy(xpath = "//span[@class='btn baseBtn-green']")
    public WebElement aydinlatmaMetniOk;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement kullaniciAdi;

    @FindBy(xpath = "//input[@id='password']")
    public  WebElement sifre;

    @FindBy(xpath = "//div[@id='loginButton']")
    public WebElement girisOnayla;

    @FindBy(xpath = "//label[@for='rememberMe']")
    public WebElement beniHatirla;

    @FindBy(xpath = "//input[@id='searchData']")
    public  WebElement aramaButonu;
    @FindBy(xpath = "//div[@class='pagination']//a[contains(text(),'2')]")
    public WebElement sayfa2;

    @FindBy(xpath = "//a[@title='Hesabım']")
    public WebElement hesabim;
   //@FindBy(xpath = "//span[@class='btnBasket']")
   //public List<WebElement> tumUrunler;

    @FindBy(xpath = "//img[@class='lazy cardImage']")
    public List<WebElement> tumUrunler;

    ////img[@class='lazy cardImage']
    @FindBy (xpath = "//a[normalize-space()='Üyelik Bilgilerim']")
    public WebElement uyelikBilgileri;
    @FindBy(xpath = "//input[@id='emailDisabled']")
    public WebElement gercekEpostaAdersi;
    @FindBy(xpath = "//h1[@class='proName']")
    public  WebElement urunBasligiElementi;

    @FindBy(xpath = "//a[@class='prodDescription'][1]")
    public WebElement sepettekiUrunBasligiElementi;

    @FindBy(xpath = "//i[@class='iconsBasketWhite']")
    public WebElement sepeteGit;
    @FindBy(xpath = "//button[@title='Sepete Ekle']")
    public WebElement sepeteEkleButonu;

    @FindBy(xpath = "//span[@class='removeProd svgIcon svgIcon_trash'][1]")
    public WebElement urunuSil;

    @FindBy(xpath = "//span[@id='deleteBtnDFLB']")
    public WebElement urunuSilOnayla;

    @FindBy(xpath = "//h2[contains(text(),'Sepetin Boş Görünüyor')]")
    public WebElement sepetBos;

}
