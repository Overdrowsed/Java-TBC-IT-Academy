import java.io.*;

public class App {
    public static void main(String[] args) throws Exception {

        String readPath = "lib/file.txt";

        FileInputStream stream = new FileInputStream(new File(readPath));

        try {
            System.out.println(streamToString(stream, "UTF-8"));
        }
        catch (FileNotFoundException exception){
            System.err.println(exception.getMessage());
        }
        catch (IOException | RuntimeException exception){
            System.out.println(exception.getStackTrace());
        }
        
        stream.close();

        System.out.println();

        String text = "abcdef" + System.lineSeparator() + "абц" + System.lineSeparator() +"აბგდევ";

        try {
            stringToStream(System.out, text, "UTF-8");
        }
        catch (FileNotFoundException exception){
            System.err.println(exception.getMessage());
        }
        catch (IOException | RuntimeException exception){
            System.out.println(exception.getStackTrace());
        }
    }

    static String streamToString(InputStream is, String encoding) throws Exception{

        String line, result = "";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is, encoding))){
            
            while((line = reader.readLine()) != null){
                
                if(!result.isEmpty())
                    result += System.lineSeparator();
                
                result += line;
            }   
        }
        
        return result;
    }

    static void stringToStream(OutputStream os, String text, String encoding) throws Exception{
        
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, encoding))){

            writer.write(text);
        }
    }
}
