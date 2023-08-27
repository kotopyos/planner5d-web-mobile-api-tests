package configs;


import org.aeonbits.owner.Config.Sources;

@Sources({"classpath:config/api/api.properties"})

public interface ConfigApi extends org.aeonbits.owner.Config {

    @Key("baseApiUrl")
    String getBaseApiUrl();

}
