package com.automation.Practice2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LetsKodeIt {
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
    public void multiSelect(){
        WebElement multiSelect =  driver.findElement(By.id("multiple-select-example"));
        Select sel = new Select(multiSelect);

        sel.selectByValue("orange");
        sel.selectByVisibleText("Peach");
        sel.selectByIndex(0);

        List<WebElement> options = sel.getAllSelectedOptions();
        //List<WebElement> options = sel.getOptions();
        for(WebElement option: options){
            System.out.println(option.getText());
            if (option.getText().contains("Apple")){
                option.click();
               String selectedItem = driver.findElement(By.xpath("//*[@id=\"multiple-select-example\"]/option[1]")).getAttribute("value");
               Assert.assertEquals(selectedItem,"apple");
                break;
            }
        }
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
