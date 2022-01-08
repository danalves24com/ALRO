package alrosource.services;

import java.util.ArrayList;
import java.util.Scanner;

public class StructureBuilder {

    public static String[] getListInput(String prompt) {
        ArrayList<String> data = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println(prompt);
        System.out.println("*type q to end list*");
        String in = "";
        while(!in.equals("q")) {
            System.out.print(">\t");
            in = scanner.nextLine();
            if(!in.equals("q")) data.add(in);
        }
        String[] v = new String[data.size()];
        int i = 0;
        for(String d : data) {
            v[i] = d;
            i+=1;
        }
        return v;
    }


    public static String[] getKeyAlgorithms() {
        return getListInput("List the key algorithms of your program");
    }

}
