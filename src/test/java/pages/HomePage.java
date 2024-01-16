package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import tests.AllListingPropertiesTest;
import utilities.TestUtility;
import utilities.logs.Log;

public class HomePage {
    public RemoteWebDriver driver;
    public TestUtility utility = new TestUtility();

    /**
     * Web Elements
     */
    @FindBy(how = How.XPATH,using = "//div[@class=\"sc-jVSGNQ hzsGOz\"]/button")
    public WebElement searchButton;
    @FindBy(how = How.XPATH,using = "//a[contains(text(),'All listings page')]")
    public WebElement allListingPageButton;

    @FindBy(how = How.XPATH,using = "//h1[@class='sc-gKAaRy cMptV'][text()=\"Search flats and houses \"]")
    public WebElement searchFlatAndHouseBigTitle;

    /**
     * Constructor
     */
    public HomePage(RemoteWebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @Step("Click On Search Button")
    public void clickSearchButton(){
        utility.waitVisibility(driver, searchButton);
        searchButton.click();
    }

    @Step("Click On All List Page Button")
    public HomePage clickOnAllListPageButton(){
        utility.waitVisibility(driver, allListingPageButton);
        allListingPageButton.click();
        return  this;
    }

    @Step("Opening Hostaway Home Page")
    public HomePage goToHostawayHomePage(){
        Log.info("Opening Hostaway Website.");
        utility.launchSite(driver);
        return this;
    }

    public HomePage verifyHomePage(){
        utility.waitVisibility(driver, searchFlatAndHouseBigTitle);
        Assert.assertTrue(searchFlatAndHouseBigTitle.isDisplayed() == true);
        return this;
    }

    @Step("Opening Search Flats And House ResultPage")
    public SearchPage goToSearchFlatsAndHousesResultsPage(){
        Log.info("Going to Search Flats And House Result Tab");
        clickSearchButton();
        return new SearchPage(driver);
    }

    @Step("Opening All Listing Page")
    public AllListingPropertiesPage goToAllListingPage(){
        Log.info("Going to All Listing Properties Tab");
        clickOnAllListPageButton();
        return new AllListingPropertiesPage(driver);
    }



}
