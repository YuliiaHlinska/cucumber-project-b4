package io.loop.pages;

import io.loop.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {

    public ProductPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public void clickCategory(String category) {

        Driver.getDriver().findElement(By.xpath("//a[contains(.,'"+category+"')]")).click();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    public String getProductPrice(String product){
        try {
            String actualPrice = Driver.getDriver().findElement(By.xpath("//a[normalize-space(.)='" + product + "']/../../h5")).getText();
            return actualPrice.substring(1);
        }catch (StaleElementReferenceException s){
            String actualPrice = Driver.getDriver().findElement(By.xpath("//a[normalize-space(.)='" + product + "']/../../h5")).getText();
            return actualPrice.substring(1);
        }


    }


}
