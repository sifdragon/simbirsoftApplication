package model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.HtmlWriter;

import java.io.IOException;

public class Parser {
    private static Logger logger = LoggerFactory.getLogger(Parser.class);
    public static String getText(String url) {
        try {
            long freeMemory = Runtime.getRuntime().freeMemory();
            int maxBodySize = (int) freeMemory -1;
            Document doc = Jsoup.connect(url).maxBodySize(maxBodySize).get();
            String html = Jsoup.connect(url).get().html();
            HtmlWriter.writeToFile(html);
            String text = doc.body().text();

            return text;

        } catch (IOException e) {
            logger.error("IOException happened!", e);
        }
        return "An error has occurred";
    }
}
