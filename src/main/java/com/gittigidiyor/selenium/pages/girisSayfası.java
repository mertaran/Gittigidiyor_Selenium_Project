package com.gittigidiyor.selenium.pages;

import com.gittigidiyor.selenium.Users.kullanici;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class girisSayfasÄ± extends BasePage{

    By userNameFieldBy = By.id("L-UserNameField");
    By passwordFieldBy = By.id("L-PasswordField");
    By loginButtonBy = By.id("gg-login-enter");

    public girisSayfasÄ±(WebDriver webDriver) {
        super(webDriver);
    }

    public anaSayfa login(kullanici kullanici) {
        sendKeys(userNameFieldBy, kullanici.getEmail(),false);
        sendKeys(passwordFieldBy, kullanici.getPassword(),true);
        //click(loginButtonBy, 15);

        anaSayfa anaSayfa = new anaSayfa(webDriver);
        anaSayfa.waitForLoad();
        return anaSayfa;
    }

}
