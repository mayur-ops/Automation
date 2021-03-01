package com.automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AutoCompletDropDown {
    public static WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.argos.co.uk/");
        driver.manage().window().maximize();
        driver.findElement(By.id("consent_prompt_submit")).click();
    }

    @Test
    public void autoComplete(){
       WebElement searchBox = driver.findElement(By.id("searchTerm"));
       searchBox.sendKeys("nike");

       List<WebElement> autoResults = driver.findElements(By.cssSelector("._3a8zN"));
       for (WebElement result: autoResults){
           System.out.println(result.getText());
            if (result.getText().contains("apple watch nike")){
                result.click();
                String resultSearchBox = driver.findElement(By.id("searchTerm")).getAttribute("value");
                Assert.assertEquals(resultSearchBox,"apple watch nike");
                break;
            }
       }
    }
}
