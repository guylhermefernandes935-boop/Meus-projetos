/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineEvent.Type;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author guylh
 */
public class Som {
    
     Clip musicClip;
     URL url[] = new URL[10];
     
     public Som() {
         url[0] = getClass().getResource("/res/musica.wav");
//         url[1] = getClass().getResource("/res/delete line.wav");
//         url[2] = getClass().getResource("/res/gameover.wav");
//         url[3] = getClass().getResource("/res/rotation.wav");
//         url[4] = getClass().getResource("/res/touch floor.wav");
         //System.out.println(url[0]);
     }
     
     public void play(int i, boolean musica){
         try{
             Clip clip;
             try (AudioInputStream ais = AudioSystem.getAudioInputStream(url[i])) {
                 clip = AudioSystem.getClip();
                 //System.out.println("Abrindo: " + url[i]);
                 if(musica){
                     musicClip = clip;
                 }   clip.open(ais);
                 clip.addLineListener((LineEvent event) -> {
                     if(event.getType() == Type.STOP){
                         clip.close();
                     }
                 });
             }
             clip.start();
         }catch(IOException | LineUnavailableException | UnsupportedAudioFileException e){
         }
     }
     
     public void loop(){
         musicClip.loop(Clip.LOOP_CONTINUOUSLY);
     }
     
     public void stop(){
         musicClip.stop();
         musicClip.close();
     }
}
