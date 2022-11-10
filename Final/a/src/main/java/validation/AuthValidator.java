package validation;

import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import beans.Agent;
import fault.AgentAccessDenied;
import fault.AgentAuthFailed;
import fault.InternalError;
import util.SqlUtil;

public class AuthValidator {

    private static final Logger logger = LogManager.getLogger("service_A");

    public static void validate(WebServiceContext context) throws AgentAuthFailed, AgentAccessDenied, InternalError{
        HttpServletRequest httpServletRequest = ((HttpServletRequest)context.getMessageContext().get(MessageContext.SERVLET_REQUEST));
        
        String id = httpServletRequest.getHeader("agent");
        String password = httpServletRequest.getHeader("pass");

        String ip = httpServletRequest.getRemoteAddr();

        logger.trace("Request: agent_id: {}, password: {}, ip: {}", id, password, ip);

        try{
            password = new String(Base64.getDecoder().decode(password));
        }
        catch(IllegalArgumentException exception){
            throw new AgentAuthFailed();
        }

        if(id == null || password == null){
            logger.error("Unauthorized/non-existent agent");

            throw new AgentAuthFailed();
        }

        Agent requestAgent = new Agent(
            Integer.valueOf(id),
            password
        );

        Agent agent = SqlUtil.getAgent(requestAgent.getId());
        
        if(!agent.equals(requestAgent)){
            logger.error("Unauthorized/non-existent agent");

            throw new AgentAuthFailed();
        }

        List<String> allowedIps = SqlUtil.getAllowedIps(requestAgent.getId());

        if(!allowedIps.contains(ip)){
            logger.error("Unauthorized agent ip");

            throw new AgentAccessDenied();
        }
    }
}
