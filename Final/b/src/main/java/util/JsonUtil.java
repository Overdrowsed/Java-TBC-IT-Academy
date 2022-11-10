package util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException; 
import com.google.gson.reflect.TypeToken;

public class JsonUtil {
    public static <T> T toObject(String json, Class<T> returnTypeClass) throws JsonSyntaxException, IOException{
        return new Gson().fromJson(json, returnTypeClass);
    }

    public static <T> List<T> toList(String json, Class<T> listTypeClass) throws JsonSyntaxException, IOException{
        List<T> list = new Gson().fromJson(
            json,
            TypeToken.getParameterized(List.class, listTypeClass).getType()
        );

        if(list == null){
            list = new ArrayList<T>();
        }
        
        return list;
    }

    public static <T> List<T> toList(File file, Class<T> listTypeClass) throws JsonSyntaxException, IOException{
        List<T> list = new Gson().fromJson(
            Files.readString(file.toPath()),
            TypeToken.getParameterized(List.class, listTypeClass).getType()
        );

        if(list == null){
            list = new ArrayList<T>();
        }
        
        return list;
    }
    
    public static <T> String toJson(List<T> list) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(list);
    }
    
    public static <T> String toJson(T object) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(object);
    }

    public static <T> void toJson(List<T> list, String path) throws IOException{
        Files.writeString(
            Path.of(path), 
            toJson(list)
        );
    }

    public static <T> void toJson(T object, String path) throws IOException{
        Files.writeString(
            Path.of(path), 
            toJson(object)
        );
    }
}