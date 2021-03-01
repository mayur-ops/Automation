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

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class Argos {
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
    public void argosCheckBox(){
       WebElement searchBox = driver.findElement(By.id("searchTerm"));
       searchBox.sendKeys("nike");
       searchBox.sendKeys(Keys.ENTER);
       WebElement checkBox = driver.findElement(By.xpath("//*[@id=\"filter-price-£20 - £25-label\"]/div/div"));
       checkBox.click();
       System.out.println(checkBox.isEnabled());
       Assert.assertTrue(checkBox.isEnabled());
    }
    @Test
    public void argosRadioButton(){
        WebElement searchBox = driver.findElement(By.id("searchTerm"));
        searchBox.sendKeys("nike");
        searchBox.sendKeys(Keys.ENTER);
        WebElement radioButton = driver.findElement(By.xpath("//*[@id=\"4 or more-label\"]/div/div/div"));
        radioButton.click();
        System.out.println(radioButton.isEnabled());
        Assert.assertTrue(radioButton.isEnabled());
    }
    @Test
    public void argosAccount(){
       WebElement account = driver.findElement(By.xpath("//*[@id=\"haas-v2\"]/div[2]/div/div[4]/a[2]"));
       account.click();
       String accountTitle = driver.getTitle();
       System.out.println(accountTitle);
       Assert.assertThat(accountTitle,Matchers.containsString("Sign in | Argos"));
    }

    @Test
    public void argosWishlist(){
       WebElement wishList = driver.findElement(By.xpath("//*[@id=\"haas-v2\"]/div[2]/div/div[4]/a[3]"));
       wishList.click();
       String wishlistTitle =  driver.getTitle();
       System.out.println(wishlistTitle);
       Assert.assertThat(wishlistTitle,Matchers.containsString("Argos - Wishlist"));
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}

