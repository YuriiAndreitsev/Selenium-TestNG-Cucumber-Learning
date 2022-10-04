package com.selenium.driver;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static com.selenium.config.ConfigurationManager.configuration;

public class TargetFactory {
    public WebDriver createInstance(String browser) {
        Target target = Target.valueOf(configuration().target().toUpperCase());
        WebDriver remoteInstance = null;
        switch (target) {
            case LOCAL:
                remoteInstance = BrowserFactory.valueOf(browser.toUpperCase()).createDriver();
                break;
            case REMOTE:
                remoteInstance = createRemoteInstance(BrowserFactory.valueOf(browser.toUpperCase()).getOptions());
                break;
        }
        return remoteInstance;
    }

    private WebDriver createRemoteInstance(MutableCapabilities capability) {
        WebDriver remoteWebDriver = null;
        try {
            String gridURL = String.format("http://%s:%s/wd/hub", configuration().gridUrl(), configuration().gridPort());
            remoteWebDriver = new RemoteWebDriver(new URL(gridURL), capability);
        } catch (MalformedURLException | IllegalArgumentException e) {
            e.printStackTrace();
        }
        return remoteWebDriver;
    }

    enum Target {
        LOCAL, REMOTE
    }
}
