package ge.ufc.project.main;

import ge.ufc.project.beans.Payment;
import ge.ufc.project.client.Client;

public class App {
    public static void main(String[] args){
        //1
        System.out.println(Client.getUser("1") == 200);

        //2
        System.out.println(Client.getUser("0") == 404);

        //3
        System.out.println(Client.fillBalance(
            new Payment(1, "1", 10)
        ) == 200);
        
        //4
        System.out.println(Client.fillBalance(
            new Payment(0, "2", 10)
        ) == 404);
        
        //5
        System.out.println(Client.fillBalance(
            new Payment(1, "3", -10)
        ) == 400);
        
        //6
        System.out.println(Client.fillBalance(
            new Payment(1, "1", 10)
        ) == 200);

        //7 requires insert_test_case.bat
        System.out.println(Client.fillBalance(
            new Payment(1, "123", 10)
        ) == 200);

        //8
        Client.fillBalance(
            new Payment(1, "3", -10)
        );

        //9
        System.out.println(Client.fillBalance(
            new Payment(2, "1", 10)
        ) == 409);

        //10
        System.out.println(Client.fillBalance(
            new Payment(2, "1", 100)
        ) == 409);
    }
}
