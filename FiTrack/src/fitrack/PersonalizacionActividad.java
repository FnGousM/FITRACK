/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fitrack;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
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
public class PersonalizacionActividad extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        //Textos para los labels y radio buttons.
        String lText[] = {"PASO TODO EL DÍA SENTADO\n(SECRETARIA,"
                + "TRABAJO DE OFICINA, ETC)"
                ,"PASO GRAN PARTE DEL TIEMPO DE PIE\n(PROFESOR, CAJERO, ETC)"
                ,"PASO GRAN PARTE DEL DIA MOVIENDOME\n(MESERO, CARTERO, ETC)"
                ,"PASO GRAN PARTE DEL DÍA HACIENDO\nMUCHA ACTIVIDAD FÍSICA"
                + "\n(ALBAÑIL, CARPINTERO, ETC)"};
        String rBText[] = {"SOY SEDENTARIO/A:","SOY LIGERAMENTE ACTIVO/A:"
                ,"SOY ACTIVO/A:","SOY MUY ACTIVO/A:"};
        
        //Controles de la aplicacion.
        Label title = new Label("PERSONALIZACIÓN DE USUARIO");
        Label subTitle = new Label("Nivel de Actividad");
        Button bBack = new Button("Atras");
        Button bNext = new Button("Siguiente");
        
        //Layout para la parte superior.
        VBox topRoot = new VBox(title,subTitle);
        //Layout para la parte central.
        HBox centerRoot = new HBox(generateVBox(lText,rBText));
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
        bottomRoot.getStyleClass().add("bottom-root");
        title.getStyleClass().add("title");
        subTitle.getStyleClass().add("subtitle");
        
        //Creamos nuestra escena y le agregamos el layout principal
        Scene scene = new Scene(mainRoot, 350, 500);
        //Vinculamos nuestro archivo css a nuestra escena.
        scene.getStylesheets().add("css/estilos-fitrack.css");
        
        primaryStage.setTitle("Nivel de Actividad");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    /*Metodo privado, el cual recibe dos cadenas de tipo String, creando con
    ellas los labels y radio buttons necesarios.
    Al final, regresa un objeto de tipo VBox.*/
    private VBox generateVBox(String lText[],String rBText[]){
        VBox root = new VBox();
        
        if(lText.length == rBText.length){
            int size = lText.length;
            Label lDescriptions[] = new Label[size];
            RadioButton rButtons[] = new RadioButton[size];
            ToggleGroup tg = new ToggleGroup();

            for(int i=0;i<size;i++){
                lDescriptions[i] = new Label(lText[i]);
                rButtons[i] = new RadioButton(rBText[i]);
                rButtons[i].setToggleGroup(tg);
                root.getChildren().addAll(rButtons[i],lDescriptions[i]);
                lDescriptions[i].getStyleClass().add("label-in-radio");
            }
        }
        return root;
    }
}