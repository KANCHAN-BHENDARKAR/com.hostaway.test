package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.TestUtility;
import utilities.logs.Log;

import java.util.List;

public class FilterPage {
    public RemoteWebDriver driver;
    public TestUtility utility = new TestUtility();

    /**
     * Constructor
     */
    public FilterPage(RemoteWebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(how = How.XPATH,using = "//input[@placeholder='From']")
    public WebElement filterByPriceFromValue;

    @FindBy(how = How.XPATH,using = "//input[@placeholder='To']")
    public WebElement filterByPriceToValue;

    @FindBy(how = How.XPATH,using = "(//button[@class=\"sc-flUlpA sc-iGkqmO eEVTIr ckwDLe\"])[1]")
    public WebElement incrementButtonForBeds;

    @FindBy(how = How.XPATH,using = "(//button[@class='sc-flUlpA sc-eXuyPJ eEVTIr kTTKRj'])[1]")
    public WebElement decrementButtonForBeds;

    @FindBy(how = How.XPATH,using = "(//button[@class='sc-flUlpA sc-iGkqmO eEVTIr ckwDLe'])[2]")
    public WebElement incrementButtonForBedrooms;

    @FindBy(how = How.XPATH,using = "(//button[@class='sc-flUlpA sc-eXuyPJ eEVTIr kTTKRj'])[2]")
    public WebElement decrementButtonForBedrooms;

    @FindBy(how = How.XPATH,using = "(//button[@class='sc-flUlpA sc-iGkqmO eEVTIr ckwDLe'])[3]")
    public WebElement incrementButtonForBathrooms;

    @FindBy(how = How.XPATH,using = "(//button[@class='sc-flUlpA sc-eXuyPJ eEVTIr kTTKRj'])[3]")
    public WebElement decrementButtonForBathrooms;

    @FindBy(how = How.XPATH,using = "//span[@class='sc-fWWYYk fepHIR'][text()='Beach front']")
    public WebElement beachFrontCheckbox;

    @FindBy(how = How.XPATH,using = "//span[@class='sc-fWWYYk fepHIR'][text()='Free WiFi']")
    public WebElement freeWiFiCheckbox;

    @FindBy(how = How.XPATH,using = "//span[@class='sc-fWWYYk fepHIR'][text()='Air conditioning']")
    public WebElement airConditioningCheckbox;

    @FindBy(how = How.XPATH,using = "//span[@class='sc-fWWYYk fepHIR'][text()='Pets allowed']")
    public WebElement petsAllowedCheckbox;

    @FindBy(how = How.XPATH,using = "//span[@class='sc-fWWYYk fepHIR'][text()='Street parking']")
    public WebElement streetParkingCheckbox;

    @FindBy(how = How.XPATH,using = "//span[@class='sc-fWWYYk fepHIR'][text()='Swimming pool']")
    public WebElement swimmingPoolCheckbox;

    @FindBy(how = How.XPATH,using = "//span[@class='sc-fWWYYk fepHIR'][text()='Kitchen']")
    public WebElement kitchenCheckbox;

    @FindBy(how = How.XPATH,using = "//span[@class='sc-fWWYYk fepHIR'][text()='Washing Machine']")
    public WebElement washingMachineCheckbox;

    @FindBy(how = How.XPATH,using = "//span[@class='sc-fWWYYk fepHIR'][text()='Hot tub']")
    public WebElement hotTubCheckbox;

    @FindBy(how = How.XPATH,using = "//span[@class='sc-fWWYYk fepHIR'][text()='Suitable for children']")
    public WebElement suitableForChildrenCheckbox;

    @FindBy(how = How.XPATH,using = "(//div[@class='sc-iNiQyp gsJhBT'])[2]")
    public WebElement allAmenitiesParent;

    @FindBy(how = How.XPATH,using ="//b[text()='Clear all']")
    public WebElement clearAllButton;

    @FindBy(how = How.XPATH,using ="//button[@class='sc-fXgAZx erAkNO']//*[name()='svg']")
    public WebElement closeFilterButton;

    @FindBy(how = How.XPATH,using = "//div[text()='Filters']")
    public WebElement filtersLabel;

    //ToDo: This Input Fields are disabled as of now
    public void selectFromValueOfPrice(){
    }

    //ToDo: This Input Fields are disabled as of now
    public void selectToValueOfPrice(){
    }

    public void selectionOfBedsIncrementByNumberOfTimes(int num){
        for (int i = 0; i <= num; i++) {
            // Validate for Enabled or Disabled
            if(i == 0){
                Assert.assertTrue(incrementButtonForBeds.isEnabled());
                Log.info("validate for enabled button with value " + i);
            }
            else if(i>0 && i<10) {
                Assert.assertTrue(incrementButtonForBeds.isEnabled());
                Log.info("validate for enabled button with value " + i);
            } else if (i>=10) {
                Assert.assertFalse(incrementButtonForBeds.isEnabled());
                Log.info("validate for disabled button with value " + i);
            }
            utility.waitVisibility(driver,incrementButtonForBeds);
            incrementButtonForBeds.click();
        }
    }
    public void selectionOfBedsDecrementByNumberOfTimes(int num){
        for (int i = num; i > 0; i--) {
            // Validate for Enabled or Disabled
            if (i>=1) {
                Assert.assertTrue(decrementButtonForBeds.isEnabled());
            }
            else if(i==0){
                Log.info("validate for disabled button with value " + i);
                Assert.assertFalse(decrementButtonForBeds.isEnabled());
            }
            decrementButtonForBeds.click();
        }
    }
    public void selectionOfBedroomsIncrementByNumberOfTimes(int num){
        for (int i = 0; i <= num; i++) {
            // Validate for Enabled or Disabled
            if(i == 0){
                Assert.assertTrue(incrementButtonForBedrooms.isEnabled());
                Log.info("validate for enabled button with value " + i);
            }
            else if(i>0 && i<10) {
                Assert.assertTrue(incrementButtonForBedrooms.isEnabled());
                Log.info("validate for enabled button with value " + i);
            } else if (i>=10) {
                Assert.assertFalse(incrementButtonForBedrooms.isEnabled());
                Log.info("validate for disabled button with value " + i);
            }
            incrementButtonForBedrooms.click();
        }
    }
    public void selectionOfBedroomsDecrementByNumberOfTimes(int num){

        for (int i = num; i > 0; i--) {
            // Validate for Enabled or Disabled
            if (i>=1) {
                Assert.assertTrue(decrementButtonForBedrooms.isEnabled());
            }
            else if(i==0){
                Log.info("validate for disabled button with value " + i);
                Assert.assertFalse(decrementButtonForBedrooms.isEnabled());
            }
            decrementButtonForBedrooms.click();
        }
    }

    public void selectionOfBathroomsIncrementByNumberOfTimes(int num){
        for (int i = 0; i <= num; i++) {
            // Validate for Enabled or Disabled
            if(i == 0){
                Assert.assertTrue(incrementButtonForBathrooms.isEnabled());
                Log.info("validate for enabled button with value " + i);
            }
            else if(i>0 && i<10) {
                Assert.assertTrue(incrementButtonForBathrooms.isEnabled());
                Log.info("validate for enabled button with value " + i);
            } else if (i>=10) {
                Assert.assertFalse(incrementButtonForBathrooms.isEnabled());
                Log.info("validate for disabled button with value " + i);
            }
            incrementButtonForBathrooms.click();
        }
    }
    public void selectionOfBathroomsDecrementByNumberOfTimes(int num){
        for (int i = num; i > 0; i--) {
            // Validate for Enabled or Disabled
            if (i>=1) {
                Assert.assertTrue(decrementButtonForBathrooms.isEnabled());
            }
            else if(i==0){
                Log.info("validate for disabled button with value " + i);
                Assert.assertFalse(decrementButtonForBathrooms.isEnabled());
            }
            decrementButtonForBathrooms.click();
        }
    }

    public void selectFreeWiFiCheckbox(){
        freeWiFiCheckbox.click();
    }
    public void selectKitchenCheckbox(){
        kitchenCheckbox.click();
    }

    public void selectHotTubCheckboxCheckbox(){
        hotTubCheckbox.click();
    }

    @Step("Select All Amenities Checkboxes")
    public void selectAllCheckbox()
    {
        utility.wait(driver,3);
        int count = 0;
        //collect all items
        List<WebElement> items= allAmenitiesParent.findElements(
                By.xpath("child::div[@class='sc-jffHpj TSsbf']"));

        //Select all checkbox one by one
        for(WebElement item:items)
        {
            if(item.isSelected() == false) {
                item.click();
            }
           utility.wait(driver,3);
            count++;
        }
        System.out.println("Total selected checkbox :: " + count );

        if(kitchenCheckbox.isSelected()==false){selectKitchenCheckbox();}
        if(freeWiFiCheckbox.isSelected()==false){selectFreeWiFiCheckbox();}
        if(hotTubCheckbox.isSelected()==false){selectHotTubCheckboxCheckbox();}
    }

    public void verifyIsAllCheckboxesSelected()
    {
        utility.wait(driver,3);
        int count = 0;
        //collect all items
        List<WebElement> items= allAmenitiesParent.findElements(
                By.xpath("child::div[@class='sc-jffHpj TSsbf']"));

        //Select all checkbox one by one
        for(WebElement item:items)
        {
            Assert.assertTrue(item.isSelected());
            utility.wait(driver,3);
            count++;
        }
        System.out.println("Total isSelected checkbox :: " + count );
    }

    @Step("Deselect All Checkbox")
    public void deselectAllCheckbox()
    {
        utility.wait(driver,3);
        int count = 0;
        //collect all items
        List<WebElement> items= allAmenitiesParent.findElements(
                By.xpath("child::div[@class='sc-jffHpj TSsbf']"));

        //Select all checkbox one by one
        for(WebElement item:items)
        {
            if(item.isSelected() == true) {
                item.click();
                count++;
            }
            utility.wait(driver,3);
        }
        System.out.println("Total deselected checkbox :: " + count );
    }

    public void verifyIsAllCheckboxesDeselected()
    {
        utility.wait(driver,3);
        int count = 0;
        //collect all items
        List<WebElement> items= allAmenitiesParent.findElements(
                By.xpath("child::div[@class='sc-jffHpj TSsbf']"));

        //Select all checkbox one by one
        for(WebElement item:items)
        {
            Assert.assertFalse(item.isSelected());
            utility.wait(driver,3);
            count++;
        }
        System.out.println("Total deselected checkbox :: " + count );
    }

    @Step("ClearAll Fields Selection from Filter Form")
    public void clearAllSelectedInformationInFilterForm(){
        clearAllButton.click();
    }

    @Step("Close Filter Form Page")
    public void closeFilterPage(){
        closeFilterButton.click();
    }

    public FilterPage verifyFilterFormPage(){
        utility.waitVisibility(driver, filtersLabel);
        Assert.assertTrue(filtersLabel.isDisplayed());
        return this;
    }

    //ToDo: As of Now This Fields are Disabled , once it is fixed will change assertions
    public FilterPage verifyPricePlaceholderFields(){
        utility.waitVisibility(driver, filterByPriceFromValue);
        Assert.assertTrue(filterByPriceFromValue.isDisplayed());
        Assert.assertFalse(filterByPriceFromValue.isEnabled());

        utility.waitVisibility(driver, filterByPriceToValue);
        Assert.assertTrue(filterByPriceToValue.isDisplayed());
        Assert.assertFalse(filterByPriceToValue.isEnabled());
        return this;
    }

    public FilterPage verifyRoomsBedsCounts(){
        // For count 0 , Validate decrement field is disabled and increment field is enabled
        Assert.assertTrue(incrementButtonForBeds.isEnabled());
        Assert.assertFalse(decrementButtonForBeds.isEnabled());
        // select and validate the same in increasing and deceasing count
        selectionOfBedsIncrementByNumberOfTimes(10);
        utility.wait(driver,10);
        selectionOfBedsDecrementByNumberOfTimes(10);
        return  this;
    }

    public FilterPage verifyRoomsBedsCountsAtInitialState(){
        // For count 0 , Validate decrement field is disabled and increment field is enabled
        Assert.assertTrue(incrementButtonForBeds.isEnabled());
        Assert.assertFalse(decrementButtonForBeds.isEnabled());
        return  this;
    }

    public FilterPage verifyRoomsBedroomsCounts(){
        // For count 0 , Validate decrement field is disabled and increment field is enabled
        Assert.assertTrue(incrementButtonForBedrooms.isEnabled());
        Assert.assertFalse(decrementButtonForBedrooms.isEnabled());
        // select and validate the same in increasing and deceasing count
        selectionOfBedroomsIncrementByNumberOfTimes(10);
        utility.wait(driver,10);
        selectionOfBedroomsDecrementByNumberOfTimes(10);
        return  this;
    }

    public FilterPage verifyRoomsBedroomsCountsAtInitialState(){
        // For count 0 , Validate decrement field is disabled and increment field is enabled
        Assert.assertTrue(incrementButtonForBedrooms.isEnabled());
        Assert.assertFalse(decrementButtonForBedrooms.isEnabled());
        return  this;
    }

    public FilterPage verifyRoomsBathroomsCounts(){
        // For count 0 , Validate decrement field is disabled and increment field is enabled
        Assert.assertTrue(incrementButtonForBathrooms.isEnabled());
        Assert.assertFalse(decrementButtonForBathrooms.isEnabled());
        // select and validate the same in increasing and deceasing count
        selectionOfBathroomsIncrementByNumberOfTimes(10);
        utility.wait(driver,10);
        selectionOfBathroomsDecrementByNumberOfTimes(10);
        return  this;
    }

    public FilterPage verifyRoomsBathroomsCountsAtInitialState(){
        // For count 0 , Validate decrement field is disabled and increment field is enabled
        Assert.assertTrue(incrementButtonForBathrooms.isEnabled());
        Assert.assertFalse(decrementButtonForBathrooms.isEnabled());

        return  this;
    }

    public FilterPage selectAndVerifyAllAmenitiesCheckboxes(){
        utility.scrollToBottom(driver);
        utility.wait(driver,3);
        selectAllCheckbox();
//        verifyIsAllCheckboxesSelected();
        return this;
    }

    public FilterPage deselectAndVerifyAllAmenitiesCheckboxes(){
        deselectAllCheckbox();
        verifyIsAllCheckboxesDeselected();
        return this;
    }

    public FilterPage clearAllFilterFormFieldsAndValidate(){
        clearAllSelectedInformationInFilterForm();
        utility.wait(driver,3);
        verifyIsAllCheckboxesDeselected();
        verifyRoomsBedsCountsAtInitialState();
        verifyRoomsBedroomsCountsAtInitialState();
        verifyRoomsBathroomsCountsAtInitialState();
        return this;
    }

     public FilterPage selectAndClearAllFilterFormFieldsAndValidate(){
         utility.wait(driver,3);
         selectionOfBathroomsIncrementByNumberOfTimes(3);
         selectionOfBedroomsIncrementByNumberOfTimes(2);
         utility.scrollToSpecificWebElement(driver,filterByPriceFromValue);
         utility.wait(driver,3);
         selectionOfBedsIncrementByNumberOfTimes(1);
         utility.scrollToBottom(driver);
         utility.wait(driver,3);
         selectAllCheckbox();
         clearAllSelectedInformationInFilterForm();
         utility.wait(driver,3);
         verifyIsAllCheckboxesDeselected();
         verifyRoomsBedsCountsAtInitialState();
         verifyRoomsBedroomsCountsAtInitialState();
         verifyRoomsBathroomsCountsAtInitialState();
         return this;
     }
}
