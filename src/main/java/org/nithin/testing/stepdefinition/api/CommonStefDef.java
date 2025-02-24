package org.nithin.testing.stepdefinition.api;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.nithin.testing.constants.Constants;

public class CommonStefDef {
    public static String getJsonOutPut(Response response, String jsonkey){
        String apiBody= Constants.response.asPrettyString();
        JsonPath js = new JsonPath(apiBody); //for parsing json
        String fn = js.getString(jsonkey);
        System.out.println(fn);

        return fn;
    }
}
