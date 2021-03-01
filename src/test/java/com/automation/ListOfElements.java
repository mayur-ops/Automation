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


public class ListOfElements {

    public static WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://letskodeit.teachable.com/p/practice");
        driver.manage().window().maximize();
    }

    @Test
    public void LetsKotItRadioButton() {

        List<WebElement> radiobuttons = driver.findElements(By.cssSelector("input[type=radio]"));
        for (WebElement radiobutton : radiobuttons) {
            System.out.println(radiobutton.getAttribute("value"));
            if (radiobutton.getAttribute("value").contains("honda")) {
                radiobutton.click();
                break;
            }
        }
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}