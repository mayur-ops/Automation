package com.automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ScreenShotDemo {

    public static WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://letskodeit.teachable.com/p/practice");
        driver.manage().window().maximize();
    }

    @Test

    public void result() throws InterruptedException {
        WebElement bmwRadioButton = driver.findElement(By.id("bmwradio"));
        bmwRadioButton.click();
        Thread.sleep(2000);

        File sourcrfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destination = new File("/Users/mayurkumarpatel/Desktop/ScreenShot/radiobuttonclick.png");
        try {
            FileUtils.copyFile(sourcrfile,destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
