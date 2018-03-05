package bootsample.model;


import javax.persistence.*;

@Entity
@Table(name = "OPINIA")
public class Opinion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ")
    @SequenceGenerator(name = "SEQ", sequenceName = "OPINIA_SEQ")
    @Column(name = "IDOPINII")
    private Long id;
    @Column(name = "KOMENTARZ")
    private String comments;
    @Column(name = "OCENA")
    private int mark;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IDUZYTKOWNIKA")
    private User user;

    public Opinion() {
    }

    public Opinion(String comments, int mark, User user) {
        this.comments = comments;
        this.mark = mark;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Opinion{" +
                "id=" + id +
                ", comments='" + comments + '\'' +
                ", mark=" + mark +
                ", user=" + user +
                '}';
    }
}
