package trevor_esparza.elixirrestblog.data;

import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Post {

    private long id;
    private String title;
    private String content;

    ////With Lombok we no longer need to generate setters/getters/constructors

//    public Post() {
//    }
//
//    public Post(Long id, String title, String content) {
//        this.id = id;
//        this.title = title;
//        this.content = content;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }


}///END OF CLASS
