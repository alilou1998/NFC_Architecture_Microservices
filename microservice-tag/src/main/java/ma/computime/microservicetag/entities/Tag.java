package ma.computime.microservicetag.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Tag {
    @Id
    private String uid;

    private int personne_id;

    public Tag() {
    }

    public Tag(String uid, int personne_id) {
        this.uid = uid;
        this.personne_id = personne_id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getPersonne_id() {
        return personne_id;
    }

    public void setPersonne_id(int personne_id) {
        this.personne_id = personne_id;
    }
}
