package manager;

import java.io.IOException;

import fault.ClientUnauthorized;
import manager.data.AuthData;
import manager.data.ConfigData;

public class AuthValidator {
    public static void validate(AuthData auth) throws ClientUnauthorized, IOException{
        ConfigData data = ConfigManager.refreshIfUpdated().getConfigurationData();

        String username = data.getUsername();
        String password = data.getPassword();
        
        if(!(auth.getUsername().equals(username) && auth.getPassword().equals(password))){
            throw new ClientUnauthorized("Invalid username/password");
        }
    }
}
