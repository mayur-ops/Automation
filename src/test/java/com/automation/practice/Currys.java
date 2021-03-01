package com.automation.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Currys {
    public static WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.firefoxdriver().setup();
        driver=new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.currys.co.uk/gbuk/index.html");
        driver.manage().window().maximize();
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
    }

    @Test
    public void currysSearch(){
        WebElement searchBox = driver.findElement(By.xpath("//form[@class='HeaderSearchProduct__StyledForm-kOQITN iIdCei Header__DesktopHeaderSearchProduct-gAfkIB giOEKM']//div[@class='HeaderSearchProduct__SearchFieldset-gQWwrm kiNZwK']//div[@class='Input__Container-gERxlz jTKYpk HeaderSearchProduct__Input-hAtjZm kIlmAC']//input[@type='text']"));
        searchBox.sendKeys("iPhone");
        searchBox.sendKeys(Keys.ENTER);
        String URL = driver.getCurrentUrl();
        System.out.println(URL);
        String title = driver.getTitle();
        System.out.println(title);
        // Assert.assertTrue(URL.endsWith("html"));
        //Assert.assertThat(URL, Matchers.equalTo("https://www.currys.co.uk/gbuk/index.html"));
        Assert.assertThat(title,Matchers.containsString("Currys PC World | Washing Machines, Laptops, TVs, Consoles"));
    }

    @Test
    public void checkBox(){
        WebElement searchBox = driver.findElement(By.xpath("//form[@class='HeaderSearchProduct__StyledForm-kOQITN iIdCei Header__DesktopHeaderSearchProduct-gAfkIB giOEKM']//div[@class='HeaderSearchProduct__SearchFieldset-gQWwrm kiNZwK']//div[@class='Input__Container-gERxlz jTKYpk HeaderSearchProduct__Input-hAtjZm kIlmAC']//input[@type='text']"));
        searchBox.sendKeys("iPhone");
        searchBox.sendKeys(Keys.ENTER);
        WebElement checkBox = driver.findElement(By.xpath("//body[@data-inq-observer='1']/div[@id='page']/div[@id='wrapper']/div[@id='content']/div[@class='row']/aside[@id='filters']/div[@class='row nosp']/section[@class='col12']/div[@class='dc-filter-container']/div/nav[1]/ul[1]/li[4]/div[1]/div[1]"));
        checkBox.click();
        System.out.println(checkBox.isEnabled());
        Assert.assertTrue(checkBox.isEnabled());
    }

    @Test
    public void currysStores(){
       WebElement stores = driver.findElement(By.xpath("//body[@data-inq-observer='1']/div[@id='page']/div[@id='menu-container']/div[@id='header']/div[@class='Header__Wrapper-ctQkEG fqJOzX']/div[@class='HeaderMenu-MuDMW SnMZG']/div[4]/a[1]"));
       stores.click();
       String title = driver.getTitle();
       System.out.println(title);
       Assert.assertThat(title,Matchers.containsString("Find a store | Currys PC World"));
    }

    @Test
    public void currysSignIn(){
       WebElement signIn =  driver.findElement(By.xpath("//body[@data-inq-observer='1']/div[@id='page']/div[@id='menu-container']/div[@id='header']/div[@class='Header__Wrapper-ctQkEG fqJOzX']/div[@class='HeaderMenu-MuDMW SnMZG']/div[5]/a[1]"));
       signIn.click();
       String signInTitle = driver.getTitle();
       System.out.println(signInTitle);
       Assert.assertEquals(signInTitle,"Sign in to your account");
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
