# Ejercicios de aplicación con principios SOLID en JAVA
## 1. Single Responsibility Principle (SRP) - Principio de Responsabilidad Única
### Definición
👉 El principio de responsabilidad única establece que una clase debe tener una sola razón para cambiar, es decir, una clase debe tener una sola responsabilidad.
### ❌ Violación del principio
```java
public class Report {
    public void generateReport() {
        System.out.println("Generating Report...");
    }

    public void saveToFile() {
        System.out.println("Saving to File...");
    }
}
```
### ✅ Aplicando el principio
```java
public class Report {
    public void generateReport() {
        System.out.println("Generating Report...");
    }
}

public class FileManager {
    public void saveToFile(Report report) {
        System.out.println("Saving Report to File...");
    }
}
```
## 2. Open/Closed Principle (OCP) - Principio de Abierto
### Definición
👉 El principio abierto/cerrado establece que una clase debe estar abierta para la extensión, pero cerrada para la modificación.
### ❌ Violación del principio
```java
public class Payment {
    public void pay(String method) {
        if (method.equals("Paypal")) {
            System.out.println("Paying with Paypal");
        } else if (method.equals("CreditCard")) {
            System.out.println("Paying with Credit Card");
        }
    }
}
```
### ✅ Aplicando el principio
```java
public interface Payment {
    void pay();
}

public class PaypalPayment implements Payment {
    @Override
    public void pay() {
        System.out.println("Paying with Paypal");
    }
}

public class CreditCardPayment implements Payment {
    @Override
    public void pay() {
        System.out.println("Paying with Credit Card");
    }
}
```
## 3. Liskov Substitution Principle (LSP) - Principio de Sustitución de Liskov
### Definición
👉 El principio de sustitución de Liskov establece que los objetos de una super
clase deben ser reemplazables por objetos de sus subclases sin afectar la
funcionalidad del programa.
👉 Las clases hijas deben poder reemplazar a sus clases padres sin alterar el funcionamiento.
### ❌ Violación del principio
```java
public class Rectangle {
    protected int width;
    protected int height;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getArea() {
        return width * height;
    }
}

public class Square extends Rectangle {
    @Override
    public void setWidth(int width) {
        this.width = width;
        this.height = width;
    }

    @Override
    public void setHeight(int height) {
        this.width = height;
        this.height = height;
    }
}
```
### ✅ Aplicando el principio
```java
public interface Shape {
    int getArea();
}

public class Rectangle implements Shape {
    protected int width;
    protected int height;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int getArea() {
        return width * height;
    }
}

public class Square implements Shape {
    private int side;

    public void setSide(int side) {
        this.side = side;
    }

    @Override
    public int getArea() {
        return side * side;
    }
}
```
### Otro ejemplo
### ❌ Violación del principio
```java
public class Bird {
    public void fly() {
        System.out.println("Flying...");
    }
}

class Penguin extends Bird {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Penguins can't fly");
    }
}

public class Main {
    public static void main(String[] args) {
        Bird bird = new Penguin();
        bird.fly();  // 💥 ¡Aquí lanza un error!
    }
}
```
#### ¿Por qué está mal? 🚫
La clase Penguin hereda de Bird, pero los pingüinos no pueden volar.

Cuando tratamos a un pingüino como si fuera un pájaro y llamamos al método fly(), el programa lanza una excepción.

Esto rompe el principio porque si reemplazamos la clase padre por una hija, no debería alterar el comportamiento esperado del sistema.

### ✅ Aplicando el principio
```java
class Bird {
    public void move() {
        System.out.println("Moving...");
    }
}

class FlyingBird extends Bird {
    public void fly() {
        System.out.println("Flying...");
    }
}

class Penguin extends Bird {
    public void swim() {
        System.out.println("Swimming...");
    }
}

public class Main {
    public static void main(String[] args) {
        Bird sparrow = new FlyingBird();
        Bird penguin = new Penguin();

        sparrow.move();   // Moving...
        ((FlyingBird) sparrow).fly();  // Flying...

        penguin.move();   // Moving...
        ((Penguin) penguin).swim();    // Swimming...
    }
}
```
### 🔑 Regla de Oro
👉 Si una clase hija rompe la lógica de la clase padre, algo está mal en la jerarquía de herencia.

## 4. Interface Segregation Principle (ISP) - Principio de Segregación de Interfaces
### Definición
👉 El principio de segregación de interfaces establece que una clase no debe depender de métodos que no utiliza.
### ❌ Violación del principio
```java
public interface Worker {
    void work();
    void eat();
}

public class Human implements Worker {
    @Override
    public void work() {
        System.out.println("Working...");
    }

    @Override
    public void eat() {
        System.out.println("Eating...");
    }
}

public class Robot implements Worker {
    @Override
    public void work() {
        System.out.println("Working...");
    }

    @Override
    public void eat() {
        // No come
    }
}
```
### ✅ Aplicando el principio
```java
public interface Workable {
    void work();
}

public interface Eatable {
    void eat();
}

public class Human implements Workable, Eatable {
    @Override
    public void work() {
        System.out.println("Working...");
    }

    @Override
    public void eat() {
        System.out.println("Eating...");
    }
}

public class Robot implements Workable {
    @Override
    public void work() {
        System.out.println("Working...");
    }
}
```
## 5. Dependency Inversion Principle (DIP) - Principio de Inversión de Dependencias
### Definición
👉 El principio de inversión de dependencias establece que las clases de alto nivel no deben depender de las clases de bajo nivel. Ambos deben depender de abstracciones.
### ❌ Violación del principio
```java
public class LightBulb {
    public void turnOn() {
        System.out.println("LightBulb: Bulb turned on...");
    }

    public void turnOff() {
        System.out.println("LightBulb: Bulb turned off...");
    }
}

public class Switch {
    private LightBulb lightBulb;

    public Switch() {
        this.lightBulb = new LightBulb();
    }

    public void flip() {
        lightBulb.turnOn();
    }
}
```
### ✅ Aplicando el principio
```java
public interface Switchable {
    void turnOn();
    void turnOff();
}

public class LightBulb implements Switchable {
    @Override
    public void turnOn() {
        System.out.println("LightBulb: Bulb turned on...");
    }

    @Override
    public void turnOff() {
        System.out.println("LightBulb: Bulb turned off...");
    }
}

public class Fan implements Switchable {
    @Override
    public void turnOn() {
        System.out.println("Fan: Fan turned on...");
    }

    @Override
    public void turnOff() {
        System.out.println("Fan: Fan turned off...");
    }
}

public class Switch {
    private Switchable client;

    public Switch(Switchable client) {
        this.client = client;
    }

    public void flip() {
        client.turnOn();
    }
}
```
### 🔑 Resumen

👉 **SRP** - Una clase debe tener una sola razón para cambiar.
👉 **OCP** - Una clase debe estar abierta para la extensión, pero cerrada para la modificación.
👉 **LSP** - Los objetos de una super
clase deben ser reemplazables por objetos de sus subclases sin afectar la
funcionalidad del programa.
👉 **ISP** - Una clase no debe depender de métodos que no utiliza.
👉 **DIP** - Las clases de alto nivel no deben depender de las clases de bajo nivel. Ambos deben depender de abstracciones.
```

## 6. Narrativas de problemas propuestos para solucionar aplicando los principios SOLID
### 6.1. Single Responsibility Principle (SRP) - Principio de Responsabilidad Única

#### Problema
👉 Tenemos una clase que se encarga de enviar correos electrónicos y también de guardar los correos en la base de datos. La clase tiene dos responsabilidades y viola el principio de responsabilidad única.

### 6.2. Open/Closed Principle (OCP) - Principio de Abierto/Cerrado

#### Problema
👉 Tenemos una clase que se encarga de calcular el salario de los empleados. La clase tiene un método que calcula el salario de un empleado, pero si queremos agregar un nuevo tipo de empleado, debemos modificar la clase existente.

### 6.3. Liskov Substitution Principle (LSP) - Principio de Sustitución de Liskov

#### Problema
👉 Tenemos una clase que representa una forma geométrica. La clase tiene un método para calcular el área de la forma. Tenemos dos subclases: Rectángulo y Cuadrado. La subclase Cuadrado hereda de la clase Rectángulo, pero cuando cambiamos el ancho de un cuadrado, también cambia la altura, lo que viola el principio de sustitución de Liskov.

### 6.4. Interface Segregation Principle (ISP) - Principio de Segregación de Interfaces

#### Problema
👉 Tenemos una interfaz que define varios métodos. Tenemos dos clases que implementan la interfaz, pero una de las clases no necesita todos los métodos. La clase tiene una dependencia innecesaria de un método que no utiliza.

### 6.5. Dependency Inversion Principle (DIP) - Principio de Inversión de Dependencias

#### Problema
👉 Tenemos una clase que depende de una clase concreta. Si queremos cambiar la clase concreta por otra, debemos modificar la clase existente. La clase tiene una dependencia fuerte de una clase concreta y viola el principio de inversión de dependencias.
