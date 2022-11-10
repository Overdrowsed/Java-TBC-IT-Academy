package ge.ufc.project.client;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Properties;

import ge.ufc.project.beans.Payment;
import ge.ufc.project.util.JsonUtil;

public class Client {
    private static Properties properties;

    private static String url;
    private static int timeout;

    static{
        properties = new Properties();

        try{
            properties.load(Client.class.getClassLoader().getResourceAsStream("config.properties"));
        }
        catch(IOException exception){
            System.out.println("Propeties file not found");
        }

        url = properties.getProperty("url");
        timeout = Integer.valueOf(properties.getProperty("timeout"));
    }
    
    public static int getUser(String userId) {
        HttpRequest request = HttpRequest.newBuilder(URI.create(url + "get_user/" + userId))
            .timeout(Duration.ofSeconds(timeout))
            .GET()
        .build();

        try{
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

            String responseBody = response.body();

            if(!responseBody.isEmpty()){
                System.out.println(responseBody);
            }

            return response.statusCode();
        }
        catch(IOException | InterruptedException exception){
            return -1;
        }
    }

    public static int fillBalance(Payment payment) {
        HttpRequest request = HttpRequest.newBuilder(URI.create(url + "fill_balance"))
            .header("Content-Type", "application/json")
            .timeout(Duration.ofSeconds(timeout))
            .POST(BodyPublishers.ofString(JsonUtil.toJson(payment)))
        .build();

        try{
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

            String responseBody = response.body();

            if(!responseBody.isEmpty()){
                System.out.println(responseBody);
            }

            return response.statusCode();
        }
        catch(IOException | InterruptedException exception){
            return -1;
        }
    }
}
