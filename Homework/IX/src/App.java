import java.util.ArrayList;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;

//FreeTTS-ით ვაპირებდი text to speech-ს მაგრამ ვეღარ მოვასწარი ბიბლიოთეკას გავცნობოდი
public class App {

    static ArrayList<String> commands = new ArrayList<String>();

    public static void main(String[] args) {
        commands.add("hello");
        commands.add("what date is it?");
        commands.add("what time is it?");
        commands.add("repeat");
        commands.add("count from to");
        commands.add("exit");

        Scanner scanner = new Scanner(System.in);


        System.out.println("Enter a command. type /commands to see available commands");

        while(true){
            String activeCommand = scanner.nextLine();

            if(activeCommand.indexOf(' ') >= 0){
                if(activeCommand.substring(0, activeCommand.indexOf(' ')).equals("repeat")){
                    printRepeat(activeCommand);
                    continue;
                }

                if(activeCommand.substring(0, activeCommand.indexOf(' ')).equals("count")){
                    countFromTo(activeCommand.substring(activeCommand.indexOf(' ') + 1));
                    continue;
                }
            }

            identifyCommand(activeCommand);
        }
    }

    static void identifyCommand(String command){
        switch(command){
            case "/commands":
                printCommands();
                break;

            case "hello":
                System.out.println("hello user");
                System.out.println();
                break;

            case "what date is it?":
                printDate();
                break;

            case "what time is it?":
                printTime();
                break;

            case "exit":
                System.out.println("goodbye");
                System.exit(0);
                break;

            default:
                System.out.println("unknown command");
                System.out.println();
        }
    }

    static void printCommands(){
        System.out.println();

        commands.forEach((command) -> System.out.println(command));

        System.out.println();
    }

    static void printDate(){
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dateFormat.format(now));

        System.out.println();
    }

    static void printTime(){
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("HH:mm");  
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dateFormat.format(now));

        System.out.println();
    }

    static void printRepeat(String text){
        System.out.println(text.substring(text.indexOf(' ') + 1));
    }

    static void countFromTo(String command){
        Scanner delimiter = new Scanner(command);

        delimiter.useDelimiter(" ");

        int from = Integer.valueOf(delimiter.next()), to = Integer.valueOf(delimiter.next());

        delimiter.close();

        for(int i = from; i <= to; i++){
            System.out.println(i);
        }

        System.out.println();
    }
}
