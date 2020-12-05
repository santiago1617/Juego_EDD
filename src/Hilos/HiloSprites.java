/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hilos;

import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 *
 * @author tagoa
 */
public class HiloSprites extends Thread {
    private ImageView image;

    public HiloSprites(ImageView image) {
        this.image = image;
    }
    
    @Override
    public void run(){
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
                    image.setImage(img2);
                }
            }
        };
        
        
        animation.play();
    }
}
