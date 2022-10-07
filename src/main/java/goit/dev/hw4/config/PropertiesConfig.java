package goit.dev.hw4.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesConfig {
    public Properties load (String configFilePath){
        try(InputStream stream = getClass().getClassLoader().getResourceAsStream(configFilePath);) {
            Properties properties = new Properties();
            properties.load(stream);
            return properties;
        } catch(IOException ioe) {
            throw new RuntimeException("Can`t load properties");
        }
    }
}
