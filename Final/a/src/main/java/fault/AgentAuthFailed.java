package fault;

import javax.xml.ws.WebFault;

@WebFault
public class AgentAuthFailed extends Exception{
    public AgentAuthFailed(){
        super("Unauthorized/non-existent agent");
    }
}
