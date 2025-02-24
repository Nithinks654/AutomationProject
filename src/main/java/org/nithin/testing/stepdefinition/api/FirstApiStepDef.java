package org.nithin.testing.stepdefinition.api;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.internal.common.assertion.Assertion;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.nithin.testing.constants.Constants;
import org.testng.Assert;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.nithin.testing.constants.Constants.response;

public class FirstApiStepDef {
    public String apiUrl=null;
    String baseUri = "https://reqres.in";

    @Given("I have get api {string}")
    public void iHaveGetApi(String url) {
        apiUrl=url;

    }

    @When("I call the api")
    public void iCallTheApi() {
        Constants.response= RestAssured.get(apiUrl);


    }

    @Then("I validate the HTTP status code {int}")
    public void iValidateTheHTTPStatusCode(int statusCode) {
        Assert.assertEquals(statusCode, Constants.response.getStatusCode());


    }

//    @Then("I validate the body of the api")
//    public void iValidateTheBodyOfTheApi() {
//       String apiBody= apiResponse.asPrettyString();
//        System.out.println(apiBody);
//    }

    @Then("I validate the body of the api {string} is {string}")
    public void iValidateTheBodyOfTheApiIs(String first, String name) {
        String fn = CommonStefDef.getJsonOutPut(response,first);
        Assert.assertEquals(fn,name);
    }

    @Then("I validate the body of the api")
    public void iValidateTheBodyOfTheApi() {
       String jobOutput= CommonStefDef.getJsonOutPut(response,"job");
       Assert.assertEquals(jobOutput,"leader");
        String nameOutput= CommonStefDef.getJsonOutPut(response,"name");
        Assert.assertEquals(nameOutput,"Nithin");
        String tsOutput = CommonStefDef.getJsonOutPut(response,"createdAt");
        Instant cts=Instant.now();
//        Instant cts0=Instant.parse(cts.toString());
        Instant ctsFinal=cts.truncatedTo(ChronoUnit.MINUTES);
        Instant tsOutPut0=Instant.parse(tsOutput);
        Instant tsOutPutFinal = tsOutPut0.truncatedTo(ChronoUnit.MINUTES);
        Assert.assertEquals(tsOutPutFinal,ctsFinal);
    }

    @Given("I set API endpoint for reading user with id {int}")
    public void iSetAPIEndpointForReadingUserWithId(int id) {
        RestAssured.baseURI=baseUri;
    }

    @When("I send a GET request")
    public void iSendAGETRequest() {
        Constants.response = given().get("/api/users/2");
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int statusCode) {
        Constants.response.then().statusCode(statusCode);
//        Assert.assertEquals();
    }

    @And("the response body should contain {string} as {string}")
    public void theResponseBodyShouldContainAs(String key, String value) {
        Constants.response.then().body(key,equalTo(value));
    }


    @When("I send a GET request for multiple users for {string}")
    public void iSendAGETRequestForMultipleUsersFor( String path) {
        Constants.response=given().contentType(ContentType.JSON).
//                header("Authentication", Constants.token).
                when().get(path).
                then().extract().response();
    }

    @And("the response body should contain expected output for {string}")
    public void theResponseBodyShouldContainExpectedOutputFor( String api) {
        int IDCount= Integer.parseInt(CommonStefDef.getJsonOutPut(response,"per_page"));
        for(int i=0;i<IDCount;i++){
            String ID = "data.id[" + i + "]";  //"data.id[%d]".formatted(i);
            System.out.println(i+ " : " +CommonStefDef.getJsonOutPut(response,ID));
            if (api.equals("simpleMultipleUser")) {
                Constants.response.then().body(ID, equalTo(i + 7));
                Constants.response.then().body("data.last_name[4]", equalTo("Edwards"));
            } else if(api.equals("multipleYearUser")) {
                String year="data.year[%d]".formatted(i);
                System.out.println(CommonStefDef.getJsonOutPut(response,year));
                Constants.response.then().body(ID, equalTo(i+1)).body(year,equalTo(i+2000));

            }


        }
    }
}
