package io.loop.pages;

import io.loop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage {

    public GoogleSearchPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//textarea[@id='searchbox']")
    public WebElement searchbox;

    @FindBy(xpath = "//button[@id='submit-button']")
    public WebElement searchbutton;

    @FindBy(xpath = "//div[@class='recaptcha-checkbox-border']" )
    public WebElement captcha;




}
