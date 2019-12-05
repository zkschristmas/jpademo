package cn.yoursky.jpademo.configuration;

import lombok.Data;

import java.util.Locale;
import java.util.ResourceBundle;

@Data
public class PropertiesUtil {
    private ResourceBundle resource;
    private String fileName;

    public PropertiesUtil(String fileName) {
        this.fileName = fileName;
        Locale locale = new Locale("zk", "CN");
        this.resource = ResourceBundle.getBundle(fileName, locale);
    }

    public String getValue(String key) {
        return resource.getString(key);
    }
}
