package filter;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import client.Client;
import util.SqlUtil;

@Provider
public class RequestFilter implements ContainerRequestFilter{
    private static final Logger logger = LogManager.getLogger("service_B");

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        Client.refreshRequestContext();
        SqlUtil.refreshConnection();

        String requestBody = new BufferedReader(new InputStreamReader(requestContext.getEntityStream())).lines()
        .collect(Collectors.joining("\n"));
        
        if(!requestBody.isBlank()){
            logger.trace("\nRequest " + requestBody);
        }

        requestContext.setEntityStream(new ByteArrayInputStream(requestBody.getBytes()));
    }
}
