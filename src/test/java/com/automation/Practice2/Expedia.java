package com.automation.Practice2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Expedia {

    public static WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.expedia.co.uk/");
        driver.manage().window().maximize();
        //driver.findElement(By.cssSelector(".uitk-button.uitk-button-small.uitk-button-fullWidth.uitk-button-has-text.uitk-button-primary.uitk-gdpr-banner-btn")).click();

    }
    @Test

    public void autoDropDownDemo() throws InterruptedException {
       WebElement flight = driver.findElement(By.xpath("//*[@id=\"uitk-tabs-button-container\"]/li[2]/a"));
       flight.click();

       WebElement flightFrom = driver.findElement(By.xpath("//body/div[@id='app']/div[@id='app-layer-manager']/div[@id='app-layer-base']/div[1]/div[1]/div[1]/div[3]/div[1]/figure[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/button[1]"));
       flightFrom.sendKeys("Lon");

       List<WebElement> autoDrops = driver.findElements(By.cssSelector(".truncate"));
       for (WebElement autoDrop: autoDrops){
           System.out.println(autoDrop.getText());
           if (autoDrop.getText().contains("London (STN - Stansted)")){
               autoDrop.click();
               break;
           }
           }
       }

    @After
    public void tearDown(){
        driver.quit();
    }

    }

