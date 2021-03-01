package com.automation.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

class CurrysFindElement{
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.currys.co.uk/gbuk/index.html");
        driver.manage().window().maximize();
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/form/div/div/input"));
        searchBox.sendKeys("iPhone");
        searchBox.sendKeys(Keys.ENTER);
        WebElement currysSelectBox = driver.findElement(By.xpath("//*[@id=\"filters\"]/div[1]/section/div/div[2]/nav[1]/ul/li[2]/div/div[1]"));
        currysSelectBox.click();
        //WebElement currysiPhone = driver.findElement(By.xpath("//*[@id=\"product10197974\"]/div[1]/header/a"));
        //currysiPhone.click();
        //String currysUrl = driver.getCurrentUrl();
        //System.out.println(currysUrl);
        //String currysTitle = driver.getTitle();
        //System.out.println(currysTitle);
        //WebElement currysStores = driver.findElement(By.linkText("Stores"));
        //currysStores.click();
        //WebElement currysSignIn = driver.findElement(By.linkText("Sign in"));
        //currysSignIn.click();
        //WebElement currysBasket = driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div[3]/div[6]/a"));
        //currysBasket.click();
        driver.quit();
    }
}
