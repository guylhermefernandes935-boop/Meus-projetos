package menor;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author guylh
 */
public class Bloco extends Rectangle {
    
    public int x, y;
    public static final int SIZE = 30; // 30x30 bloco
    public Color c; 
    
    public Bloco(Color c){
        this.c = c;
    }
    
    public void draw(Graphics2D g2) {
        int margine = 2;
        g2.setColor(c);
        g2.fillRect(x + margine, y + margine, SIZE-(margine*2), SIZE-(margine*2));
    }
}
