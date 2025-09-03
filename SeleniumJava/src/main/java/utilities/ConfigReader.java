package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	Properties properties=new Properties();
	FileInputStream fi;
	
	public ConfigReader(String path) {
		try {
			fi=new FileInputStream(path);
			properties.load(fi);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getValue(String key) {
		return properties.getProperty(key);
	}
}
