package readContent.main;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.*;

public class Main {
    public static void readContent ( String url ) {

        try {
            JFrame.setDefaultLookAndFeelDecorated (true);
            JFrame frame = new JFrame ("Html demo");
            frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

            JEditorPane editorPane = new JEditorPane (url);
            editorPane.setEditable (false);
            frame.getContentPane ().add (editorPane);

            frame.setSize (700, 800);
            frame.setVisible (true);
        } catch (IOException e) {
            System.out.println ("Неправильный ввод адреса, введите его в формате: http://*.*/");
            Scanner scanner = new Scanner (System.in);
            url = scanner.nextLine ();
            readContent (url);
        }


    }

    public static void main ( String[] args ) {
        Scanner scanner = new Scanner (System.in);
        String url = scanner.nextLine ();
        if (args.length > 0) {
            url = args[0];
        }
        readContent (url);
    }
}
