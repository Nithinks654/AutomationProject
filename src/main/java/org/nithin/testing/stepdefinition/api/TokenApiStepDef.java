package org.nithin.testing.stepdefinition.api;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.nithin.testing.constants.Constants;
import org.testng.Assert;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.nithin.testing.constants.Constants.response;

public class TokenApiStepDef {

    @Given("I call api url {string} with body {string}")
    public void iCallApiUrlWithBody(String url, String validationType) {
        String body="";
        if(validationType.equals("Positive")){
            body = "{\n" +
                    "    \"email\": \"eve.holt@reqres.in\",\n" +
                    "    \"password\": \"cityslicka\"\n" +
                    "}";
        } else if (validationType.equals("Mispwd")) {
            body = "{\n" +
                    "    \"email\": \"peter@klaven\"\n" +
                    "}";
        }
//        else {
//            body="";
//        }
        System.out.println("body:" +body);
        response = given().contentType(ContentType.JSON).body(body).
                when().post(url).
                then().extract().response();
        Constants.token=CommonStefDef.getJsonOutPut(response,"token");
//        if(validationType.equals("Positive")){
//            response = given().contentType(ContentType.JSON).body("{\n" +
//                    "    \"email\": \"eve.holt@reqres.in\",\n" +
//                    "    \"password\": \"cityslicka\"\n" +
//                    "}").
//                when().post(url).
//                then().extract().response();
//
//        }
//        else if (validationType.equals("Negative2")) {
//            response = given().contentType(ContentType.JSON).body("{\n" +
//                            "    \"email\": \"eve.holt@reqres.in\"\n" +
//                            "}").
//                    when().post(url).
//                    then().extract().response();
//        } else {
//            response = given().contentType(ContentType.JSON).body("").
//                    when().post(url).
//                    then().extract().response();
//
//        }
    }

    @Then("I validate Api response code {int}")
    public void iValidateApiResponseCode(int statusCode) {
        Assert.assertEquals(Constants.response.statusCode(),statusCode);
    }

    @And("I validate the response in api body {string}")
    public void iValidateTheResponseInApiBody(String errorMsg) {
//        if(!(errorMsg.equals("")))
        if(!errorMsg.isEmpty()){
           String fn =CommonStefDef.getJsonOutPut(response,"error");
            Assert.assertEquals(fn,errorMsg);

        }
    }
}
