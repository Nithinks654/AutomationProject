package org.nithin.testing.pageFactory;

import org.nithin.testing.Base;
import org.nithin.testing.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class HomePage extends DriverManager {
    @FindBy(xpath = "//a[@href='/login']")
    WebElement signUpOrLoginButton;

    @FindBy(css = "div.signup-form > h2")
    WebElement signUpPageMsg;

    @FindBy(xpath = "//input[@placeholder='Name']")
    WebElement signUpNameField;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    WebElement signUpEmailField;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    WebElement signUpButton;

    @FindBy(css = "form > p[style='color: red;']")
    WebElement emailExistsMsg;

    @FindBy(css = "div > h2.title >b")
    WebElement createAccountPageMessage;

    @FindBy(css = "input#id_gender1")
    WebElement titleRadioButton;

    @FindBy(css = "input#password")
    WebElement passwordField;

    @FindBy(css = "select#days")
    WebElement days;

    @FindBy(css = "select#months")
    WebElement months;

    @FindBy(css = "select#years")
    WebElement years;

    @FindBy(css = "input#first_name")
    WebElement firstNameTextField;

    @FindBy(css = "input#last_name")
    WebElement lastNameTextField;

    @FindBy(css = "input#address1")
    WebElement address1TextField;

    @FindBy(css = "input#state")
    WebElement stateTextField;

    @FindBy(css = "input#city")
    WebElement cityTextField;

    @FindBy(css = "input#zipcode")
    WebElement zipCodeTextField;

    @FindBy(css = "input#mobile_number")
    WebElement mobileNumberTextField;

    @FindBy(css = "button[data-qa='create-account']")
    WebElement createAccountButton;

    @FindBy(css = "div > h2.title > b")
    WebElement accountCreatedMessage;


    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void hitURL(WebDriver driver) {
        driver.get("https://automationexercise.com/");
    }

    public void validateSignUpOrLoginPage() {
        signUpOrLoginButton.click();
        String msg = signUpPageMsg.getText();
        Assert.assertEquals(msg, "New User Signup!");
    }

    public void validateEmailExist() {
        signUpNameField.sendKeys("nithin");
        signUpEmailField.sendKeys("test12368854@gmail.com");
        signUpButton.click();
        String emailExists = emailExistsMsg.getText();
        Assert.assertEquals(emailExists, "Email Address already exist!");

    }

    public void validateCreateAccountPage() {
        signUpNameField.sendKeys("nithin");
        String mailid = randomEmailGenerator();
        signUpEmailField.sendKeys(mailid);
        signUpButton.click();
        String signupmsg = createAccountPageMessage.getText();
        Assert.assertEquals(signupmsg, "ENTER ACCOUNT INFORMATION");

    }

    public void enterAllDetailsForSignUp(String details) {
        String[] detail = details.split(",");
        titleRadioButton.click();
        passwordField.sendKeys("testing@123");
        dropDown(days).selectByIndex(4);
        dropDown(months).selectByValue("6");
        dropDown(years).selectByVisibleText("1999");
        WebElement checkBox = driver.findElement(By.id("newsletter"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", checkBox);
        js.executeScript("arguments[0].click()", checkBox);
        firstNameTextField.sendKeys(detail[0]);
        lastNameTextField.sendKeys(detail[1]);
        address1TextField.sendKeys(detail[2]);
        stateTextField.sendKeys(detail[3]);
        cityTextField.sendKeys(detail[4]);
        zipCodeTextField.sendKeys(detail[5]);
        mobileNumberTextField.sendKeys(detail[6]);

    }

    public void createAccountButtonClick() {
        createAccountButton.click();
    }

    public void validateAccountCreatedMessage() {
        String creatMsg = accountCreatedMessage.getText();
        Assert.assertEquals(creatMsg, "ACCOUNT CREATED!");
    }


    public void closeThePage() {
        DriverManager.quitDriver();
    }
}
