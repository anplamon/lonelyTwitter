package ca.ualberta.cs.lonelytwitter;

<<<<<<< HEAD
import java.util.Date;

/**
 * Created by joshua2 on 9/16/15.
 */
public class NormalTweet extends Tweet {
    public NormalTweet(String tweet, Date date) {
        super(tweet, date);
    }

    public NormalTweet(String tweet) {
        super(tweet);
=======
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by anplamon on 9/14/15.
 */
public class NormalTweet extends Tweet implements Tweetable {
    public NormalTweet(String text, Date date, ArrayList<CurrentMood> moodArrayList) {
        super(text, date, moodArrayList);
    }

    public NormalTweet(String text) {
        super(text);
>>>>>>> master
    }

    public Boolean isImportant() {
        return Boolean.FALSE;
    }
}
