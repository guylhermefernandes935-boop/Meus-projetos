/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import javazoom.jl.player.Player;
import java.io.InputStream;

/**
 *
 * @author guylh
 */
public class MusicaPlayer {
    private Player player;
    
    public void play(String caminho){
      new Thread(() -> {
            try {
                InputStream is = getClass().getResourceAsStream(caminho);

                if (is == null) {
                    System.out.println("Arquivo não encontrado: " + caminho);
                    return;
                }

                player = new Player(is);
                player.play();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    public void stop() {
        if (player != null) {
            player.close();
        }
    }
}