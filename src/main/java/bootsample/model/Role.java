package bootsample.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "KONTO")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ")
    @SequenceGenerator(name = "SEQ", sequenceName = "ACCOUNT_SEQ")
    @Column(name = "IDUZYTKOWNIKA")
    private Long id;
    @Column(name = "LOGIN")
    private String nickname;
    @Column(name = "HASLO")
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IDUZYTKOWNIKA_KONTO")
    private User user;

    public Role() {
    }

    public Role(String nickname, String password, User user) {
        this.nickname = nickname;
        this.password = password;
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    //    @ManyToMany(mappedBy = "roles")
//    public Set<User> getUsers() {
//        return users;
//    }
//
//    public void setUsers(Set<User> users) {
//        this.users = users;
//    }
}
