/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fitrack;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Vanessa
 */
public class PersonalizacionGenero extends Application {
    
    RadioButton rbHombre, rbMujer;
    DatePicker fecha; 
        
    @Override
    public void start(Stage escenario) {
        escenario.setTitle("Personalizacion de genero"); 
                   
        //Etiqueta titulo
        Label lbTitulo = new Label("PERSONALIZACION DE USUARIO");
                
        //Etiqueta genero
        Label lbGenero = new Label("Elige tu genero");
        
        //Etiqueta nacimiento
        Label lbNacimiento = new Label("Fecha de nacimiento");
                
        //Crea los Radio Buttons
        rbHombre = new RadioButton("HOMBRE");
        rbMujer = new RadioButton("MUJER");
        
        //Solo se ve laimagen en los Radio Buttons
        rbHombre.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        rbMujer.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        
        //Añade la imagen a a los Radio Buttons
        rbHombre.setGraphic(new ImageView("images/hombre.png"));
        rbHombre.setAlignment(Pos.CENTER_LEFT);
        
        rbMujer.setGraphic(new ImageView("images/mujer.png"));
        rbMujer.setAlignment(Pos.CENTER_RIGHT);
                
        //Agrega metodo de DatePicker
        iniciarFecha();
        
        //Etiqueta estatura
        Label lbEstatura = new Label("Estatura");
        
        //Caja de texto para la estatura
        TextField tfEstatura = new TextField(" ");
        
        //Crea una lista observable para el combo box
        ObservableList<String> unidad =
        FXCollections.observableArrayList("CM", "FT");  
        
        //Crea el combo box
        ComboBox<String> cbEstatura = new ComboBox<String>(unidad);
        cbEstatura.setPrefWidth(80);
        
        //Inicializa el combo box
        cbEstatura.setValue("CM");
        
        // Escuchado de acción para la combo box. 
        cbEstatura.setOnAction(new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent ae) { 
    	  
            } 
        }); 
                
        //Crea boton atras
        Button atras= new Button("Atras");
               
        //Crea boton siguiente
        Button siguiente= new Button("Siguiente");
        
        //Layout para la parte superior.
        VBox topRoot = new VBox(lbTitulo, lbGenero);

        //Layout para la parte de los Radio Buttons
        HBox centerRoot = new HBox(rbHombre, rbMujer);
        
        //Espacio entre los Radio Buttons
        centerRoot.setSpacing(20);
        
        //Layout para la fecha y estatura
        VBox cFecha = new VBox(lbNacimiento, fecha, lbEstatura);
        
        //Layout para la estatura,caja de texto y combo box
        HBox cEsta = new HBox(tfEstatura, cbEstatura);
        
        //Layout para la parte inferiror.
        AnchorPane bottomRoot = new AnchorPane(atras,siguiente);
       
        //Layout principal, el cual contendra a los tres layouts anteriores.
        BorderPane mainRoot = new BorderPane();
        
        /*Al utilizar BorderPane como layout princiapl, debemos establecer 
        la posicion de nuestros layouts secundarios.*/
        mainRoot.setTop(topRoot);
        mainRoot.setCenter(centerRoot);
        mainRoot.setCenter(cFecha);
        mainRoot.setCenter(cEsta);
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
        lbGenero.getStyleClass().add("subtitle");
        lbNacimiento.getStyleClass().add("subtitle");
        lbEstatura.getStyleClass().add("subtitle");
        
        //Crea una escena y se añade el layout principal
        Scene escena = new Scene(mainRoot, 350, 700);
        
        //Añade hoja de estilos
        escena.getStylesheets().add("css/Estilo.css");
        
        //Añade la escena al escenario
        escenario.setScene(escena);
        escenario.show();
    }
    
    private void iniciarFecha(){
        VBox vbox = new VBox(20);
        vbox.setStyle("-fx-padding: 10;");
        
        fecha = new DatePicker();
        
        GridPane gridpane = new GridPane();
        gridpane.setHgap(10);
        gridpane.setVgap(10);
        
        Label lbNacimiento = new Label("Fecha de nacimiento");
        gridpane.add(lbNacimiento, 0, 0);
        
        GridPane.setHalignment(lbNacimiento, HPos.CENTER);
        gridpane.add(fecha, 0, 1);
        vbox.getChildren().add(gridpane);
    }
    
    public static void main(String[] args) { 
 
    // Inicia la aplicación JavaFX llamando a launch()
    launch(args);   
  } 

    
    }
    

