package homework.client;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpTimeoutException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.Base64;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("unused")
public class TriangleServletClient{
    static Properties properties = new Properties();

    static Logger logger;
    public static void main(String[] args) throws Exception{
        properties.load(new FileInputStream("src/main/resources/http_client.properties"));

        logger = LogManager.getLogger("triangle_servlet_client");
        
        try{
            httpGetPostAsync(12);
        }
        catch(Exception exception){
            logger.error(
                "httpGetPostAsync method threw exception with message {}",
                exception.getMessage()
            );
        }

        try{
            //Intentionally passing an invalid parameter
            httpGetPostAsync(0);
        }
        catch(Exception exception){
            logger.error(
                "httpGetPostAsync method threw exception with message {}",
                exception.getMessage()
            );
        }
    }

    public static void httpGetPostAsync(int perimeter) throws IOException, InterruptedException, ExecutionException{
        String getUrl = properties.getProperty("triangle_servlet_get");
        String postUrl = properties.getProperty("triangle_servlet_post");

        int timeout = Integer.valueOf(properties.getProperty("timeout"));

        String requestedPerimeter = String.valueOf(perimeter);

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        HttpRequest getRequest = HttpRequest.newBuilder().version(HttpClient.Version.HTTP_2)
            .uri(URI.create(getUrl + "p=" + requestedPerimeter)).GET()
            .setHeader("username", "admin")
            .setHeader("password", "admin")
            .header(
                "Authorization",
                "Basic " + Base64.getEncoder().encodeToString(("user:password").getBytes()) 
            )
            .timeout(Duration.ofSeconds(timeout))
        .build();

        HttpRequest postRequest = HttpRequest.newBuilder().version(HttpClient.Version.HTTP_2)
            .uri(URI.create(postUrl)).POST(HttpRequest.BodyPublishers.ofString(
                Files.readString(Path.of("src/main/resources/triangle_post.json"))
            ))
            .setHeader("username", "admin")
            .setHeader("password", "admin")
            .timeout(Duration.ofSeconds(timeout))
        .build();

        logger.info("Sending get and post requests to triangle servlet");
        
        var getFuture = HttpClient.newBuilder().executor(executorService)
        // .authenticator(new Authenticator() {
        //     @Override
        //     protected PasswordAuthentication getPasswordAuthentication(){
        //         return new PasswordAuthentication("user", "password".toCharArray());
        //     }    
        // })
        .build().sendAsync(getRequest, HttpResponse.BodyHandlers.ofString());
            
        var postFuture = HttpClient.newBuilder().executor(executorService).build()
            .sendAsync(postRequest, HttpResponse.BodyHandlers.ofString());
        

        CompletableFuture.allOf(getFuture, postFuture).join();

        var getResponse = getFuture.get();

        int getStatusCode = getResponse.statusCode();

        if(getStatusCode >= 400){
            logger.error(
                "Get request returned status code {}",
                getStatusCode
            );
        }
        else{
            logger.info(
                "Get request returned status code {} with body {}",
                getStatusCode, getResponse.body()
            );
        }
        
        var postResponse = postFuture.get();

        int postStatusCode = postResponse.statusCode();

        if(postStatusCode >= 400){
            logger.error(
                "Post request returned status code {}",
                postStatusCode
            );
        }
        else{
            logger.info(
                "Post request returned status code {}",
                postStatusCode
            );
        }
        
        executorService.shutdown();
    }
}
