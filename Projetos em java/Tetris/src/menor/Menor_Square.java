package menor;

import java.awt.Color;

/**
 *
 * @author guylh
 */
public class Menor_Square extends Menor{
    
    public Menor_Square(){
        //criar(Color.YELLOW);
        criar(Color.WHITE);
    }
    
    public void setXY(int x, int y){
        // o o
        // o o
        b[0].x = x;
        b[0].y = y;
        b[1].x = b[0].x;
        b[1].y = b[0].y + Bloco.SIZE;
        b[2].x = b[0].x + Bloco.SIZE;
        b[2].y = b[0].y;
        b[3].x = b[0].x + Bloco.SIZE;
        b[3].y = b[0].y + Bloco.SIZE;
    }
    
    
    @Override
    public void getDirecao1(){}
    @Override
    public void getDirecao2(){}
    @Override
    public void getDirecao3(){}
    @Override
    public void getDirecao4(){}
}
