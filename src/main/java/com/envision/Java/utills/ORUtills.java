package com.envision.Java.utills;

import java.io.IOException;
import java.util.Properties;

public class ORUtills {
    static Properties ORProperties;
    public static void loadORFiles() throws IOException {
        ORProperties= PropertiesLoader.loadPropertiesFile(System.getProperty("user.dir")
                +"/src/main/resources/OR.Properties");
    }
    public static String getORPropertyValue(String ORPropertyName){
        return PropertiesLoader.getPropertyValue(ORPropertyName,ORProperties);
    }
}
