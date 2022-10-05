package manager;

import java.io.IOException;
import java.util.stream.Stream;

import javax.naming.AuthenticationException;

import manager.data.ConfigData;

public class IpValidator {
    public static void validate(String clientIp) throws IOException, AuthenticationException{
        ConfigData configData = ConfigManager.refreshIfUpdated().getConfigurationData();

        boolean isValidIp = Stream.of(configData.getAllowedIps())
        .anyMatch(allowedIp -> allowedIp.equals(clientIp));

        if(!isValidIp){
            throw new AuthenticationException();
        }
    }
}
