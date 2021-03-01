package com.automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ImplicitlyWaitDemo {

    public static WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://letskodeit.teachable.com/");
        driver.manage().window().maximize();
    }

    @Test

    public void implicit(){
       WebElement loginbutton =  driver.findElement(By.linkText("Login"));

       System.out.println(loginbutton.isEnabled());
       loginbutton.click();

       WebElement userName = driver.findElement(By.id("user_email"));
       userName.sendKeys("test@test.com");

    }

    @Test

    public void explicit(){
        WebElement loginbutton =  driver.findElement(By.linkText("Login"));
        loginbutton.click();

        WebDriverWait wait = new WebDriverWait(driver,3);
        WebElement userName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_email")));
        userName.sendKeys("test@test.com");
    }

}
