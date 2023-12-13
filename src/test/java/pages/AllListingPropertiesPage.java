package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.TestUtility;
import utilities.logs.Log;

import java.sql.SQLOutput;
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


    //div[@class='sc-jffHpj ewTIhF']/child::a[contains(@href,'/listings/')]
    @FindBys({
            @FindBy( how = How.XPATH,using = "//div[@class='sc-jffHpj ewTIhF']")
    })
    public List<WebElement> PropertiesListingCount;

    @FindBy(how = How.XPATH,using = "//span[normalize-space()='(71)']")
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
    public AllListingPropertiesPage verifyAllListingPropertiesCount(){

        // ---- Traverse till the last element piece by piece
        utility.wait(driver,20);
        int LableValue = utility.convertStringBracketValueIntoInteger(AllLabelCount.getText());

        utility.scrollToSpecificWebElement1(driver,DenmarkAalborgRecord);
        utility.wait(driver,10);
        utility.scrollToSpecificWebElement1(driver,AngolaLubangoRecord);
        utility.wait(driver,10);
        utility.scrollToSpecificWebElement1(driver,SerbiaRecord);
        utility.wait(driver,10);
        utility.scrollToSpecificWebElement1(driver,cozyPlaceInMarmaidLastRecord);

        int ActualTotalPropertiesListingCount = PropertiesListingCount.size();
        Log.info("Total Properties Listing Count "+ ActualTotalPropertiesListingCount);

        //----- Validate the Both Counts ----
        Assert.assertEquals(ActualTotalPropertiesListingCount,LableValue);
        return this;
    }






}
