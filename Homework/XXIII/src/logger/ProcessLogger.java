package logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ProcessLogger extends Thread{
    Thread generator, readerWriter;

    public ProcessLogger(Thread generator, Thread readerWriter){
        this.generator = generator;
        this.readerWriter = readerWriter;
    }
    
    public void run(){
        while(true){
            printTime();
            printCurrentTask();

            try{
                sleep(2000);
            }
            catch (InterruptedException exception){
                System.out.println(exception);
            }
        }
    }

    private static void printTime(){
        System.out.println(DateTimeFormatter.ofPattern("HH:mm:ss").format(LocalDateTime.now()));
    }

    private void printCurrentTask() {
        if(generator.isAlive())
            System.out.println("Generating in files");
        
        if(readerWriter.isAlive())
            System.out.println("Generating out files");
    }
}
