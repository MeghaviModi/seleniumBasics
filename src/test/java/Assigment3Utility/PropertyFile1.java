package Assigment3Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertyFile1 {
    public static String  getPropertyValue(String propFileName, String key) throws FileNotFoundException {
        try(FileInputStream fis1=new FileInputStream("data/"+propFileName+".properties")){
            Properties p= new Properties();
            p.load(fis1);
            return p.getProperty(key);
        }catch (Exception t){
            t.printStackTrace();
        }
        return null;
    }
}
