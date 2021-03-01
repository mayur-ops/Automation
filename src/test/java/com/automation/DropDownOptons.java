package com.automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDownOptons {
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
    public void dropDownDemo(){
        WebElement dropDownOption = driver.findElement(By.id("carselect"));
        Select sel = new Select(dropDownOption);

        sel.selectByIndex(0);
        sel.selectByValue("benz");
        sel.selectByVisibleText("Honda");

        //List<WebElement> options = sel.getAllSelectedOptions();
        List<WebElement> options = sel.getOptions();
        for(WebElement option: options){
            System.out.println(option.getText());
        }
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}

