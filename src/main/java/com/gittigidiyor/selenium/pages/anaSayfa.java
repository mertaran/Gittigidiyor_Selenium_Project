package com.gittigidiyor.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class anaSayfa extends BasePage{
    By mainBy = By.className("f2lc5a-0");
    By closeCookiesButtonBy = By.cssSelector("#__next > main > div:nth-child(2) > section.tyj39b-0.iqtPYy > section.tyj39b-4.jZoSqD > a");

    public anaSayfa(WebDriver webDriver) {
        super(webDriver);
    }

    public String getHomePageTitle(){
        return webDriver.getTitle();
    }

    public void waitForLoad() {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(mainBy));
    }

    public void closeCookiesPopUp(){
        click(closeCookiesButtonBy,10);
    }
}
