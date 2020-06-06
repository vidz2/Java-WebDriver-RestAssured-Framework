package tmsandbox;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;

import static org.testng.AssertJUnit.assertEquals;


public class TestHelper {

    public static ResponseSpecification defaultSpecBuilder(){
        ResponseSpecBuilder builder = new ResponseSpecBuilder();
        builder.expectStatusCode(200);
        builder.expectContentType(ContentType.JSON);
        return builder.build();
    }

    public static void statusIs200 (Response res) {
        assertEquals(res.getStatusCode(), 200);
    }
}
