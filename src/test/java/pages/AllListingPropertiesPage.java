package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.TestUtility;
import utilities.logs.Log;
import java.util.List;

public class AllListingPropertiesPage {

    public RemoteWebDriver driver;
    public TestUtility utility = new TestUtility();

    /**
     * Constructor
     */
    public AllListingPropertiesPage(RemoteWebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(how = How.XPATH,using = "//h1[text()='Properties']")
    public WebElement PropertiesLabel;

    @FindBys({
            @FindBy( how = How.XPATH,using = "//a[contains(@href,\"listing\")]")
    })
    public List<WebElement> PropertiesListingCount;

    @FindBy(how = How.XPATH,using = "//span[text()='All']/child::*")
    public WebElement AllLabelCount;

    @FindBy(how = How.XPATH,using = "//h3[text()='Cozy Place in Marmaris']")
    public WebElement cozyPlaceInMarmaidLastRecord;

    @FindBy(how = How.XPATH,using = "//h3[contains(text(),'Denmark, Aalborg_')]")
    public WebElement DenmarkAalborgRecord;

    @FindBy(how = How.XPATH,using = "//h3[contains(text(),'Angola, Lubango_')]")
    public WebElement AngolaLubangoRecord;

    @FindBy(how = How.XPATH,using = "//h3[contains(text(),'Serbia_')]")
    public WebElement SerbiaRecord;

    public AllListingPropertiesPage verifyAllListingPage(){
        utility.waitVisibility(driver, PropertiesLabel);
        Assert.assertTrue(PropertiesLabel.isDisplayed());
        return this;
    }

    @Step("Verify All Listing Properties Results")
    public AllListingPropertiesPage verifyAllListingPropertiesCount()  {

        // ---- Traverse till the last element piece by piece
        utility.wait(driver,20);
        int LableValue = utility.extractDigits(AllLabelCount.getText());
        for (int i = 0; i < LableValue; i+=18) {
            utility.scrollToBottom(driver);
            try{Thread.sleep(4000);}catch (Exception e){
                e.getMessage();}
        }

        int ActualTotalPropertiesListingCount = PropertiesListingCount.size();
        Log.info("Total Properties Listing Count "+ ActualTotalPropertiesListingCount);

        //----- Validate the Both Counts ----
        //ToDo: We consistently decrease the count of items in the UI locators list by one since
        // it encompasses the locator for the page name on the All Listing page.
        Assert.assertEquals((ActualTotalPropertiesListingCount-1),LableValue);
        return this;
    }
}
