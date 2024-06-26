package lab7.lab_7;

public class Token {

    Integer v1;
    Integer v2;

    public Token(Integer v1, Integer v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    public Integer getV1() {
        return v1;
    }

    public void setV1(Integer v1) {
        this.v1 = v1;
    }

    public Integer getV2() {
        return v2;
    }

    public void setV2(Integer v2) {
        this.v2 = v2;
    }

    @Override
    public String toString() {
        return "Token{" +
                "v1=" + v1 +
                ", v2=" + v2 +
                '}';
    }
}
