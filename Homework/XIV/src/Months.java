public class Months {
    public static void main(String[] args) {
        String inputMonth = args[0].toLowerCase();

        switch (inputMonth){
            case "january":
                System.out.println("Odd");
                break;

            case "february":
                System.out.println("Even");
                break;

            case "march":
                System.out.println("Odd");
                break;

            case "april":
                System.out.println("Even");
                break;

            case "may":
                System.out.println("Odd");
                break;

            case "june":
                System.out.println("Even");
                break;

            case "july":
                System.out.println("Odd");
                break;

            case "august":
                System.out.println("Even");
                break;

            case "september":
                System.out.println("Odd");
                break;

            case "october":
                System.out.println("Even");
                break;

            case "november":
                System.out.println("Odd");
                break;

            case "december":
                System.out.println("Even");
                break;

            default: 
                System.out.println("Invalid input");
        }
    }
}