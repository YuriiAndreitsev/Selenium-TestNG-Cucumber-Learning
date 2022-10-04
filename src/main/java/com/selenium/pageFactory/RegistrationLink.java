package com.selenium.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationLink {
    private WebDriver webDriver;

    public RegistrationLink(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @FindBy(css = "#gh-ug-flex > a")
    private WebElement registrationLink;

    public void click(){
        registrationLink.click();
    }
}
