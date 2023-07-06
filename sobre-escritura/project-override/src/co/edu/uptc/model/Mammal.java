package co.edu.uptc.model;

public class Mammal {
    private String walk;

    public String walking() {
        setWalk("i'm walking");
        return this.walk;
    }

    public String getWalk() {
        return walk;
    }

    public void setWalk(String walk) {
        this.walk = walk;
    }
}
