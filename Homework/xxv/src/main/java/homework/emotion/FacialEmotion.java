package homework.emotion;


public class FacialEmotion {
    private String eyebrows, mouth;
    
    transient static String[] eyebrowsOptions = {"upward", "downward", "raised", "neutral"};
    transient static String[] mouthOptions = {"smile", "frown", "laugh", "neutral"};

    public FacialEmotion(String eyebrows, String mouth) {
        for(var eyebrowsOption : eyebrowsOptions){
            if(eyebrows == eyebrowsOption){
                for(var mouthOption : mouthOptions){
                    if(mouth == mouthOption){
                        this.eyebrows = eyebrows;
                        this.mouth = mouth;
                        return;
                    }
                }
            }
        }
        
        throw new IllegalArgumentException("Invalid constructor parameter(s)");
    }

    public String getEyebrows() {
        return eyebrows;
    }

    public String getMouth() {
        return mouth;
    }
}
