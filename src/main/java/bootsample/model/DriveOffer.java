package bootsample.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "OFERTAPRZEJAZDU")
public class DriveOffer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ")
    @SequenceGenerator(name = "SEQ", sequenceName = "OFERTAPRZEJAZDU_SEQ")
    @Column(name = "IDPRZEJAZDU")
    private Long id;
    @Column(name = "DATA")
    private String date;
    @Column(name = "KOSZT")
    private float cost;
    @Column(name = "WOLNEMIEJSCA")
    private int sitsNumber;
    @Column(name = "IDKIEROWCY")
    private Long idDriver;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IDPREFERENCJI")
    private Preference preference;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="IDTRASY_OFERTA")
    private Route route;

    @OneToMany(mappedBy = "driveOffer", cascade = CascadeType.MERGE )
    private List<ReservationDrive> reservationDrive;

    public DriveOffer() {
    }

    public DriveOffer(String date, float cost, int sitsNumber, Long idDriver, Preference preference, Route route) {
        this.date = date;
        this.cost = cost;
        this.sitsNumber = sitsNumber;
        this.idDriver = idDriver;
        this.preference = preference;
        this.route = route;
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

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public int getSitsNumber() {
        return sitsNumber;
    }

    public void setSitsNumber(int sitsNumber) {
        this.sitsNumber = sitsNumber;
    }


    public Long getIdDriver() {
        return idDriver;
    }

    public void setIdDriver(Long idDriver) {
        this.idDriver = idDriver;
    }

    public Preference getPreference() {
        return preference;
    }

    public void setPreference(Preference preference) {
        this.preference = preference;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public List<ReservationDrive> getReservationDrive() {
        return reservationDrive;
    }

    public void setReservationDrive(List<ReservationDrive> reservationDrive) {
        this.reservationDrive = reservationDrive;
    }
}
