package main;

import java.awt.Frame;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author guylh
 */
public class GameFrame extends Frame{
    
    public GameFrame(){
        
        JFrame window = new JFrame("Tetris");
        
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        
        ImageIcon icon = new ImageIcon(getClass().getResource("/res/tetris.png"));
        window.setIconImage(icon.getImage());
        
        GamePanel gp = new GamePanel();
        window.add(gp);
        
        window.pack();
        
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        
        gp.launchGame();
    }
}
