package org.nithin.testing.stepdefinition.api;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.nithin.testing.constants.Constants;
import org.nithin.testing.query.Body;
import org.testng.Assert;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import static io.restassured.RestAssured.given;
import static org.nithin.testing.constants.Constants.response;

public class CrudoperationsStefDef {
    @Given("I call create api")
    public void iCallCreateApi() {
        Constants.response=given().contentType(ContentType.JSON).body(Body.createApiBody).
                when().post("https://reqres.in/api/users").
                then().extract().response();
        System.out.println(response.getBody().prettyPrint());

    }

    @Given("I call update api")
    public void iCallUpdateApi() {
        Constants.response=given().contentType(ContentType.JSON).body(Body.updateApiBody).
                when().put("https://reqres.in/api/users/2").
                then().extract().response();
//        Constants.response=given().contentType(ContentType.JSON).body(Body.updateApiBody).
//                when().patch("https://reqres.in/api/users/2").
//                then().extract().response();

    }

    @Given("I call delete api")
    public void iCallDeleteApi() {
        Constants.response=given().
                when().delete("https://reqres.in/api/users/2").
                then().extract().response();
    }

    @And("I validate the body of the api for updated record")
    public void iValidateTheBodyOfTheApiForDeletedRecord() {
        String nameOutput = CommonStefDef.getJsonOutPut(response,"name");
        Assert.assertEquals(nameOutput,"Nithin");
        String jobOutput = CommonStefDef.getJsonOutPut(response,"job");
        Assert.assertEquals(jobOutput,"ProTester");
        String updatedTS = CommonStefDef.getJsonOutPut(response,"updatedAt");
        Instant updatedTS0 = Instant.parse(updatedTS);
        Instant utsFinal = updatedTS0.truncatedTo(ChronoUnit.MINUTES);
        Instant expectedUTS = Instant.now();
//        Instant expectedUTS1 = Instant.parse()
        Instant expectedUTSFinal= expectedUTS.truncatedTo(ChronoUnit.MINUTES);
        Assert.assertEquals(utsFinal,expectedUTSFinal);

    }
}
