package alrosource;

import alrosource.data.ALROfile;
import alrosource.services.FileMaker;
import alrosource.services.Greeter;
import alrosource.services.StructureBuilder;
import alrosource.services.builders.HookBuilder;
import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        String mode = args[0];
        if(args.length == 0) return;
        else
            if (mode.equals("generate"))
                generateMode();
            else if (mode.equals("setup"))
                generateRatingStructure();
    }

    public static void generateRatingStructure() {
        Greeter.greet();
        boolean exists = Files.exists(Paths.get("./.alro"));
        if (!exists) return;
        else Greeter.inf("Project Setup Found\t[Ok]");
        Gson gson = new Gson();
        ALROfile aFile = gson.fromJson(FileMaker.getConfiguration(),ALROfile.class);
        String[] algorithms = StructureBuilder.getKeyAlgorithms();
        String lang = aFile.getLanguage();
        for(String alg : algorithms) {
            String[] p = HookBuilder.createHookSet(alg, lang);
            System.out.println("\n======[ "+alg+" ]======\n");
            System.out.println("START HOOK:\n\n\t"+p[0]+"\n");
            System.out.println("STOP HOOK:\n\n\t"+p[1]);
        }
    }


    public static void generateMode() {
        Greeter.greet();
        String[] prompts = {
                "Project name",
                "Project description",
                "Description tags (a,b,...)",
                "Project author",
                "Project language"
        }, res = new String[5]; int i = 0;
        for(String p : prompts) {
            res[i] = Greeter.in(p);
            i+=1;
        }
        try {
            Files.createDirectory(Paths.get("./.alro"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        boolean status = new FileMaker().generateBasic(res);
        if (status)
            Greeter.inf("ALRO file created successfully");
        else
            Greeter.inf("ERROR\tFile not created");
    }

}
