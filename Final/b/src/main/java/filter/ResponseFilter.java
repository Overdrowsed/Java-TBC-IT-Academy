package filter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import util.JsonUtil;

public class ResponseFilter implements ContainerResponseFilter{
    private static final Logger logger = LogManager.getLogger("service_B");

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        if(responseContext.hasEntity()){
            logger.trace("\nResponse: " + JsonUtil.toJson(responseContext.getEntity()));
        }
    }
}
