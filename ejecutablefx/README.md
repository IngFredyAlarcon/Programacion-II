# Pasos para generar un ejecutable de JavaFX

## 1. Crear archivo manifest.mf
```bash
echo "Main-Class: co.edu.uptc.App" > manifest.mf
```

## 2. Compilar el proyecto
```bash
javac --module-path $PATH_TO_FX --add-modules javafx.controls,javafx.fxml,javafx.graphics,javafx.base,javafx.media,javafx.swing,javafx.web -d out src/co/edu/uptc/*.java
```

## 3. Crear archivo jar
### 3.1 Crear archivo jar sin dependencias
```bash
jar cfm app.jar manifest.mf -C target/classes .
```

### 3.2 Crear archivo jar con dependencias
```bash
jar cfm app.jar manifest.mf -C out . -C $PATH_TO_FX .
```

## 4. Ejecutar el archivo jar

### 4.1 dando de manera explicita el sdk de javafx

```bash
java --module-path "C:\javafx-sdk-22.0.2\lib" --add-modules javafx.controls,javafx.fxml -jar app.jar
```

### 4.2 dando de manera implicita el sdk de javafx

```bash
java -jar app.jar
```

## 5. Crear archivo ejecutable
### 5.1 Crear archivo ejecutable para Windows
```bash
echo "@echo off" > run.bat
echo "java --module-path "C:\\javafx-sdk-22.0.2\\lib" --add-modules javafx.controls,javafx.fxml -jar app.jar" >> run.bat
```


