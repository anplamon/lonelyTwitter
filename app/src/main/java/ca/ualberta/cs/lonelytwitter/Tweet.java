package ca.ualberta.cs.lonelytwitter;

import java.io.IOException;
<<<<<<< HEAD
import java.util.Date;

/**
 * Created by joshua2 on 9/16/15.
 */
public abstract class Tweet extends Object implements Tweetable {
    private String text;
    protected Date date;

    public Tweet(String tweet, Date date) throws TweetTooLongException {
        this.setText(tweet);
        this.date = date;
    }

    public Tweet(String tweet) throws TweetTooLongException {
        this.setText(tweet);
        this.date = new Date();
=======
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
>>>>>>> master
    }

    public String getText() {
        return text;
    }

<<<<<<< HEAD
    public void setText(String text) throws TweetTooLongException {
        if (text.length() <= 140) {
            this.text = text;
        } else {
            throw new TweetTooLongException();
=======
    public void setText(String text) throws IOException {
        if (text.length() <= 140) {
            this.text = text;
        } else {
            throw new IOException(("Tweet was too long!"));
>>>>>>> master
        }
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

<<<<<<< HEAD
    public abstract Boolean isImportant();

    @Override
    public String toString() {
        return date.toString() + " | " + text;
    }

=======
    public ArrayList<CurrentMood> getMoodArrayList() {
        return moodArrayList;
    }

    public void setMoodArrayList(ArrayList<CurrentMood> moodArrayList) {
        this.moodArrayList = moodArrayList;
    }
>>>>>>> master
}
