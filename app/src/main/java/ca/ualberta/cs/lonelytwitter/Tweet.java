package ca.ualberta.cs.lonelytwitter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by anplamon on 9/14/15.
 */
public class Tweet {
    private String text;
    private Date date;
    private ArrayList<CurrentMood> moodArrayList;

    public Tweet(String text, Date date, ArrayList<CurrentMood> moodArrayList) {
        this.text = text;
        this.date = date;
        this.moodArrayList = moodArrayList;
    }

    public Tweet(String text) {
        this.text = text;
        date = new Date();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) throws IOException {
        if (text.length() <= 140) {
            this.text = text;
        } else {
            throw new IOException(("Tweet was too long!"));
        }
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ArrayList<CurrentMood> getMoodArrayList() {
        return moodArrayList;
    }

    public void setMoodArrayList(ArrayList<CurrentMood> moodArrayList) {
        this.moodArrayList = moodArrayList;
    }
}
