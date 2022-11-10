package manager;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import manager.data.ConfigData;

public class ConfigManager {
    private static Logger logger = LogManager.getLogger("service_B");

    private static final String CONFIG_FILE = "service_b.properties";

    private volatile static ConfigManager singleton = null;

    protected long lastModified;

    private static URL url = null;

    private ConfigData configData;

    private ConfigManager(URLConnection connection) throws IOException {
        this.lastModified = connection.getLastModified();
        
        try (InputStream connectionStream = connection.getInputStream()){
            Properties properties = new Properties();
            properties.load(connectionStream);

            fillConfigData(properties);
        }
    }
    
    public static ConfigManager refreshIfUpdated() throws IOException {
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

    private void fillConfigData(Properties properties){
        configData = new ConfigData();

        configData.setAgentId(properties.getProperty("agent_id"));
        configData.setPassword(properties.getProperty("password"));
        configData.setUrl(properties.getProperty("url"));
        configData.setTimeout(Integer.valueOf(properties.getProperty("timeout")));
    }

    public ConfigData getConfigurationData(){
        return configData;
    }
}
