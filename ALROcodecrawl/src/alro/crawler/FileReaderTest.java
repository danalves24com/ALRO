package alro.crawler;

import alro.crawler.lang.JavaLinguist;
import alro.crawler.lang.Linguist;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FileReaderTest {

    @Test
    void read() {
        String path = "SampleProgram.java";
        ArrayList<String> out = FileReader.readLines(path);
        Linguist linguist = new JavaLinguist();
        for(String line : out) {
            if(linguist.isFunctionStart(line)) {
                System.out.println(linguist.getFunctionName(line));
            }
        }
    }
}