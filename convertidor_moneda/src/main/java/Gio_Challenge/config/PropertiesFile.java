package Gio_Challenge.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFile {

    static Properties properties = new Properties();
    static String API_KEY;
    public static void readPropertiesFile(){
        try {
            InputStream input = new FileInputStream("src/main/java/Gio_Challenge/config/config.properties");
            properties.load(input);
            API_KEY = properties.getProperty("API_KEY");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static String getApiKey() {
        return API_KEY;
    }

}
