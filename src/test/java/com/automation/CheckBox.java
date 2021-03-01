package com.automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CheckBox {
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
    public void BMWCheckBox(){
        WebElement BMWCheckBox = driver.findElement(By.id("bmwcheck"));
        BMWCheckBox.click();
        System.out.println(BMWCheckBox.isSelected());
        Assert.assertTrue(BMWCheckBox.isSelected());
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
