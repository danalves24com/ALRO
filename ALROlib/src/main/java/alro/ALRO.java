package alro;

import alro.hook.GlobalHook;
import com.google.gson.Gson;
import services.FileReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class ALRO {


    String dotalro;
    String[] algorithms;
    double[] algorithmRuntimes;
    public static ALRO register(String alroConfig) {
        ALRO alro = new ALRO();
        boolean exists = Files.exists(Paths.get(alroConfig));
        if (!exists) return null;
        File file = new File(alroConfig);
        String alrofilecontents = FileReader.readContents(file);
        Gson gson = new Gson();
        ALROfile alrOfile = gson.fromJson(alrofilecontents, ALROfile.class);
        alro.dotalro = file.getAbsoluteFile().getParent()+"/.alro";
        Path path2 = Paths.get(alro.dotalro+"/keyalgs");
        System.out.println(path2);
        exists = Files.exists(path2);
        if (exists) alro.setAlgorithms(FileReader.readContents(path2.toFile()).split("\n"));
        return alro;

    }

    public void savePerformance() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < algorithms.length; i += 1) {
            String rep = algorithms[i]+":"+algorithmRuntimes[i];
            sb.append(rep+"\n");
        }
        FileWriter writer = null;
        try {
            writer = new FileWriter(dotalro+"/keyalgsrun");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            writer.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(sb.toString());
    }

    public void unregister() {
        algorithmRuntimes = new double[algorithms.length]; int i = 0;
        for(String algorithm : algorithms) {
            double ns = GlobalHook.getAlgorithmRuntime(algorithm);
            algorithmRuntimes[i] = GlobalHook.nanoToMili(ns);
            i+=1;
        }
        savePerformance();
    }



    public String[] getAlgorithms() {
        return algorithms;
    }

    public void setAlgorithms(String[] algorithms) {
        this.algorithms = algorithms;
    }
}
class ALROfile {
    private String name, description, author, language;
    String[] tags;

    public ALROfile(String name, String description, String author, String language, String[] tags) {
        this.name = name;
        this.language = language;
        this.description = description;
        this.author = author;
        this.tags = tags;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
