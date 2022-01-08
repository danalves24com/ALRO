package alrosource.services;

import com.google.gson.Gson;
import alrosource.data.ALROfile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class FileMaker {

    public static String getConfiguration() {
        try {
            File myObj = new File(".ALRO");
            Scanner myReader = new Scanner(myObj);
            StringBuilder sb = new StringBuilder();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                sb.append(data+"\n");
            }
            myReader.close();
            return sb.toString();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }
    }

    public boolean generateBasic(String[] res)  {
        String[] tags = res[2].split(",");
        ALROfile file = new ALROfile(res[0], res[1], res[3], res[4], tags);
        Gson gson = new Gson();
        try {
            FileWriter writer = new FileWriter(".ALRO");
            writer.write(gson.toJson(file));
            writer.close();
            return true;
        }
        catch (Exception e) {
            return false;
        }

    }
}
