package menor;

import java.awt.Color;
import java.awt.Graphics2D;
import main.KeyHandler;
import main.PlayManager;

/**
 *
 * @author guylh
 */
public class Menor {
    
    public Bloco b[] = new Bloco[4];
    public Bloco tempB[] = new Bloco[4];
    int autoDropCounter = 0;
    public int direcao = 1;
    boolean leftCollision, rightCollision, bottomCollision;
    public boolean ativado = true;
    public boolean deactivating;
    int deactivateCounter = 0;
    
    
    public void criar(Color c){
        b[0] = new Bloco(c);
        b[1] = new Bloco(c);
        b[2] = new Bloco(c);
        b[3] = new Bloco(c);
        tempB[0] = new Bloco(c);
        tempB[1] = new Bloco(c);
        tempB[2] = new Bloco(c);
        tempB[3] = new Bloco(c);
    }
    
    public void setXY(int x, int y){}
    public void updateXY(int direction){
       
        checkRotationCollision();
        
        if(leftCollision == false && rightCollision == false && bottomCollision == false){
            this.direcao = direction;
            b[0].x = tempB[0].x;
            b[0].y = tempB[0].y;
            b[1].x = tempB[1].x;
            b[1].y = tempB[1].y;
            b[2].x = tempB[2].x;
            b[2].y = tempB[2].y;
            b[3].x = tempB[3].x;
            b[3].y = tempB[3].y;  
        }
        
    }
    public void getDirecao1(){}
    public void getDirecao2(){}
    public void getDirecao3(){}
    public void getDirecao4(){}
    public void checkMovementCollision(){
        leftCollision = false;
        rightCollision = false;
        bottomCollision = false;
        
        checkStaticBlockCollision();
        
        for(int i = 0; i < b.length; i++){
            if(b[i].x == PlayManager.left_x){
                leftCollision = true;
            }
        }
        
        for(int i = 0; i < b.length; i++){
            if(b[i].x + Bloco.SIZE == PlayManager.right_x) {
                rightCollision = true;
            }
        }
        
        for(int i = 0; i < b.length; i++){
            if(b[i].y + Bloco.SIZE == PlayManager.bottom_y){
                bottomCollision = true;
            }
        }
    }
    public void checkRotationCollision(){
        
        leftCollision = false;
        rightCollision = false;
        bottomCollision = false;
        
        checkStaticBlockCollision();
        
        for(int i = 0; i < b.length; i++){
            if(tempB[i].x < PlayManager.left_x){
                leftCollision = true;
            }
        }
        
        for(int i = 0; i < b.length; i++){
            if(tempB[i].x + Bloco.SIZE > PlayManager.right_x) {
                rightCollision = true;
            }
        }
        
        for(int i = 0; i < b.length; i++){
            if(tempB[i].y + Bloco.SIZE > PlayManager.bottom_y){
                bottomCollision = true;
            }
        }
    }
    
    private void checkStaticBlockCollision(){
        for(int i = 0; i < PlayManager.staticbBlocos.size(); i++){
           int targetX = PlayManager.staticbBlocos.get(i).x;
           int targetY = PlayManager.staticbBlocos.get(i).y;
           
           for(int j = 0; j < b.length; j++){
               if(b[j].y + Bloco.SIZE == targetY && b[j].x == targetX){
                   bottomCollision = true;
               }
           }
           
           for(int j = 0; j < b.length; j++){
               if(b[j].x - Bloco.SIZE == targetX && b[j].y == targetY){
                   leftCollision = true;
               }
           }
           for(int j = 0; j < b.length; j++){
               if(b[j].x + Bloco.SIZE == targetX && b[j].y == targetY){
                   rightCollision = true;
               }
           }
        }
    }
    
    public void update() {
    
        if(deactivating){
            deactivating();
        }
        if(KeyHandler.upPressed){
            switch(direcao){
                case 1 -> getDirecao2();
                case 2 -> getDirecao3();
                case 3 -> getDirecao4();
                case 4 -> getDirecao1();
            }
            KeyHandler.upPressed = false;
            //GamePanel.se.play(1, false);
        }
        
        checkMovementCollision();
        
        if(KeyHandler.downPressed){
            if(bottomCollision == false){
                b[0].y += Bloco.SIZE;
                b[1].y += Bloco.SIZE;
                b[2].y += Bloco.SIZE;
                b[3].y += Bloco.SIZE;

                autoDropCounter = 0;
            }
            
            KeyHandler.downPressed = false;
        }
        if(KeyHandler.leftPressed){
            if(leftCollision == false){
                b[0].x -= Bloco.SIZE;
                b[1].x -= Bloco.SIZE;
                b[2].x -= Bloco.SIZE;
                b[3].x -= Bloco.SIZE;
            }
            
            KeyHandler.leftPressed = false;
        }
        if(KeyHandler.rightPressed){
            if(rightCollision == false){
                b[0].x += Bloco.SIZE;
                b[1].x += Bloco.SIZE;
                b[2].x += Bloco.SIZE;
                b[3].x += Bloco.SIZE;
            }
            
            KeyHandler.rightPressed = false;
        }
        
        if(bottomCollision){
            if(deactivating == false){
              //  GamePanel.se.play(4, false);
            }
            deactivating = true;
        }else {
            autoDropCounter++;
            if(autoDropCounter == PlayManager.dropInterval){
                b[0].y += Bloco.SIZE;
                b[1].y += Bloco.SIZE;
                b[2].y += Bloco.SIZE;
                b[3].y += Bloco.SIZE;
                autoDropCounter = 0;
            }
        }
    }
    
    public void deactivating(){
        deactivateCounter++;
        
        if(deactivateCounter == 45){
            deactivateCounter = 0;
            checkMovementCollision();
            
            if(bottomCollision){
                ativado = false;
            }
        }
    }
    
    public void draw(Graphics2D g2){
        int margem = 2;
        g2.setColor(b[0].c);
        g2.fillRect(b[0].x+margem, b[0].y+margem, Bloco.SIZE-(margem*2), Bloco.SIZE-(margem*2));
        g2.fillRect(b[1].x+margem, b[1].y+margem, Bloco.SIZE-(margem*2), Bloco.SIZE-(margem*2));
        g2.fillRect(b[2].x+margem, b[2].y+margem, Bloco.SIZE-(margem*2), Bloco.SIZE-(margem*2));
        g2.fillRect(b[3].x+margem, b[3].y+margem, Bloco.SIZE-(margem*2), Bloco.SIZE-(margem*2));
        
    }
    
}
