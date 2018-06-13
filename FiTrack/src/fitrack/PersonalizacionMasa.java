/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fitrack;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Mauricio
 */
public class PersonalizacionMasa extends Application {
       
    @Override
    public void start(Stage escenario) {
        escenario.setTitle("Personalizacion de genero");
        
        //Etiqueta para el titulo
        Label lbTitulo = new Label("PERSONALIZACION DE USUARIO");
                          
        //Etiqueta para el peso
        Label lbPeso = new Label("Peso");
                
        //Crea una caja de texto
        TextField tfPeso = new TextField(" ");
        tfPeso.setPrefSize(80, 10);
        
        //Crea una lista observable para el combo box
        ObservableList<String> unidad =
        FXCollections.observableArrayList("KG", "LB");  
        
        //Crea el combo box
        ComboBox<String> cbPeso = new ComboBox<String>(unidad);
        cbPeso.setPrefWidth(80);
        
        //Inicializa el combo box
        cbPeso.setValue("KG");
        
        // Escuchador de acción para la combo box. 
        cbPeso.setOnAction(new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent ae) { 
    	  
            } 
        }); 
               
        //Etiqueta para el porcentaje
        Label lbPorcentaje = new Label("Porcentaje de grasa");
        
        //Crea una caja de texto
        TextField tfPorcentaje = new TextField(" ");
                
        //Crea la imagen
        Image porcentaje = new Image("images/porcentaje.png");
        
        //Crea un imageview que usa la imagen
        ImageView ivPorcentaje= new ImageView(porcentaje);
               
        //Crea boton atras
        Button atras= new Button("Atras");
                
        //Crea boton siguiento
        Button siguiente = new Button("Siguiente");
        
        //Layout para la parte superior.
        VBox topRoot = new VBox(lbTitulo, lbPeso);

        //Layout para la parte de los Radio Buttons
        HBox centerRoot = new HBox(tfPeso, cbPeso);
        
        //Espacio entre los Radio Buttons
        centerRoot.setSpacing(20);
        
        //Layout para el porcentaje de gras, caja de texto y combo box
        VBox cPor = new VBox(lbPorcentaje, tfPorcentaje, ivPorcentaje);
        
                
        //Layout para la parte inferiror.
        AnchorPane bottomRoot = new AnchorPane(atras,siguiente);
       
        //Layout principal, el cual contendra a los tres layouts anteriores.
        BorderPane mainRoot = new BorderPane();
        
        /*Al utilizar BorderPane como layout princiapl, debemos establecer 
        la posicion de nuestros layouts secundarios.*/
        mainRoot.setTop(topRoot);
        mainRoot.setCenter(centerRoot);
        mainRoot.setCenter(cPor);
        mainRoot.setBottom(bottomRoot);
        
        //Define la distancia entre los Radio Buttons
        //Establecemos la destancia entre los botones y las esquinas.
        AnchorPane.setRightAnchor(atras,10.0);
        AnchorPane.setLeftAnchor(siguiente,10.0);
        
        //Creamos y asociamos las clases css para los controles.
        mainRoot.getStyleClass().add("main-root");
        topRoot.getStyleClass().add("top-root");
        centerRoot.getStyleClass().add("center-root");
        bottomRoot.getStyleClass().add("bottom-root");
        lbTitulo.getStyleClass().add("title");
        lbPorcentaje.getStyleClass().add("subtitle");
        lbPeso.getStyleClass().add("subtitle");
        
        //Crea una escena y se añade el layout principal
        Scene escena = new Scene(mainRoot, 350, 700);
        
        //Añade hoja de estilos
        escena.getStylesheets().add("css/Estilo.css");
        
        //Añade la escena al escenario
        escenario.setScene(escena);        
       
        escenario.show();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
