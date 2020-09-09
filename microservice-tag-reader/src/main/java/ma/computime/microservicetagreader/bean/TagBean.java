package ma.computime.microservicetagreader.bean;


import java.util.Date;

public class TagBean {

    private String uid;

    private Date registerDate;


    public TagBean() {
    }

    public TagBean(String uid, Date registerDate) {
        this.uid = uid;
        this.registerDate = registerDate;
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

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }
}
