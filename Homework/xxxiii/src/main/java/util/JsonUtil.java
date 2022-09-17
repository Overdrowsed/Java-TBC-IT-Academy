package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import polygon.Triangle;

public class JsonUtil {
    public static Triangle[] jsonToTriangleArray(String path) throws JsonSyntaxException, IOException{
        String fileContent = Files.readString(Path.of(path));

        Gson json = new Gson();

        Triangle[] triangles = json.fromJson(fileContent, Triangle[].class);

        return triangles;
    }

    public static List<Triangle> jsonToTriangleList(String path) throws JsonSyntaxException, IOException{
        String fileContent = Files.readString(Path.of(path));

        Gson json = new Gson();

        Triangle[] triangles = json.fromJson(fileContent, Triangle[].class);

        return new ArrayList<>(Arrays.asList(triangles));
    }

    public static String trianglesToJson(List<Triangle> triangles){
        Gson json = new GsonBuilder().setPrettyPrinting().create();

        return json.toJson(triangles);
    }

    public static String trianglesToJson(Triangle[] triangles){
        Gson json = new GsonBuilder().setPrettyPrinting().create();

        return json.toJson(triangles);
    }

    public static void updateTriangleDatabase(String path, Triangle newTriangle) throws JsonSyntaxException, IOException, IllegalArgumentException{
        if(newTriangle == null){
            throw new NullPointerException("New triangle wasn't passed or was invalid");
        }
        
        if(!newTriangle.validate()){
            throw new IllegalArgumentException("The triangle has an invalid configuration");
        }
        
        List<Triangle> existingTriangles = JsonUtil.jsonToTriangleList(path);

        existingTriangles.add(newTriangle);

        Files.writeString(Path.of(path), JsonUtil.trianglesToJson(existingTriangles));
    }
}
