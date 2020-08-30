package ma.computime.microservicetagreader.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Tag {
    @Id
    private String uid;
    @OneToOne(cascade = CascadeType.DETACH)
    private Personne personne;

    public Tag() {
    }

    public Tag(String uid, Personne personne) {
        this.uid = uid;
        this.personne = personne;
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
}
