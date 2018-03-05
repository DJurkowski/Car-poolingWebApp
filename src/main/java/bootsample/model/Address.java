package bootsample.model;

import javax.persistence.*;

@Entity
@Table(name = "ADRES")
public class Address {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ")
    @SequenceGenerator(name = "SEQ", sequenceName = "ADRES_SEQ")
    @Column(name = "IDMIEJSCA")
    private Long id;
    @Column(name = "PANSTWO")
    private String nation;
    @Column(name = "MIASTO")
    private String city;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
