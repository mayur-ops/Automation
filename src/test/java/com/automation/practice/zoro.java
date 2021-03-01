package com.automation.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class zoro {
    public static WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.zoro.co.uk/");
        driver.manage().window().maximize();
    }
    @Test
    public void registration(){
       WebElement signInButton = driver.findElement(By.id("HeaderMenu.showLoginDialogButton"));
       signInButton.click();
       WebElement createAccount = driver.findElement(By.xpath("//button[contains(text(),'Create account')]"));
       createAccount.click();
       WebElement registerEmail = driver.findElement(By.xpath("//input[@id='register_email']"));
       registerEmail.sendKeys("mkp802002@gmail.com");
       WebElement password = driver.findElement(By.cssSelector(".ReactPasswordStrength-input.form-control.password"));
       password.sendKeys("shreeram");
       WebElement confirmPassword = driver.findElement(By.xpath("//input[@id='confirmPassword']"));
       confirmPassword.sendKeys("shreeram");
       driver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();
        WebElement title = driver.findElement(By.cssSelector("select[name=\"title\"]"));
        title.click();
        Select sel = new Select(title);
        sel.selectByValue("Mr");
        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys("Mayurkumar");
        WebElement lastName =  driver.findElement(By.id("lastName"));
        lastName.sendKeys("Patel");
        WebElement phoneNumber = driver.findElement(By.id("phoneNumber"));
        phoneNumber.sendKeys("07311795657");
        WebElement companyName = driver.findElement(By.id("companyName"));
        companyName.sendKeys("N/A");
        WebElement checkBox = driver.findElement(By.cssSelector("input[name=\"marketingConsent\"]"));
        checkBox.isSelected();
        driver.findElement(By.cssSelector(".formButtons_button-primary__1Y09V.formButtons_modal-register-button__S_C6F")).click();
    }

    @Test
    public void logIn(){
        WebElement signInButton = driver.findElement(By.id("HeaderMenu.showLoginDialogButton"));
        signInButton.click();
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("mkp802002@gmail.com");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("shreeram");
        WebElement signIn = driver.findElement(By.xpath("//button[contains(text(),'Sign in')]"));
        signIn.click();
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertEquals(currentUrl,"https://www.zoro.co.uk/");

    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
