package GUI;

import java.util.HashMap;
import java.util.Map;

public class PropertiesManager {

    private static Map<String, Boolean> properties;

    public void init() {
        properties = new HashMap<>();
        properties.put("del", false);
        properties.put("dup", false);
        properties.put("ins", false);
        properties.put("inv", false);
        properties.put(">", false);
        properties.put("t", false);
    }

    public Map<String, Boolean> getProperties() {
        return properties;
    }

    @SuppressWarnings("ConstantConditions")
    public void enableDeletions() {
            properties.replace("del", true);
    }

    @SuppressWarnings("ConstantConditions")
    public void disableDeletions() {
        properties.replace("del", false);
    }

    @SuppressWarnings("ConstantConditions")
    public void enableDuplications() {
        properties.replace("dup", true);
    }

    @SuppressWarnings("ConstantConditions")
    public void disableDuplications() {
        properties.replace("dup", false);
    }

    @SuppressWarnings("ConstantConditions")
    public void enableInsertions() {
        properties.replace("ins", true);
    }

    @SuppressWarnings("ConstantConditions")
    public void disableInsertions() {
        properties.replace("ins", false);
    }

    @SuppressWarnings("ConstantConditions")
    public void enableInversions() {
        properties.replace("inv", true);
    }

    @SuppressWarnings("ConstantConditions")
    public void disableInversions() {
        properties.replace("inv", false);
    }

    @SuppressWarnings("ConstantConditions")
    public void enableSubstitutions() {
        properties.replace(">", true);
    }

    @SuppressWarnings("ConstantConditions")
    public void disableSubstitutions() {
        properties.replace(">", false);
    }

    @SuppressWarnings("ConstantConditions")
    public boolean enableTranslocations() {
        return properties.replace("t", true);
    }

    @SuppressWarnings("ConstantConditions")
    public boolean disableTranslocations() {
        return properties.replace("t", false);
    }

    public void clearProperties() {
        properties.clear();
    }
}
