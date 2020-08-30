package ma.computime.microservicetagreader.bean;

public class TagBean {

    private String uid;

    private PersonneBean personne;

    public TagBean() {
    }

    public TagBean(String uid, PersonneBean personne) {
        this.uid = uid;
        this.personne = personne;
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
}
