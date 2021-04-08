package utils;

import model.Parser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class HtmlWriter {
    private static Logger logger = LoggerFactory.getLogger(Parser.class);

    public static void writeToFile(String html) {
        String directoryName = "C:" + File.separator + "SavedHtmls";
        String filepath = directoryName + File.separator + System.currentTimeMillis() + ".txt";
        File directory = new File((directoryName));
        if (!directory.exists()) {

            directory.mkdir();
            try {
                FileOutputStream outputStream = new FileOutputStream(filepath);
                byte[] strToBytes = html.getBytes();
                outputStream.write(strToBytes);

                outputStream.close();
            } catch (IOException e) {
                logger.error("IOException happened!", e);
            }
        }
    }
}
