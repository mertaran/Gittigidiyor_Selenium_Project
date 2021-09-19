package com.gittigidiyor.selenium.pages;

import com.gittigidiyor.selenium.WebDriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class BasePage extends WebDriverHelper {
    By loginOrRegisterButtonBy = By.cssSelector("div[data-cy='header-user-menu']");
    By loginButtonBy = By.cssSelector("a[data-cy='header-login-button']");
    By searchBoxBy = By.className("sc-4995aq-0");

    public BasePage(WebDriver webDriver) {
        super(webDriver);
    }

    public girisSayfası getLoginPage(){
        moveToElement(loginOrRegisterButtonBy);
        click(loginButtonBy, 10);
        return new girisSayfası(webDriver);
    }
    public String getAccountText(){
        return getText(loginOrRegisterButtonBy);
    }

    public aramaSonuc search(String keyword) {
        webDriver.findElement(searchBoxBy).sendKeys(keyword + Keys.ENTER);
        return new aramaSonuc(webDriver);
    }


}
