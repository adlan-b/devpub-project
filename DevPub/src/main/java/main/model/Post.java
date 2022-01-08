package main.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;


@Data
@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "is_active", nullable = false)
    private byte isActive;

    @Enumerated(EnumType.STRING)
    @Column(name = "moderator_status", columnDefinition = "enum('NEW', 'ACCEPTED', 'DECLINED') default 'NEW'", nullable = false)
    private Status moderatorStatus;

    @Column(name = "moderator_id")
    private Integer moderatorId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User userId;

    @Column(name = "time", nullable = false)
    private LocalDateTime time;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "text", nullable = false, columnDefinition = "TEXT")
    private String text;

    @Column(name = "view_count", nullable = false)
    private Integer viewCount;

    @OneToMany(mappedBy = "postId",cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
    private List<PostVotes> postVotes;

    @ManyToMany
    @JoinTable(
            name = "tag2post",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Tag> tags;

    @OneToMany(mappedBy = "postId")
    private List<PostComment> postComments;

}
