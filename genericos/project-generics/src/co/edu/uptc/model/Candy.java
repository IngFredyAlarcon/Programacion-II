package co.edu.uptc.model;

public class Candy {
    private int packageSize;
    private String flavor;

    public int getPackageSize() {
        return packageSize;
    }

    public void setPackageSize(int packageSize) {
        this.packageSize = packageSize;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public Candy() {
    }

    public Candy(int packageSize, String flavor) {
        this.packageSize = packageSize;
        this.flavor = flavor;
    }

    @Override
    public String toString() {
        return "Candy [packageSize=" + packageSize + ", flavor=" + flavor + "]";
    }

}
