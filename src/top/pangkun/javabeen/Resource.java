package top.pangkun.javabeen;

/**
 * Created by 庞昆 on 2018/1/30.
 */
public class Resource {
    private int id;
    private String title;
    private String url;
    private String time;

    public Resource(){

    }

    public Resource(String title, String url, String time) {
        this.title = title;
        this.url=url;
        this.time = time;
    }
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
