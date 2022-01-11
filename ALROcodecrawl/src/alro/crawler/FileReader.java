package alro.crawler;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {
    public static ArrayList<String> readLines(String path) {

        File file = new File(path);
        ArrayList<String> list = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scanner.hasNextLine()) {
            list.add(scanner.nextLine());
        }
        scanner.close();;

        return list;
    }
    public static String read(String path) {

        return String.join("\n", readLines(path));

    }
}
