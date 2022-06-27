import java.io.Console;
import java.io.File;
import java.util.Scanner;

public class SumConsole {
    
    public static void main(String[] args) throws Exception{
        
        Console console = System.console();

        console.printf("Hello SUM" + System.lineSeparator() + System.lineSeparator());

        while(true){
            String username = console.readLine("Enter username: ");
            String password = new String(console.readPassword("Enter password: "));
    
            if(!valideteUser(username, password)){
                console.printf("Incorrect username or password" + System.lineSeparator() + System.lineSeparator());
                continue;
            }

            break;
        }

        console.printf(System.lineSeparator());

        int sum = 0;

        while(true){
            
            String input = console.readLine("Enter whole number: ");

            if(input.equals("end")){
                console.printf("Bye SUM");
                return;
            }

            int inputNumber = 0;

            if(validateInput(input))
                inputNumber = Integer.valueOf(input);
            
            else{
                console.printf("Incorrect whole number value" + System.lineSeparator() + System.lineSeparator());
                continue;
            }

            sum += inputNumber;

            console.printf("Total SUM: " + sum + System.lineSeparator() + System.lineSeparator());
        }
    }

    static boolean valideteUser(String username, String password) throws Exception{
        try(Scanner scanner = new Scanner(new File("lib/users.dat"))){
            while(scanner.hasNext()){
                if(username.equals(scanner.nextLine())){
                    if(password.equals(scanner.nextLine())){
                        return true;
                    }
                }
            }
    
            return false;
        }
    }

    static boolean validateInput(String input){
        
        try {
            if(Integer.valueOf(input) >= 0)
                return true;

            throw new NumberFormatException();
        }
        catch (NumberFormatException exception){
            return false;
        }
    }
}