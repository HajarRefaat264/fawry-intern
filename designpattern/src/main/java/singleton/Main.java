package singleton;

public class Main {
    public static void main(String[] args) {
        // Access the ConfigurationManager instance
        ConfigurationManager configManager = ConfigurationManager.getInstance();

        // Use the configuration manager to get and set settings
        String settingValue = configManager.getSetting("mySetting");
        System.out.println("Setting value: " + settingValue);

        configManager.setSetting("anotherSetting", "New Value");
    }
}
