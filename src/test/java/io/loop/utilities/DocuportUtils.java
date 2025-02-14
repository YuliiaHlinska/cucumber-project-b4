package io.loop.test.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.print.Doc;
import java.time.Duration;

public class DocuportUtils {
    private static final Logger log = LoggerFactory.getLogger(DocuportUtils.class);

    /**
     * logins to docuport applications
     * @param driver, which is initialized in the test base
     * @param role, comes from docuport constance
     * author nsh
     */
    public static void login(WebDriver driver, String role) throws InterruptedException {
        driver.get(ConfigurationReader.getProperties("docuportBETA"));
        WebElement username = driver.findElement(By.xpath("//label[.='Username or email']//following-sibling::input"));
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));

        switch (role.toLowerCase()){
            case "client":
                username.sendKeys(DocuportConstance.USERNAME_CLIENT);
                password.sendKeys(DocuportConstance.PASSWORD_CLIENT);
                break;

            case "supervisor":
                username.sendKeys(DocuportConstance.USERNAME_SUPERVISOR);
                password.sendKeys(DocuportConstance.PASSWORD_CLIENT);
                break;

            case "advisor":
                username.sendKeys(DocuportConstance.USERNAME_ADVISOR);
                password.sendKeys(DocuportConstance.PASSWORD_CLIENT);
                break;

            case "employee":
                username.sendKeys(DocuportConstance.USERNAME_EMPLOYEE);
                password.sendKeys(DocuportConstance.PASSWORD_CLIENT);
                break;

            default: throw new InterruptedException("There is not such a role: " + role);

        }

        loginButton.click();
        if(role.toLowerCase().equals("client")){
            Thread.sleep(3000);
            WebElement con = driver.findElement(By.xpath("//button[@type='submit']"));
            con.click();
            Thread.sleep(3000);
        }

    }

    /**
     * logs out from docuport application
     * @param driver
     * @author nsh
     */
    public static void logOut(WebDriver driver){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement userIcon = driver.findElement(By.xpath("//div[@class='v-avatar primary']"));
        userIcon.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement logOut = driver.findElement(By.xpath("//span[contains(text(),'Log out')]"));
        logOut.click();
    }


}
