package config;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import authmanager.AuthData;
import resource.ResourcePath;

public class ConfigManager {
    private static Logger logger = LogManager.getLogger();


    private static final String CONFIG_FILE = "config.properties";

    private volatile static ConfigManager singleton = null;

    protected long lastModified;

    private static URL url = null;

    private AuthData authenticationData;
    private ResourcePath resourcePath;

    private ConfigManager(URLConnection connection) throws IOException {
        this.lastModified = connection.getLastModified();
        
        try (InputStream connectionStream = connection.getInputStream()){
            Properties properties = new Properties();
            properties.load(connection.getInputStream());

            fillAuthData(properties);
            fillResourcePathData(properties);
        }
    }

    public static ConfigManager getConfiguration() throws IOException {
        if (url == null) {
            url = ConfigManager.class.getClassLoader().getResource(CONFIG_FILE);
        }
        if (url == null) {
            throw new IOException("Configuration file not found");
        }
        
        URLConnection connection = url.openConnection();
        
        long lastModified = connection.getLastModified();

        if (singleton == null || lastModified > singleton.lastModified) {
            synchronized (CONFIG_FILE) {
                if (singleton == null || lastModified > singleton.lastModified) {
                    logger.info("Updating configuration");
                    singleton = new ConfigManager(connection);
                }
            }
        }
        
        return singleton;
    }

    private void fillAuthData(Properties properties){
        authenticationData = new AuthData();

        authenticationData.setUsername(properties.getProperty("username"));
        authenticationData.setPassword(properties.getProperty("password"));
    }

    private void fillResourcePathData(Properties properties){
        resourcePath = new ResourcePath();

        resourcePath.setDatabasePath(properties.getProperty("rectangle_data"));
    }

    public AuthData getAuthenticationData(){
        return authenticationData;
    }

    public ResourcePath getResourcePath(){
        return resourcePath;
    }
}
