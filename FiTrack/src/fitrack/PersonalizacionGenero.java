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
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Vanessa
 */
public class PersonalizacionGenero extends Application {
    
   // Label lbTitulo, lbGenero, lbNacimiento, lbEstatura; 
    RadioButton rbHombre, rbMujer;
    DatePicker fecha;
    //TextField tfEstatura;
    //ObservableList<String> tipos; 
    //ComboBox<String> cbEstatura;
    //Button atras,siguiente;

    
    @Override
    public void start(Stage escenario) {
        escenario.setTitle("Personalizacion de genero");
        //Crea un FlowPane      
        FlowPane raiz = new FlowPane();
        raiz.setAlignment(Pos.TOP_CENTER); 
        //Crea una escena
        Scene escena = new Scene(raiz, 270, 480);
        
        //Añade la escena al escenario
        escenario.setScene(escena);
        
        //Arriba
        Label lbTitulo = new Label("PERSONALIZACION DE USUARIO");
        lbTitulo.setFont(new Font("Arial Rounded MT Bold", 14));
        //Centro
        Label lbGenero = new Label("Escoge tu genero");
        lbGenero.setFont(new Font("Arial Rounded MT Bold", 14));
        
        rbHombre.setGraphic(new ImageView("hombre.jpg"));
        rbHombre.setAlignment(Pos.CENTER_LEFT);
        
        rbMujer.setGraphic(new ImageView("mujer.jpg"));
        rbMujer.setAlignment(Pos.CENTER_RIGHT);
        
        //Agrega metodo de DatePicker
        iniciarFecha();
        
        Label lbEstatura = new Label("Estatura");
        lbEstatura.setFont(new Font("Arial Rounded MT Bold", 14));
        TextField tfEstatura = new TextField(" ");
        
        Separator separador3 = new Separator();
        separador3.setPrefSize(270, 100);
        separador3.setVisible(false);
        
        ObservableList<String> unidad =
        FXCollections.observableArrayList("CM", "FT");  
               
        ComboBox<String> cbEstatura = new ComboBox<String>(unidad);
        cbEstatura.setPrefWidth(50);
        cbEstatura.setValue(unidad.get(0));
        
        // Escuchado de acción para la combo box. 
        cbEstatura.setOnAction(new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent ae) { 
    	  
            } 
        }); 
                
        Separator separador4 = new Separator();
        separador4.setPrefSize(70, 0);
        separador4.setVisible(false);
        
        //Abajo
        //Crea boton atras
        Button atras= new Button("Atras");
        atras.setTextFill(Color.BLUE);
        atras.setPrefSize(60, 10);
        atras.setLayoutX(10);
        atras.setLayoutY(450);
        
        //Crea boton siguiento
        Button siguiente= new Button("Siguiente");
        siguiente.setTextFill(Color.BLUE);
        siguiente.setPrefSize(60, 10);
        siguiente.setAlignment(Pos.BOTTOM_LEFT);
     
        raiz.getChildren().addAll(lbTitulo, lbGenero, rbHombre, rbMujer, fecha, lbEstatura,
                tfEstatura, cbEstatura, separador3, atras, separador4, siguiente); 
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
