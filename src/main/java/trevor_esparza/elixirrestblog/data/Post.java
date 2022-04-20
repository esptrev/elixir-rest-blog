package trevor_esparza.elixirrestblog.data;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "blog_posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String content;
//    private User author;


    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }
}///END OF CLASS
