# Interfaces en Java
En Java, una interfaz es un tipo de referencia similar a una clase que puede contener solo constantes, métodos de firma, métodos predeterminados y métodos estáticos. Es un mecanismo mediante el cual se puede lograr la abstracción y el mecanismo de herencia múltiple.

Una interfaz no puede contener un constructor porque no se puede instanciar. Por lo tanto, no se puede crear un objeto de una interfaz. La interfaz se utiliza para proporcionar una forma de definir un contrato para los métodos.

## Sintaxis
```java
interface interfaz {
    // constantes
    // métodos abstractos
}
```

## Ejemplo
```java
interface Animal {
    void sonido();
}

class Perro implements Animal {
    public void sonido() {
        System.out.println("Guau");
    }
}

class Gato implements Animal {
    public void sonido() {
        System.out.println("Miau");
    }
}

public class Main {
    public static void main(String[] args) {
        Perro perro = new Perro();
        perro.sonido();

        Gato gato = new Gato();
        gato.sonido();
    }
}
```

## Salida
```
Guau
Miau
```
