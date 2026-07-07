package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.Random;
import menor.*;

/**
 *
 * @author guylh
 */
public class PlayManager {
    //Área pricipal do jogo
    final int WIDTH = 360;
    final int HEIGHT = 600;
    public static int left_x;
    public static int right_x;
    public static int top_y;
    public static int bottom_y;

    
    Menor currentMino;
    final int MINO_START_X;
    final int MINO_START_Y;
    Menor nextMino;
    final int NEXTMENOR_X;
    final int NEXTMENOR_Y;
    public static  ArrayList<Bloco> staticbBlocos = new ArrayList<>();
    
    public static int dropInterval = 60;
    boolean gameOver;
    
    boolean effectCouterOn;
    int effectCounter;
    ArrayList<Integer> effectY = new ArrayList<>();
    
    int level = 1;
    int lines;
    int score;
    
    public PlayManager() {
        staticbBlocos.clear();
        dropInterval = 60;
        int boxGap = 20;
        int boxWidth = 180;
        int larguraTotal = WIDTH + boxGap + boxWidth;

        left_x = (GamePanel.WIDTH - larguraTotal) / 2;
        right_x = left_x + WIDTH;
        top_y = 20;
        bottom_y = top_y + HEIGHT;

        MINO_START_X = left_x + (WIDTH/2) - Bloco.SIZE;
        MINO_START_Y = top_y + Bloco.SIZE;

        NEXTMENOR_X = right_x + boxGap + (boxWidth/2) - Bloco.SIZE;
        NEXTMENOR_Y = top_y + 70;

        currentMino = pickMenor();
        currentMino.setXY(MINO_START_X, MINO_START_Y);

        nextMino = pickMenor();
        nextMino.setXY(NEXTMENOR_X, NEXTMENOR_Y);
    }
    
    private Menor pickMenor(){
        Menor menor = null;
        int i = new Random().nextInt(7);
        
        switch(i){
            case 0 -> menor = new Menor_L1();
            case 1 -> menor = new Menor_L2();
            case 2 -> menor = new Menor_Square();
            case 3 -> menor = new Menor_Bar();
            case 4 -> menor = new Menor_T();
            case 5 -> menor = new Menor_Z1();
            case 6 -> menor = new Menor_Z2();
        }
        
        return menor;
    }
    
    public void update(){
        if(currentMino.ativado == false){
            staticbBlocos.add(currentMino.b[0]);
            staticbBlocos.add(currentMino.b[1]);
            staticbBlocos.add(currentMino.b[2]);
            staticbBlocos.add(currentMino.b[3]);
            
            if(currentMino.b[0].x == MINO_START_X && currentMino.b[0].y == MINO_START_Y){
                gameOver = true;
            }
            
            currentMino.deactivating = false;
            
            currentMino = nextMino;
            currentMino.setXY(MINO_START_X, MINO_START_Y);
            nextMino = pickMenor();
            nextMino.setXY(NEXTMENOR_X, NEXTMENOR_Y);
            
            checkDelete();
        } else {
            currentMino.update();
        }
    }
    
    public void checkDelete(){
        int x = left_x;
        int y = top_y;
        int contarBlocos = 0;
        int contaLinhas = 0;
        
        while(x < right_x && y < bottom_y){
            
            for(int i = 0; i < staticbBlocos.size(); i++){
               if(staticbBlocos.get(i).x == x && staticbBlocos.get(i).y == y){
                   contarBlocos++;
               } 
            }
            x += Bloco.SIZE;
            
            if(x == right_x){
                if(contarBlocos == 12){
                    
                    effectCouterOn = true;
                    effectY.add(y);
                    
                   for(int i = staticbBlocos.size()-1; i > -1; i--){
                       if(staticbBlocos.get(i).y == y){
                           staticbBlocos.remove(i);
                       }
                    } 
               
                   contaLinhas++;
                   lines++;
                   
                   if(lines % 10 == 0 && dropInterval > 1){
                       
                       level++;
                       if(dropInterval > 10){
                           dropInterval -= 10;
                       } else {
                           dropInterval -= 1;
                       }
                   }
                
                    for(int i = 0; i < staticbBlocos.size(); i++){
                        if (staticbBlocos.get(i).y < y){
                            staticbBlocos.get(i).y += Bloco.SIZE;
                        }
                    }
                 }
                contarBlocos = 0;
                x = left_x;
                y += Bloco.SIZE;
            }
        }
        
        if(contaLinhas > 0){
            int singleLineScore = 10 * level;
            score += singleLineScore * contaLinhas;
        }
    }
    
    public void draw(Graphics2D g2){
        //Desenhar a moldura da área de jogo
        g2.setColor(Color.WHITE);
        g2.setStroke(new BasicStroke(4f));
        g2.drawRect(left_x - 4, top_y - 4, WIDTH + 8, HEIGHT + 8);

        g2.setFont(new Font("Arial", Font.PLAIN, 28));
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        int boxX = right_x + 20;
        int boxWidth = 180;
        int boxHeight = 140;
        int boxGap = 15;
        int y = top_y;

        //Caixa: Próximo
        g2.drawRect(boxX, y, boxWidth, boxHeight);
        g2.drawString("Proximo", boxX + 25, y + 40);
        y += boxHeight + boxGap;

        //Caixa: Pontos
        g2.drawRect(boxX, y, boxWidth, boxHeight);
        g2.drawString("PONTOS", boxX + 25, y + 40);
        g2.setFont(new Font("Arial", Font.PLAIN, 32));
        g2.drawString(String.valueOf(score), boxX + (boxWidth/2) - 15, y + 95);
        y += boxHeight + boxGap;

        //Caixa: Nível
        g2.setFont(new Font("Arial", Font.PLAIN, 28));
        g2.drawRect(boxX, y, boxWidth, boxHeight);
        g2.drawString("NÍVEL", boxX + 25, y + 40);
        g2.setFont(new Font("Arial", Font.PLAIN, 32));
        g2.drawString(String.valueOf(level), boxX + (boxWidth/2) - 10, y + 95);
        y += boxHeight + boxGap;

        //Caixa: Linhas
        g2.setFont(new Font("Arial", Font.PLAIN, 28));
        g2.drawRect(boxX, y, boxWidth, boxHeight);
        g2.drawString("LINHAS", boxX + 25, y + 40);
        g2.setFont(new Font("Arial", Font.PLAIN, 32));
        g2.drawString(String.valueOf(lines), boxX + (boxWidth/2) - 15, y + 95);

        if(currentMino != null){
            currentMino.draw(g2);
        }

        // Desenhar a peça "Próximo" centralizada e em tamanho reduzido
        AffineTransform oldTransform = g2.getTransform();
        double escala = 0.6;

        // 1) Calcula a bounding box da peça atual (varia de acordo com o formato)
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;

        for(int i = 0; i < nextMino.b.length; i++){
            minX = Math.min(minX, nextMino.b[i].x);
            minY = Math.min(minY, nextMino.b[i].y);
            maxX = Math.max(maxX, nextMino.b[i].x + Bloco.SIZE);
            maxY = Math.max(maxY, nextMino.b[i].y + Bloco.SIZE);
        }

        // 2) Centro real da peça (em coordenadas de tela, antes de escalar)
        double centroX = (minX + maxX) / 2.0;
        double centroY = (minY + maxY) / 2.0;

        // 3) Centro desejado dentro da caixa "Proximo" (área abaixo do texto)
        int caixaCentroX = boxX + (boxWidth / 2);
        int caixaCentroY = top_y + 90; // ajuste esse valor pra subir/descer a peça na caixa

        // 4) Move o centro da peça pro centro da caixa, aplicando a escala no processo
        g2.translate(caixaCentroX, caixaCentroY);
        g2.scale(escala, escala);
        g2.translate(-centroX, -centroY);

        nextMino.draw(g2);

        g2.setTransform(oldTransform);
        for(int i = 0; i < staticbBlocos.size(); i++){
            staticbBlocos.get(i).draw(g2);
        }

        if(effectCouterOn){
            effectCounter++;

            for(int i = 0; i<effectY.size(); i++){
                g2.fillRect(left_x, effectY.get(i), WIDTH, Bloco.SIZE);
            }

            if(effectCounter == 10){
                effectCouterOn = false;
                effectCounter = 0;
                effectY.clear();
            }
        }

        g2.setColor(Color.RED);
        g2.setFont(g2.getFont().deriveFont(50f));
        int x;
        
        if(gameOver){
            x = left_x + 25;
            y = top_y + 320;
            g2.drawString("FIM DE JOGO", x, y);
            
            g2.setColor(Color.BLUE);
            g2.setFont(new Font("Arial", Font.BOLD,30));
            g2.drawString("  Aperte ENTER PARA", x, y +25);
            g2.drawString("   REINICIAR O JOGO", x, y+55);
        } else if(KeyHandler.pausePressed){
            x = left_x + 60;
            y = top_y + 300;
            g2.drawString("PAUSADO", x, y);
        }

    }
}
