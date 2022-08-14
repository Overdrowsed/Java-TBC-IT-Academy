package homework.jsonconverter;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.Gson;

import homework.emotion.FacialEmotion;
import homework.emotion.FacialEmotionRecognized;

public class JsonConverter {
    public static String serializeJson(FacialEmotion emotion){
        GsonBuilder jsonBuilder = new GsonBuilder().setPrettyPrinting();
        
        Gson json = jsonBuilder.create();

        return json.toJson(emotion);
    }

    public static String serializeJson(FacialEmotionRecognized emotion){
        GsonBuilder jsonBuilder = new GsonBuilder().setPrettyPrinting();
        
        Gson json = jsonBuilder.create();

        return json.toJson(emotion);
    }

    public static FacialEmotionRecognized deserializeFacialEmotion(String jsonString){
        Gson json = new Gson();

        FacialEmotionRecognized emotion = new FacialEmotionRecognized();

        try{
            emotion = json.fromJson(jsonString, FacialEmotionRecognized.class);
        }
        catch (JsonSyntaxException exception){
            System.out.println("Arguement json doesn't match class FacialEmotion, returning null");
            return null;
        }

        emotion.setEmotion();

        return emotion;
    }
}
