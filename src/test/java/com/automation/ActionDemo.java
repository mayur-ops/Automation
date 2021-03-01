package com.automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class ActionDemo {

    public static WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://letskodeit.teachable.com/p/practice");
        driver.manage().window().maximize();
    }

    @Test
    public void action() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000);");
        Thread.sleep(2000);
        WebElement mouseHover = driver.findElement(By.id("mousehover"));

        Actions action = new Actions(driver);
        action.moveToElement(mouseHover).perform();
        Thread.sleep(2000);
        WebElement subElement = driver.findElement(By.linkText("Top"));
        action.moveToElement(subElement).click().perform();
    }

}
