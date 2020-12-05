/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hilos;

import java.applet.AudioClip;

/**
 *
 * @author tagoa
 */
public class HiloMusica extends Thread{
    private AudioClip audio;

    public HiloMusica(AudioClip audio) {
        this.audio = audio;
    }
    
    @Override
    public void run(){
        audio.loop();
        audio.play();
    }
}
