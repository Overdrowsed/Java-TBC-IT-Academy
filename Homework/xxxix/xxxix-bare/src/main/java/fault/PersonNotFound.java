package fault;

import javax.xml.ws.WebFault;

@WebFault
public class PersonNotFound extends Exception{
    public PersonNotFound(){
        super("Requested person couldn't be found");
    }

    public PersonNotFound(String message){
        super(message);
    }
}
