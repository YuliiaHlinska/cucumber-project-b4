package io.loop.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Driver {

    /*
    Creating the private constructor, so this class's object is not reachable from outside
     */
    private Driver(){}

    /*
    making driver instance private
    static - run before everything else and use in static method
     */

    //private static WebDriver driver;
    //implement threadLocal to achieve multi thread locally
    private static InheritableThreadLocal <WebDriver> driverPool = new InheritableThreadLocal<>();



    /*
    reusable method that will return the same driver instance every time called
     */
    /**
     * singletn pattern
     * @return
     */

    public static WebDriver getDriver(){
        ChromeOptions options = new ChromeOptions();

        if(driverPool.get()==null){
            String browserType = ConfigurationReader.getProperties("browser");
            switch (browserType.toLowerCase()){
                case "chrome":
                    options.addArguments("--lang=en");
                    driverPool.set(new ChromeDriver(options));
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.valueOf(ConfigurationReader.getProperties("timeouts"))));
                    break;
                case "firefox":
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.valueOf(ConfigurationReader.getProperties("timeouts"))));
                    break;
                case "safari":
                    driverPool.set(new SafariDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.valueOf(ConfigurationReader.getProperties("timeouts"))));
                    break;
                case"headless":
                    options.addArguments("--headless");
                    driverPool.set(new ChromeDriver(options));
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.valueOf(ConfigurationReader.getProperties("timeouts"))));
                    break;


            }
        }
        return driverPool.get();
    }

    /**
     * closing driver
     * @author Yuliia
     */

    public static void closeDriver() {
        if (driverPool.get() != null) {
            driverPool.get().quit();
            //driver = null;
            driverPool.remove();
        }
    }
}
