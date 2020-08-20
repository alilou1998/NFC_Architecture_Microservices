package ma.computime.microservicetag.entities;

public class mData {

    private String m;

    public mData(String m) {
        this.m = m;
    }

    public mData() {
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
