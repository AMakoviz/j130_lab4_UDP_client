package org.example;

import java.util.Properties;

public class AppProperties {

    private Properties properties;
    public AppProperties(String host, String port) {
        properties = new Properties();
        properties.put("host", host);
        properties.put("port", port);
    }

    public String getHost() {
        if (properties != null) {
            return properties.getProperty("host");
        } else {
            throw new NullPointerException();
        }
    }

    public int getPort() {
        if (properties != null) {
            return Integer.parseInt(properties.getProperty("port"));
        } else {
            throw new NullPointerException();
        }
    }
}
