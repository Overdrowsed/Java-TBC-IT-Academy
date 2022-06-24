import java.io.*;

public class App {
    public static void main(String[] args) throws Exception {

        String readPath = "lib/file.txt";

        FileInputStream stream = new FileInputStream(new File(readPath));

        System.out.println(streamToString(stream, "UTF-8"));
        
        stream.close();

        System.out.println();

        String text = "abcdef" + System.lineSeparator() + "абц" + System.lineSeparator() +"აბგდევ";

        stringToStream(System.out, text, "UTF-8");
    }

    static String streamToString(InputStream is, String encoding){

        String line, result = "";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is, encoding))){
            
            while((line = reader.readLine()) != null){
                
                if(!result.isEmpty())
                    result += System.lineSeparator();
                
                result += line;
            }   
        }
        //IOException, UnsupportedEncodingException
        catch (Exception exception){
            System.err.println(exception.getMessage());
        }
        
        return result;
    }

    static void stringToStream(OutputStream os, String text, String encoding) {
        
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, encoding))){

            writer.write(text);
        }
        catch (IOException exception){
            System.err.println(exception.getMessage());
        }
    }
}
