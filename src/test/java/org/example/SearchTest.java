package org.example;

import org.example.pages.HomePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;

public class SearchTest {

    public WebDriver driver;

    @Before
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void shouldRedirectToAnotherPageWhenSearchButtonIsClicked() {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.open();
        String productKey = "product";
        homePage.setProductKey(productKey);
        homePage.clickSearchButton();
        String currentUrl = homePage.getCurrentUrl();
        assertEquals(homePage.searchUrl + productKey, currentUrl);
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldNotProvidedElementsOfChatWhenItWasntClicked() {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.open();
        homePage.findChatBody();
        homePage.findChatBody();
    }

    @After
    public void close() {
        driver.quit();
    }
}
