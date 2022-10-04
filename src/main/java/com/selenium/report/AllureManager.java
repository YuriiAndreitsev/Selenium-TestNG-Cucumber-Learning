package com.selenium.report;

import com.github.automatedowl.tools.AllureEnvironmentWriter;
import com.google.common.collect.ImmutableMap;

import static com.selenium.config.ConfigurationManager.configuration;

public class AllureManager {

    private AllureManager() {
    }

    public static void setAllureEnvironmentInformation() {
        AllureEnvironmentWriter.allureEnvironmentWriter(
                ImmutableMap.<String, String>builder().
                        put("Test URL", configuration().url()).
                        put("Target execution", configuration().target()).
                        put("Global timeout", String.valueOf(configuration().timeout())).
                        put("Headless mode", String.valueOf(configuration().headless())).
                        put("Faker locale", configuration().faker()).
                        put("Local browser", configuration().browser()).
                        put("Grid URL", configuration().gridUrl()).
                        put("Grid port", configuration().gridPort()).
                        build());
    }

//    @Attachment(value = "Failed test screenshot", type = "image/png")
//    public static byte[] takeScreenshotToAttachOnAllureReport() {
//        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(BYTES);
//    }
//
//    @Attachment(value = "Browser information", type = "text/plain")
//    public static String addBrowserInformationOnAllureReport() {
//        return DriverManager.getInfo();
//    }

}
