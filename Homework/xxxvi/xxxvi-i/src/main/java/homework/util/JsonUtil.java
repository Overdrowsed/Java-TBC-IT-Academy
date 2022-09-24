package homework.util;

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
    public static <T> List<T> jsonToList(Path path, Class<T> listTypeClass) throws JsonSyntaxException, IOException{
        String fileContent = Files.readString(path);
        
        Type typeOfT = TypeToken.getParameterized(List.class, listTypeClass).getType();

        List<T> list = new Gson().fromJson(fileContent, typeOfT);

        if(list == null){
            list = new ArrayList<T>();
        }

        return list;
    }

    public static <T> void listToJsonFile(List<T> list, Path path) throws IOException{
        Files.writeString(
            path, 
            new GsonBuilder().setPrettyPrinting().create().toJson(list)
        );
    }
}