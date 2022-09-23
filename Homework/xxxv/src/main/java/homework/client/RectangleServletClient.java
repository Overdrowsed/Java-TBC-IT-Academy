package homework.client;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RectangleServletClient {
    static Properties properties = new Properties();

    static Logger logger;
    public static void main(String[] args) throws Exception{
        properties.load(new FileInputStream("src/main/resources/http_client.properties"));

        logger = LogManager.getLogger("rectangle_servlet_client");

        try{
            getRectangleWithArea(12);
        }
        catch(Exception exception){
            logger.error(
                exception.getMessage()
            );
        }

        try{
            //Intentionally sending an invalid parameter
            getRectangleWithArea(-1);
        }
        catch(Exception exception){
            logger.error(
                exception.getMessage()
            );
        }
        
        try{
            addRectangle();
        }
        catch(Exception exception){
            logger.error(
                exception.getMessage()
            );
        }
    }

    public static void getRectangleWithArea(int area) throws MalformedURLException, IOException{
        String url = properties.getProperty("rectangle_servlet_get");

        int timeout = Integer.valueOf(properties.getProperty("timeout"));

        String requestedArea = String.valueOf(area);

        logger.info("Establishing connection to get request...");

        HttpURLConnection connection = (HttpURLConnection) new URL(url + "s=" + requestedArea).openConnection();

        connection.setRequestProperty("username", "admin");
        connection.setRequestProperty("password", "admin");

        connection.setConnectTimeout(timeout * 1000);
        connection.setReadTimeout(timeout * 1000);

        BufferedReader responseBuffer = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        String inputLine = "";
        StringBuilder responseBody = new StringBuilder();

        while ((inputLine = responseBuffer.readLine()) != null) {
            responseBody.append(inputLine);
        }

        if(connection.getResponseCode() >= 400){
            logger.error(
                "Get request returned error code {}",
                connection.getResponseCode()
            );
        }
        else{
            logger.info(
                "Get request responded with status code {} and body {}",
                connection.getResponseCode(), responseBody.toString()
            );
        }
    }

    public static void addRectangle() throws MalformedURLException, IOException{
        String url = properties.getProperty("rectangle_servlet_post");

        int timeout = Integer.valueOf(properties.getProperty("timeout"));

        logger.info("Establishing connection to post request...");

        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();

        connection.setRequestProperty("username", "admin");
        connection.setRequestProperty("password", "admin");

        connection.setConnectTimeout(timeout * 1000);
        connection.setReadTimeout(timeout * 1000);

        connection.setDoOutput(true);

        try(OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream())){
            out.write(Files.readString(Path.of("src/main/resources/rectangle_post.xml")));
        }

        if(connection.getResponseCode() >= 400){
            logger.error(
                "Post request returned error code {}",
                connection.getResponseCode()
            );
        }
        else{
            logger.info(
                "Post request responded with status code {}",
                connection.getResponseCode()
            );
        }
    }
}
