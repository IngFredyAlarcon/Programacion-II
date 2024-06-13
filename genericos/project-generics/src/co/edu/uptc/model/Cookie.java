package co.edu.uptc.model;

public class Cookie {
    private String type;

    public String get pe() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Cookie() {
    }

    public Cookie(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Cookie [type=" + type + "]";
    }

}
