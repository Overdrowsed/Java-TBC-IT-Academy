package homework.main;

import homework.client.Client;

public class App {
    public static void main(String[] args) {
        Client.getPerson("1");
        Client.getPerson("0");
        
        Client.addPerson("11", "John", "Doe", 24);
        Client.addPerson("1", "Jane", "Doe", 21);
        
        Client.updatePerson("11", "Jane", "Doe", 21);
        Client.updatePerson("0", "Jane", "Doe", 21);

        Client.deletePerson("11");
        Client.deletePerson("0");

        Client.listPersons();
    }
}
