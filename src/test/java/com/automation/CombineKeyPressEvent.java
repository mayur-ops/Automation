package com.automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CombineKeyPressEvent {
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
    public void combineKeyPress (){
        WebElement bmwradio = driver.findElement(By.id("bmwradio"));
        bmwradio.click();
        bmwradio.sendKeys(Keys.COMMAND + "a", Keys.COMMAND + "c");

        WebElement enteryournamebox = driver.findElement(By.id("name"));
        enteryournamebox.click();
        enteryournamebox.sendKeys(Keys.COMMAND + "v");
    }

}
