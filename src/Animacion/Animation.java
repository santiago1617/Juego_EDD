/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Animacion;

import Hilos.HiloAnimacion;
import java.applet.AudioClip;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Transition;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 *
 * @author tagoa
 */
public class Animation {
    public static void ConvertirMortal(ImageView view) {

       Image img = new Image("/Recursos/Base/Base.png");
        HiloAnimacion hilo= new HiloAnimacion(view,img,"VIVO");
        hilo.start();
        try {
            hilo.join();
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Animation.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void HacerInmortal(ImageView view) {

       Image img = new Image("/Recursos/Inmortal/Inmortal.png");
        HiloAnimacion hilo= new HiloAnimacion(view,img,"INMORTAL");
        hilo.start();
        try {
            hilo.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Animation.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void MatarPersonaje(ImageView view) {
        
        Image img = new Image("/Recursos/Base/Muerto.png");
        HiloAnimacion hilo= new HiloAnimacion(view,img,"MUERTO");
        hilo.start();
        try {
            
            hilo.join();
           
        } catch (InterruptedException ex) {
            Logger.getLogger(Animation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public static void AnimacionAtacar(ImageView view) {
        

        Transition animation = new Transition() {
            {
                setCycleDuration(Duration.millis(1000)); // total time for animation
            }

            @Override
            protected void interpolate(double fraction) {
                
                int index = (int) (fraction * (3 - 1));
                if (index > 0) {
                    Image img2 = new Image("/Recursos/Base/Atacando" + index + ".png");
                    view.setImage(img2);
                }
            }
        };
        animation.play();

    }
    public static void AnimacionInmortalAtacar(ImageView view) {
        

        Transition animation = new Transition() {
            {
                setCycleDuration(Duration.millis(1000)); // total time for animation
            }

            @Override
            protected void interpolate(double fraction) {
                System.out.println("Fraccion: " + fraction);
                int index = (int) (fraction * (3 - 1));
                if (index > 0) {
                    Image img2 = new Image("/Recursos/Inmortal/InmortalAtacando" + index + ".png");
                    view.setImage(img2);
                }
            }
        };
        animation.play();

    }
    
    public static void AnimacionExplosion(ImageView view) {
        

        Transition animation = new Transition() {
            {
                setCycleDuration(Duration.millis(1000)); // total time for animation
            }

            @Override
            protected void interpolate(double fraction) {
                System.out.println("Fraccion: " + fraction);
                int index = (int) (fraction * (3 - 1));
                if (index > 0) {
                    Image img2 = new Image("/Recursos/Gifs/Explosion.gif");
                    view.setImage(img2);
                }
            }
        };
        animation.play();
        
    }
 

}
