package analyzer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileAnalyzer {
    public static void writeFile(String... filepaths) throws FileNotFoundException, IOException{
        File inputFile = new File(filepaths[0]);

        if(!inputFile.exists()){
            throw new RuntimeException("Specified input file doesn't exist.");
        }

        Scanner fileReader = new Scanner(inputFile);
        FileWriter writer = new FileWriter(filepaths[1]);
        
        try(fileReader; writer){
            while(fileReader.hasNextLine()){
                String currentLine = fileReader.nextLine();

                currentLine = currentLine.toUpperCase();
                currentLine = currentLine.replaceAll("\\s", "_");

                writer.write(currentLine + System.lineSeparator());
            }
        }
        catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
