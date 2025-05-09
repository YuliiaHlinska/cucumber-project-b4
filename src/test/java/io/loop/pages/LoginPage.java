package io.loop.pages;

import io.loop.utilities.BrowserUtils;
import io.loop.utilities.ConfigurationReader;
import io.loop.utilities.DocuportConstance;
import io.loop.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@type='text']")
    public WebElement usernameInput;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    @FindBy (xpath = "//span[.=' Continue ']")
    public WebElement continueButton;


    public void insertField(String field, String input){
        switch (field.toLowerCase().trim()){
            case "username":
                BrowserUtils.waitForVisibility(usernameInput, 10).sendKeys(input);
                break;
            case "password":
                BrowserUtils.waitForVisibility(passwordInput, 10).sendKeys(input);
                break;
            default: throw new IllegalArgumentException("No such a field:" + field);
        }

    }


    public void clickButton (String button){
        switch (button.toLowerCase().trim()){
            case "login":
                BrowserUtils.waitForClickable(loginButton, 10).click();
                break;
            case "continue":
                BrowserUtils.waitForClickable(continueButton, 10).click();
                break;
            default:
                throw new IllegalArgumentException("Not such button" + button);
        }
    }



    /**
     *logins to docuport application
     * @param driver, which is initialized in the test base
     * @param role, comes from docuport constants
     * author Yuliia
     */
    public void login(WebDriver driver, String role) throws InterruptedException {
        switch (role.toLowerCase()){
            case "client":
                usernameInput.sendKeys(DocuportConstance.USERNAME_CLIENT);
                passwordInput.sendKeys(DocuportConstance.PASSWORD_CLIENT);
                break;
            case "supervisor":
                usernameInput.sendKeys(DocuportConstance.USERNAME_SUPERVISOR);
                passwordInput.sendKeys(DocuportConstance.PASSWORD_CLIENT);
                break;
            case "advisor":
                usernameInput.sendKeys(DocuportConstance.USERNAME_ADVISOR);
                passwordInput.sendKeys(DocuportConstance.PASSWORD_CLIENT);
                break;
            case "employee":
                usernameInput.sendKeys(DocuportConstance.USERNAME_EMPLOYEE);
                passwordInput.sendKeys(DocuportConstance.PASSWORD_CLIENT);
                break;
            default: throw new InterruptedException("There is not such a role: " + role);
        }

        loginButton.click();

        if(role.toLowerCase().equals("client")){
            Thread.sleep(3000);
            WebElement cont = driver.findElement(By.xpath("//button[@type='submit']"));
            cont.click();
            Thread.sleep(3000);
        }
    }

    public void login2(String username, String password){
        BrowserUtils.waitForClickable(loginButton, 10);
        usernameInput.clear();
        usernameInput.sendKeys(username);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        loginButton.click();
        if (BrowserUtils.waitForVisibility(continueButton, 10).isDisplayed()); {
            continueButton.click();
        }
    }

}

