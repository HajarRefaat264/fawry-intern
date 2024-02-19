package singleton;

public class ConfigurationManager {
    private static ConfigurationManager instance;

    // Private constructor to prevent instantiation
    private ConfigurationManager() {
        // Initialize configuration settings here
    }

    // Lazy initialization with double-check locking for thread safety
    public static ConfigurationManager getInstance() {
        if (instance == null) {
            synchronized (ConfigurationManager.class) {
                if (instance == null) {
                    instance = new ConfigurationManager();
                }
            }
        }
        return instance;
    }

    // Methods to get and set configuration settings
    public String getSetting(String key) {
        // Implementation to get the value of a configuration setting
        return "Value for " + key;
    }

    public void setSetting(String key, String value) {
        // Implementation to set the value of a configuration setting
        System.out.println("Setting " + key + " to " + value);
    }
}
