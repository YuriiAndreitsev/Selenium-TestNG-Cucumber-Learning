package com.selenium.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectCategoryDropdownButton {
    private WebDriver webDriver;

    public SelectCategoryDropdownButton(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @FindBy(css = "#gh-shop-a")
    private WebElement selectDropdownButton;

    public SelectCategoryDropdownButton clickSelectDropdownButton(){
        selectDropdownButton.click();
        return this;
    }
}
