package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by anplamon on 9/14/15.
 */
public class HappyMood extends CurrentMood {
    public HappyMood(Date date) {
        super(date);
    }

    public String mood() {
        return "I AM HAPPY!!!!!!!";
    }
}
