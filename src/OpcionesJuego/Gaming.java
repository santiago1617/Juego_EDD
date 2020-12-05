/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OpcionesJuego;

import Animacion.Animation;
import Hilos.Hilo1;
import TDAs.CircleLinkedList;
import TDAs.Direction;
import TDAs.Node;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author tagoa
 */
public class Gaming {

    public static void StartPurge(Node<ImageView> img, CircleLinkedList<ImageView> personajes, Direction direccion) {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {

                if (direccion == Direction.ANTIHORARIO) {

                    KillPrevious(img);

                } else if (direccion == Direction.HORARIO) {
                    KillNext(img);

                }

            }

        });

    }

    public static void KillNext(Node<ImageView> asesino) {
        Node<ImageView> next = asesino.getNext();
        System.out.println("ID ASESINO: "+asesino.getContenido().getId());
        System.out.println("ID NEXT: "+next.getContenido().getId());
        
        if(next.getContenido().getId().equals("VIVO") && asesino.getContenido().getId().equals("VIVO")){
            Animation.AnimacionAtacar(asesino.getContenido());
        Animation.MatarPersonaje(next.getContenido());
        }
        else if(next.getContenido().getId().equals("INMORTAL") && asesino.getContenido().getId().equals("VIVO")){
            Animation.AnimacionExplosion(asesino.getContenido());
        }
        else if(next.getContenido().getId().equals("INMORTAL") && asesino.getContenido().getId().equals("INMORTAL")){
            Animation.ConvertirMortal(asesino.getContenido());
        }
        else if(next.getContenido().getId().equals("VIVO") && asesino.getContenido().getId().equals("INMORTAL")){
            Animation.MatarPersonaje(next.getContenido());
            Animation.AnimacionInmortalAtacar(asesino.getContenido());
        }
        
                     
    }

    ;
    public static void KillPrevious(Node<ImageView> asesino) {
        Node<ImageView> previous = asesino.getPrevious();
        System.out.println("ID ASESINO: "+asesino.getContenido().getId());
        System.out.println("ID NEXT: "+previous.getContenido().getId());
        
        if(previous.getContenido().getId().equals("VIVO") && asesino.getContenido().getId().equals("VIVO")){
            Animation.AnimacionAtacar(asesino.getContenido());
        Animation.MatarPersonaje(previous.getContenido());
        }
        else if(previous.getContenido().getId().equals("INMORTAL") && asesino.getContenido().getId().equals("VIVO")){
            Animation.AnimacionExplosion(asesino.getContenido());
        }
        else if(previous.getContenido().getId().equals("INMORTAL") && asesino.getContenido().getId().equals("INMORTAL")){
            Animation.ConvertirMortal(asesino.getContenido());
        }
        else if(previous.getContenido().getId().equals("Mortal") && asesino.getContenido().getId().equals("INMORTAL")){
            Animation.MatarPersonaje(previous.getContenido());
            Animation.AnimacionInmortalAtacar(asesino.getContenido());
        }
        
                        
    }

    ;
    
    public static void PoderComenzarMatanza(CircleLinkedList<ImageView> personajes,Direction direccion) {
        Node<ImageView> nodo = personajes.getLast();
        int cont = 0;
        while (nodo != personajes.getLast() || cont == 0) {
            ImageView img = nodo.getContenido();
            img.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    Node<ImageView> personaje = personajes.SearchNode(img);

                    RondaN(personaje, personajes, direccion);
                    //Animation.MatarPersonaje(img);
                }
            }
            );
            nodo = nodo.getNext();
            cont++;
        }
    }
    /*
    Este metodo es para activar cada ronda de muerte
    */
    public static void RondaN(Node<ImageView> img, CircleLinkedList<ImageView> personajes, Direction direccion) {

                int cont = 0;
                Node<ImageView> p = img;
                int contador=0;
                while (p != img || cont == 0) {
                    Hilo1 hilo= new Hilo1(p,direccion);
                    hilo.start();
                    try {
                        
                        hilo.join();
                        
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Gaming.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    p=p.getNext();
                    cont++;
                    System.out.println("Contador: "+contador);
                    contador++;
                    
                }
            
    }

}
