package tests;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.AllListingPropertiesPage;
import pages.FilterPage;
import pages.HomePage;
import pages.SearchPage;
import utilities.PropertiesFileUtility;

public class BaseTest {

    public RemoteWebDriver driver;
    public HomePage homePage;
    public SearchPage searchPage;
    public FilterPage filterPage;

    public AllListingPropertiesPage allListingPropertiesPage;

    @BeforeClass
    public  RemoteWebDriver openBrowser()
    {
        String browsername = PropertiesFileUtility.getValueFromConfigPropertiesFile("browsername");
        if(browsername.equalsIgnoreCase("chrome"))
        {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
            driver = new ChromeDriver(chromeOptions);
        }
        else if(browsername.equalsIgnoreCase("firefox"))
        {
            driver=new FirefoxDriver();
        }
        else if(browsername.equalsIgnoreCase("edge"))
        {
            driver=new EdgeDriver();
        }
        else
        {
            //Set IE browser zoom level to 100% manually
            //System.setProperty("webdriver.ie.driver","path of iedriverserver.exe software");
            driver=new InternetExplorerDriver();
        }
        return(driver);
    }

    @AfterClass
    public void closeSite()
    {
        driver.quit();
    }

    @BeforeMethod
    public void pageInstanceProvider(){
        homePage = new HomePage(driver);
        searchPage= new SearchPage(driver);
        filterPage = new FilterPage(driver);
         allListingPropertiesPage = new AllListingPropertiesPage(driver);
    }
}
