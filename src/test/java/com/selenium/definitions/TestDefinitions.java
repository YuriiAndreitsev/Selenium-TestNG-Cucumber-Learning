package com.selenium.definitions;

import com.selenium.driver.DriverManager;
import com.selenium.driver.TargetFactory;
import com.selenium.pageFactory.EbaySearchBar;
import com.selenium.pageFactory.FirstSearchResult;
import com.selenium.pageFactory.SeeAllCategoriesLink;
import com.selenium.pageFactory.SelectCategoryDropdownButton;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static com.selenium.config.ConfigurationManager.configuration;
import static com.selenium.driver.DriverManager.waitForSeconds;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

public class TestDefinitions {
    private WebDriver webDriver;

    @Given("SetupEnv with browser")
    public void setupenv() {
        WebDriver driver = new TargetFactory().createInstance(configuration().browser());
        DriverManager.setDriver(driver);
    }

    @Given("Launch the browser")
    public void launchTheBrowser() {
        webDriver = DriverManager.getDriver();
    }

    @When("Open ebay")
    public void openGoogleComSite() {
        webDriver.navigate().to(configuration().url());
    }

    @Then("Enter {string} in the search text box")
    public void enterInTheSearchTextBox(String searchText) {
        PageFactory.initElements(webDriver, EbaySearchBar.class).sendSearchBarKeys(searchText).clickSearch();
    }

    @Then("verify result contains {string}")
    public void verifyResultContainsHttpsCucumberIo(String desiredSearch) {
        String headingOfSearchResult = PageFactory.initElements(webDriver, FirstSearchResult.class).getHeadingOfSearchResult();
        assertTrue(headingOfSearchResult.toLowerCase().contains(desiredSearch.toLowerCase().trim()));
    }

    @Then("Close Browser")
    public void closeBrowser() {
        webDriver.quit();
    }

    @Then("Click on Shop by category dropdown")
    public void clickOnShopByCategoryDropdown() {
        PageFactory.initElements(webDriver, SelectCategoryDropdownButton.class).clickSelectDropdownButton();
    }

    @Then("Select See All Categories")
    public void selectSeeAllCategories() {
        WebElement categoriesSidebar = PageFactory.initElements(webDriver, SeeAllCategoriesLink.class).clickSeeAllCategoriesLink()
                .waitUntilResultShows(waitForSeconds(webDriver, 3));
        assertNotNull(categoriesSidebar);
    }
}
