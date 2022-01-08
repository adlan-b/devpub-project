package main.model;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "is_moderator", nullable = false, columnDefinition = "TINYINT")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean isModerator;

    @Column(name = "reg_time", nullable = false)
    private LocalDateTime regTime;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "code")
    private String code;

    @Column(name = "photo", columnDefinition = "TEXT")
    private String photo;

    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL)
    private List<Post> posts;

    @OneToMany(mappedBy = "userId", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
    private List<PostVotes> postVotes;

    public void addPostToAuthor(Post post) {
        if (posts == null) {
            posts = new ArrayList<>();
        }
        posts.add(post);
        post.setUserId(this);
    }

    @OneToMany(mappedBy = "userId")
    private List<PostComment> postComments;

}
