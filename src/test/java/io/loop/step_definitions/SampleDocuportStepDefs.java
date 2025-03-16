package io.loop.step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.loop.pages.*;
import io.loop.utilities.BrowserUtils;
import io.loop.utilities.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.awt.*;

public class SampleDocuportStepDefs {

    LoginPage loginPage = new LoginPage();
    LeftNavigatePage leftNavigatePage = new LeftNavigatePage();
    ReceivedDocsPage receivedDocsPage = new ReceivedDocsPage();
    MyUploadsPage myUploadsPage = new MyUploadsPage();


    private static final Logger LOG = LogManager.getLogger();


    @When("user inserts {string} to {string} field on {string} page")
    public void user_inserts_to_field_on_page(String input, String field, String page) {

        switch (page.toLowerCase().trim()){
            case "login":
                loginPage.insertField(field, input);
                LOG.info(input + " - was successfully sent to -  " + field);
                break;
            case "received doc":
                receivedDocsPage.insertField(field, input);
                LOG.info(input + " - was successfully sent to -  " + field);
                break;
            default:
                throw new IllegalArgumentException("not such a page: " + page);
        }

    }
    @When("user clicks {string} button on {string} page")
    public void user_clicks_button_on_page(String button, String page) {

        switch (page.toLowerCase().trim()){
            case "login":
            case "choose account":
                loginPage.clickButton(button);
                LOG.info(button + " was successfully clicked");
                break;
            case "left navigate":
                leftNavigatePage.clickButton(button);
                LOG.info(button + " - was successfully clicked");
                break;
            case "received doc":
                receivedDocsPage.clickButton(button);
                LOG.info(button + " - was successfully clicked");
                break;
            case "my uploads":
                myUploadsPage.clickButton(button);
                LOG.info(button+ " - was successfully clicked");
                break;
            default: throw new IllegalArgumentException("not such a page: " + page);
        }

    }

    @Then("user should be able to see {string}")
    public void user_should_be_able_to_see(String string) {


    }

    @Then("user uploads document")
    public void user_uploads_document() throws AWTException {

//        WebElement element = Driver.getDriver().findElement(By.xpath("//input[@type='file']"));
//        element.sendKeys("C:/Users/admin/Desktop/forUploads.txt");

       BrowserUtils.uploadFile("\"C:\\Users\\admin\\Desktop\\forUploads.txt\"");

    }

}