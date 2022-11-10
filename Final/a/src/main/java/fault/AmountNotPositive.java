package fault;

import javax.xml.ws.WebFault;

@WebFault
public class AmountNotPositive extends Exception {
    public AmountNotPositive(){
        super("Transaction amount must be a positive number");
    }
}
