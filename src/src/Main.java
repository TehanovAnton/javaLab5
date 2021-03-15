package src;

import src.cashregister.CashRegistrer;
import src.cashregister.Client;
import src.cashregister.Manager;
import src.shower.Hostel;

import javax.security.auth.callback.CallbackHandler;
import java.util.LinkedList;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        LinkedList<CashRegistrer> registrers = new LinkedList<CashRegistrer>(){
            {
                this.add(new CashRegistrer(5));
                this.add(new CashRegistrer(7));
            }
        };

        Manager manager = new Manager(registrers);

        for (int i = 0; i < 7; i++)
            (new Client((i + 1) + "", 5 * (i + 1), manager)).start();

        Hostel.hostelWorkDayStart();
    }
}
