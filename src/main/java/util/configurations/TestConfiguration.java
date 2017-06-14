package util.configurations;

import com.codeborne.selenide.Configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class TestConfiguration extends Properties {

    public String defaultUserName;
    public String defaultUserPassword;
    public String defaultUserEmail;

    public TestConfiguration() {
        InputStream is = null;
        Properties properties = new Properties();

        try {
            is = new FileInputStream("src/main/resources/properties.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

        init(properties);
    }

    private void init(Properties properties) {
        Configuration.browser = properties.getProperty("browser");
        Configuration.baseUrl = properties.getProperty("baseUrl");
        Configuration.timeout = Long.parseLong(properties.getProperty("timeout"));
        Configuration.startMaximized = Boolean.parseBoolean(properties.getProperty("startMaximized"));
        Configuration.reportsFolder = properties.getProperty("reportsFolder");

        defaultUserName = properties.getProperty("defaultUserName");
        defaultUserPassword = properties.getProperty("defaultUserPassword");
        defaultUserEmail = properties.getProperty("defaultUserEmail");
    }

}
