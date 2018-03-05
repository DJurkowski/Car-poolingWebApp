package bootsample.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "SAMOCHOD")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ")
    @SequenceGenerator(name = "SEQ", sequenceName = "SAMOCHOD_SEQ")
    @Column(name = "IDSAMOCHODU")
    private Long id;
    @Column(name = "MARKA")
    private String brand;
    @Column(name = "MODEL")
    private String model;
    @Column(name = "NRREJESTRACYJNY")
    private String rejestrationNumber;
    @Column(name = "LICZBAMIEJSC")
    private int sitsNumber;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private List<Driver> driver;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRejestrationNumber() {
        return rejestrationNumber;
    }

    public void setRejestrationNumber(String rejestrationNumber) {
        this.rejestrationNumber = rejestrationNumber;
    }

    public int getSitsNumber() {
        return sitsNumber;
    }

    public void setSitsNumber(int sitsNumber) {
        this.sitsNumber = sitsNumber;
    }

    public List<Driver> getDriver() {
        return driver;
    }

    public void setDriver(List<Driver> driver) {
        this.driver = driver;
    }
}
