package data;

import java.security.PublicKey;

public class Word implements Comparable<Word> {
    private String body;
    private int count;

    public Word(String body, int count){
        this.body = body;
        this.count = count;
    }

    public Word(){}

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public int hashCode() { return body.hashCode(); }

    @Override
    public boolean equals(Object obj) { return body.equals(((Word)obj).body); }

    @Override
    public int compareTo(Word b) { return b.count - count; }
}
