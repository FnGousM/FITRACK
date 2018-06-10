/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fitrack;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Mauricio
 */
public class PersonalizacionUsuario extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        //Textos para los radio buttons.
        String objective[] = {"PERDIDA DE PESO","MANTENIMIENTO"
                ,"GANANCIA DE MASA MUSCULAR"};
        //ObservableList para el combo box.
        ObservableList<String> trainingDays = FXCollections.observableArrayList(
                "1","2","3","4","5","6","7");
        
        //Controles de la aplicacion.
        Label title = new Label("PERSONALIZACIÓN DE USUARIO");
        Label lOne = new Label("¿Cuántos días a la semana entrenas?");
        Label lTwo = new Label("¿Cuántos minutos entrenas por día?"
                + "\n  (incluyendo cardio y pesas juntos)");
        Label lThree = new Label("¿Cuál es tu objetivo?");
        ComboBox days = new ComboBox(trainingDays);
        TextField minutes = new TextField();
        Button bBack = new Button("Atras");
        Button bNext = new Button("Siguiente");
        
        //Layout para la parte superior.
        VBox topRoot = new VBox(title);
        //Layout para la parte central superior.
        VBox centerSupRoot = new VBox(lOne,days,lTwo,minutes,lThree);
        //Layout para la parte central inferior.
        HBox centerInfRoot = new HBox(generateVBox(objective));
        //Layout para la parte central.
        VBox centerRoot = new VBox(centerSupRoot,centerInfRoot);
        //Layout para la parte inferiror.
        AnchorPane bottomRoot = new AnchorPane(bBack,bNext);
        //Layout principal, el cual contendra a los tres layouts anteriores.
        BorderPane mainRoot = new BorderPane();
        
        /*Al utilizar BorderPane como layout princiapl, debemos establecer 
        la posicion de nuestros layouts secundarios.*/
        mainRoot.setTop(topRoot);
        mainRoot.setCenter(centerRoot);
        mainRoot.setBottom(bottomRoot);
        //Establecemos la destancia entre los botones y las esquinas.
        AnchorPane.setRightAnchor(bNext,10.0);
        AnchorPane.setLeftAnchor(bBack,10.0);
        
        //Creamos y asociamos las clases css para los controles.
        mainRoot.getStyleClass().add("main-root");
        topRoot.getStyleClass().add("top-root");
        centerRoot.getStyleClass().add("center-root");
        centerSupRoot.getStyleClass().add("center-sup-root");
        centerInfRoot.getStyleClass().add("center-inf-root");
        bottomRoot.getStyleClass().add("bottom-root");
        title.getStyleClass().add("title");
        
        //Creamos nuestra escena y le agregamos el layout principal
        Scene scene = new Scene(mainRoot, 350, 500);
        //Vinculamos nuestro archivo css a nuestra escena.
        scene.getStylesheets().add("css/estilos-fitrack.css");
        
        primaryStage.setTitle("Nivel de Actividad");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    /*Metodo privado, el cual recibe una cadena de tipo String, creando con
    ella los radio buttons necesarios.
    Al final, regresa un objeto de tipo VBox.*/
    private VBox generateVBox(String rBText[]){
        VBox root = new VBox();

        int size = rBText.length;
        RadioButton rButtons[] = new RadioButton[size];
        ToggleGroup tg = new ToggleGroup();

        for(int i=0;i<size;i++){
            rButtons[i] = new RadioButton(rBText[i]);
            rButtons[i].setToggleGroup(tg);
            root.getChildren().addAll(rButtons[i]);
        }
        return root;
    }
}