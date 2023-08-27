package configs;


import org.aeonbits.owner.Config.Sources;

@Sources({"classpath:config/web/${env}.properties"})

public interface ConfigWeb extends org.aeonbits.owner.Config {

    @Key("browser")
    String getBrowser();

    @Key("baseUrl")
    String getBaseUrl();

    @Key("browserVersion")
    String getBrowserVersion();

    @Key("browserSize")
    String getBrowserSize();

    @Key("remote")
    String getRemote();

}
