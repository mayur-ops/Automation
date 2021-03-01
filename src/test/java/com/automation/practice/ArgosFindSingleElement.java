package com.automation.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.Matchers;
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

public class ArgosFindSingleElement {

    public static WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.argos.co.uk/");
        driver.manage().window().maximize();
        driver.findElement(By.id("consent_prompt_submit")).click();
    }

    @Test
    public void argosBasketTest(){
       WebElement searchBox = driver.findElement(By.id("searchTerm"));
       searchBox.sendKeys("nike");
       searchBox.sendKeys(Keys.ENTER);
       String URL = driver.getCurrentUrl();
       System.out.println(URL);
       Assert.assertThat(URL, Matchers.endsWith("nike"));
       WebElement product = driver.findElement(By.linkText("Nike Premier League Pitch Size 5 Football - Blue and White"));
       product.click();
       WebElement addToTrolley = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div[1]/div[3]/div[1]/section[2]/section/div[15]/div/div[2]/button"));
       addToTrolley.click();
       WebElement goToTrolley = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div[1]/div[3]/div[1]/section[2]/section/div[13]/div/div/div[1]/footer/div/div[2]/a"));
       goToTrolley.click();
       String basketProduct = driver.findElement(By.xpath("//*[@id=\"basket-content\"]/main/div[2]/section[1]/div[1]/ul/li/div/section/div/div[2]/div[2]/div/div[1]/p/a/span")).getText();
       System.out.println(basketProduct);
       Assert.assertTrue(basketProduct.contains("Nike Premier League Pitch Size 5 Football - Blue and White"));
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
