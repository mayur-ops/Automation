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

public class ArgosStarRatingRadioButton {
    public static WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.argos.co.uk/search/nike/?clickOrigin=searchbar:search:term:nike");
        driver.manage().window().maximize();
        driver.findElement(By.id("consent_prompt_submit")).click();
    }

    @Test
    public void argosRadioButton(){

       List<WebElement> radiobuttons = driver.findElements(By.cssSelector(".RadioListstyles__Label-sc-1atiffa-5.iGLFTd"));
       for(WebElement radiobutton: radiobuttons){
           System.out.println(radiobutton.getAttribute("id"));
           if (radiobutton.getAttribute("id").contains("4 or more-label")){
               radiobutton.click();
               break;
           }
       }
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
