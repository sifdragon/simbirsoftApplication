package model;

import sun.misc.Regexp;

public class Trimmer {
    String regex;
    public Trimmer(String regex){
        this.regex = regex;
    }
    public Trimmer(){
        this.regex = "[\\\\s.,!?\\\";:\\\\[\\\\]()\\\\n\\\\t\\\\ra-zA-Z0-9-@«»+#/© ]";
    }
    public String[] trim(String text){
        return text.split(regex);
    }
}
