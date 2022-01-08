package alrosource.services;
import java.util.Scanner;
public class Greeter {
    public static void greet() {
        System.out.println("    _   _    ___  ___  \n" +
                "   /_\\ | |  | _ \\/ _ \\ \n" +
                "  / _ \\| |__|   / (_) |\n" +
                " /_/ \\_\\____|_|_\\\\___/ \n" +
                "                       ");
    }
    public static String in(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("["+prompt+"]:\t");
        return scanner.nextLine();
    }
    public static void inf(String msg) {
        System.out.println("\n\t[ "+msg+" ]\n");
    }
}
