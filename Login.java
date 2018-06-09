/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conta;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Mauricio
 */
public class Login extends Application {
TextField tf; 
Label respuesta; 

Button botonTexto; 
Button botonReversa; 
 private FlowPane flow;
Label selección; 
    
    
    public static void main(String[] args) { 
 
    // Inicia la aplicación JavaFX llamando a launch()
    launch(args);   
  } 
    
    @Override
    public void start(Stage primaryStage) {
        
        
        
        
        
        
        
        
        // cramos un layout del tipo VBox


       
 Image image = new Image("uplog.jpg");
 
//.setTop(btn);
 ImageView iv2 = new ImageView();
         iv2.setImage(image);
         iv2.setFitWidth(430);
         iv2.setPreserveRatio(true);
         iv2.setSmooth(true);
         iv2.setCache(true);
//---------------------------IDIOMAS-----------------------------------
        flow = new FlowPane();
        flow.getChildren().addAll(new Button("ingles"), new Button("Español"), new Button("Más"));
         flow.setId("idiomas"); 
         
         
VBox vbox= new VBox();
vbox.setSpacing(20);
vbox.setPadding(new Insets(0));
// creamos los controles
TextField user= new TextField();
user.setPromptText("USUARIO O CORREO ELECTRONICO"); 
TextField pass= new TextField();
pass.setPromptText("CONTRASEÑA"); 
Button btn= new Button("Iniciar sesión");
Button forgotpas= new Button("¿Olvidaste tu contrsseña");
  forgotpas.setId("forgotpas"); 
Button face= new Button("Iniciar con Facebook");
  face.setId("facebook"); 
  
  
Button regist= new Button("Registrarse");
  regist.setId("registrarse"); 
// añadimos nuestros controles al layout
vbox.getChildren().addAll(iv2,flow,user,pass,btn,forgotpas,face,regist);
// cremos nuestra Scena en la que dibujaremos el layout
Scene scene= new Scene(vbox,430, 700);
 scene.getStylesheets().add(
getClass().getResource("Estilo.css").toExternalForm());
primaryStage.setScene(scene);
primaryStage.setTitle("FITDIEZ");
primaryStage.show();
}
        
        
        
        
          
}

