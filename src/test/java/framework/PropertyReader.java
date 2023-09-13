package framework;

import java.io.IOException;

public class PropertyReader {

    public static String getProperties(String value) throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("config.properties"));
        return System.getProperty(value);
    }
}