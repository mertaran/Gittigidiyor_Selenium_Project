package com.gittigidiyor.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class aramaSonuc extends BasePage{

    public aramaSonuc(WebDriver webDriver) {
        super(webDriver);
    }

    public By randomSelectProductBy()
        {
        Random random = new Random();
        int randm = random.nextInt(5) + 1;
       return By.xpath("(//*[@data-testid='productImage'])[" + randm + "]");

    }


    public void choosePage(String pageNumber) {
        webDriver.get(webDriver.getCurrentUrl() + "&sf=" + pageNumber);
    }

    public urunDetay goToProductDetails(){
        click (randomSelectProductBy(),10);
        return new urunDetay(webDriver);
    }


}
