package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String leitura;
        System.out.println("Digite sua frase para avaliação do seu sentimento, fofo(a)!");
        leitura = sc.nextLine();
        String leitura2 = leitura;

        int chateadoCont = 0;
        int divertidoCont = 0;
        int i;

        // O indexOf()método retorna a posição da primeira ocorrência do(s) caractere(s) especificado(s) em uma string.
        //Foi colocado o emoticon para ser encontrado na frase e somado, caso haja ocorrência.

        i = leitura.indexOf(":-)");

            while (i != -1){
            divertidoCont+=1;
            leitura = leitura.substring(i+3);
            i = leitura.indexOf(":-)");
        }

        i = leitura2.indexOf(":-(");

        while (i != -1){
            chateadoCont+=1;
            leitura2 = leitura2.substring(i+3);
            i = leitura2.indexOf(":-(");
        }

        //Comparações para expressão do sentimento.

        if(divertidoCont > chateadoCont){
            System.out.println("Divertido");
        }

        else if(chateadoCont > divertidoCont){
            System.out.println("Chateado");
        }
        else if(divertidoCont==chateadoCont){
            System.out.println("Neutro");
        }
    }
}
