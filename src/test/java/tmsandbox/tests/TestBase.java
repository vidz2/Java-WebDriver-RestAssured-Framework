package tmsandbox.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import tmsandbox.ApiHelper;
import tmsandbox.TestHelper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestBase {

    static ResponseSpecification defaultResponseSpec;
    static Properties env_properties = new Properties();
    Logger logger = Logger.getLogger(TestBase.class);

    private static String output_path;

    @BeforeClass(groups={"api_test","ui_test","used_cars"})
    public static void beforeAll() throws IOException {
        InputStream inputStream = TestBase.class.getResourceAsStream("/test.properties");
        env_properties.load(inputStream);
        output_path = env_properties.getProperty("outputPath");
    }

    @BeforeMethod(groups={"api_test","ui_test","used_cars"})
    public void setupApiTest(){
        ApiHelper.setBaseURI(env_properties.getProperty("baseURI"));
        ApiHelper.setBasePath(env_properties.getProperty("apiVersion"));
        ApiHelper.setContentType(ContentType.JSON);
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        defaultResponseSpec = TestHelper.defaultSpecBuilder();
    }

}
