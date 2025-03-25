package org.nithin.testing.pageFactory;

import org.nithin.testing.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class ProductsPage extends Base {

    @FindBy(css = "h4 > a[href='#Men']")
    WebElement menCategory;

    @FindBy(css = "div#Men >div >ul >li:nth-child(1) > a")
    WebElement tShirts;

    @FindBy(css = "h2.title.text-center")
    WebElement menProductsPage;

    @FindBy(css = "img[src='/get_product_picture/29']")
    WebElement greenSidePlacketDetailTShirt;

    @FindBy(css = "div.overlay-content >a[data-product-id='29']")
    WebElement greenTShirtAddToCartButton;

    @FindBy(css = "h4.modal-title.w-100")
    WebElement productAdded;

    @FindBy(css = "button.btn-success")
    WebElement continueShoppingButton;

    @FindBy(css = "img[src='/get_product_picture/31']")
    WebElement neonTShirt;

    @FindBy(css = "div.overlay-content >a[data-product-id='31']")
    WebElement neonTShirtAddToCartButton;

    @FindBy(css ="p.text-center > a")
    WebElement viewCartLink;

    @FindBy(css = "li.active")
    WebElement shoppingCartPage;

    @FindBy(css = "a.check_out")
    WebElement proceedCheckoutButton;

    @FindBy(css = "h4.modal-title.w-100")
    WebElement checkOutPage;

    @FindBy(css = "p.text-center > a[href='/login']")
    WebElement registerOrLoginLink;

    @FindBy(xpath = "//input[@placeholder='Name']")
    WebElement signUpNameField;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    WebElement signUpEmailField;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    WebElement signUpButton;

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

    @FindBy(css = "a.btn")
    WebElement continueButton;

    @FindBy (css = "ul > li:nth-child(10) > a > b")
    WebElement loggedUserName;

    @FindBy(css = "ul.navbar-nav >li > a[href='/view_cart'] ")
    WebElement cartPage;

    @FindBy(css = "#cart_items > div > div:nth-child(2) > h2")
    WebElement addressDetails;

    @FindBy(css ="ul.address.item.box > li.address_firstname")
    WebElement firstAndLastName;

    @FindBy(css = "ul.address.item.box > li:nth-child(4)")
    WebElement address1;

    @FindBy(css = "ul.address.item.box > li.address_city.address_state_name.address_postcode")
    WebElement cityStatePostalCode;

    @FindBy(css = "ul.address.item.box > li.address_country_name")
    WebElement country;

    @FindBy(css = "ul.address.item.box > li.address_phone")
    WebElement phoneNumber;

    @FindBy(css = "tr:nth-child(3) p.cart_total_price")
    WebElement totalPrice;

    @FindBy(css = "a[href='/product_details/29']")
    WebElement greenTShirtName;

    @FindBy(css = "a[href='/product_details/31']")
    WebElement neonTShirtName;

    @FindBy(css = "textarea.form-control")
    WebElement commentTextArea;

    @FindBy(css = "a.check_out")
    WebElement placeOrderButton;

    @FindBy(css = "input[name='name_on_card']")
    WebElement nameOnCard;

    @FindBy(css = "input[name='card_number']")
    WebElement cardNumberField;

    @FindBy(css = "input.card-cvc")
    WebElement cvvTextField;

    @FindBy(css = "input.card-expiry-month")
    WebElement cardExpiryMonthTextField;

    @FindBy(css = "input.card-expiry-year")
    WebElement cardExpiryYearTextField;

    @FindBy(css = "button.form-control.btn.btn-primary.submit-button")
    WebElement payAndConfirmOrderButton;

    @FindBy(css = "div.col-md-12 > div.alert-success.alert")
    WebElement orderSuccessMessage;

    @FindBy(css = "h2.title.text-center b")
    WebElement orderPlacedMessage;

    @FindBy(css = "a[href='/delete_account']")
    WebElement deleteAccount;

    @FindBy(css = "h2.title.text-center>b")
    WebElement accountDeletedMsg;










    public ProductsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void hitURL(WebDriver driver) {
        driver.get("https://automationexercise.com/");
    }


    public void toValidateHomePage() {
        String pageTitle = getPageTitle();
        Assert.assertEquals(pageTitle,"Automation Exercise");

    }

    public void addProductsToCart() {


        scrollDown(1000);
        waitUntilVisible(menCategory);
        menCategory.click();
        waitUntilVisible(tShirts);
        clickUsingJS(tShirts);
//        leftClick(tShirts);
        String tShirtsPageText = menProductsPage.getText();
        Assert.assertEquals(tShirtsPageText,"MEN - TSHIRTS PRODUCTS");
        pause(3);
//        scrollRight(100);
        hoverOverElement(greenSidePlacketDetailTShirt);
//        pause(3);
//        scrollToElement(greenTShirtAddToCartButton);
//        clickElement(greenTShirtAddToCartButton);
        waitUntilClickable(greenTShirtAddToCartButton);
        clickUsingJS(greenTShirtAddToCartButton);
        waitUntilVisible(productAdded);
//        String productAddedMessage = productAdded.getText();
//        Assert.assertEquals(productAddedMessage,"Added!");
        getTextAndValidate(productAdded,"Added!");
        continueShoppingButton.click();
        hoverOverElement(neonTShirt);
        pause(2);
//        scrollToElement(neonTShirtAddToCartButton);
//        clickElement(neonTShirtAddToCartButton);
        waitUntilClickable(neonTShirtAddToCartButton);
        clickUsingJS(neonTShirtAddToCartButton);
        waitUntilVisible(productAdded);
//        String productAddedMessage2 = productAdded.getText();
//        Assert.assertEquals(productAddedMessage2,"Added!");
        getTextAndValidate(productAdded,"Added!");


    }

    public void clickViewCart() {
        viewCartLink.click();
    }

    public void validateCartPageIsVisible() {
        getTextAndValidate(shoppingCartPage,"Shopping Cart");

    }

    public void ProceedCheckout() {
        proceedCheckoutButton.click();
    }

    public void clickRegisterOrLoginButton() {
        getTextAndValidate(checkOutPage,"Checkout");
        registerOrLoginLink.click();
    }
    public void validateCreateAccountPage() {
        signUpNameField.sendKeys("nithin");
        String mailid = randomEmailGenerator();
        signUpEmailField.sendKeys(mailid);
        signUpButton.click();
//        String signupmsg = createAccountPageMessage.getText();
//        Assert.assertEquals(signupmsg, "ENTER ACCOUNT INFORMATION");
        getTextAndValidate(createAccountPageMessage,"ENTER ACCOUNT INFORMATION");

    }
    public void enterAllDetailsForSignUp(String details) {
        String[] detail = details.split(",");
        titleRadioButton.click();
        passwordField.sendKeys("testing@123");
//        dropDown(days).selectByIndex(4);
//        dropDown(months).selectByValue("6");
//        dropDown(years).selectByVisibleText("1999");
        selectByIndex(days, 4);
        selectByValue(months, "6");
        selectByVisibleText(years, "1999");
        WebElement checkBox = driver.findElement(By.id("newsletter"));
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView(true)", checkBox);
//        js.executeScript("arguments[0].click()", checkBox);
        scrollToElement(checkBox);
        clickUsingJS(checkBox);
        firstNameTextField.sendKeys(detail[0]);
        lastNameTextField.sendKeys(detail[1]);
        address1TextField.sendKeys(detail[2]);
        stateTextField.sendKeys(detail[3]);
        cityTextField.sendKeys(detail[4]);
        zipCodeTextField.sendKeys(detail[5]);
        mobileNumberTextField.sendKeys(detail[6]);

    }
    public void createAccountButtonClick() {
        scrollToElement(createAccountButton);
        createAccountButton.click();
    }
    public void validateAccountCreatedMessage() {
        pause(2);
//        waitUntilVisible(accountCreatedMessage);
//        String createMsg = accountCreatedMessage.getText();
//        Assert.assertEquals(createMsg, "ACCOUNT CREATED!");
        getTextAndValidate(accountCreatedMessage,"ACCOUNT CREATED!");
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public void validateLoggedInWithCorrectUsername() {
        String userName = loggedUserName.getText();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(userName,"nithin");
    }

    public void goToCartPage(){
        cartPage.click();
    }
    public void toValidateAddressDetails(String details) {
        String[] detail = details.split(",");
        getTextAndValidate(addressDetails,detail[0]);
        getTextAndValidate(firstAndLastName,detail[1]);
        getTextAndValidate(address1,detail[2]);
        getTextAndValidate(cityStatePostalCode,detail[3]);
        getTextAndValidate(country,detail[4]);
        getTextAndValidate(phoneNumber,detail[5]);
    }

    public void toValidateCartDetails(String products) {
        String[] product = products.split(",");
        getTextAndValidate(greenTShirtName,product[0]);
        getTextAndValidate(neonTShirtName,product[1]);
        getTextAndValidate(totalPrice,product[2]);
    }

    public void toAddCommentInTextAreaField() {
        commentTextArea.sendKeys("all the added items are present in cart page");
    }

    public void toClickPlaceOrderButton() {
        placeOrderButton.click();
    }

    public void enterPaymentDetails(String paymentDetails) {
        String[] payment = paymentDetails.split(",");
        nameOnCard.sendKeys(payment[0]);
        cardNumberField.sendKeys(payment[1]);
        cvvTextField.sendKeys(payment[2]);
        cardExpiryMonthTextField.sendKeys(payment[3]);
        cardExpiryYearTextField.sendKeys(payment[4]);
    }
    public void clickPayAndConfirmButton() {
        payAndConfirmOrderButton.click();
    }
    public void validateOrderSuccessMessage(String orderMessage) {
//        waitUntilVisible(orderSuccessMessage);
//        getTextAndValidate(orderSuccessMessage,orderMessage);
        waitUntilVisible(orderPlacedMessage);
        getTextAndValidate(orderPlacedMessage,"ORDER PLACED!");
    }
    public void clickDeleteAccountButton() {
        deleteAccount.click();

    }

    public void validateAccountDeleted(String deleteMessage){
//        String accountDeleted = accountDeletedMsg.getText();
//        Assert.assertEquals(accountDeleted,"ACCOUNT DELETED!");
        getTextAndValidate(accountDeletedMsg,deleteMessage);
//        deleteThenContinueButton.click();
    }

}
