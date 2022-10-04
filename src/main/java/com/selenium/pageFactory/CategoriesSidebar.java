package com.selenium.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CategoriesSidebar {
    private final WebDriver webDriver;

    public CategoriesSidebar(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @FindBy(css = "#wrapper > div.page-content > div > div > div:nth-child(2) > div.all-categories-left-nav-container")
    private WebElement categoriesSidebar;
}
