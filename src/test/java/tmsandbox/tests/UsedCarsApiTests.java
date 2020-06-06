package tmsandbox.tests;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.emptyArray;
import static org.hamcrest.Matchers.hasEntry;


public class UsedCarsApiTests extends TestBase {

    String usedCarsApiPathUri = "/Categories/UsedCars.json?with_counts=true";

    @Test(groups={"api_test","used_cars"})
    public void test_API_Get_Number_Of_Used_Cars_Brands(){
        List<Object> subCategories =  when().get(usedCarsApiPathUri)
                .then().spec(defaultResponseSpec)
                .assertThat().body("Subcategories",not(emptyArray()))
                .extract().jsonPath().getList("Subcategories");

        System.out.println("Number of brands of Used Cars: " + subCategories.size());
    }

    @Test(groups={"api_test","used_cars"})
    public void test_API_Check_Brand_Kia_Exists_And_Get_Listings(){

        HashMap<String,Object> categoryData = when().get(usedCarsApiPathUri)
                .then().spec(defaultResponseSpec)
                .assertThat().body("Subcategories", hasItems(hasEntry("Name","Kia")))
                .extract().jsonPath().get("Subcategories.find { category -> category.Name == 'Kia' }");

        System.out.println("Current Number of Kia Cars Listed: " + categoryData.get("Count").toString());
    }

    @Test(groups={"api_test","used_cars"})
    public void test_API_Check_Brand_Hispano_Suiza_Not_Exists() {

        when().get(usedCarsApiPathUri)
                .then().spec(defaultResponseSpec)
                .assertThat().body("Subcategories", not(hasItems(hasEntry("Name", "Hispano Suiza"))));

    }

}

