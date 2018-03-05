package bootsample.model;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "REZERWACJAPRZEJAZDU")
public class ReservationDrive {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ")
    @SequenceGenerator(name = "SEQ", sequenceName = "REZERWACJAPRZEJAZDU_SEQ")
    @Column(name = "IDDOLACZENIA")
    private Long id;
    @Column(name = "DATA")
    private String date;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "IDPRZEJAZDU")
    private DriveOffer driveOffer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IDUZYTKOWNIKA")
    private User user;

    @Transient
    DateFormat dateFormat;

    @Transient
    Date dateNow;

    public ReservationDrive() {
    }

    public ReservationDrive(DriveOffer driveOffer, User user) {
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateNow = new Date();
        this.date = dateFormat.format(dateNow).toString();
        this.driveOffer = driveOffer;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public DriveOffer getDriveOffer() {
        return driveOffer;
    }

    public void setDriveOffer(DriveOffer driveOffer) {
        this.driveOffer = driveOffer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
