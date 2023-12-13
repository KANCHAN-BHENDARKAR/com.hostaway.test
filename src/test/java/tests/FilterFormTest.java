package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;


@Feature("Filter Form")
@Epic("Regression Tests")
public class FilterFormTest extends BaseTest{

    @Test(description = "Test All Fields of filter Form")
    @Description("Test All fields of filter form")
    @Story("Validate All Filters Form Selections")
    public void testFilterForm() {

        homePage.goToHostawayHomePage().verifyHomePage()
                .goToSearchFlatsAndHousesResultsPage().verifySearchPage()
                .goToFilterFormPage().verifyFilterFormPage()
                .verifyPricePlaceholderFields()
                .verifyRoomsBedsCounts()
                .verifyRoomsBedroomsCounts()
                .verifyRoomsBathroomsCounts()
                .selectAndVerifyAllAmenitiesCheckboxes()
                .selectAndClearAllFilterFormFieldsAndValidate()
                .closeFilterPage();
    }
}
