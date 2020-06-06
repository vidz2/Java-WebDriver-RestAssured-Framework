package tmsandbox.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UsedCarsMakesPage extends BasePage{

    @FindBy(id="mainContent")
    private WebElement mainContent;

    @FindBy(css="#makeTable tr td a")
    private List<WebElement> carBrandsList;

    @FindBy(css="#makeTable tr td a + .count")
    private List<WebElement> carBrandsListItems;

    public UsedCarsMakesPage(){
        wait.waitForElementToBeVisible(mainContent);
    }

    public List<String> getUsedCarsBrandsList(){
        return carBrandsList.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public String getUsedCarsListingCountByBrand(String brand){
        // Get list of car brand count elements and get the number between ( and ) and collect into a List
        List<String> brandsCountList = carBrandsListItems.stream()
                .map(element -> {
                    String s = element.getText();
                    return s.substring(s.indexOf("(")+1,s.indexOf(")"));}
                    )
                .collect(Collectors.toList());

        List<String> carBrandsList = getUsedCarsBrandsList();
        Map<String,String> carBrandsWithListingCountMap = new HashMap<String,String>();

        // Create a new map with the brand name and count as key/value
        for (int i=0; i<carBrandsList.size(); i++) {
            carBrandsWithListingCountMap.put(carBrandsList.get(i), brandsCountList.get(i));
        }
        System.out.println(carBrandsWithListingCountMap);
        return carBrandsWithListingCountMap.getOrDefault(brand,null);

    }
}
