package ca.ualberta.cs.lonelytwitter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public abstract class Tweet extends Object implements Tweetable, MyObservable {
    private String text;
    protected Date date;
    private volatile ArrayList<MyObserver> observers = new ArrayList<MyObserver>();

    public Tweet(String tweet, Date date) throws TweetTooLongException {
        this.setText(tweet);
        this.date = date;
    }

    public Tweet(String tweet) throws TweetTooLongException {
        this.setText(tweet);
        this.date = new Date();

    }

    public String getText() {
        return text;
    }

    public void setText(String text) throws TweetTooLongException {
        if (text.length() <= 140) {
            this.text = text;
        } else {
            throw new TweetTooLongException();
        }
        notifyAllObservers();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public abstract Boolean isImportant();

    @Override
    public String toString() {
        return date.toString() + " | " + text;
    }

    public void addObserver(MyObserver observer) {
        observers.add(observer);
    }

    private void notifyAllObservers () {
        for (MyObserver observer : observers) {
            observer.myNotify(this);
        }
    }

}
