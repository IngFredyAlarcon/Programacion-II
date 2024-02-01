package co.edu.uptc.model;

public class Donut {
    private String flavor;

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public Donut() {
    }

    public Donut(String flavor) {
        this.flavor = flavor;
    }

    @Override
    public String toString() {
        return "Donut [flavor=" + flavor + "]";
    }

}
