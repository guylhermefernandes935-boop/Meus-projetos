package menor;

import java.awt.Color;

/**
 *
 * @author guylh
 */
public class Menor_T extends Menor{
    
    public Menor_T(){
        //criar(Color.MAGENTA);
        criar(Color.WHITE);
    }
    
    public void setXY(int x, int y){
        //   o
        // o o o
        b[0].x = x;
        b[0].y = y;
        b[1].x = b[0].x;
        b[1].y = b[0].y - Bloco.SIZE;
        b[2].x = b[0].x - Bloco.SIZE;
        b[2].y = b[0].y;
        b[3].x = b[0].x + Bloco.SIZE;
        b[3].y = b[0].y;
    }
    
    @Override
    public void getDirecao1(){
        //   o
        // o o o
        tempB[0].x = b[0].x;
        tempB[0].y = b[0].y;
        tempB[1].x = b[0].x;
        tempB[1].y = b[0].y - Bloco.SIZE;
        tempB[2].x = b[0].x - Bloco.SIZE;
        tempB[2].y = b[0].y;
        tempB[3].x = b[0].x + Bloco.SIZE;
        tempB[3].y = b[0].y;
        
        updateXY(1);
    }
    @Override
    public void getDirecao2(){
        // o
        // o o
        // o
        tempB[0].x = b[0].x;
        tempB[0].y = b[0].y;
        tempB[1].x = b[0].x + Bloco.SIZE;
        tempB[1].y = b[0].y;
        tempB[2].x = b[0].x;
        tempB[2].y = b[0].y - Bloco.SIZE;
        tempB[3].x = b[0].x;
        tempB[3].y = b[0].y + Bloco.SIZE;
        
        updateXY(2);
    }
    @Override
    public void getDirecao3(){
        // o o o
        //   o
        tempB[0].x = b[0].x;
        tempB[0].y = b[0].y;
        tempB[1].x = b[0].x;
        tempB[1].y = b[0].y + Bloco.SIZE;
        tempB[2].x = b[0].x + Bloco.SIZE;
        tempB[2].y = b[0].y;
        tempB[3].x = b[0].x - Bloco.SIZE;
        tempB[3].y = b[0].y;
        
        updateXY(3);
    }
    @Override
    public void getDirecao4(){
        //   o
        // o o
        //   o
        tempB[0].x = b[0].x;
        tempB[0].y = b[0].y;
        tempB[1].x = b[0].x - Bloco.SIZE;
        tempB[1].y = b[0].y;
        tempB[2].x = b[0].x;
        tempB[2].y = b[0].y + Bloco.SIZE;
        tempB[3].x = b[0].x;
        tempB[3].y = b[0].y - Bloco.SIZE;
        
        updateXY(4);
    }
}
