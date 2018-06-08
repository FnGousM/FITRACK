package fitrack;

/* 
 * Demostración de ListView 
 */
 

import javafx.application.*; 
import javafx.scene.*; 
import javafx.stage.*; 
import javafx.scene.layout.*; 
import javafx.scene.control.*; 
import javafx.geometry.*; 
import javafx.beans.value.*; 
import javafx.collections.*; 
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.util.Callback;
 
public class PersonalizacionSomatotipo extends Application { 
 
  Label respuesta,titulo,somatotipo,textbaj; 
  ComboBox<String> fCuerpo; 
 
  Button TEST,atras,siguiente;
  BorderPane raiz; 
  TableView table = new TableView();

  public static void main(String[] args) { 
 
    // Inicia la aplicación JavaFX llamando a launch()
    launch(args);   
  } 
 
  // Override del método start() 
  public void start(Stage myStage) { 

    // Se le da el título al escenario 
    myStage.setTitle("Personalización de Usuario"); 
 
    // Usa un FlowPane para el nodo raiz.   
    // Vertical y horizontalmente espacios de 10.
    FlowPane rootNode = new FlowPane(10, 7); 
   //FlowPane rootNode2=new FlowPane(Orientation.HORIZONTAL);
    // Centrar controles en el nodo raíz 
    rootNode.setAlignment(Pos.TOP_CENTER); 
   // rootNode.setAlignment(Pos.); 
    // Crear la escena
    Scene myScene = new Scene(rootNode, 270, 480); 
 
    // Pone la escena en el escenario 
    myStage.setScene(myScene); 
    raiz = new BorderPane();
    Image im1=new Image("somatotipo.jpg");
    ImageView im= new ImageView();
    im.setImage(im1);
    im.setFitWidth(250);
    im.setFitHeight(100);
    // Crea la etiqueta
    TEST=new Button("TEST");
    TEST.setTextFill(Color.web("#FFFFFF"));
    TEST.setPrefSize(200, 40);
    atras=new Button("Atras");
    atras.setTextFill(Color.web("#FFFFFF"));
    atras.setPrefSize(60, 10);
    atras.setLayoutX(10);
    atras.setLayoutY(450);
    siguiente=new Button("Siguiente");
    siguiente.setTextFill(Color.web("#FFFFFF"));
    siguiente.setPrefSize(60, 10);
    siguiente.setAlignment(Pos.BOTTOM_RIGHT);
    titulo = new Label("Personalización de Usuario"); 
    textbaj=new Label("Si no conoces tu somatotipo da clic en el\nboton para que realices el test de evaluación.");
    textbaj.setPrefWidth(250);
    textbaj.setTextAlignment(TextAlignment.CENTER);
    somatotipo = new Label("Somatotipo"); 
    titulo.setFont(new Font("Helvetica", 18));
    titulo.setTextFill(Color.web("#FFFFFF"));
    somatotipo.setFont(new Font("Helvetica", 14));
    // Crea una ObservableList de entradas para la lista 
    ObservableList<String> tipos = 
     FXCollections.observableArrayList("Endoformo", "Ectoformo", "Mesoformo");  
     


    fCuerpo=new ComboBox<String>(tipos);
    fCuerpo.setPrefWidth(200);
    fCuerpo.setValue(tipos.get(0));
    Separator separador=new Separator();
    separador.setPrefSize(270, 100);
    separador.setVisible(false);
    Separator separador2=new Separator();
    separador2.setPrefSize(70, 0);
    separador2.setVisible(false);
    table.setPrefSize(270, 10);

  
   // Escucha eventos de acción para la combo box. 
    fCuerpo.setOnAction(new EventHandler<ActionEvent>() { 
      public void handle(ActionEvent ae) { 
    	  
      } 
    }); 
 
    // Inserta la lista y la etiqueta al grafo de la escena 
    rootNode.getChildren().addAll(titulo,somatotipo, fCuerpo,im,TEST,textbaj,separador,atras,separador2,siguiente); 
 
    // Muestra el escenario y su escena 
    myStage.show(); 
  } 
}
