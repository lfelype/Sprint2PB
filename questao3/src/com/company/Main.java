package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String leitura;
        System.out.println("Digite sua frase para avaliação do seu sentimento, :-) para feliz e :-( para triste");
        leitura = sc.nextLine();
        String leitura2 = leitura;

        int chateadoCont = 0;
        int divertidoCont = 0;
        int i;

        // O indexOf()método retorna a posição da primeira ocorrência do(s) caractere(s) especificado(s) em uma string.
        //Foi colocado o emoticon para ser encontrado na frase e somado, caso haja ocorrência.
        //Quando não é encontrado o emotion, o retorno é -1.

        i = leitura.indexOf(":-)");
        while (i != -1 && leitura.length() != 0) {
            divertidoCont++;
            //i+3 pois inicia no : e conta 3 caracteres com substring
            leitura = leitura.substring(i + 3);
            i = leitura.indexOf(":-)");
        }
        System.out.println("Encontramos " + divertidoCont + " emoticon divertido na frase!");


        i = leitura2.indexOf(":-(");
        while (i != -1) {
            chateadoCont++;
            //i+3 pois inicia no : e conta 3 caracteres com substring
            leitura2 = leitura2.substring(i + 3);
            i = leitura2.indexOf(":-(");
        }
        System.out.println("Encontramos " + chateadoCont + " emoticon chateado na frase!\n");

        //Comparações para expressão do sentimento.

        if (divertidoCont > chateadoCont) {
            System.out.println("Você está divertido(a)!");
        } else if (chateadoCont > divertidoCont) {
            System.out.println("Você está chateado(a)!");
        } else if (divertidoCont == chateadoCont) {
            System.out.println("Você está com um sentimento neutro!");
        }

    }
}

