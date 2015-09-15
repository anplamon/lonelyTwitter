package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by anplamon on 9/14/15.
 */
public class ImporantTweet extends Tweet {
    public ImporantTweet(String text, Date date) {
        super(text, date);
    }

    public ImporantTweet(String text) {
        super(text);
        this.setText(text);
    }
}
