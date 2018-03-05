package bootsample.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "KIEROWCA")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ")
    @SequenceGenerator(name = "SEQ", sequenceName = "KIEROWCA_SEQ")
    @Column(name = "IDKIEROWCY")
    private Long id;
    @Column(name = "IDUZYTKOWNIKA")
    private Long idUser;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IDSAMOCHODU")
    private Car car;

    public Driver(){
    }

    public Driver(Long idUser, Car car) {
        this.idUser = idUser;
        this.car = car;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
