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
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CheckBoxButton {
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
    public void BenzCheckBox(){
        WebElement BenzCheckBoxClick = driver.findElement(By.id("benzcheck"));
        BenzCheckBoxClick.click();
        System.out.println(BenzCheckBoxClick.isSelected());
        Assert.assertTrue(BenzCheckBoxClick.isSelected());
    }
    @Test
    public void HondaCheckBox(){
        WebElement HondaCheckBoxButton = driver.findElement(By.id("hondacheck"));
        HondaCheckBoxButton.click();
        System.out.println(HondaCheckBoxButton.isSelected());
        Assert.assertTrue(HondaCheckBoxButton.isSelected());
    }

    @Test
    public void BenzRadioButton(){
       WebElement BenzRadioButtonClick = driver.findElement(By.id("benzradio"));
       BenzRadioButtonClick.click();
       System.out.println(BenzRadioButtonClick.isSelected());
       Assert.assertTrue(BenzRadioButtonClick.isSelected());
    }

    @Test
    public void HondaRadioButton(){
       WebElement HondaRadioButtonClick = driver.findElement(By.id("hondaradio"));
       HondaRadioButtonClick.click();
       System.out.println(HondaRadioButtonClick.isSelected());
       Assert.assertTrue(HondaRadioButtonClick.isSelected());
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}

