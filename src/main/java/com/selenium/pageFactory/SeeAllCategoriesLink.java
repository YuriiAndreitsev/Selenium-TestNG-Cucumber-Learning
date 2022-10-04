package com.selenium.pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeeAllCategoriesLink {
    private final WebDriver webDriver;

    public SeeAllCategoriesLink(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @FindBy(css = "#gh-shop-see-all")
    private WebElement seeAllCategoriesLink;

    public SeeAllCategoriesLink clickSeeAllCategoriesLink() {
        seeAllCategoriesLink.click();
        return this;
    }

    public WebElement waitUntilResultShows(WebDriverWait wait) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("#wrapper > div.page-content > div > div > div:nth-child(2) > div.all-categories-left-nav-container")));
    }
}
