package io.loop.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.loop.pages.GoogleSearchPage;
import io.loop.pages.POM;
import io.loop.utilities.BrowserUtils;
import io.loop.utilities.ConfigurationReader;
import io.loop.utilities.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;


import static org.junit.Assert.assertEquals;

public class GoogleSearchStepDefs {


    GoogleSearchPage googleSearchPage = new GoogleSearchPage();

    POM pages = new POM();

    @Given("user is on Google page")
    public void user_is_on_google_page() {
        Driver.getDriver().get(ConfigurationReader.getProperties("google.url"));
        BrowserUtils.takeScreenshot();

    }
    @When("user types Loop Academy in the google search box and click here")
    public void user_types_loop_academy_in_the_google_search_box_and_click_here() throws InterruptedException {
        googleSearchPage.searchbox.sendKeys("Loop Academy" + Keys.ENTER);

       Thread.sleep(10);


    }
    @Then("user should be see Loop Academy in the google title")
    public void user_should_be_see_loop_academy_in_the_google_title() {
        String actualTitle = Driver.getDriver().getTitle();
        assertEquals("Expected result does not match actual", "Loop Academy - Google Search", actualTitle);

    }


    @When("user types {string} in the google search box and clicks enter")
    public void user_types_in_the_google_search_box_and_clicks_enter(String input) throws InterruptedException {
        googleSearchPage.searchbox.sendKeys(input + Keys.ENTER);
    }

    @Then("user should see {string} in the google title")
    public void user_should_see_in_the_google_title(String expectedTitle) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(Integer.valueOf(ConfigurationReader.getProperties("timeouts"))));
        wait.until(ExpectedConditions.titleIs(expectedTitle));
        String actualTitle = Driver.getDriver().getTitle();
        assertEquals("Expected result does not match the actual", expectedTitle, actualTitle);
    }

    @Then("user searches the following items")
    public void user_searches_the_following_items(List <String > items) {

        items.forEach(p-> {
            googleSearchPage.searchbox.clear();
            googleSearchPage.searchbox.sendKeys(p + Keys.ENTER);
            googleSearchPage.handleCaptcha(Driver.getDriver(), googleSearchPage.captcha);
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(Integer.valueOf(ConfigurationReader.getProperties("timeouts"))));
            wait.until(ExpectedConditions.titleIs(p + " - Google Search"));
            assertEquals("Expected does not match the actual",p + " - Google Search",Driver.getDriver().getTitle());
        });
    }

        @Then("we love Loop Academy")
        public void we_love_loop_academy() {
            System.out.println("We love Loop Academy");
        }

    @When("user search for {string}")
    public void user_search_for(String country) {
        googleSearchPage.searchbox.sendKeys("What is the capital of the " + country + Keys.ENTER);

    }
    @Then("user should see the {string} in the results")
    public void user_should_see_the_in_the_results(String capital) {
        googleSearchPage.handleCaptcha(Driver.getDriver(), googleSearchPage.captcha);
        assertEquals("Expected capital city: " + capital + "does not match actual one: " + googleSearchPage.capital.getText(), capital, googleSearchPage.capital.getText());

    }
    }



