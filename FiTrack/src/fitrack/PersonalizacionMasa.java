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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Mauricio
 */
public class PersonalizacionMasa extends Application {
    
    Label lbTitulo, lbPeso, lbPorcentaje; 
    TextField tfPeso, tfPorcentaje;
    ObservableList<String> unidad; 
    ComboBox<String> cbPeso;
    Button atras,siguiente;

    
    @Override
    public void start(Stage escenario) {
        escenario.setTitle("Personalizacion de genero");
        //Crea un BorderPane para poder colocar los elementos y los botones en su posicion requerida         
        FlowPane raiz = new FlowPane();
        //Crea una escena
        Scene escena = new Scene(raiz, 270, 480);
        
        //Añade la escena al escenario
        escenario.setScene(escena);
        
        //Crea los controles de las posiciones del BorderPane
        //Arriba
        Label lbTitulo = new Label("PERSONALIZACION DE USUARIO");
                
        Separator separador=new Separator();
        separador.setPrefSize(270, 0);
        separador.setVisible(false);
            
        //Centro
        Label lbPeso = new Label("Peso");
        TextField tfPeso = new TextField(" ");
        
        ObservableList<String> unidad =
        FXCollections.observableArrayList("KG", "LB");  
                
        ComboBox<String> cbEstatura = new ComboBox<String>(unidad);
        cbEstatura.setPrefWidth(50);
        cbEstatura.setValue(unidad.get(0));
        
        // Escuchado de acción para la combo box. 
        cbEstatura.setOnAction(new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent ae) { 
    	  
            } 
        }); 
        
        Separator separador2 = new Separator();
        separador2.setPrefSize(270, 0);
        separador2.setVisible(false);
        
        Label lbPorcentaje = new Label("Porcentaje de grasa");
        TextField tfPorcentaje = new TextField(" ");
        
        Separator separador3 = new Separator();
        separador2.setPrefSize(270, 0);
        separador2.setVisible(false);
        
        Image porcentaje = new Image("porcentaje.jpg");
        ImageView ivPorcentaje= new ImageView();
        ivPorcentaje.setImage(porcentaje);
        ivPorcentaje.setFitWidth(250);
        ivPorcentaje.setFitHeight(200);
        
        Separator separador4 = new Separator();
        separador2.setPrefSize(270, 0);
        separador2.setVisible(false);
        
        //Crea boton atras
        Button atras= new Button("Atras");
        atras.setTextFill(Color.BLUE);
        atras.setPrefSize(60, 10);
        atras.setAlignment(Pos.BOTTOM_LEFT);
        
        //Crea boton siguiento
        Button siguiente= new Button("Siguiente");
        siguiente.setTextFill(Color.BLUE);
        siguiente.setPrefSize(60, 10);
        siguiente.setAlignment(Pos.BOTTOM_RIGHT);
                
                
        escenario.show();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
