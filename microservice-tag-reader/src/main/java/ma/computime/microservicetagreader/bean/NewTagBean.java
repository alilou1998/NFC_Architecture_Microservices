package ma.computime.microservicetagreader.bean;

public class NewTagBean {

    private String uid;
    private int personne_id;

    public NewTagBean(String uid, int personne_id) {
        this.uid = uid;
        this.personne_id = personne_id;
    }

    public NewTagBean() {
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
