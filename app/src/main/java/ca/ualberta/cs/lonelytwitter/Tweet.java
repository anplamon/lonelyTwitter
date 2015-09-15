package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by anplamon on 9/14/15.
 */
public class Tweet {
    private String text;
    private Date date;

    public Tweet(String text, Date date) {
        this.text = text;
        this.date = date;
    }

    public Tweet(String text) {
        this.text = text;
        date = new Date();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        if (text.length() <= 140) {
            this.text = text;
        }
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
