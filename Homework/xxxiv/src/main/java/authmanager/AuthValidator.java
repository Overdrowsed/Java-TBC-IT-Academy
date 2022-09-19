package authmanager;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import config.ConfigManager;

public class AuthValidator {
    public static boolean validate(HttpServletRequest request, HttpServletResponse response) throws IOException{
        AuthData authData = ConfigManager.getConfiguration().getAuthenticationData();

        String inputUsername = request.getHeader("username");
        String inputPassword = request.getHeader("password");
        
        if(!(authData.getUsername().equals(inputUsername) && authData.getPassword().equals(inputPassword))) {
            response.sendError(401, "Incorrect username/password");
            return false;
        }

        return true;
    }
}
