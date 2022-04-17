package config;

import org.aeonbits.owner.ConfigFactory;

public class Project {

    public static WebDriverConfig webConfig = (WebDriverConfig) ConfigFactory.create(WebDriverConfig.class, System.getProperties());

    public static boolean isWebMobile() {
        return !webConfig.browserMobileView().equals("");
    }

    public static boolean isRemoteWebDriver() {
        return !webConfig.remoteDriverUrl().equals("");
    }

    public static boolean isVideoOn() {
        return !webConfig.videoStorage().equals("");
    }
}
