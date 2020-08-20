package ma.computime.microservicetag.bean;

public class PersonneBean {


    private String nom;
    private String prenom;

    public PersonneBean() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public PersonneBean(String prenom, String nom) {
        this.prenom = prenom;
        this.nom = nom;
    }

}
