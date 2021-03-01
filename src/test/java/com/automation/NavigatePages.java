package com.automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class NavigatePages {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://letskodeit.teachable.com/");
        driver.manage().window().maximize();
        String currentURL= driver.getCurrentUrl();
        System.out.println(currentURL);
        driver.navigate().to("https://sso.teachable.com/secure/42299/users/sign_in?clean_login=true&reset_purchase_session=1");
        String NavigatedURL = driver.getCurrentUrl();
        System.out.println(NavigatedURL);
        driver.navigate().back();
        driver.navigate().forward();
    }
}
class LetsKodeItLogin{
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://letskodeit.teachable.com/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
        WebElement emailAddress = driver.findElement(By.id("user_email"));
        emailAddress.sendKeys("test12@gmail.com");

        WebElement password = driver.findElement(By.id("user_password"));
        password.sendKeys("test123");

        driver.findElement(By.xpath("//*[@id=\"new_user\"]/div[3]/input")).click();

        //driver.findElement(By.xpath("//*[@id=\"checkbox\"]")).click();

        WebElement message = driver.findElement(By.xpath("//div[contains(text(),'Invalid email or password.')]"));
        String failmessage = message.getText();
        System.out.println(failmessage);
        //Assert.assertThat(failmessage,"");
    }
}