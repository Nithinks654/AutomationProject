package org.nithin.testing.stepdefinition.web;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.nithin.testing.DriverManager;
import org.nithin.testing.pageFactory.ProductsPage;
import org.openqa.selenium.WebDriver;

public class ProductsStefDef {

    public ProductsPage productsPage;
    public WebDriver driver;

    public ProductsStefDef() {
        driver = new DriverManager(driver).getDriver();
        productsPage = new ProductsPage(driver);
    }


    @Given("I enter into Products webPage")
    public void iEnterIntoProductsWebPage() {
        productsPage.hitURL(driver);
    }

    @Then("I should see the home page displayed successfully")
    public void iShouldSeeTheHomePageDisplayedSuccessfully() {
        productsPage.toValidateHomePage();
    }

    @When("I add products to the cart")
    public void iAddProductsToTheCart() {
        productsPage.addProductsToCart();
    }

    @And("I click the view cart link")
    public void iClickTheViewCartLink() {
        productsPage.clickViewCart();
    }


    @Then("I should see the cart page displayed")
    public void iShouldSeeTheCartPageDisplayed() {
        productsPage.validateCartPageIsVisible();
    }

    @When("I click Proceed To Checkout")
    public void iClickProceedToCheckout() {
        productsPage.ProceedCheckout();
    }

    @And("I click Register Or Login button")
    public void iClickRegisterOrLoginButton() {
        productsPage.clickRegisterOrLoginButton();
    }

    @And("I fill all details in Signup and create an account {string}")
    public void iFillAllDetailsInSignupAndCreateAnAccount(String details) {
        productsPage.validateCreateAccountPage();
        productsPage.enterAllDetailsForSignUp(details);
        productsPage.createAccountButtonClick();
    }

    @Then("I should see ACCOUNT CREATED! message")
    public void iShouldSeeACCOUNTCREATEDMessage() {
        productsPage.validateAccountCreatedMessage();
    }

    @And("I click the Continue button")
    public void iClickTheContinueButton() {
        productsPage.clickContinueButton();
    }

    @Then("I should see Logged in as username at the top")
    public void iShouldSeeLoggedInAsUsernameAtTheTop() {
        productsPage.validateLoggedInWithCorrectUsername();
    }


    @When("I click the Cart button")
    public void iClickTheCartButton() {
        productsPage.goToCartPage();
    }

    @Then("I should see the Address Details and Review Order section and verify all the details {string}")
    public void iShouldSeeTheAddressDetailsAndReviewOrderSectionAndVerifyAllTheDetails(String details) {
        productsPage.toValidateAddressDetails(details);
    }

    @And("I should see items i have added with correct total amount {string}")
    public void iShouldSeeItemsIHaveAddedWithCorrectTotalAmount(String products) {
        productsPage.toValidateCartDetails(products);
    }

    @When("I enter a description in the comment text area")
    public void iEnterADescriptionInTheCommentTextArea() {
        productsPage.toAddCommentInTextAreaField();
    }

    @And("I click the Place Order button")
    public void iClickThePlaceOrderButton() {
        productsPage.toClickPlaceOrderButton();

    }

    @And("I enter payment details {string}")
    public void iEnterPaymentDetails(String paymentDetails) {
        productsPage.enterPaymentDetails(paymentDetails);
    }


    @And("I click Pay and Confirm Order button")
    public void iClickPayAndConfirmOrderButton() {
        productsPage.clickPayAndConfirmButton();
    }

    @Then("I should see the success message {string}")
    public void iShouldSeeTheSuccessMessage(String orderMessage) {
        productsPage.validateOrderSuccessMessage(orderMessage);
    }

    @When("I click the Delete Account button")
    public void iClickTheDeleteAccountButton() {
        productsPage.clickDeleteAccountButton();
    }

    @Then("I should see {string} message")
    public void iShouldSeeMessage(String deleteMessage) {
        productsPage.validateAccountDeleted(deleteMessage);
    }


}
