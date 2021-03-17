package org.example;

import org.example.pages.HomePage;
import org.example.pages.RegistrationPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import static org.example.pages.RegistrationPage.REGISTRATION_TITLE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class RegistrationTest {

    public static final String CABINET_USER_SETTINGS = "https://my.prom.ua/cabinet/user/settings";

    public WebDriver driver;

    @Before
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void shouldRegisterUserWhenProvidedEmailValid() {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.open();
        homePage.goToRegistrationPage();

        RegistrationPage registrationPage = PageFactory.initElements(driver, RegistrationPage.class);
        registrationPage.fillCorrectName();
        registrationPage.fillCorrectEmail();
        registrationPage.fillCorrectPassword();
        registrationPage.submit();
        String currentUrl = registrationPage.getCurrentUrl();

        assertEquals(CABINET_USER_SETTINGS, currentUrl);
    }


    @Test
    public void shouldNotRegisterUserWhenProvidedPasswordLessFourSymbols() {
        RegistrationPage registrationPage = PageFactory.initElements(driver, RegistrationPage.class);
        registrationPage.open();
        registrationPage.fillCorrectEmail();
        registrationPage.fillCorrectName();
        registrationPage.fillIncorrectPassword();
        registrationPage.submit();
        String currentUrl = registrationPage.getCurrentUrl();

        assertNotEquals(CABINET_USER_SETTINGS, currentUrl);
    }

    @Test
    public void shouldNotRegisterUserWhenProvidedEmailNotValid() {
        RegistrationPage registrationPage = PageFactory.initElements(driver, RegistrationPage.class);
        registrationPage.open();
        registrationPage.fillCorrectPassword();
        registrationPage.fillIncorrectEmail();
        registrationPage.fillCorrectName();
        registrationPage.submit();

        String title = registrationPage.getTitle();
        assertEquals(REGISTRATION_TITLE, title);
    }

    @After
    public void close() {
        driver.quit();
    }
}
