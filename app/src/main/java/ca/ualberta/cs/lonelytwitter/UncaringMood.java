package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by anplamon on 9/14/15.
 */
public class UncaringMood extends CurrentMood {
    public UncaringMood(Date date) {
        super(date);
    }

    @Override
    public String mood() {
        return "i am feeling neutral.";
    }
}
