package ma.computime.microservicetagreader.bean;

public class mDataBean {

    private String m;

    public mDataBean(String m) {
        this.m = m;
    }

    public mDataBean() {
    }

    public String getM() {
        return m;
    }

    public void setM(String m) {
        this.m = m;
    }

    @Override
    public String toString() {
        return "mData{" +
                "m='" + m + '\'' +
                '}';
    }
}
