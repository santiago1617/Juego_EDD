/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Animacion;

import TDAs.Node;
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

//    public static void crearPersonaje(Node person) {
//        Image img = new Image("/Recursos/Base/Base.png");
//        ImageView img1 = new ImageView(img);
//        img1.setOnMouseClicked(event -> {
//            HacerInmortal(img1);
//        });
//
//        person.setContenido(img1);
//        System.out.println("Algoooo");
//
//    }
    public static void HacerInmortal(ImageView view) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        Image img = new Image("/Recursos/Inmortal/Inmortal.png");
                        view.setImage(img);

                        System.out.println("neeeeeell");
                    }
                });
            }
        });

        thread.start();
        try {

            thread.join();
            System.out.println("Hilo terminado");
            System.out.println(thread.isAlive());
        } catch (InterruptedException ex) {
            Logger.getLogger(Animation.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void MatarPersonaje(ImageView view) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {

                        Image img = new Image("/Recursos/Base/Muerto.png");
                        view.setImage(img);

                        System.out.println("neeeeeell");

                    }

                });
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Animation.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        thread.start();

        try {

            thread.join();
            System.out.println("Hilo terminado");
            System.out.println(thread.isAlive());
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
                System.out.println("Fraccion: " + fraction);
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

}
