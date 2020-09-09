package ma.computime.microservicetagdateregister.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class TagDateRegister {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String uid;
    private Date registerDate;

    public TagDateRegister() {
    }

    public TagDateRegister(String uid,Date date){
        this.uid=uid;
        this.registerDate =date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date dateRegister) {
        this.registerDate = dateRegister;
    }
}
