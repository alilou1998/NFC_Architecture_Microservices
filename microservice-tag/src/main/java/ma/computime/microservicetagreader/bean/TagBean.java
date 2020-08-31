package ma.computime.microservicetagreader.bean;

import java.util.Date;

public class TagBean {

    private String uid;

    private PersonneBean personne;

    private Date registerDate;

    public TagBean() {
    }

    public TagBean(String uid, PersonneBean personne,Date registerDate) {
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

    public PersonneBean getPersonne() {
        return personne;
    }

    public void setPersonne(PersonneBean personne) {
        this.personne = personne;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }
}
