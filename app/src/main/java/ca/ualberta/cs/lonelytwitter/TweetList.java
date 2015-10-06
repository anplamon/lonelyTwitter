package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

/**
 * Created by anplamon on 9/28/15.
 */
public class TweetList implements MyObservable, MyObserver {
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();
    private volatile ArrayList<MyObserver> observers = new ArrayList<MyObserver>();

    public void add(Tweet tweet) {
        if(tweets.contains(tweet)) {
            throw new IllegalArgumentException();
        } else {
            tweets.add(tweet);
            tweet.addObserver(this);
            notifyAllObservers();
        }
    }

    public void delete(Tweet tweet) {
        tweets.remove(tweet);
    }

    public Boolean contains(Tweet tweet) {
        return tweets.contains(tweet);
    }

    public ArrayList<Tweet> getTweets() {
        return tweets;
    }

    public Integer getCount() {
        return tweets.size();
    }

    public void addObserver(MyObserver observer) {
        observers.add(observer);
    }

    private void notifyAllObservers () {
        for (MyObserver observer : observers) {
            observer.myNotify(this);
        }
    }

    public void myNotify(MyObservable observable) {
        notifyAllObservers();
    }
}
