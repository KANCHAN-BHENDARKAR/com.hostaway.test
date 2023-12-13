package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.TestUtility;
import utilities.logs.Log;

public class SearchPage {
    public RemoteWebDriver driver;

    public TestUtility utility = new TestUtility();

    @FindBy(how = How.XPATH,using = "//button[@class='sc-giAqHp eaGTVv']/child::span[text()='Filter']")
    public WebElement filterButton;

    public SearchPage(RemoteWebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @Step("Opening Filter Form Tab")
    public FilterPage goToFilterFormPage(){
        Log.info("Opening Filter Form Tab");
        utility.waitVisibility(driver, filterButton);
        filterButton.click();
        return new FilterPage(driver);
    }

    public SearchPage verifySearchPage(){
        utility.waitVisibility(driver, filterButton);
        Assert.assertTrue(filterButton.isDisplayed());
        return this;
    }

}
