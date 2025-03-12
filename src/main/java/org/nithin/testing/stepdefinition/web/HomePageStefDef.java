package org.nithin.testing.stepdefinition.web;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.nithin.testing.DriverManager;
import org.nithin.testing.pageFactory.HomePage;
import org.openqa.selenium.WebDriver;

public class HomePageStefDef {

    public HomePage homepage;
    public WebDriver driver;

    public HomePageStefDef() {
        driver = new DriverManager(driver).getDriver();
        homepage = new HomePage(driver);

    }


    @Given("I enter into webPage")

    public void iEnterIntoWebPage() {
        homepage.hitURL(driver);
    }

    @Then("I validate that I am in signUp page")
    public void iValidateThatIAmInSignUpPage() {
        homepage.validateSignUpOrLoginPage();
    }

    @When("Try to signup with existing email and check the error message")
    public void tryToSignupWithExistingEmailAndCheckTheErrorMessage() {
        homepage.validateEmailExist();
    }

    @And("I close the webpage")
    public void iCloseTheWebpage() {
        homepage.closeThePage();
    }

    @And("I validate that I am in create account page")
    public void iValidateThatIAmInCreateAccountPage() {
        homepage.validateCreateAccountPage();
    }

    @When("I click create account button")
    public void iClickCreateAccountButton() {
        homepage.createAccountButtonClick();

    }

    @Then("Account created message should be displayed")
    public void accountCreatedMessageShouldBeDisplayed() {
        homepage.validateAccountCreatedMessage();
    }

    @Then("I enter all the signUp details {string}")
    public void iEnterAllTheSignUpDetails(String details) {
        homepage.enterAllDetailsForSignUp(details);

    }
}
