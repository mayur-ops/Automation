package com.automation.Practice2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Asda {
    public static WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.asda.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void searchBox(){
       WebElement searchBox = driver.findElement(By.xpath("//header/div[1]/form[1]/input[1]"));
       searchBox.sendKeys("milk");
       searchBox.sendKeys(Keys.ENTER);
       String currentUrl = driver.getCurrentUrl();
       System.out.println(currentUrl);
       Assert.assertEquals(currentUrl,"https://groceries.asda.com/search/milk?cmpid=ahc-_-ghs-_-asdacom-_-hp-_-search-milk");
    }

    @Test
    public void categoryDropDown(){
        WebElement searchBox = driver.findElement(By.xpath("//header/div[1]/form[1]/input[1]"));
        searchBox.sendKeys("milk");
        searchBox.sendKeys(Keys.ENTER);
        WebElement categories = driver.findElement(By.xpath("//body/div[@id='root']/div[2]/section[1]/main[1]/div[1]/div[4]/div[1]/div[1]/div[2]/select[1]"));
        Select sel = new Select(categories);

        sel.selectByIndex(1);

          List<WebElement> options = sel.getAllSelectedOptions();
        //List<WebElement> options = sel.getOptions();
        for (WebElement option: options){
            System.out.println(option.getText());
            if (option.getText().contains("Food Cupboard (328)")){
                option.click();
                String selectedItem = driver.findElement(By.xpath("//*[@id=\"main-content\"]/main/div[1]/div[4]/div/div[1]/div[2]/select")).getAttribute("value");
                Assert.assertEquals(selectedItem,"super_dept_name:Food Cupboard");
                break;
            }
        }
    }

    @Test


   @After
    public void tearDown(){
        driver.quit();
    }
}
