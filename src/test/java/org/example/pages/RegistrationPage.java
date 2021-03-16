package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage {

    private WebDriver driver;

    private String correctName = "rostyslav";

    @FindBy(css = "input[name=vertical-name]")
    private WebElement nameField;

    @FindBy(css = "input[name=vertical-email]")
    private WebElement emailField;

    @FindBy(css = "input[name=vertical-password]")
    private WebElement passwordField;

    private String correctEmail;

    private String correctPassword = "12323";

    private String incorrectPassword = "123";

    @FindBy(xpath = "/html/body/div[5]/div[2]/div/div[2]/div/form/div[7]/button")
    private WebElement submitButton;

    private String incorrectEmail = "122342342332412323emailgoogle.com";

    public static final String REGISTRATION_TITLE = "Регистрация покупателя на сайте Prom.ua";
    private String url = "https://prom.ua/join-customer?source_id=txt.register.customer";

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    private void setValueToField(WebElement field, String value) {
        field.sendKeys(value);
    }

    public void fillCorrectName() {
        generateCorrectName();
        setValueToField(this.nameField, this.correctName);
    }

    private void generateCorrectName() {
        this.correctName = (int) (Math.random() * 10000) + "rostyslav";
    }

    public void fillCorrectEmail() {
        generateCorrectEmail();
        setValueToField(this.emailField, this.correctEmail);
    }

    private void generateCorrectEmail() {
        this.correctEmail = (int) (Math.random() * 10000) + "sdf@emailgoogle.com";
    }

    public void fillCorrectPassword() {
        setValueToField(this.passwordField, this.correctPassword);
    }

    public void submit() {
        submitButton.click();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void fillIncorrectPassword() {
        setValueToField(this.nameField, this.incorrectPassword);
    }

    public void fillIncorrectEmail() {
        generateIncorrectEmail();
        setValueToField(this.emailField, this.incorrectEmail);
    }

    private void generateIncorrectEmail() {
        this.incorrectEmail = (int) (Math.random() * 10000) + "sdfemailgoogle.com";
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void open() {
        driver.get(url);
    }
}
