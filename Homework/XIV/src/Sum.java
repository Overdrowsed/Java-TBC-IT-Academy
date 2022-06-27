import java.util.Scanner;

public class Sum {
    
    public static void main(String[] args) {
        
        System.out.println("Hello SUM" + System.lineSeparator());

        Scanner scanner = new Scanner(System.in);

        int sum = 0;

        while(true){

            System.out.print("Enter whole number: ");
            
            String input = scanner.nextLine();

            if(input.equals("end")){
                System.out.println("Bye SUM");
                scanner.close();
                return;
            }

            int inputNumber = 0;

            if(validateInput(input))
                inputNumber = Integer.valueOf(input);
            
            else{
                System.err.println("Incorrect whole number value" + System.lineSeparator());
                continue;
            }

            sum += inputNumber;

            System.out.println("Total SUM: " + sum + System.lineSeparator());
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
