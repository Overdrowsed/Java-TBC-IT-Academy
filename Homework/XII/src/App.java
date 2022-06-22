import java.io.*;

public class App {
    public static void main(String[] args) throws Exception {
        
        String path = args[0];
        
        File root = new File(path);

        listFiles(root);

        System.out.println();

        listExeFiles(root);

        reverseFile();

        reverseFileBuffered();

        copyFile();
    }
    
    static void listFiles(File root) throws IOException{
        
        File[] childFiles = root.listFiles();
        
        if (childFiles != null){
            
            for(var file : childFiles){
                System.out.println(file.getCanonicalPath());

                if(file.isDirectory())
                    listFiles(file);
            }
        }
    }

    static void listExeFiles(File root) throws IOException{
        
        File[] childFiles = root.listFiles();

        if (childFiles != null){
            
            for(var file : childFiles){
                if(file.getName().endsWith(".exe"))
                    System.out.println(file.getCanonicalPath());

                if(file.isDirectory())
                    listExeFiles(file);
            }
        }
    }

    static void reverseFile() {
        
        String readPath = "lib/input.txt";

        File file = new File(readPath);

        byte[] bytes = new byte[(int)file.length()];

        try{
            FileInputStream input = new FileInputStream(file);
    
            input.read(bytes);
    
            input.close();
        }
        //FileNotFoundException extends IOException
        catch(IOException exception){
            System.out.println(exception.getMessage());
        }


        String writePath = "lib/output.txt";

        try{
            FileOutputStream output = new FileOutputStream(writePath);
    
            for(int i = bytes.length - 1; i >= 0; i--){
                output.write(bytes[i]);
            }
    
            output.close();
        }
        //FileNotFoundException extends IOException
        catch (IOException exception){
            System.out.println(exception.getMessage());
        }
    }

    static void reverseFileBuffered() {

        String readPath = "lib/buffered input.txt";

        File file = new File(readPath);

        byte[] bytes = new byte[(int)file.length()];

        try{
            BufferedInputStream input = new BufferedInputStream(new FileInputStream(file));
    
            input.read(bytes);
    
            input.close();
        }
        //FileNotFoundException extends IOException
        catch(IOException exception){
            System.out.println(exception.getMessage());
        }


        String writePath = "lib/buffered output.txt";

        try{
            BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(writePath));
    
            for(int i = bytes.length - 1; i >= 0; i--){
                output.write(bytes[i]);
            }
    
            output.close();
        }
        //FileNotFoundException extends IOException
        catch (IOException exception){
            System.out.println(exception.getMessage());
        }
    }

    static void copyFile() {
        String readPath = "lib/copy text.txt";

        File file = new File(readPath);

        byte[] bytes = new byte[(int)file.length()];

        try{
            BufferedInputStream input = new BufferedInputStream(new FileInputStream(file));
    
            input.read(bytes);
    
            input.close();
        }
        //FileNotFoundException extends IOException
        catch(IOException exception){
            System.out.println(exception.getMessage());
        }


        String writePath = "lib/copy text output.txt";

        try{
            BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(writePath));

            for(int i = 0; i < bytes.length; i++){
                output.write(bytes[i]);
                
                if((i + 1) % 3 == 0)
                    output.flush();
            }

            output.close();
        }
        //FileNotFoundException extends IOException
        catch (IOException exception){
            System.out.println(exception.getMessage());
        }
    }
}
