package fault;

import javax.xml.ws.WebFault;

@WebFault
public class TransactionNotFound extends Exception{
    public TransactionNotFound(){
        super("Transaction not found");
    }
}
