package co.edu.uptc.modelo;

public abstract class FiguraGeometrica {
    public abstract void calcularArea();

    public void metodoNoAbstracto() {
        System.out.println(
                "Este es un método no abstracto que no es obligatorio ser implementado en las clases que hereden");
    }
}
