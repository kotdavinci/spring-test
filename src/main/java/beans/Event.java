package beans;

import java.text.DateFormat;
import java.util.Date;

public class Event {
    private DateFormat df;
    private int id = (int) (Math.random()*100);
    private String msg;
    private Date date;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Event(Date date, DateFormat df) {
        this.date = date;
        this.df = df;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", id, df.format(date), msg);
    }
}