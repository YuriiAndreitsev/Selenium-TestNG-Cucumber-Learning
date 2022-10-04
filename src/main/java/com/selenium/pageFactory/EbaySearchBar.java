package com.selenium.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EbaySearchBar {
    private WebDriver webDriver;

    public EbaySearchBar(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @FindBy(id = "gh-ac")
    private WebElement searchInput;
    @FindBy(id = "gh-btn")
    private WebElement searchButton;

    public EbaySearchBar sendSearchBarKeys(String searchText) {
        searchInput.sendKeys(searchText);
        return this;
    }

    public void clickSearch() {
        searchButton.click();
    }
}
