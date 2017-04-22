import java.util.Date;

public class TweetInfo {
    private String name;
    private String message;
    private Date date;

    public TweetInfo(String name, String message) {
        this.name = name;
        this.message = message;
        this.date = new Date();
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

    public Date getDate() {
        return date;
    }
}
