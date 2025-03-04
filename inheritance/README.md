# Herencia en Java
La herencia es un mecanismo que permite crear una nueva clase a partir de una clase existente. La nueva clase hereda los atributos y métodos de la clase existente. La clase existente se conoce como superclase y la nueva clase se conoce como subclase.

La herencia se utiliza para reutilizar el código y para reducir la complejidad de un programa. En Java, una clase puede heredar de otra clase utilizando la palabra clave `extends`.

## Sintaxis

La sintaxis para crear una subclase en Java es la siguiente:

```java
class Subclase extends Superclase {
    // Cuerpo de la subclase
}
```

Donde `Subclase` es la nueva clase que se está creando y `Superclase` es la clase de la que se está heredando.

## Ejemplo

Supongamos que tenemos una clase `Vehiculo` que tiene los atributos `marca` y `modelo`, y la clase `Coche` que hereda de la clase `Vehiculo` y tiene un atributo adicional `numeroPuertas`. La clase `Coche` se puede definir de la siguiente manera:

```java

class Vehiculo {
    String marca;
    String modelo;
}

class Coche extends Vehiculo {
    int numeroPuertas;
}
```

En este ejemplo, la clase `Coche` hereda los atributos `marca` y `modelo` de la clase `Vehiculo` y tiene un atributo adicional `numeroPuertas`.