/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OpcionesJuego;

import TDAs.CircleLinkedList;
import TDAs.Direction;
import TDAs.Node;
import javafx.scene.image.ImageView;

/**
 *
 * @author tagoa
 */
public class Gaming {
    
    public static void StartPurge(ImageView img,CircleLinkedList<ImageView> personajes,Direction direccion){
        Node<ImageView> person= personajes.getLast();
        int cont=0;
        while(cont!=2){
            
            if(direccion==Direction.ANTIHORARIO){
                person=person.getPrevious();
            }
            else if(direccion==Direction.HORARIO){
                person=person.getNext();
            }
        }
        
        
    };
    public static void KillNext(){};
    public static void KillPrevious(){};
    
    
    
}
