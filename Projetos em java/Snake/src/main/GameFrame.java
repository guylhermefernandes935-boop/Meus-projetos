package main;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class GameFrame extends JFrame {

    public GameFrame() {
        
        this.add(new GamePanel());
        
        ImageIcon icon = new ImageIcon(getClass().getResource("/icone/icon.png"));
        this.setIconImage(icon.getImage());
        
        this.setTitle("Snake Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
    
}
