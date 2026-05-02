package jogodeforca;

import java.util.Arrays;
import java.util.Scanner;

public class JogoDeForca {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String escolhar ;
        boolean voltar = true;
        while(voltar){
        System.out.println("=============Jogo da Forca==============");
        System.out.println("\nJogo Altomati (1)\nJogo Manual (2)\nSair(3)");
        System.out.print("Escolhar: ");
        escolhar = sc.nextLine();
        
        switch (escolhar) {
            case "1" -> {
                String forca[][]= {{" ", "+", "-", "-", "+", ""},
                    {" ", "|", " ", " | ", " ", " "},
                    {" ", "|", " ", " |", " ", " "},
                    {" ", "|", " ", " ", " ", " "},
                    {" ", "|", " ", " ", " ", " "},
                    {" ", "|", " ", " ", " ", " "},
                    {"=", "=", "=", "=", "=", "="}};
                
                String palavrasAltomaticas[] = {"JAVA","MATRIZ","COMPUTADOR","TECLADO","JOGOS"};
                boolean vitoria1 = false;
                int chances = 7;
                char caracter1 = 0;
                int palevraEscolhida = (int) (Math.random()*palavrasAltomaticas.length);
               
                String palavra = palavrasAltomaticas[palevraEscolhida];
                
                char letras[] = new char[palavra.length()];
                char letrasErradas[] = new char[7];
                for (int i = 0; i < letrasErradas.length; i++) {
                    letrasErradas[i] = '_';
                }
                for (int g = 0; g < letras.length; g++) {
                    letras[g]='_';
                }
                while(chances > 0 && !vitoria1){
                    for (int k = 0; k < 10; k++) {
                        System.out.println();
                    }
                    System.out.println("=============Jogo da Forca==============\n");
                    
                    System.out.println("Digite uma letra por vez!");
                    System.out.println("Letras Erradas: "+Arrays.toString(letrasErradas));
                    for (String[] forca1 : forca) {
                        for (String forca11 : forca1) {
                            System.out.print(forca11);
                        }
                        System.out.println();
                    } 
                    
                    System.out.println("Você tem "+chances+" chances");
                    System.out.print("Palavra Screta: "+Arrays.toString(letras));
                    
                    System.out.print("\nDigite uma palavra: ");
                    caracter1 = sc.nextLine().toUpperCase().charAt(0);   
                    
                    boolean erro1 = true;                       
                    for (int i = 0; i < letras.length; i++) {
                        if(palavra.charAt(i) == caracter1){
                            letras[i] = caracter1;
                            erro1 = false;
                        }
                    }
                    

                    
                    if(erro1){
                        if(chances == 7 && " ".equals(forca[3][3])){
                            chances--;
                            forca[3][3]=" O ";
                            letrasErradas[0] = caracter1;
                        } else if(chances == 6 && " ".equals(forca[4][3])){
                            chances--;
                            forca[4][3]="|";
                            letrasErradas[1] = caracter1;
                        } else if(chances == 5 && " ".equals(forca[4][2])){
                            chances--;
                            forca[4][2]=" /";
                            letrasErradas[2] = caracter1;
                        } else if(chances == 4 && " ".equals(forca[4][4])){
                            chances--;
                            forca[4][4]="\\ ";
                            letrasErradas[3] = caracter1;
                        } else if(chances == 3 && " ".equals(forca[5][2])){
                            chances--;
                            forca[5][2]=" /";
                            letrasErradas[4] = caracter1;
                        } else if(chances == 2 && " ".equals(forca[5][4])){
                            chances--;
                            forca[5][4]="\\ ";
                            letrasErradas[5] = caracter1;
                        } else if(chances == 1 ){
                            chances--;
                            forca[2][3] = " O "; forca[3][3] = " ";
                            forca[3][3] = "|";   forca[4][3] = " ";
                            forca[3][2] = " /";  forca[4][2] = " ";
                            forca[3][4] = "\\";  forca[4][4] = " ";
                            forca[4][2] = " /";  forca[5][2] = " ";
                            forca[4][4] = "\\";  forca[5][4] = " ";
                            letrasErradas[6]=caracter1;
                        }
                    }
                    boolean venceu = true;
                    for (int h = 0; h < letras.length; h++) {
                        if (letras[h] == '_') {
                            venceu = false;
                            break;
                        }
                    }
                    
                    if (venceu) {
                        vitoria1 = true;   
                        System.out.println("\n\n");
                        System.out.println("Letras Erradas: "+Arrays.toString(letrasErradas));
                        for (String[] forca1 : forca) {
                            for (String forca11 : forca1) {
                                System.out.print(forca11);
                            }
                            System.out.println();
                        }
                        System.out.print("Palavra: ");
                        
                        for (int g = 0; g < letras.length; g++) {
                            
                            System.out.print(letras[g]);
                        }
                        System.out.println();
                        System.out.println("PARABÉNS! VOCÊ VENCEU!");
                        break;
                    }
                }
                
                if (chances == 0) {
                    System.out.println("\n\n");
                    System.out.println("Letras Erradas: "+Arrays.toString(letrasErradas));
                    for (String[] forca1 : forca) {
                        for (String forca11 : forca1) {
                            System.out.print(forca11);
                        }
                        System.out.println();
                    }
                    System.out.println("INFORCADO!");
                    System.out.println("GAME OVER - Você perdeu");
                    System.out.println("A palavra era: " + palavra);
                    
                    
                }
                
                System.out.println("\nDeseja vouta para o menu: S/N");
                escolhar = sc.nextLine();
                if("S".equals(escolhar) || "s".equals(escolhar)){
                    for (int i = 0; i < 20; i++) {
                        System.out.println("");
                    }
                } else{
                    voltar = false;
                }
                }
                   
            case "2" -> {
                String forca2[][]= {{" ", "+", "-", "-", "+", ""},
                    {" ", "|", " ", " | ", " ", " "},
                    {" ", "|", " ", " |", " ", " "},
                    {" ", "|", " ", " ", " ", " "},
                    {" ", "|", " ", " ", " ", " "},
                    {" ", "|", " ", " ", " ", " "},
                    {"=", "=", "=", "=", "=", "="}};
                
                int chances2 = 7;
                boolean vitoria2 = false;
                char caracter2;
                String palavraManuas;
                System.out.print("Digite a palavra secreta: ");
                palavraManuas = sc.nextLine().toUpperCase();
                System.out.println();
                
                char letras2[]= new char[palavraManuas.length()];
                char[] lertasErradas = new char[7];
                
                for (int i = 0; i < letras2.length; i++) {
                    letras2[i]='_';
                }
                for (int i = 0; i < lertasErradas.length; i++) {
                    lertasErradas[i] = '_';
                }
                
                while(chances2 > 0 && !vitoria2){
                    for (int i = 0; i < 10; i++) {
                        System.out.println();
                    }
                    System.out.println("=============Jogo da Forca==============\n");
                    
                    System.out.println("Digite uma letra por vez!");
                    System.out.println("Letras Erradas: "+Arrays.toString(lertasErradas));
                    for (String[] forca1 : forca2) {
                        for (String item : forca1) {
                            System.out.print(item);
                        }
                        System.out.println();
                    }
                    System.out.println();
                    System.out.println("Você tem "+chances2+" chances ");
                    System.out.println("Palavra Screta: "+Arrays.toString(letras2));
                    System.out.print("Digite uma letra: ");
                    caracter2 = sc.nextLine().toUpperCase().charAt(0);
                    
                    boolean erro2 = true;
                    for (int i = 0; i < letras2.length; i++) {
                        if(palavraManuas.charAt(i) == caracter2){
                            letras2[i] = caracter2;
                            erro2 = false;
                        }
                    }
                    
                    if(erro2){
                        if(chances2 == 7 && " ".equals(forca2[3][3])){
                            chances2--;
                            forca2[3][3]=" O ";
                            lertasErradas[0] = caracter2;
                        } else if(chances2 == 6 && " ".equals(forca2[4][3])){
                            chances2--;
                            forca2[4][3]="|";
                            lertasErradas[1] = caracter2;
                        } else if(chances2 == 5 && " ".equals(forca2[4][2])){
                            chances2--;
                            forca2[4][2]=" /";
                            lertasErradas[2] = caracter2;
                        } else if(chances2 == 4 && " ".equals(forca2[4][4])){
                            chances2--;
                            forca2[4][4]="\\ ";
                            lertasErradas[3] = caracter2;
                        } else if(chances2 == 3 && " ".equals(forca2[5][2])){
                            chances2--;
                            forca2[5][2]=" /";
                            lertasErradas[4] = caracter2;
                        } else if(chances2 == 2 && " ".equals(forca2[5][4])){
                            chances2--;
                            forca2[5][4]="\\ ";
                            lertasErradas[5] = caracter2;
                        } else if(chances2 == 1 ){
                            chances2--;
                            forca2[2][3] = " O "; forca2[3][3] = " ";
                            forca2[3][3] = "|";   forca2[4][3] = " ";
                            forca2[3][2] = " /";  forca2[4][2] = " ";
                            forca2[3][4] = "\\";  forca2[4][4] = " ";
                            forca2[4][2] = " /";  forca2[5][2] = " ";
                            forca2[4][4] = "\\";  forca2[5][4] = " ";
                            lertasErradas[6]=caracter2;
                        }
                    }
                    
                    boolean vence = true;
                    for (int g = 0; g < letras2.length; g++) {
                        if (letras2[g]== '_') {
                            vence = false;
                            break;
                        }
                    }
                    
                    if(vence){
                        vitoria2 = true;
                        System.out.println("\n\n");
                        System.out.println("Letras Erradas: "+Arrays.toString(lertasErradas));
                        for (String[] forca1 : forca2) {
                            for (String forca11 : forca1) {
                                System.out.print(forca11);
                            }
                            System.out.println();
                        }
                        System.out.print("Palavra: ");
                        
                        for (int g = 0; g < letras2.length; g++) {
                            
                            System.out.print(letras2[g]);
                        }
                        System.out.println();
                        System.out.println("PARABÉNS! VOCÊ VENCEU!");
                        break;
                    }
                    
                }
                
                if (chances2 == 0) {
                    System.out.println("\n\n");
                    System.out.println("Letras Erradas: "+Arrays.toString(lertasErradas));
                    for (String[] forca1 : forca2) {
                        for (String forca11 : forca1) {
                            System.out.print(forca11);
                        }
                        System.out.println();
                    }
                    System.out.println("INFORCADO!");
                    System.out.println("GAME OVER - Você perdeu");
                    System.out.println("A palavra era: " + palavraManuas);
                }
                
                System.out.println("\nDeseja vouta para o menu: S/N");
                escolhar = sc.nextLine();
                if("S".equals(escolhar) || "s".equals(escolhar)){
                    for (int i = 0; i < 20; i++) {
                        System.out.println("");
                    }
                } else{
                    voltar = false;
                }
                }
            
            case "3" -> voltar = false;
            default -> System.out.println("Opição invalida!");
        }
        
        } 
    }
    
}