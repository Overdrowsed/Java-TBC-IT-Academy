package fault;

import javax.xml.ws.WebFault;

@WebFault
public class AccessForbidden extends Exception{
    public AccessForbidden(){
        super("Unauthorized client ip");
    }

    public AccessForbidden(String message){
        super(message);
    }
}
