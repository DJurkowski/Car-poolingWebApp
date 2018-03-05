package bootsample.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TRASA")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ")
    @SequenceGenerator(name="SEQ",sequenceName = "TRASA_SEQ")
    @Column(name = "IDTRASY")
    private Long id;
    @Column(name = "PANSTWOPOCZATKOWE")
    private String beginNation;
    @Column(name = "MIASTOPOCZATKOWE")
    private String beginCity;
    @Column(name = "PANSTWODOCELOWE")
    private String endNation;
    @Column(name = "MIASTODOCELOWE")
    private String endCity;

    @OneToMany(mappedBy = "route", cascade = CascadeType.ALL)
    private List<DriveOffer> offerList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBeginNation() {
        return beginNation;
    }

    public void setBeginNation(String beginNation) {
        this.beginNation = beginNation;
    }

    public String getBeginCity() {
        return beginCity;
    }

    public void setBeginCity(String beginCity) {
        this.beginCity = beginCity;
    }

    public String getEndNation() {
        return endNation;
    }

    public void setEndNation(String endNation) {
        this.endNation = endNation;
    }

    public String getEndCity() {
        return endCity;
    }

    public void setEndCity(String endCity) {
        this.endCity = endCity;
    }

    public List<DriveOffer> getOfferList() {
        return offerList;
    }

    public void setOfferList(List<DriveOffer> offerList) {
        this.offerList = offerList;
    }
}
