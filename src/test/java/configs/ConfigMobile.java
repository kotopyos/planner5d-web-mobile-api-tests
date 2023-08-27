package configs;


import org.aeonbits.owner.Config.Sources;

@Sources({"classpath:config/mobile/${env}.properties"})

public interface ConfigMobile extends org.aeonbits.owner.Config {

    @Key("remote")
    String getRemote();

    @Key("login")
    String getLogin();

    @Key("password")
    String getPassword();

    @Key("appUrl")
    String getAppUrl();

    @Key("device")
    String getDevice();

    @Key("os_version")
    String getOsVersion();

    @Key("project")
    String getProjectName();

    @Key("build")
    String getBuildName();

    @Key("name")
    String getTestName();

}
