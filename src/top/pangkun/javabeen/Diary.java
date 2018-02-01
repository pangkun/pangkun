package top.pangkun.javabeen;

/**
 * Created by 庞昆 on 2018/1/24.
 */
public class Diary {
    private String time;
    private String title;
    private String payload;
    private int id;

    public Diary() {

    }

    public Diary(String title, String payload, String time) {
        this.title = title;
        this.payload = payload;
        this.time = time;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
