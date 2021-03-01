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

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Travelodge {

    public static WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.travelodge.co.uk/");
        driver.manage().window().maximize();
    }

    @Test
    public void logIn(){
        WebElement logInButton = driver.findElement(By.id("triggerLoginPopOver"));
        logInButton.click();
        WebElement enterEmail = driver.findElement(By.id("authentication_email"));
        enterEmail.sendKeys("mayurpatel_802002@yahoo.com");
        WebElement password = driver.findElement(By.id("authentication_password"));
        password.sendKeys("25Vinus19");
        WebElement logIn = driver.findElement(By.xpath("//*[@id=\"login-modal-popup\"]/div[2]/form/div[8]/button"));
        logIn.click();
    }

    @Test
    public void dropDownList(){
        WebElement destination = driver.findElement(By.xpath("//*[@id=\"main\"]/form/div[1]/fieldset/div[1]/div/span/input"));
        destination.sendKeys("lon");
        List<WebElement> areas = driver.findElements(By.cssSelector(".tt-suggestion.tt-selectable"));
        for (WebElement area: areas){
            System.out.println(area.getText());
            if (area.getText().contains("East London")){
              area.click();
              String selectedDestination = driver.findElement(By.xpath("//body/div[2]/div[3]/form[1]/div[1]/fieldset[1]/div[1]/div[1]/span[1]/input[1]")).getAttribute("name");
                Assert.assertEquals(selectedDestination,"location");
              break;
            }
        }
    }

    @Test
    public void calender() throws InterruptedException {
//        WebElement destination = driver.findElement(By.xpath("//*[@id=\"main\"]/form/div[1]/fieldset/div[1]/div/span/input"));
//        destination.sendKeys("East London");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"optInText\"]")).click();
        WebElement checkIn = driver.findElement(By.cssSelector(".input-group.non-mob"));
        checkIn.isEnabled();
//        List<WebElement> checkInDates = driver.findElements(By.cssSelector(".ui-state-default"));
//        for (WebElement date: checkInDates){
//            System.out.println(date.getText());
        }
    //}

    //@After
    public void tearDown(){
        driver.quit();
    }
}
