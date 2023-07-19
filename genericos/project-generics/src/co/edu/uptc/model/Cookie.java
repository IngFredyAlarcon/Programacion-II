package co.edu.uptc.model;

public class Cookie {
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Cookie(String type) {
        this.type = type;
    }

    public Cookie() {
    }

    @Override
    public String toString() {
        return "Cookie [type=" + type + "]";
    }

}
