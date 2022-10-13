package fault;

import javax.xml.ws.WebFault;

@WebFault
public class GeneralError extends Exception{
    public GeneralError(){
        super("Internal error occured");
    }

    public GeneralError(String message){
        super(message);
    }
}
