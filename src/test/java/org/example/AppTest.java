package org.example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
        WebDriverWait wait = new WebDriverWait(driver, 10);

        String title = driver.getTitle();
        Assert.assertTrue(title.equals("Регистрация покупателя на сайте Prom.ua"));
    }

    @After
    public void close() {
        System.out.println("Test end");
        driver.quit();
    }
}
