public class Estudiante {
    private static Estudiante instanciaUnica;

    private Estudiante() {
        // Inicialización de recursos, si es necesario
    }

    public static Estudiante obtenerInstancia() {
        if (instanciaUnica == null) {
            synchronized (Estudiante.class) {
                if (instanciaUnica == null) {
                    instanciaUnica = new Estudiante();
                }
            }
        }
        return instanciaUnica;
    }

    public static void mostrarMensaje() {
        System.out.println("Hola, soy una instancia única del Estudiante!");
    }
}

// el siguiente fragmento en la clase app
/*public class Main {
    public static void main(String[] args) {
        Estudiante estudiante = Estudiante.obtenerInstancia();

        Estudiante.mostrarMensaje();
    }
}*/



