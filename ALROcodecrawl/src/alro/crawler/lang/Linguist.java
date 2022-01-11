package alro.crawler.lang;

public interface Linguist {
    boolean isFunctionStart(String line);
    String getFunctionName(String line);
}
