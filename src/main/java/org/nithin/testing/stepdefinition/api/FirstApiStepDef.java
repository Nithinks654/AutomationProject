package org.nithin.testing.stepdefinition.api;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.internal.common.assertion.Assertion;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class FirstApiStepDef {
    public String apiUrl=null;
    Response apiResponse;

    @Given("I have get api {string}")
    public void iHaveGetApi(String url) {
        apiUrl=url;

    }

    @When("I call the api")
    public void iCallTheApi() {
        apiResponse= RestAssured.get(apiUrl);


    }

    @Then("I validate the HTTP status code {int}")
    public void iValidateTheHTTPStatusCode(int statusCode) {
        Assert.assertEquals(statusCode,apiResponse.getStatusCode());


    }

//    @Then("I validate the body of the api")
//    public void iValidateTheBodyOfTheApi() {
//       String apiBody= apiResponse.asPrettyString();
//        System.out.println(apiBody);
//    }

    @Then("I validate the body of the api {string} is {string}")
    public void iValidateTheBodyOfTheApiIs(String first, String name) {
        String apiBody= apiResponse.asPrettyString();
        JsonPath js = new JsonPath(apiBody); //for parsing json
        String fn = js.getString(first);
        Assert.assertEquals(name,fn);

    }
}
