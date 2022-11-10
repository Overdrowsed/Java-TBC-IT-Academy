package fault;

import javax.xml.ws.WebFault;

@WebFault
public class UserNotFound extends Exception{
    public UserNotFound(){
        super("Requested user doesn't exist in the database");
    }
}
