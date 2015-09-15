package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by anplamon on 9/14/15.
 */
public abstract class CurrentMood {
    private Date date;

    public CurrentMood(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public abstract String mood();
}
