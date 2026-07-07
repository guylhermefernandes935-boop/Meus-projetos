package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author guylh
 */
public class GamePanel extends JPanel implements Runnable{
    public static final int WIDTH = 607;
    public static final int HERIGHT = 640;
    final int FPS = 60;
    Thread gameThread;
    PlayManager pm;
    public static Som musica = new Som();
    public static Som se = new Som();
    
    public GamePanel(){
        this.setPreferredSize(new Dimension(WIDTH, HERIGHT));
        this.setBackground(Color.BLACK);
        this.setLayout(null);
        
        this.addKeyListener(new KeyHandler());
        this.setFocusable(true);
        pm = new PlayManager();
    }

    public void launchGame(){
        gameThread = new Thread(this);
        gameThread.start();
        
        musica.play(0, true);
        musica.loop();
    }
    
    @Override
    public void run() {
        
        //Game loop
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        
        while(gameThread != null){
            
            currentTime = System.nanoTime();
            
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;
            
            if(delta >= 1){
                update();
                repaint();
                delta--;
            }
        }
    }
    
    public void update(){
        if(pm.gameOver){
            if(KeyHandler.enterPressed){
                pm = new PlayManager();
                KeyHandler.enterPressed = false;
            }
            return;
        }
        
        if(KeyHandler.pausePressed == false && pm.gameOver == false){
            pm.update();
        }
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D) g;
        pm.draw(g2);
        
    }
}
