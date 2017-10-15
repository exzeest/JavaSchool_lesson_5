package Terminal;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

public class TestTerminal {
    public static void main ( String[] args ) throws InterruptedException {
        Terminal terminal = new TerminalImpl ();
        /*try {
            terminal.login (1234);
            System.out.println ("На счету: " + terminal.deposit (1000));
            terminal.deposit (123);
        } catch (Exception e) {
            e.printStackTrace ();
        }
        try {
            System.out.println ("На счету: " + terminal.withdraw (100));
            System.out.println ("accountCheck: " + terminal.checkAccount ());
        } catch (Exception e) {
            e.printStackTrace ();
        }*/

        for (int i = 0; i < 4; ++i){
            try {
                terminal.login (12);
            } catch (Exception e) {
                e.printStackTrace ();
            }
        }
        try {
            System.out.println ("На счету: " + terminal.checkAccount ());
        } catch (Exception e) {
            e.printStackTrace ();
        }
        Thread.sleep (5000);

        try {
            System.out.println ("Авторизован: " + terminal.login (1234));
            System.out.println ("Положили 1000. На счету: " + terminal.deposit (1000));
            System.out.println ("Сняли 10000. На счету: " + terminal.withdraw (10000));
        } catch (Exception e) {
            e.printStackTrace ();
        }


    }
}
