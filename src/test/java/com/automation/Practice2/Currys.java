package com.automation.Practice2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Currys {
    public static WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.currys.co.uk/gbuk/index.html");
        driver.manage().window().maximize();
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
    }

    @Test
    public void currysDemo(){
      WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/form/div/div/input"));
      searchBox.sendKeys("tv");
      searchBox.sendKeys(Keys.ENTER);

        List<WebElement> tvs = driver.findElements(By.cssSelector(".dc-checkbox-wrapper"));
        for (WebElement tv: tvs){
            System.out.println(tv.getText());
            if (tv.getText().contains("£699.00 - £1,000.00")){
                tv.click();
                break;
            }
        }
    }

    @Test
    public void navigateURL(){
       String URL = driver.getCurrentUrl();
        System.out.println(URL);
        driver.navigate().to("https://www.currys.co.uk/gbuk/tv-and-home-entertainment/televisions/televisions/301_3002_30002_xx_xx/xx-criteria.html");
        String navigateURL = driver.getCurrentUrl();
        System.out.println(navigateURL);
        driver.navigate().back();
        driver.navigate().forward();
    }

    @Test
    public void starRating(){
        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/form/div/div/input"));
        searchBox.sendKeys("tv");
        searchBox.sendKeys(Keys.ENTER);
       List<WebElement> starRatings =  driver.findElements(By.cssSelector(".dc-checkbox-wrapper"));
       for (WebElement star: starRatings){
           System.out.println(star.getText());
           if (star.getText().contains("4 or more (332)")){
              star.click();
              String type = driver.findElement(By.xpath("//*[@id=\"filters\"]/div[1]/section/div/div[2]/nav[3]/ul/li[2]/div")).getAttribute("type");
               Assert.assertEquals(type,"checkbox");
              break;
           }
       }
    }

    @Test
    public void scrollDownAndUp() throws InterruptedException {
        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/form/div/div/input"));
        searchBox.sendKeys("tv");
        searchBox.sendKeys(Keys.ENTER);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0,1900);");
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0,-1700);");
        Thread.sleep(2000);

        WebElement jvcTv = driver.findElement(By.xpath("//*[@id=\"product10191559\"]/div[1]/header/a/span[2]"));
        js.executeScript("arguments[0].scrollIntoView(true);", jvcTv);
        Thread.sleep(2000);
    }

    //@After
    public void tearDown(){
        driver.quit();
    }
}
