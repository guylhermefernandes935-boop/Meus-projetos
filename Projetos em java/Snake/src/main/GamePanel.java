package main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener{

    static final int SCREEN_WIDTH = 850;
    static final int SCREEN_HEIGHT = 450;
    static final int UNIT_SIZE = 25;
    static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/UNIT_SIZE;
    static final int DELAY = 100;
    final int x[] = new int[GAME_UNITS];
    final int y[] = new int[GAME_UNITS];
    int bodyParts = 3;
    int applesEaten;
    int appleX;
    int appleY;
    char direction = 'R';
    boolean running = false;
    Timer timer;
    Random random;
    MusicaPlayer musica = new MusicaPlayer();
    boolean directionChanged = false;
    boolean paused = false;
    public GamePanel() {
        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyadapter());
        startGame();
    }
    
    private void startGame(){
        x[0] = (SCREEN_WIDTH / UNIT_SIZE / 2) * UNIT_SIZE;
        y[0] = (SCREEN_HEIGHT / UNIT_SIZE / 2) * UNIT_SIZE;
        
        for(int i = 1; i < bodyParts; i++){
            x[i] = x[0] - (i*UNIT_SIZE);
            y[i] = y[0];
        }
        
        newApple();
        
        musica.stop();
        musica.play("/musica/Gymnopedie_20No_201.mp3");
        
        running = true;
        timer = new Timer(DELAY, this);
        timer.start();
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }
    
    public void draw(Graphics g){
        if(running){
            /*
            // Linhas verticais
            for(int i = 0; i <= SCREEN_WIDTH / UNIT_SIZE; i++){
                g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT);
            }

            // Linhas horizontais
            for(int i = 0; i <= SCREEN_HEIGHT / UNIT_SIZE; i++){
                g.drawLine(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE);
            }
            */
            g.setColor(Color.red);
            g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);

            for(int j = 0; j<bodyParts;j++){
                if(j == 0){
                    g.setColor(Color.GREEN);
                    g.fillRect(x[j], y[j], UNIT_SIZE, UNIT_SIZE);
                }else {
                    g.setColor(new Color(45,180,0));
                    //g.setColor(new Color(random.nextInt(255), random.nextInt(255),random.nextInt(255)));
                    g.fillRect(x[j], y[j], UNIT_SIZE, UNIT_SIZE);

                }
            }
            //Pontuação
            g.setColor(Color.red);
            g.setFont(new Font("Arial", Font.BOLD, 14));
            FontMetrics metrics1 = getFontMetrics(g.getFont());
            g.drawString("Pontuação: "+applesEaten, (SCREEN_WIDTH - metrics1.stringWidth("Pontuação"))/2, g.getFont().getSize());
        
            if(paused){
                g.setColor(Color.red);
                g.setFont(new Font("Arial", Font.BOLD, 50));

                FontMetrics metric2 = getFontMetrics(g.getFont());

                g.drawString("PAUSADO", (SCREEN_WIDTH - metric2.stringWidth("PAUSADO"))/2, SCREEN_HEIGHT/2);
            }
        } else {
            gameOver(g);
        }
        
    }
    
    public void newApple(){
        boolean onSnake;

        do {
            onSnake = false;

            appleX = random.nextInt(SCREEN_WIDTH / UNIT_SIZE) * UNIT_SIZE;
            appleY = random.nextInt(SCREEN_HEIGHT / UNIT_SIZE) * UNIT_SIZE;

            for (int i = 0; i < bodyParts; i++) {
                if (x[i] == appleX && y[i] == appleY) {
                    onSnake = true;
                    break;
                }
            }

        } while (onSnake);
    }
    
    public void move(){
        for(int i = bodyParts; i>0; i--){
            x[i] = x[i-1];
            y[i] = y[i-1];
        }
        switch (direction){
            case 'U' -> y[0] -= UNIT_SIZE;
            case 'D' -> y[0] += UNIT_SIZE;
            case 'L' -> x[0] -= UNIT_SIZE;
            case 'R' -> x[0] += UNIT_SIZE;
        }
    }
    
    public void checkApple(){
        if((x[0] == appleX) && (y[0] == appleY)){
            bodyParts++;
            applesEaten++;
            newApple();
        }
    }
    
    public void checkCollisions(){
        //verifica se a cabeça colide com a borda
        for(int i = bodyParts; i > 0; i--){
            if(x[0] == x[i] && (y[0] == y[i])){
                running = false;
            }
        }
        //verifica se a cabeça toca a borda esquerda
        if(x[0] < 0){
            running = false;
        }
        //verifica se a cabeça toca a borda diretita
        if(x[0] >= SCREEN_WIDTH){
            running = false;
        }
        //verifica se a cabeça toca a borda de cima
        if(y[0] < 0){
            running = false;
        }
        //verifica se a cabeça toca a borda de baixo
        if(y[0] >= SCREEN_HEIGHT){
            running = false;
        }
        if(!running){
            timer.stop();
            musica.stop();
        }
    }
    
    public void gameOver(Graphics g){
        //Pontuação
        g.setColor(Color.red);
        g.setFont(new Font("Arial", Font.BOLD, 14));
        FontMetrics metrics1 = getFontMetrics(g.getFont());
        g.drawString("Pontuação: "+applesEaten, (SCREEN_WIDTH - metrics1.stringWidth("Pontuação"))/2, g.getFont().getSize());
  
    
        //Texto "Game Over
        g.setColor(Color.red);
        g.setFont(new Font("Arial", Font.BOLD, 75));
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.drawString("Game Over", (SCREEN_WIDTH - metrics2.stringWidth("Game Over"))/2, SCREEN_HEIGHT/2);
        
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.PLAIN, 25));
        FontMetrics metrics3 = getFontMetrics(g.getFont());

        g.drawString("    Aperte ENTER para reinicia o jogo", (SCREEN_WIDTH - metrics3.stringWidth("Pressione ENTER para voltar ao menu")) / 2, SCREEN_HEIGHT / 2 + 50);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        directionChanged = false;
        if(running){
            move();
            checkApple();
            checkCollisions();
        }
        repaint();
    }
    
    public void restarGame(){
        bodyParts = 3;
        applesEaten = 0;
        direction = 'R';
        
        for(int i = 0; i < GAME_UNITS; i++){
            x[i] = 0;
            y[i] = 0;
        }
        
        startGame();
    }
    
    public class MyKeyadapter extends KeyAdapter{
       
        @Override
        public void keyPressed(KeyEvent e){
            if(paused && e.getKeyCode() != KeyEvent.VK_SPACE){
                return;
            }
            
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT -> { 
                    if(!directionChanged && direction != 'R'){
                        direction = 'L';
                        directionChanged = true;
                    }
                }
                case KeyEvent.VK_RIGHT -> { 
                    if(!directionChanged && direction != 'L'){
                        direction = 'R';
                        directionChanged = true;
                    }
                }
                case KeyEvent.VK_UP -> { 
                    if(!directionChanged && direction != 'D'){
                        direction = 'U';
                        directionChanged = true;
                    }
                }
                case KeyEvent.VK_DOWN -> { 
                    if(!directionChanged && direction != 'U'){
                        direction = 'D';
                        directionChanged = true;
                    }
                }
                case KeyEvent.VK_ENTER -> { 
                    if(!running){
                        //new Menu().setVisible(true);
                        //new GameFrame().setVisible(true);
                        
                        restarGame();
                        //Window janela = SwingUtilities.getWindowAncestor(GamePanel.this);
                        //janela.dispose();
                    }
                }
                case KeyEvent.VK_SPACE -> {
                    if(running){
                       if(!paused){
                           paused = true;
                           repaint();
                           timer.stop();
                       } else {
                            paused = false;
                            timer.start();
                            repaint();
                        }
                    }
                }
            }
        }
    }
}
