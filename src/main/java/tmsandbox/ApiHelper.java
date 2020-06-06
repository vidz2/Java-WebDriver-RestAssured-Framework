package tmsandbox;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class ApiHelper {

    public static void setBaseURI (String baseUri){
        RestAssured.baseURI = baseUri;
    }

    public static void setBasePath (String path){
        RestAssured.basePath = path;
    }

    public static void setContentType (ContentType Type){
        given().contentType(Type);
    }

}
