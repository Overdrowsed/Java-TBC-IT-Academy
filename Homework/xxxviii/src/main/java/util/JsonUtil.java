package util;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

public class JsonUtil {
    public static <T> List<T> toList(String json, Class<T> listTypeClass) throws JsonSyntaxException, IOException{                
        Type typeOfT = TypeToken.getParameterized(List.class, listTypeClass).getType();

        List<T> list = new Gson().fromJson(
            json,
            typeOfT
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

    public static <T> void toJsonFile(List<T> list, Path path) throws IOException{
        Files.writeString(
            path, 
            toJson(list)
        );
    }

    public static <T> void toJsonFile(T object, Path path) throws IOException{
        Files.writeString(
            path, 
            toJson(object)
        );
    }
}