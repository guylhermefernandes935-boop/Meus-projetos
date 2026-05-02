
package jogoDaVelhar;

import java.util.Scanner;

public class jogoDaVelhar {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("=============Jogo da Velhear=================");
        String posicoes [][] = {{"|1|","|2|","|3|"}, 
                                {"|4|","|5|","|6|"},
                                {"|7|","|8|","|9|"}};
        String jogador = "X";
        boolean vencer = false;
        int jogadas = 0;
        
        while(!vencer && jogadas < 9){
        for (String[] posicoe : posicoes) {
                System.out.println("");
            for (int j = 0; j<posicoes.length; j++) {
                System.out.print(posicoe[j]);          
            }
        }
            System.out.println("");
            
            System.out.println("Vez do jogador: "+ jogador);
            System.out.print("Escolhar uma posição: ");
            String posicao = sc.nextLine();
            
            boolean jogadaValida = true;

            switch (posicao) {
                case "1": if("|1|".equals(posicoes[0][0])){posicoes[0][0] = "|"+jogador+"|";}
                          else {System.out.println("Posição inválida!");
                          jogadaValida = false;}
                          break;
                case "2":  if("|2|".equals(posicoes[0][1])){posicoes[0][1] = "|"+jogador+"|";}
                           else {System.out.println("Posição inválida!");
                           jogadaValida = false;}
                           break;
                case "3": if("|3|".equals(posicoes[0][2])){posicoes[0][2] = "|"+jogador+"|";}
                          else {System.out.println("Posição inválida!");
                           jogadaValida = false;}
                           break;
                case "4": if("|4|".equals(posicoes[1][0])){posicoes[1][0] = "|"+jogador+"|";} 
                          else {System.out.println("Posição inválida!");
                           jogadaValida = false;}
                           break;
                case "5": if("|5|".equals(posicoes[1][1])){posicoes[1][1] = "|"+jogador+"|";}
                          else {System.out.println("Posição inválida!");
                           jogadaValida = false;}
                           break;
                case "6": if("|6|".equals(posicoes[1][2])){posicoes[1][2] = "|"+jogador+"|";}
                          else {System.out.println("Posição inválida!");
                           jogadaValida = false;}
                           break;
                case "7": if("|7|".equals(posicoes[2][0])){posicoes[2][0] = "|"+jogador+"|";}
                          else {System.out.println("Posição inválida!");
                           jogadaValida = false;}
                           break;
                case "8": if("|8|".equals(posicoes[2][1])){posicoes[2][1] = "|"+jogador+"|";}
                          else {System.out.println("Posição inválida!");
                           jogadaValida = false;}
                           break;  
                case "9": if("|9|".equals(posicoes[2][2])){posicoes[2][2] = "|"+jogador+"|";}
                          else {System.out.println("Posição inválida!");
                           jogadaValida = false;}
                           break; 
                default:
                    System.out.println("Posição inválida!");
                    jogadaValida = false;
            }
             if (!jogadaValida) continue; 
            
            jogadas++;
            
            for(int t=0; t<3; t++){
                if(posicoes[t][0].equals("|"+jogador+"|") &&
                   posicoes[t][1].equals("|"+jogador+"|") &&
                   posicoes[t][2].equals("|"+jogador+"|")){
                    vencer = true;
                }
                if(posicoes[0][t].equals("|"+jogador+"|") &&
                   posicoes[1][t].equals("|"+jogador+"|") &&
                   posicoes[2][t].equals("|"+jogador+"|")){
                    vencer = true;
                }
            }
                if (posicoes[0][0].equals("|"+jogador+"|") &&
                    posicoes[1][1].equals("|"+jogador+"|") &&
                    posicoes[2][2].equals("|"+jogador+"|")) {
                vencer = true;
            }
            if (posicoes[0][2].equals("|"+jogador+"|") &&
                posicoes[1][1].equals("|"+jogador+"|") &&
                posicoes[2][0].equals("|"+jogador+"|")) {
                vencer = true;
            }
        
            if (vencer) {
                for (int i = 0; i < 3; i++) {
                    System.out.println();
                    for (int j = 0; j < 3; j++) {
                        System.out.print(posicoes[i][j]);
                    }
                }
                System.out.println("\nJogador " + jogador + " venceu!");
                break;
            }
            if(!vencer){
                jogador = ("X".equals(jogador))? "O":"X";
            }
            
          
        }
        if(!vencer){
            System.out.println("\nDeu velhar");
        }
        
    }
    
}
