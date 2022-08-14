package homework.main;

import homework.emotion.FacialEmotion;
import homework.emotion.FacialEmotionRecognized;
import homework.jsonconverter.JsonConverter;

public class App {
    public static void main(String[] args){
        FacialEmotion emotion = new FacialEmotion("downward", "smile");
        
        String facialEmotionJson = JsonConverter.serializeJson(emotion); 

        System.out.println(facialEmotionJson);


        System.out.println();


        FacialEmotionRecognized deserializedEmotion = JsonConverter.deserializeFacialEmotion(facialEmotionJson);

        System.out.println(deserializedEmotion);


        System.out.println();

        
        String facialEmotionRecognizedJson = JsonConverter.serializeJson(deserializedEmotion); 

        System.out.println(facialEmotionRecognizedJson);
    }
}
