package com.automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CalenderExamples {
    public static WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.southalltravel.co.uk/");
        driver.manage().window().maximize();
        //driver.findElement(By.id("/html/body/div[1]/div/div[2]/div/div[3]/button")).click();
    }

    @Test
    public void southHallTravel(){
       WebElement calender = driver.findElement(By.id("depdateit"));
       calender.click();
       //driver.findElement(By.id("/html/body/div[1]/div/div[2]/div/div[3]/button")).click();
       List<WebElement> calenderdates = driver.findElements(By.cssSelector(".ui-state-default"));
       for(WebElement calenderdate: calenderdates){
           System.out.println(calenderdate.getText());
           if (calenderdate.getText().contains("17")){
               calenderdate.click();
               break;
           }
       }
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
