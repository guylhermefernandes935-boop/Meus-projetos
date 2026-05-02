#include <stdio.h>
#include <stdlib.h>
#include <time.h>/*Contém protótipo para funções time*/

/*constantes de enumeração representam atatus do jogo*/
enum Status{CONTINUE, WON, LOST};

int rolleDice();/*protótipo de função*/

/*função main inicia a execução do program*/
int main(){

    int sum; /*soma dos dados lançados*/
    int myPoint; /*ponto ganho*/

    enum Status gameStatus;/*pode conter CONTINUE, WON ou LOST*/

    /*randomiza gerador de número aleatório usando hora atual*/
    srand( time(NULL));

    sum = rolleDice();/*primeiro lançamento dos dados*/

    /*determina status do jogo com base na soma dos dados*/
    switch(sum){

        /*vence na primeira jogada*/
        case 7:
        case 11: 
            gameStatus = WON;
            break;

        /*perde na primeira jogada*/
        case 2:
        case 3:
        case 12:
            gameStatus = LOST;
            break;

        /*lembra ponto*/
        default:
            gameStatus = CONTINUE;
            myPoint = sum;
            printf("Ponto é %d\n", myPoint);
            break;
    }/*fim do switch*/

    /*enquanto jogo não termina*/
    while(gameStatus == CONTINUE){
        sum = rolleDice(); /*jogo dados novamente*/

        /*determina status do jogo*/
        if(sum == myPoint){
            gameStatus = WON;/*jogo termina, jogador vence*/
        }/*fim do if*/ 
        else {
            if(sum == 7){/*perde por lançar 7*/
                gameStatus = LOST;/*jogo termina, jogador perde*/
            }/*fim do if*/
        }/*fim do else*/
    }/*fim do while*/

    /*mostra mansagem d evitória ou perda*/
    if(gameStatus == WON){/*jogador venceu?*/
        printf("Jogador vence\n");
    }/*fim do if*/ 
    else { /*jogador perdeu*/
        printf("Jogador perde\n");
    }/*fim do else*/

    return 0;/*indica conlusão bem-sucedida*/
}/*fim do main*/

/*lança dados, calcula soma e exibe resultados*/
int rolleDice(){

    int die1;/*primeiro dado*/
    int die2;/*segundo dado*/
    int workSum;/*soma dos dados*/

    die1 = 1 + (rand() % 6);/*escolhe valor aleatório die1*/
    die2 = 1 + (rand() % 6);/*escolhe valor aleatório die2*/
    workSum = die1 + die2;/*soma die1 e die2*/

    /*exibe resultados dessa joganda*/
    printf("Jogador rolou %d + %d = %d\n", die1, die2, workSum);
    return workSum;
}/*fim da função rollRice*/