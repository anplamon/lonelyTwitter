package ca.ualberta.cs.lonelytwitter;

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
    }

    public Boolean isImportant() {
        return Boolean.FALSE;
    }
}
