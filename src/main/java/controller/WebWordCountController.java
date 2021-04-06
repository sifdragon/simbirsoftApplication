package controller;

import model.FreqCount;
import model.Parser;
import model.Trimmer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.DbActions;

import java.sql.SQLException;

public class WebWordCountController {
    private static Logger logger = LoggerFactory.getLogger(Parser.class);
    public static void operate(String url){
        Trimmer trimmer = new Trimmer();
        try {
            DbActions.insertData(FreqCount.count(trimmer.trim(Parser.getText(url))), url);
        } catch (SQLException e) {
            logger.error("IOException happened!", e);
            e.printStackTrace();
        }
    }

    public static void operate(String url, String regex){
        Trimmer trimmer = new Trimmer(regex);
        try {
            DbActions.insertData(FreqCount.count(trimmer.trim(Parser.getText(url))), url);
        } catch (SQLException e) {
            logger.error("IOException happened!", e);
            e.printStackTrace();
        }
    }
}
