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
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Mauricio
 */
public class PersonalizacionMasa extends Application {
    
    /*Label lbTitulo, lbPeso, lbPorcentaje; 
    TextField tfPeso, tfPorcentaje;
    ObservableList<String> unidad; 
    ComboBox<String> cbPeso;
    Button atras,siguiente;*/

    
    @Override
    public void start(Stage escenario) {
        escenario.setTitle("Personalizacion de genero");
        
        //Crea un FlowPane
        FlowPane root = new FlowPane(Orientation.VERTICAL, 10, 10); 
        root.setAlignment(Pos.CENTER); 
        
        //Crea una escena
        Scene escena = new Scene(root, 270, 480);
        
        //Añade hoja de estilos
        escena.getStylesheets().add("css/Estilo.css");
        
        //Añade la escena al escenario
        escenario.setScene(escena);
        
        //Etiqueta para el titulo
        Label lbTitulo = new Label("PERSONALIZACION DE USUARIO");
        lbTitulo.setFont(new Font("Arial Rounded MT Bold", 14));
                          
        //Etiqueta para el peso
        Label lbPeso = new Label("Peso");
        lbPeso.setFont(new Font("Arial Rounded MT Bold", 14));
        
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
        lbPorcentaje.setFont(new Font("Arial Rounded MT Bold", 14));
        
        //Crea una caja de texto
        TextField tfPorcentaje = new TextField(" ");
        tfPorcentaje.setPrefSize(80, 10);
        
        //Crea la imagen
        Image porcentaje = new Image("images/porcentaje.png");
        
        //Crea un imageview que usa la imagen
        ImageView ivPorcentaje= new ImageView(porcentaje);
        
        //Crea separadores
        Separator separador = new Separator();
        separador.setPrefSize(270, 10);
        separador.setValignment(VPos.BOTTOM);
        
        Separator separador3 = new Separator();
        separador3.setPrefSize(270, 100);
        separador3.setValignment(VPos.BOTTOM);
        
        Separator separador4 = new Separator();
        separador4.setValignment(VPos.BOTTOM);
        separador4.setPrefSize(0, 0);
        
        //Crea boton atras
        Button atras= new Button("Atras");
        atras.setTextFill(Color.BLUE);
        atras.setPrefSize(60, 10);
        atras.setLayoutX(10);
        atras.setLayoutY(450);
        
        //Crea boton siguiento
        Button siguiente = new Button("Siguiente");
        siguiente.setTextFill(Color.BLUE);
        siguiente.setPrefSize(80, 10);
        siguiente.setAlignment(Pos.BOTTOM_LEFT);
                
        root.getChildren().addAll(lbTitulo, lbPeso, tfPeso, cbPeso, lbPorcentaje, tfPorcentaje, ivPorcentaje, separador3, atras, siguiente);
        escenario.show();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
