package bootsample.model;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "UZYTKOWNIK")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ")
    @SequenceGenerator(name = "SEQ", sequenceName = "USER_SEQ")
    @Column(name = "IDUZYTKOWNIKA")
    private Long id;
    @Column(name = "IMIE")
    private String name;
    @Column(name = "NAZWISKO")
    private String surname;
    @Column(name = "TELEFON")
    private String phone;
    @Column(name = "PLEC")
    private String gender;
    @Column(name = "ROKURODZENIA")
    private int bornyear;
    @Column(name = "MAIL")
    private String mail;
    @Transient
    private String passwordConfirm;

    @OneToOne(mappedBy = "user")
    private Role role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Opinion> opinion;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<ReservationDrive> reservationDriver;

    public User() {
    }

    public User(String name, String surname, String phone, String gender, int bornyear, String mail, Role role) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.gender = gender;
        this.bornyear = bornyear;
        this.mail = mail;
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getBornyear() {
        return bornyear;
    }

    public void setBornyear(int bornyear) {
        this.bornyear = bornyear;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Transient
    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public List<Opinion> getOpinion() {
        return opinion;
    }

    public void setOpinion(List<Opinion> opinion) {
        this.opinion = opinion;
    }

    public List<ReservationDrive> getReservationDriver() {
        return reservationDriver;
    }

    public void setReservationDriver(List<ReservationDrive> reservationDriver) {
        this.reservationDriver = reservationDriver;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", gender='" + gender + '\'' +
                ", bornyear=" + bornyear +
                ", mail='" + mail + '\'' +
                ", role=" + role +
                ", opinion=" + opinion +
                '}';
    }
}
