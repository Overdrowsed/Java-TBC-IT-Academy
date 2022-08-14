package homework.emotion;

import java.util.HashMap;
import java.util.Map;

public class FacialEmotionRecognized {
    private String eyebrows, mouth, emotion;
    
    private static Map<String, String> emotions = new HashMap<>(){
        {
            put("upwardsmile", "pleasantly surprised");
            put("upwardfrown", "surprised and displeased");
            put("upwardlaugh", "extremely amused");
            put("upwardneutral", "shocked");
            put("downwardsmile", "evil smile");
            put("downwardfrown", "very angry");
            put("downwardlaugh", "madman");
            put("downwardneutral", "slightly angry");
            put("raisedsmile", "very pleased");
            put("raisedfrown", "extremely surprised and disappointed");
            put("raisedlaugh", "very happy");
            put("raisedneutral", "questioning something");
            put("neutralsmile", "slightly happy");
            put("neutralfrown", "slightly disappointed");
            put("neutrallaugh", "slightly amused");
            put("neutralneutral", "neutral");
        }
    };

    @Override
    public String toString() {
        return "FacialEmotionRecognized [eyebrows=" + eyebrows + ", mouth=" + mouth + ", emotion=" + emotion + "]";
    }

    public void setEmotion() {
        this.emotion = emotions.get(eyebrows + mouth);
    }
}
