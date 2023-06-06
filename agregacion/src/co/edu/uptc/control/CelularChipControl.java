package co.edu.uptc.control;

import co.edu.uptc.modelo.Chip;
import co.edu.uptc.modelo.Movil;

public class CelularChipControl {
    private Movil m;
    private Chip c;

    public CelularChipControl() {
    }

    public void crearMovil(String marca, String modelo, String proveedor, String tipo, String descripcion) {
        m = new Movil(marca, modelo);
        c = new Chip();
        c.setDescripcion(descripcion);
        c.setProveedor(proveedor);
        c.setTipo(tipo);
        m.agregarChip(c);
    }

    public String mostrarDatosMovil() {
        return m.toString();
    }

    public String mostrarDatosChip() {
        return c.toString();
    }

    public void eliminarMovil() {
        m = null;
    }
}
