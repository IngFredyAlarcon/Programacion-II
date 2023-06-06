package co.edu.uptc.modelo;

public class Chip {
    private String proveedor;
    private String tipo;// memoria o Sim Card
    private String descripcion;

    public Chip(String proveedor, String tipo, String descripcion) {
        this.proveedor = proveedor;
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    public Chip() {
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Chip [proveedor=" + proveedor + ", tipo=" + tipo + ", descripcion=" + descripcion + "]";
    }
}
