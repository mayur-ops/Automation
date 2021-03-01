package com.automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class KeyPressEvent {

    public static WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://letskodeit.teachable.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void keyPress(){
        WebElement loginButton = driver.findElement(By.linkText("Login"));
        loginButton.click();

        WebElement username = driver.findElement(By.id("user_email"));
        username.sendKeys("ketan@gmail.com");
        username.sendKeys(Keys.TAB);

        WebElement password = driver.findElement(By.id("user_password"));
        password.sendKeys("123456");
        password.sendKeys(Keys.ENTER);
    }
}
