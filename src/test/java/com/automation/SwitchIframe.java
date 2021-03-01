package com.automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SwitchIframe {
    public static WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://letskodeit.teachable.com/p/practice");
        driver.manage().window().maximize();
    }

    @Test
    public void iFrame() throws InterruptedException {
        Thread.sleep(2000);
        driver.switchTo().frame("courses-iframe");
        //driver.switchTo().frame(0);

        WebElement searchCourse = driver.findElement(By.id("search-courses"));
        searchCourse.sendKeys("java");

        Thread.sleep(2000);

        driver.switchTo().defaultContent();
        WebElement hondaradio = driver.findElement(By.id("hondaradio"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",hondaradio);

        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0,-190);");
        hondaradio.click();
    }
}
