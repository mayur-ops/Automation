package com.automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PriceRangeAssertion {
    public static WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.argos.co.uk/search/nike/price:%C2%A35-%252D-%C2%A310/");
        driver.manage().window().maximize();
        driver.findElement(By.id("consent_prompt_submit")).click();
    }

    @Test
    public void assertion(){
        List<WebElement> priceranges = driver.findElements(By.cssSelector(".ProductCardstyles__PriceText-gm8lcq-14.lhwdnp"));
        for (WebElement pricerange: priceranges){
            System.out.println(pricerange.getText());

            String pricewithoutpound = pricerange.getText().replace("£","");

            double priceindouble = Double.parseDouble(pricewithoutpound);
            System.out.println(priceindouble);

            Assert.assertThat(priceindouble, Matchers.greaterThanOrEqualTo(5.00));
            Assert.assertThat(priceindouble,Matchers.lessThanOrEqualTo(10.00));
        }
    }

}
