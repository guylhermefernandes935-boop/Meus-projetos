package menor;

import java.awt.Color;

/**
 *
 * @author guylh
 */
public class Menor_L1 extends Menor{
    
    public Menor_L1(){
        //criar(Color.ORANGE);
        criar(Color.WHITE);
    }
    
    @Override
    public void setXY(int x, int y){
        // o
        // o
        // o o
        b[0].x = x;
        b[0].y = y;
        b[1].x = b[0].x;
        b[1].y = b[0].y - Bloco.SIZE;
        b[2].x = b[0].x;
        b[2].y = b[0].y + Bloco.SIZE;
        b[3].x = b[0].x + Bloco.SIZE;
        b[3].y = b[0].y + Bloco.SIZE;
    }
    
    @Override
    public void getDirecao1(){
        //o
        //o
        //o o
        tempB[0].x = b[0].x;
        tempB[0].y = b[0].y;
        tempB[1].x = b[0].x;
        tempB[1].y = b[0].y - Bloco.SIZE;
        tempB[2].x = b[0].x;
        tempB[2].y = b[0].y + Bloco.SIZE;
        tempB[3].x = b[0].x + Bloco.SIZE;
        tempB[3].y = b[0].y + Bloco.SIZE;
        
        updateXY(1);
    }
    @Override
    public void getDirecao2(){
        //o o o
        //o
        tempB[0].x = b[0].x;
        tempB[0].y = b[0].y;
        tempB[1].x = b[0].x + Bloco.SIZE;
        tempB[1].y = b[0].y;
        tempB[2].x = b[0].x - Bloco.SIZE;
        tempB[2].y = b[0].y;
        tempB[3].x = b[0].x - Bloco.SIZE;
        tempB[3].y = b[0].y + Bloco.SIZE;
        
        updateXY(2);
    }
    @Override
    public void getDirecao3(){
         //o o
         //  o 
         //  o
        tempB[0].x = b[0].x;
        tempB[0].y = b[0].y;
        tempB[1].x = b[0].x;
        tempB[1].y = b[0].y + Bloco.SIZE;
        tempB[2].x = b[0].x;
        tempB[2].y = b[0].y - Bloco.SIZE;
        tempB[3].x = b[0].x - Bloco.SIZE;
        tempB[3].y = b[0].y - Bloco.SIZE;
        
        updateXY(3);
         
    }
    @Override
    public void getDirecao4(){
        //    o
        //o o o
        tempB[0].x = b[0].x;
        tempB[0].y = b[0].y;
        tempB[1].x = b[0].x - Bloco.SIZE;
        tempB[1].y = b[0].y;
        tempB[2].x = b[0].x + Bloco.SIZE;
        tempB[2].y = b[0].y;
        tempB[3].x = b[0].x + Bloco.SIZE;
        tempB[3].y = b[0].y - Bloco.SIZE;
        
        updateXY(4);
    }
}
