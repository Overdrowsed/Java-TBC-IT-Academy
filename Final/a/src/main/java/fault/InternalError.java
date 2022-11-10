package fault;

import javax.xml.ws.WebFault;

@WebFault
public class InternalError extends Exception {
    public InternalError(){
        super("Internal error");
    }
}
