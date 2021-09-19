package com.gittigidiyor.selenium;

import com.gittigidiyor.selenium.Users.kullanici;
import com.gittigidiyor.selenium.pages.*;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;

public class TestCase extends BaseTest {
    @Test
    public void gittiGidiyorTest() throws InterruptedException {
        String title = "GittiGidiyor - Türkiye'nin Öncü Alışveriş Sitesi";
        String email = "mertarann@hotmail.com";
        String password = "testiniummert98";

        anaSayfa anaSayfa = new anaSayfa(webDriver);
        String webDriverTitle = anaSayfa.getHomePageTitle();

        Log4j.info("Title: " + webDriverTitle);
        assertEquals(webDriverTitle, title);

        Log4j.info("Giriş sayfasına gidiliyor");
        girisSayfası girisSayfası = anaSayfa.getLoginPage();
        Log4j.info("email: " + email + ", password: " + password);
        kullanici kullanici = new kullanici(email, password);
        girisSayfası.login(kullanici);
        Log4j.info("Ana sayfaya gidiliyor");
        String accountButtonText = anaSayfa.getAccountText();
        Log4j.info("Hesabım: " + accountButtonText);
        assertTrue(accountButtonText.contains("Hesabım"));

        Log4j.info("'bilgisayar'kelimesi aratılıyor");
        aramaSonuc aramaSonuc = anaSayfa.search("bilgisayar");
        aramaSonuc.scrollToPage("7200");
        Log4j.info("Seçilen sayfa açılıyor.");
        aramaSonuc.choosePage("2");
        assertTrue(webDriver.getCurrentUrl().contains("2"));



        Log4j.info("Ürün detay sayfasına gidiliyor");
        urunDetay urunDetay = aramaSonuc.goToProductDetails();

        Log4j.info("Ürün fiyat bilgisi alınıyor");
        String productPrice = urunDetay.productPrice();
        urunDetay.scrollToPage("200");
        Log4j.info("Seçilen ürün sepete eklendi");
        urunDetay.addToBasket();

        Log4j.info("Sepetim sayfasına gidiliyor.");
        sepetimSayfası sepetimSayfası = urunDetay.goToBasket();
        Log4j.info("Ürün sayfasındaki fiyat, sepetteki ürünün fiyatı ile karşılaştırılırıyor.");
        webDriver.get("https://www.gittigidiyor.com/sepetim");

        Log4j.info("ürün sayısı arttırılıyor.");
        sepetimSayfası.setNumberOfProducts();
        Thread.sleep(2000);
        assertTrue(sepetimSayfası.getTotalProduct().contains("2 Adet"));
        Log4j.info("ürün sepetten silindi.");
        sepetimSayfası.deleteProduct();
        Thread.sleep(10000);
        String sepetMesaj = "Sepetinizde ürün bulunmamaktadır.";
        Log4j.info("Sepetin boş olduğu kontrol ediliyor");
        assertEquals(sepetMesaj, sepetimSayfası.isEmpty());

    }

}
