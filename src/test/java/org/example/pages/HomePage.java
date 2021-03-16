package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    private final WebDriver driver;
    public final String searchUrl = "https://prom.ua/search?search_term=";
    private String productKey = "";
    public final String url = "http://prom.ua/";

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(name = "search_term")
    private WebElement searchTermField;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div[1]/div/header/div/div/div/div/div[2]/div/div/div[1]/div/div/div/div[1]/form/div[2]")
    private WebElement searchButton;

    @FindBy(linkText = "зарегистрироваться")
    private WebElement registrationButton;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[1]/div[2]/div/div")
    private WebElement chatBody;

    private void setValueToField(WebElement field, String value) {
        field.sendKeys(value);
    }

    public void setProductKey(String productKey) {
        this.productKey = productKey;
        setValueToField(searchTermField, productKey);
    }

    public void goToRegistrationPage() {
        registrationButton.click();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getSearchUrl() {
        return this.searchUrl + productKey;
    }

    public void open() {
        driver.get(url);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void findChatBody() {
        chatBody.isDisplayed();
    }
}
