/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hilos;

import OpcionesJuego.Gaming;
import TDAs.CircleLinkedList;
import TDAs.Direction;
import TDAs.Node;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.ImageView;

/**
 *
 * @author tagoa
 */
public class Hilo1 extends Thread {
    private Node<ImageView> imagen;
    private Direction direccion;

    public Hilo1(Node<ImageView> imagen, Direction direccion) {
        this.imagen = imagen;
        this.direccion = direccion;
    }
    

    
    @Override
    public void run(){
        if(direccion==Direction.HORARIO){
        Gaming.KillNext(imagen);}
        else if(direccion==Direction.ANTIHORARIO){
         Gaming.KillPrevious(imagen);
        }
        System.out.println("Sucediendo****");
//        try {
//            Hilo1.sleep(1000);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(Hilo1.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
    }

}
