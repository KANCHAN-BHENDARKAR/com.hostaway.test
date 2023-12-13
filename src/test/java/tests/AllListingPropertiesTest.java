package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Feature("All Listing Properties")
@Epic("Regression Tests")
public class AllListingPropertiesTest extends BaseTest {

    @Test(description = "Test All Listing Properties Page")
    @Description("Test All Listing Properties")
    @Story("Validate All Listing Properties Results")
    public void testAllListingProperties() {

        homePage.goToHostawayHomePage().verifyHomePage()
                .goToAllListingPage().verifyAllListingPage()
                .verifyAllListingPropertiesCount();

    }
}
