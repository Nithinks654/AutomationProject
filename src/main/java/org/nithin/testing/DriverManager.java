package org.nithin.testing;


import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.Collections;

public class DriverManager  {
//    private static WebDriver driver;

    public static WebDriver driver;


    public DriverManager(WebDriver driver) {
        this.driver = driver;
    }


    @Before
    public static WebDriver getDriver() {
        if ((driver == null)) {
            System.setProperty("webdriver.chrome.driver", "C:/Java/chromedriver/chromedriver.exe");

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--incognito");
            options.addArguments("--disable-blink-features=AutomationControlled");
            options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
            options.setExperimentalOption("useAutomationExtension", false);
            options.addArguments("disable-infobars");
            options.addArguments("--enable-web-rtc");
            options.addArguments("--disable-extensions");
            options.addArguments("--disable-password-manager-reauthentication");
            options.addArguments("--ignore-gpu-blacklist");
            options.addArguments("--disable-software-rasterizer");
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--disable-popup-blocking");
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        }
        return driver;
    }

    @After
    public static void quitDriver() {
        driver.quit();
        driver = null;
    }

    public static WebDriver getWebDriver() {
        return driver;
    }
}
