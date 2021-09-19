package com.gittigidiyor.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class urunDetay extends BasePage{
    private By lowProductPriceBy  = By.id("sp-price-lowPrice");
    private By highProductPriceBy = By.id("sp-price-highPrice");
    private By addToBasketButtonBy = By.id("add-to-basket");
    private By goToBasketButtonBy = By.xpath("//a[@href='https://www.gittigidiyor.com/sepetim']");
    public urunDetay(WebDriver webDriver) {
        super(webDriver);
    }


    public String productPrice(){
        String productPrice = webDriver.findElement(lowProductPriceBy).getText();
        if (productPrice.isEmpty()) {
            return getText(highProductPriceBy);
        }
        return getText(lowProductPriceBy);
    }

    public void addToBasket(){
        click(addToBasketButtonBy,50);
    }
    public sepetimSayfası goToBasket(){
        click(goToBasketButtonBy,10);
        return new sepetimSayfası(webDriver);
    }
}
