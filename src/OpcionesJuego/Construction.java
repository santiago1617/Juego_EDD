/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OpcionesJuego;

import Animacion.Animation;
import Hilos.HiloMusica;
import Interfaz.Interfaz;
import TDAs.CircleLinkedList;
import TDAs.Node;
import java.applet.AudioClip;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author tagoa
 */
public class Construction {

    private double centroX = 500.0;
    private double centroY = 500.0;

    public int radioNecesario(int Nperson) {
        double perimetro = Nperson * 15;
        int radio = (int) Math.ceil((perimetro / 2 * Math.PI));
        return radio;
    }

    public double anguloSeparacion(int Nperson) {
        double angulo = 360 / Nperson;
        System.out.println("El angulo es: "+angulo);
        return angulo;
    }

    //A estos personajes ya se les asignaron las imagenes los que nos ingresan
    public Pane CrearCirculoMuerte(int Nperson) {
        CircleLinkedList<Node> personajes = new CircleLinkedList();
        double contAngulo = 0;
        double separacionAngulo = anguloSeparacion(Nperson);
        Pane panel= new Pane();
        int radio = radioNecesario(Nperson);
        System.out.println("Radio: "+radio);
        for (int i = 1; i <= Nperson; i++) {
            System.out.println("PARTE "+i+" --------------------");
            System.out.println("Coseno: "+Math.cos(Math.toRadians(contAngulo)));
            
            System.out.println("Seno: "+Math.sin(Math.toRadians(contAngulo)));
            System.out.println("contador Angulo: "+contAngulo);
            double X = radio * Math.cos(Math.toRadians(contAngulo)) + centroX;
            double Y = radio * Math.sin(Math.toRadians(contAngulo)) + centroY;
            System.out.println("EjeX: "+X);
            System.out.println("EjeY: "+Y);
            Point2D point= new Point2D(X,Y);
            
            Image img = new Image("/Recursos/Base/Base.png");
            ImageView img1 = new ImageView(img);
            img1.setLayoutX(X);
            img1.setLayoutY(Y);
            Node<ImageView> person= new Node(img1);
            
            personajes.addLast(person);
            img1.setId("VIVO");
            panel.getChildren().add(img1);
            
            contAngulo+=separacionAngulo;

        }
        
        return panel;
    }
    public CircleLinkedList<ImageView> CrearCirculoMuerteLista(int Nperson) {
        CircleLinkedList<ImageView> personajes = new CircleLinkedList();
        double contAngulo = 0;
        double separacionAngulo = anguloSeparacion(Nperson);
        
        int radio = radioNecesario(Nperson);
        System.out.println("Radio: "+radio);
        for (int i = 1; i <= Nperson; i++) {
            System.out.println("PARTE "+i+" --------------------");
            System.out.println("Coseno: "+Math.cos(Math.toRadians(contAngulo)));
            
            System.out.println("Seno: "+Math.sin(Math.toRadians(contAngulo)));
            System.out.println("contador Angulo: "+contAngulo);
            double X = radio * Math.cos(Math.toRadians(contAngulo)) + centroX;
            double Y = radio * Math.sin(Math.toRadians(contAngulo)) + centroY;
            System.out.println("EjeX: "+X);
            System.out.println("EjeY: "+Y);
//            Point2D point= new Point2D(X,Y);
            
            Image img = new Image("/Recursos/Base/Base.png");
            ImageView img1 = new ImageView(img);
            img1.setLayoutX(X);
            img1.setLayoutY(Y);
            
            img1.setId("VIVO");           
            personajes.addLast(img1);
            contAngulo+=separacionAngulo;
        }
        
        return personajes;
    }
    //Validar ue no se permita tene rla lista vacia
    public Pane AgregarPane(CircleLinkedList<ImageView> personajes){
        Pane pane = new Pane();
        if(personajes.size()==1){
            pane.getChildren().add(personajes.getLast().getContenido());
        }
        else{
            Node<ImageView> nodo= personajes.getFirst();
            while(nodo!=personajes.getLast()){
                pane.getChildren().add(nodo.getContenido());
                nodo=nodo.getNext();
            }
            pane.getChildren().add(personajes.getLast().getContenido());
        }
        ObservableList<javafx.scene.Node> lista= pane.getChildren();
        System.out.println(lista.size());
        System.out.println(lista.get(0).getId());
        return pane;
    }
//    public Scene sceneMakeInmortal(CircleLinkedList<ImageView> personajes){
//         
//    }
    public void PoderSerInmortales(CircleLinkedList<ImageView> personajes){
        Node<ImageView> nodo= personajes.getLast();
            int cont=0;
            while(nodo!=personajes.getLast() || cont==0){
                ImageView img=nodo.getContenido();
                img.setOnMouseClicked(event -> Animation.HacerInmortal(img));
                nodo=nodo.getNext();
                cont++;
            }
            
    }
    public void PrubaAnimacion(CircleLinkedList<ImageView> personajes){
        Node<ImageView> nodo= personajes.getLast();
            int cont=0;
            while(nodo!=personajes.getLast() || cont==0){
                ImageView img=nodo.getContenido();
                img.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        Animation.HacerInmortal(img);
                        Animation.MatarPersonaje(img);
                    }
                }
                );
                nodo=nodo.getNext();
                cont++;
            }
    }
    public void EliminarAcciones(CircleLinkedList<ImageView> personajes){
        Node<ImageView> nodo= personajes.getLast();
            int cont=0;
            while(nodo!=personajes.getLast() || cont==0){
                ImageView img=nodo.getContenido();
                img.setOnMouseClicked(event -> System.out.print("evento eliminado"));
                nodo=nodo.getNext();
                cont++;
            }
    }
    public static void EliminarMuertos(CircleLinkedList<ImageView> personajes){
        Node<ImageView> nodo= personajes.getLast();
            int cont=0;
            while(nodo!=personajes.getLast() || cont==0){
                ImageView img=nodo.getContenido();
                if(img.getId().equals("MUERTO")){
                    personajes.remove(img);
                }
                cont++;
            }
            
    }
        public void AudioFondo() {
        AudioClip mensaje = java.applet.Applet.newAudioClip(getClass().getResource("/Recursos/Base/fondo.wav"));
        HiloMusica hilo= new HiloMusica(mensaje);
        hilo.start();
        
    }
        
    
}
