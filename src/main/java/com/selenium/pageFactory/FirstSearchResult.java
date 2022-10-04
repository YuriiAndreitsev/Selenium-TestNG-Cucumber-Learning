package com.selenium.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FirstSearchResult {
    private final WebDriver webDriver;

    public FirstSearchResult(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @FindBy(xpath = "//*[@id=\"srp-river-results\"]/ul/li[2]/div/div[2]/a/div/span")
    private WebElement webElement;

    public String getHeadingOfSearchResult() {
        return webElement.getText();
    }

}
