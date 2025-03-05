package com.testwebsite.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesManager {

    public static Properties webConfig ;

    public static void intializeConfig(){
        try {
            FileInputStream webConfigFile = null;
            webConfigFile =new FileInputStream("src/main/resources/WebConfigurations.properties");

            webConfig = new Properties();
            webConfig.load(webConfigFile);
        }

        catch (FileNotFoundException e){
            LoggerUtil.error("File Not Found , Ensure that the file loaded " + e.getMessage());
        }
        catch (IOException e){
            LoggerUtil.error(e.getMessage());
        }
    }
}
