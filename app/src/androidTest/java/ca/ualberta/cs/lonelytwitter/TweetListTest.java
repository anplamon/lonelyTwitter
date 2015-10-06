package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import junit.framework.TestCase;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by anplamon on 9/28/15.
 */
public class TweetListTest extends ActivityInstrumentationTestCase2 implements MyObserver {
    private Boolean wasNotified = Boolean.FALSE;

    public TweetListTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    public void myNotify(MyObservable observable) {
        wasNotified = Boolean.TRUE;
    }

    public void testAddTweet() {
        Boolean errorCheck = false;
        TweetList List = new TweetList();
        Tweet tweet = new NormalTweet("test");
        List.add(tweet);
        try{
            List.add(tweet);
        } catch(IllegalArgumentException e) {
            errorCheck = true;
        }
        assertTrue(errorCheck);
    }

    public void testDelete() {
        TweetList List = new TweetList();
        Tweet tweet = new NormalTweet("test");
        List.add(tweet);
        List.delete(tweet);
        assertFalse(List.contains(tweet));
    }

    public void testContains() {
        TweetList List = new TweetList();
        Tweet tweet = new NormalTweet("test");
        List.add(tweet);
        assertTrue(List.contains(tweet));
    }

    public void testGetTweets() {
        TweetList List = new TweetList();
        ArrayList <Tweet> List2 = new ArrayList<Tweet>();
        Tweet tweet1 = new NormalTweet("test1");
        Tweet tweet2 = new NormalTweet("test2");
        List.add(tweet1);
        List.add(tweet2);
        List2 = List.getTweets();

        assertEquals(List2.get(0), tweet1);
        assertEquals(List2.get(1), tweet2);
    }

    public void testGetCount() {
        TweetList List = new TweetList();
        Tweet tweet1 = new NormalTweet("test1");
        Tweet tweet2 = new NormalTweet("test2");
        List.add(tweet1);
        List.add(tweet2);

        Boolean test = List.getCount().equals(2);
        assertTrue(test);
    }

    public void testAddObserver() {
        TweetList list = new TweetList();
        list.addObserver(this);
        wasNotified = Boolean.FALSE;
        list.add(new NormalTweet("test"));
        assertTrue(wasNotified);
    }

    public void testTweetObserver() {
        TweetList list = new TweetList();
        list.addObserver(this);
        Tweet tweet = new NormalTweet("test");
        list.add(tweet);
        wasNotified = Boolean.FALSE;
        tweet.setText("different");
        assertTrue(wasNotified);
    }

}