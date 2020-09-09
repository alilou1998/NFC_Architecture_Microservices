package ma.computime.microservicetagdateregister.bean;

public class TagBean {

    private String uid;
    private int personne_id;

    public TagBean(String uid, int personne) {
        this.uid = uid;
        this.personne_id =personne;
    }

    public TagBean() {
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
