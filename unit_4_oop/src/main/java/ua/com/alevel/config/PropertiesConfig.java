package ua.com.alevel.config;

public enum PropertiesConfig {

    APPLICATION_PROPERTIES("application.properties");

    private final String properties;

    PropertiesConfig(String properties) {
        this.properties = properties;
    }

    public String getProperties() {
        return properties;
    }
}
