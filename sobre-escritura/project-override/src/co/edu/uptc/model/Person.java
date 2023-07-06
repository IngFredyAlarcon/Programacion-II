package co.edu.uptc.model;

public class Person extends Mammal {
    private String walk;

    public String walking() {
        setWalk("i'm walking with my feet");
        return this.walk;
    }

    public String walking(int distance) {
        setWalk("i'm walking with my feet " + distance + " km");
        return this.walk;
    }

    public String getWalk() {
        return walk;
    }

    public void setWalk(String walk) {
        this.walk = walk;
    }

}
