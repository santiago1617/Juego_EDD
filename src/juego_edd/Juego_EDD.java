/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego_edd;

import Animacion.Animation;
import OpcionesJuego.Construction;
import OpcionesJuego.Gaming;
import TDAs.CircleLinkedList;
import TDAs.Direction;
import TDAs.Node;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author tagoa
 */
public class Juego_EDD extends Application {
    
    @Override
    public void start(Stage primaryStage) {
//        Button btn = new Button();
//        btn.setText("Say 'Hello World'");
//        btn.setOnAction(new EventHandler<ActionEvent>() {
//            
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("Hello World!");
//            }
//        });
//        
//        StackPane root = new StackPane();
//        root.getChildren().add(btn);
//        
//        Scene scene = new Scene(root, 300, 250);
//        
//        primaryStage.setTitle("Hello World!");
//        primaryStage.setScene(scene);
//        primaryStage.show();
    CircleLinkedList<Node> imagenes= new CircleLinkedList<>();
    Node per= new Node(new ImageView());
    
        
//        Image img=new Image(getClass().getResource("/Recursos/Base/Base.png").toString());
//        
//        Image imagen2=new Image(getClass().getResource("/Sprites/Inmortal.png").toString());
//        Image imagen3=new Image(getClass().getResource("/Sprites/Muerto.png").toString());
//        
//        ImageView img1=new ImageView(img);
//        img1.setViewport(new Rectangle2D(0,0,50,96));
//        
//        ImageView img2=new ImageView(imagen2);
//        ImageView img3=new ImageView(imagen3);
//        
//        img2.setFitHeight(150);
//        img2.setFitWidth(150);
//        img3.setFitHeight(150);
//        img3.setFitWidth(150);
//        img1.setLayoutX(0);
//        img1.setLayoutY(0);
//        img2.setLayoutX(200);
//        img2.setLayoutY(200);
//        img3.setLayoutX(400);
//        img3.setLayoutY(400);
//        
//        
//        
//        imagenes.addFirst(img1);
//        imagenes.addFirst(img2);
//        imagenes.addFirst(img3);
Construction con= new Construction();
//         Pane pane= con.CrearCirculoMuerte(20);
        CircleLinkedList<ImageView> persons= con.CrearCirculoMuerteLista(10);
        Pane pane=con.AgregarPane(persons);
//        con.HacerInmortales(persons);
//        con.PrubaAnimacion(persons);
          Gaming.PoderComenzarMatanza(persons,Direction.HORARIO);
//         pane.setOnMouseClicked(event-> 
//                 System.out.println(event.getX()+"-----"+event.getY())
//         );
          con.AudioFondo();
//         Node person= new Node(new ImageView());
//         Animation ani= new Animation();
//        
//            
//        
//         
//         Scene scene= new Scene(pane,1000,1000);
//         Stage stage= new Stage();
//         stage.setScene(scene);
//         stage.show();
//         FadeTransition fade= new FadeTransition();
//        PathTransition path= new PathTransition();
//        fade.setDuration(new Duration(300));
//        fade.setNode(img1);
    
         
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        launch(args);
        
        
    }
    
}
