package com.automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.DriverManager;
import java.util.concurrent.TimeUnit;

public class BrowserInvoked {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.argos.co.uk/");
        driver.manage().window().maximize();
        driver.findElement(By.id("consent_prompt_submit")).click();
        driver.quit();
    }
}

class FindElement{
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        driver.get("https://www.argos.co.uk/");
        driver.manage().window().maximize();
        driver.findElement(By.id("consent_prompt_submit")).click();
        WebElement searchTerm=driver.findElement(By.id("searchTerm"));
        searchTerm.sendKeys("nike");
        searchTerm.sendKeys(Keys.ENTER);
        WebElement nikeWord = driver.findElement(By.xpath("//h1[contains(text(),'nike')]"));
        String actual = nikeWord.getText();
        Assert.assertEquals(actual,"nike");
        String actualNikeURL= driver.getCurrentUrl();
        Assert.assertThat(actualNikeURL,Matchers.containsString("nike"));
    }
}
class FindElementByText{
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        driver.get("https://www.argos.co.uk/");
        driver.manage().window().maximize();
        driver.findElement(By.id("consent_prompt_submit")).click();
        String URL= driver.getCurrentUrl();
        System.out.println(URL);
        //Assert.assertEquals(URL,"https://www.argos.co.uk/");
        Assert.assertThat(URL, CoreMatchers.containsString("https://www.argos.co.uk/"));
        Assert.assertThat(URL, Matchers.equalToIgnoringCase("https://www.argos.co.uk/"));
        Assert.assertThat(URL,Matchers.endsWith("https://www.argos.co.uk/"));
        String Title = driver.getTitle();
        System.out.println(Title);
        WebElement AccountButton = driver.findElement(By.linkText("Account"));
        AccountButton.click();
        driver.quit();
    }
}

