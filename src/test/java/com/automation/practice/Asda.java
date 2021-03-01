package com.automation.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Asda {
    public static  WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.asda.com/");
        driver.manage().window().maximize();
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
    }

    @Test
    public void asdaSearch(){
       WebElement searchButton = driver.findElement(By.xpath("//header/div[1]/form[1]/input[1]"));
       searchButton.sendKeys("milk");
       searchButton.sendKeys(Keys.ENTER);
       String URL = driver.getCurrentUrl();
       System.out.println(URL);
       Assert.assertEquals(URL,"https://groceries.asda.com/search/milk?cmpid=ahc-_-ghs-_-asdacom-_-hp-_-search-milk");

       String title = driver.getTitle();
       System.out.println(title);
       Assert.assertTrue(title.equalsIgnoreCase("Online Food Shopping | Grocery Delivery | ASDA Groceries"));
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
