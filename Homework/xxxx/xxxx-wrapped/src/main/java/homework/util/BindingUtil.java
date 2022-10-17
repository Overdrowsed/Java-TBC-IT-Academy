package homework.util;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Properties;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import com.sun.xml.ws.client.BindingProviderProperties;

import homework.handler.SoapHandler;
import jakarta.xml.ws.Binding;
import jakarta.xml.ws.BindingProvider;

public class BindingUtil {
    public static void configureRequestContext(BindingProvider bindingProvider) throws IOException{
        var requestContext = bindingProvider.getRequestContext();
        
        Properties properties = new Properties();

        properties.load(
            BindingUtil.class.getClassLoader().getResourceAsStream("client.properties")
        );

        requestContext.put(
            BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
            properties.getProperty("url")
        );
        
        requestContext.put(
            BindingProviderProperties.REQUEST_TIMEOUT,
            Integer.valueOf(properties.getProperty("timeout"))
        );

        requestContext.put(
            BindingProviderProperties.CONNECT_TIMEOUT,
            Integer.valueOf(properties.getProperty("timeout"))
        );

        requestContext.put(
            BindingProviderProperties.SSL_SOCKET_FACTORY,
            getUnsecureSSLContext().getSocketFactory()
        );

            requestContext.put(
            BindingProviderProperties.HOSTNAME_VERIFIER,
            getHostnameVerifier()
        );
    }

    public static void configureHandler(BindingProvider bindingProvider) {
        Binding binding = bindingProvider.getBinding();

        var handlerList = binding.getHandlerChain();

        if (handlerList == null) {
            handlerList = new ArrayList<>();
        }

        handlerList.add(new SoapHandler());
        
        binding.setHandlerChain(handlerList);
    }

    private static SSLContext getUnsecureSSLContext() {
        TrustManager[] trustStore = new TrustManager[] { new X509TrustManager() {
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return null;
            }

            public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
            }

            public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {
            }
        } };

        try {
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustStore, new SecureRandom());
            return sc;
        } catch (KeyManagementException | NoSuchAlgorithmException ex) {
            return null;
        }
    }
    
    private static HostnameVerifier getHostnameVerifier() {
        return new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession sslSession) {
                return true;
            }
        };
    }
}
