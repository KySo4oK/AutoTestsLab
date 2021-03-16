package org.example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppTest {
    public WebDriver driver;

    @Before
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        System.out.println("Test start");
    }

    @Test
    public void shouldNotRegisterUserWhenProvidedPasswordLessFourSymbols() {
        driver.get("http://prom.ua/join-customer?source_id=txt.register.customer");
        driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/div[2]/div/form/div[2]/input")).sendKeys("rostyslav");
        driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/div[2]/div/form/div[3]/input")).sendKeys("123email@google.com");
        driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/div[2]/div/form/div[4]/input")).sendKeys("123");
        driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/div[2]/div/form/div[7]/button")).click();

        String title = driver.getTitle();
        Assert.assertTrue(title.equals("Регистрация покупателя на сайте Prom.ua"));
    }

    @Test
    public void shouldRedirectToAnotherPageWhenSearchButtonIsClicked() {
        driver.get("http://prom.ua/");
        driver.findElement(By.name("search_term")).sendKeys("product");
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/header/div/div/div/div/div[2]/div/div/div[1]/div/div/div/div[1]/form/div[2]")).click();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.equals("https://prom.ua/search?search_term=product"));
    }

    @Test
    public void shouldNotRegisterUserWhenProvidedEmailNotValid() {
        driver.get("http://prom.ua/join-customer?source_id=txt.register.customer");
        driver.findElement(By.cssSelector("input[name=vertical-name]")).sendKeys("rostyslav");
        driver.findElement(By.cssSelector("input[name=vertical-email]")).sendKeys("123email@google.com");
        driver.findElement(By.cssSelector("input[name=vertical-password]")).sendKeys("123");
        driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/div[2]/div/form/div[7]/button")).click();

        String title = driver.getTitle();
        Assert.assertTrue(title.equals("Регистрация покупателя на сайте Prom.ua"));
    }

    @After
    public void close() {
        System.out.println("Test end");
        driver.quit();
    }
}
