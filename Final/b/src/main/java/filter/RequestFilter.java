package filter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;

import client.Client;
import util.SqlUtil;

@Provider
public class RequestFilter implements ContainerRequestFilter{

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        Client.refreshRequestContext();
        SqlUtil.refreshConnection();
    }
}
