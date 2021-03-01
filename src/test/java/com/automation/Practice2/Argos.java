package com.automation.Practice2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.is;

public class Argos {

    public static WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        //driver.get("https://www.argos.co.uk/");   // usr for puma product
        driver.get("https://www.argos.co.uk/search/nike/?clickOrigin=searchbar:home:term:nike");
        driver.manage().window().maximize();
        driver.findElement(By.id("consent_prompt_submit")).click();
    }

    @Test
    public void customerRatings() {
        List<WebElement> argosRadioButtons = driver.findElements(By.cssSelector(".RadioListstyles__Label-sc-1atiffa-5.iGLFTd"));
        for (WebElement radioButton : argosRadioButtons) {
            System.out.println(radioButton.getAttribute("id"));
            if (radioButton.getAttribute("id").contains("2 or more-label")) {
                radioButton.click();
                String radioButtonLabel = driver.findElement(By.xpath("//label[@id='2 or more-label']")).getAttribute("id");
                Assert.assertEquals(radioButtonLabel,"2 or more-label");
                break;
            }
        }
    }

        @Test
        public void checkBox () {
        List<WebElement> checkBoxes = driver.findElements(By.cssSelector(".Checkboxstyles__Label-b61uwr-4.kmdVAM.font-standard"));
        for (WebElement checkbox: checkBoxes){
            System.out.println(checkbox.getAttribute("id"));
            if(checkbox.getAttribute("id").contains("filter-type-backpacks-label")){
                checkbox.click();
                String backpacksValue = driver.findElement(By.id("filter-type-backpacks-label")).getAttribute("value");
                Assert.assertTrue(backpacksValue.contains("backpacks"));
                break;
            }
        }
    }
    @Test
    public void nikeProduct() {
       List<WebElement> products = driver.findElements(By.cssSelector(".ProductCardstyles__Title-gm8lcq-12.hkIdWm"));
       for (WebElement product: products){
           System.out.println(product.getText());
           if (product.getText().contains("Nike Crossbody Bag - Black")){
               product.click();
               String selectProduct = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/section[1]/div[1]/h2[1]/span[1]")).getText();
               Assert.assertThat(selectProduct,Matchers.containsString("Black"));
               break;
           }
       }
    }

    @Test
    public void relevance() throws InterruptedException {
       WebElement relevanceDropDown = driver.findElement(By.id("sort-select"));
        Select sel = new Select(relevanceDropDown);

        //sel.selectByVisibleText("Price: Low - High");
        //Thread.sleep(2000);
        //sel.selectByVisibleText("Price: High - Low");
        //sel.selectByVisibleText("Customer Rating");

        //List<WebElement> options = sel.getAllSelectedOptions();
        List<WebElement> options = sel.getOptions();
       for (WebElement option: options){
           System.out.println(option.getText());
       }
    }

    @Test
    public void category(){
      List<WebElement> categories =  driver.findElements(By.cssSelector(".styles__CategoryFilterText-sc-1ghu43i-6.gSQouC"));
      for (WebElement cat: categories){
          System.out.println(cat.getText());
          if(cat.getText().contains("Technology")){
              cat.click();
             String title = driver.getTitle();
              System.out.println(title);
              Assert.assertEquals(title,"Results for nike");
              break;
          }
      }
    }

    @Test
    public void pumaAutoDrop(){
       WebElement searchBox = driver.findElement(By.id("searchTerm"));
       searchBox.sendKeys("puma");

      List<WebElement> pumaDropDowns =  driver.findElements(By.cssSelector("._3a8zN"));
      for (WebElement pumaDrop: pumaDropDowns){
          System.out.println(pumaDrop.getText());
          if (pumaDrop.getText().contains("football pump")){
              pumaDrop.click();
              String title = driver.getTitle();
              System.out.println(title);
              Assert.assertEquals(title,"Results for football pump in Sports and fitness, Football, Football pumps");
              break;
          }
      }
    }

    @Test
    public void actionClass(){
       WebElement shopLink = driver.findElement(By.id("ShopLink"));
        Actions actions = new Actions(driver);
        actions.moveToElement(shopLink).perform();

//       WebElement technology = driver.findElement(By.xpath("//*[@id=\"megaMenu\"]/li[1]/ul/ul/li[1]/a"));
//       actions.moveToElement(technology).click().perform();

//      WebElement television =  driver.findElement(By.xpath("//*[@id=\"megaMenu\"]/li[4]/ul[1]/ul/li[1]/a"));
//      actions.moveToElement(television).click().perform();
    }

    //@After
    public void tearDown(){
        driver.quit();
        }

    }

