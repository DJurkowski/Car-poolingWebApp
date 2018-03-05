package bootsample.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PREFERENCJE")
public class Preference {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ")
    @SequenceGenerator(name = "SEQ", sequenceName = "PREFERENCJE_SEQ")
    @Column(name = "IDPREFERENCJI")
    private Long id;
    @Column(name = "CZYNIEPALACY")
    private String smokeOrNot;
    @Column(name = "PREFEROWANAPLEC")
    private String preferGender;
    @Column(name = "CZYZWIERZAK")
    private String animalYesOrNot;

    @OneToMany(mappedBy = "preference", cascade = CascadeType.ALL)
    private List<DriveOffer> offerList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSmokeOrNot() {
        return smokeOrNot;
    }

    public void setSmokeOrNot(String smokeOrNot) {
        this.smokeOrNot = smokeOrNot;
    }

    public String getPreferGender() {
        return preferGender;
    }

    public void setPreferGender(String preferGender) {
        this.preferGender = preferGender;
    }

    public String getAnimalYesOrNot() {
        return animalYesOrNot;
    }

    public void setAnimalYesOrNot(String animalYesOrNot) {
        this.animalYesOrNot = animalYesOrNot;
    }

    public List<DriveOffer> getOfferList() {
        return offerList;
    }

    public void setOfferList(List<DriveOffer> offerList) {
        this.offerList = offerList;
    }
}
