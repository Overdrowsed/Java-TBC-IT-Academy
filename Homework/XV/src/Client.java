public class Client {
    public static void main(String[] args) {
        String input = "ClientName: Mark Twain,  Address: London, Balance: 123.56";

        for (String word : input.split("[\\s,:]+"))
            if(!word.equals("ClientName") && !word.equals("Address") && !word.equals("Balance"))
                System.out.println(word);
    }
}
