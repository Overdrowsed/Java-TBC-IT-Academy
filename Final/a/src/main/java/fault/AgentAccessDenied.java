package fault;

import javax.xml.ws.WebFault;

@WebFault
public class AgentAccessDenied extends Exception{
    public AgentAccessDenied(){
        super("Unauthorized agent ip");
    }
}
