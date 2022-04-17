package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties"
})
public interface WebDriverConfig extends Config {


    String browser();
    String browserVersion();
    String browserSize();
    String browserMobileView();
    String remoteDriverUrl();
    String videoStorage();
    String timeout();
}

