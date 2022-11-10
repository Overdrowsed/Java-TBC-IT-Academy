package util;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sun.xml.ws.client.BindingProviderProperties;

import jakarta.xml.ws.BindingProvider;
import jakarta.xml.ws.handler.MessageContext;
import manager.ConfigManager;
import manager.data.ConfigData;

public class BindingUtil {
    public static void configureRequestContext(BindingProvider bindingProvider) throws IOException{
        var requestContext = bindingProvider.getRequestContext();
        
        ConfigData configData = ConfigManager.refreshIfUpdated().getConfigurationData();

        requestContext.put(
            BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
            configData.getUrl()
        );
        
        requestContext.put(
            BindingProviderProperties.REQUEST_TIMEOUT,
            configData.getTimeout()
        );

        requestContext.put(
            BindingProviderProperties.CONNECT_TIMEOUT,
            configData.getTimeout()
        );

        Map<String, List<String>> requestHeaders = new HashMap<>(){
            {
                put("agent", Arrays.asList(configData.getAgentId()));
                put("pass", Arrays.asList(configData.getPassword()));
            }
        };

        requestContext.put(MessageContext.HTTP_REQUEST_HEADERS, requestHeaders);
    }
}