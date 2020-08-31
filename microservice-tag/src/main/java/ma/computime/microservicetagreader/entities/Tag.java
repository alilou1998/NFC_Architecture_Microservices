package ma.computime.microservicetagreader.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Date;

@Entity
public class Tag {
    @Id
    private String uid;
    @OneToOne(cascade = CascadeType.DETACH)
    private Personne personne;

    private Date registerDate;

    public Tag() {
    }

    public Tag(String uid, Personne personne,Date registerDate) {
        this.uid = uid;
        this.personne = personne;
        this.registerDate= registerDate;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }
}
