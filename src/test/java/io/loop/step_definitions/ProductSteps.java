package io.loop.step_definitions;

import io.cucumber.java.en.*;
import io.loop.pages.POM;
import io.loop.utilities.ConfigurationReader;
import io.loop.utilities.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ProductSteps {

    POM pages = new POM();
    private static final Logger LOG = LogManager.getLogger();

    @Given("user is on the Homepage")
    public void user_is_on_the_homepage() {

        Driver.getDriver().get(ConfigurationReader.getProperties("product.url"));
        LOG.info("User is on HomePage");


    }
    @Then("user should be able to see expected prices in the following prices")
    public void user_should_be_able_to_see_expected_prices_in_the_following_prices(List<Map<String,String>> productDetails) throws InterruptedException {


        for (Map<String, String> productDetail : productDetails) {
//            System.out.println("***Product details***");
//            System.out.println("productDetail.get(\"Category\") = " + productDetail.get("Category"));
//            System.out.println("productDetail.get(\"Product\") = " + productDetail.get("Product"));
//            System.out.println("productDetail.get(\"expectedPrice\") = " + productDetail.get("expectedPrice"));


            //click the category
            pages.getProductPage().clickCategory(productDetail.get("Category"));
            //Thread.sleep(15000);

            //get actual price
            String actualPrice = pages.getProductPage().getProductPrice(productDetail.get("Product"));

            //get product price fom my data table
            String expectedPrice = productDetail.get("expectedPrice");

            //assertions
            assertEquals("Expected does not match of actual", expectedPrice, actualPrice);

            LOG.info("Validation of price for :" + productDetail.get("Category") + ", for Product: "+ productDetail.get("Product") + "expected" + expectedPrice+ "actual" + actualPrice);

        }
    }

    @Then("user should be able to see expected prices in the following products with ListOfLists")
    public void user_should_be_able_to_see_expected_prices_in_the_following_products_with_list_of_lists(List<List<String>> productDetails) {

        for (List<String> productDetail : productDetails) {
            //get category
            pages.getProductPage().clickCategory(productDetail.get(0));

            //get actual price for each product
            String actualPrice = pages.getProductPage().getProductPrice(productDetail.get(1));

            //get expected price
            String expectedPrice = productDetail.get(2);

            //assertion
            assertEquals("Expected does not match actual", expectedPrice, actualPrice);
            LOG.info("Validation of the price for:" + productDetail.get(0) + ", for Product:" +productDetail.get(1) + "expected price " + expectedPrice + "actual price "+ actualPrice);
        }
    }

    @Then("user should be able to see the following names in their groups")
    public void user_should_be_able_to_see_the_following_names_in_their_groups(Map<String, List<String>> students) {

        List<String> group2 = students.get("Group 2");
        System.out.println("Group2 = " + group2);

        List<String> group1 = students.get("Group 1");
        System.out.println("Group1 = " + group1);




    }




}
