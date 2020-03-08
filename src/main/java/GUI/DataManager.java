package GUI;

import buisness.EncoderImpl;

import java.io.File;
import java.util.Map;

public class DataManager {

    private PropertiesManager propertiesManager;
    private Map<String, Boolean> properties;
    private EncoderImpl encoder;
    private static File file;

    public DataManager() {}

    public DataManager(EncoderImpl encoder, PropertiesManager propertiesManager) {
        this.encoder = encoder;
        this.propertiesManager = propertiesManager;
        this.properties = getPropertiesFromManager();
    }

    private Map<String, Boolean> getPropertiesFromManager() {
        return propertiesManager.getProperties();
    }

    public static void setFile(File file) {
        DataManager.file = file;
    }

    public static File getFile() {
        return DataManager.file;
    }

}
