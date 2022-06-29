import java.io.FileInputStream;
import java.util.Properties;
import java.util.regex.Pattern;

public class UserValidation {
    
    public static void main(String[] args) throws Exception{
        Properties properties = new Properties();

        properties.load(new FileInputStream("lib/users.properties"));

        properties.forEach(
            (credential, value) -> System.out.println(validate(credential.toString(), value.toString()))
        );
    }

    static boolean validate (String credential, String value){
        String user = credential.split("\\.")[0];
        credential = credential.split("\\.")[1];
        value = value.trim();
        
        if(credential.equals("username")){
            if(validateUsername(value))
                return true;
            
            throw new RuntimeException("Invalid username for user " + user);
        }
        else{
            if(validatePassword(value))
                return true;
            
            throw new RuntimeException("Invalid password for user " + user);
        }
    }

    static boolean validateUsername(String username){
        return !Pattern.compile("\\W").matcher(username).find()
            && Pattern.compile("^.{5,20}$").matcher(username).find();
    }

    static boolean validatePassword(String password){
        return Pattern.compile("[a-z]").matcher(password).find()
            && Pattern.compile("[A-Z]").matcher(password).find()
            && Pattern.compile("\\W").matcher(password).find()
            && Pattern.compile("^.{7,}").matcher(password).find();
    }
}