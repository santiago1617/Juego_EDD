/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego_edd;

import Animacion.Animation;
import Interfaz.Interfaz;
import OpcionesJuego.Construction;
import TDAs.CircleLinkedList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author tagoa
 */
public class Main extends Application {
     @Override
    public void start(Stage primaryStage) {
        Interfaz in= new Interfaz();
         in.Principal();
    }
    public static void main(String args[]){
        launch(args);
    }
}
