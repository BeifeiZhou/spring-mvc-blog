package blog.models;
import java.util.Date;

/**
 * Created by bzhou on 01/09/16.
 */
public class Post {
    private Long id;
    private String title;
    private String body;
    private User author;
    private Date date = new Date();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString(){
        return "User{" + "id=" + id + ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", date='" + date + '\'' + '}';
    }
}
