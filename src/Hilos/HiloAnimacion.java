/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hilos;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author tagoa
 */
public class HiloAnimacion extends Thread {

    private ImageView view;
    private Image imagen;
    private String estado;

    public HiloAnimacion(ImageView view, Image imagen, String estado) {
        this.view = view;
        this.imagen = imagen;
        this.estado = estado;
    }

    @Override
    public void run() {
 
        Image img = imagen;
        view.setId(estado);
        view.setImage(img);
        
    }
}
