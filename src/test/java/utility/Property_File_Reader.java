package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class Property_File_Reader {
    public static String  getPropertyValue(String propFileName, String key) throws FileNotFoundException {
        try(FileInputStream fis=new FileInputStream("data/"+propFileName+".properties")){
            Properties p= new Properties();
            p.load(fis);
            return p.getProperty(key);
        }catch (Exception t){
            t.printStackTrace();
        }
       return null;
    }
}
