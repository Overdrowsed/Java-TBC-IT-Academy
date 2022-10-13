package fault;

import javax.xml.ws.WebFault;

@WebFault
public class ClientUnauthorized extends Exception{
    public ClientUnauthorized(){
        super("Unauthorized client ip");
    }

    public ClientUnauthorized(String message){
        super(message);
    }
}
