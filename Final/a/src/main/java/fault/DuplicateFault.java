package fault;

import javax.xml.ws.WebFault;

@WebFault
public class DuplicateFault extends Exception {
    public DuplicateFault(){
        super("Duplicate transaction");
    }
}
