package io.loop.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {

    /*
    Creating the private constructor, so this class's object is not reachable from outside
     */
    private Driver(){}

    /*
    making driver instance private
    static - run before everything else and use in static method
     */
    private static WebDriver driver;

    /*
    reusable method that will return the same driver instance every time called
     */
    /**
     * singletn pattern
     * @return
     */

    public static WebDriver getDriver(){
        ChromeOptions options = new ChromeOptions();

        if(driver==null){
            String browserType = ConfigurationReader.getProperties("browser");
            switch (browserType.toLowerCase()){
                case "chrome":
                    options.addArguments("--lang=en");
                    driver = new ChromeDriver(options);
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "safari":
                    driver = new SafariDriver();
                    break;
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }
        return driver;
    }

    /**
     * closing driver
     * @author Yuliia
     */

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
