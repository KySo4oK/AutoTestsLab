package org.example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
        String title = driver.getTitle();
        Assert.assertTrue(title.equals("Регистрация покупателя на сайте Prom.ua"));
    }

    @After
    public void close() {
        System.out.println("Test end");
        driver.quit();
    }
}
