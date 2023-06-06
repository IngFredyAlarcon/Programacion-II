package co.edu.uptc.control;

import co.edu.uptc.modelo.Circulo;
import co.edu.uptc.modelo.Cuadrado;

public class ControlFiguraGeometrica {
    Cuadrado cuadrado1 = new Cuadrado();
    Circulo circulo1 = new Circulo();

    public void calcularAreaCuadrado(int lado) {
        cuadrado1.setLado(lado);
        cuadrado1.calcularArea();
    }

    public int mostrarAreaCuadrado() {
        return cuadrado1.getArea();
    }

    public void calcularAreaCirculo(int radio) {
        circulo1.setRadio(radio);
        circulo1.calcularArea();
    }

    public float mostrarAreaCirculo() {
        return circulo1.getArea();
    }
}
