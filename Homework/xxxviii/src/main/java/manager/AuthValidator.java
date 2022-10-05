package manager;

import java.io.IOException;

import javax.naming.AuthenticationException;

import manager.data.ConfigData;

public class AuthValidator {
    public static void validate(String inputUsername, String inputPassword) throws IOException, AuthenticationException{
        ConfigData configData = ConfigManager.refreshIfUpdated().getConfigurationData();

        String username = configData.getUsername();
        String password = configData.getPassword();
        
        if(!(username.equals(inputUsername) && password.equals(inputPassword))) {
            throw new AuthenticationException();
        }
    }
}
