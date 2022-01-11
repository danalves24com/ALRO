package alro.crawler.lang;

public class JavaLinguist implements  Linguist{
    @Override
    public boolean isFunctionStart(String line) {
        if(line.contains("static")) return true;
        else return false;
    }

    @Override
    public String getFunctionName(String line) {
        for(String word : line.split(" ")) {
            System.out.println(word);
            if(word.contains("(")) {
                return word.split("\\(")[0];
            }
        }
        return null;
    }
}
