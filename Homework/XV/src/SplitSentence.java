import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SplitSentence {
    public static void main(String[] args) {
        String text = "This is a dog, that - a cat.";
        
        Properties properties = new Properties();

        try{
            properties.load(new FileInputStream("lib/regex.properties"));
            
            for (String word : text.split(properties.getProperty("regex")))
                System.out.println(word);
        }
        catch (IOException exception){
            if(exception.getMessage().length() > 100)
                System.out.println(exception.getMessage().substring(0, 100));
            else
                System.out.println(exception.getMessage());
        }
    }
}

