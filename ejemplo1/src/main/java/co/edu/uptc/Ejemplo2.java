package co.edu.uptc;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Ejemplo2 extends Application {

    private Stage primaryStage;
    private Scene scene1, scene2;
    private Label labelScene1;
    private TextField textFieldScene1;
    private Label labelScene2;
    private TextField textFieldScene2;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;

        // Contenido para la primera escena
        Pane rootPane1 = new Pane();
        labelScene1 = new Label("enter your name: ");
        labelScene1.setLayoutX(20);
        labelScene1.setLayoutY(20);
        textFieldScene1 = new TextField();
        textFieldScene1.setLayoutX(20);
        textFieldScene1.setLayoutY(50);
        Button button1 = new Button("Change to scene 2");
        // rootPane1.getChildren().add(button1);//Se pueden adicionar uno por uno o
        // adicionar todos los elementos al mismo tiempo
        rootPane1.getChildren().addAll(labelScene1, textFieldScene1, button1);
        scene1 = new Scene(rootPane1, 300, 200);

        // Configurar la escena inicial
        primaryStage.setScene(scene1);
        primaryStage.setTitle("Scene 1");
        primaryStage.show();

        // Configurar el evento de clic para cambiar a la segunda escena
        button1.setOnAction(event -> cambiarAEscena2());
    }

    private void cambiarAEscena2() {
        // Obtener valores de la Escena 1
        String valueTextFieldScene1 = textFieldScene1.getText();

        // Crear el contenido para la segunda escena
        StackPane rootPane2 = new StackPane();
        labelScene2 = new Label("Hello " + valueTextFieldScene1);
        labelScene2.setLayoutY(1);
        labelScene2.setLayoutX(1);
        textFieldScene2 = new TextField();
        textFieldScene2.setLayoutY(50);
        textFieldScene2.setLayoutX(20);
        Button button2 = new Button("Change to scene 1");
        button2.setLayoutY(80);
        button2.setLayoutX(20);

        rootPane2.getChildren().addAll(labelScene2, textFieldScene2);
        StackPane.setMargin(button2, new Insets(10, 10, 50, 40));
        rootPane2.getChildren().add(button2);
        scene2 = new Scene(rootPane2, 300, 200);

        // Configurar la escena actual en la Stage
        primaryStage.setScene(scene2);
        primaryStage.setTitle("Escena 2");

        // Configurar el evento de clic para cambiar a la primera escena
        button2.setOnAction(event -> cambiarAEscena1());

        // Puedes utilizar el valor obtenido de la escena 1 en la escena 2
        textFieldScene2.setText("Valor de Escena 1: " + valueTextFieldScene1);
        textFieldScene2.setDisable(true);
    }

    private void cambiarAEscena1() {
        // Configurar la escena actual en la Stage
        primaryStage.setScene(scene1);
        primaryStage.setTitle("Escena 1");
    }

    public static void main(String[] args) {
        launch(args);
    }

}
