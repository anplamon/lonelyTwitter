package ca.ualberta.cs.lonelytwitter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by anplamon on 9/14/15.
 */
public class ImporantTweet extends Tweet implements Tweetable {
    public ImporantTweet(String text, Date date, ArrayList<CurrentMood> moodArrayList) {
        super(text, date, moodArrayList);
    }

    public ImporantTweet(String text) throws IOException {
        super(text);
        this.setText(text);
    }

    public Boolean isImportant() {
        return Boolean.TRUE;
    }
}
