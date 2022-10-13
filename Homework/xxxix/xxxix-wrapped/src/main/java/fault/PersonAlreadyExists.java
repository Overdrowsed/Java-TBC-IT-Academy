package fault;

import javax.xml.ws.WebFault;

@WebFault
public class PersonAlreadyExists extends Exception{
    public PersonAlreadyExists(){
        super("Person already exists");
    }

    public PersonAlreadyExists(String message){
        super(message);
    }
}
