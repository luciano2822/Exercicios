/*
 * Programa desenvolvido para treinar os conceitos aprendidos até o momento atual do curso
 * incluindo estruturas de controle, de repetição, array, matriz e modularização.
 * */

import java.util.Arrays;

public class AnaliseDeVendas {

    /*
    * Na principal serão inseridos os dados a serem processados e serão realizadas as invocações
    * dos métodos auxiliares.
    */
    public static void main(String[] args){


        String[] dias = { "Segunda-feira", "Terça-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira", "Sabado", "Domingo" };


        String[] produtos = {"Café", "Suco", "Bolo", "Sanduíche", "Torta", "Cookie"};



        int[][] matrizDeValor = {
                {35, 18, 12, 22, 5, 1},
                {40, 21, 15, 25, 10},
                {32, 20, 17, 0, 16, 19},
                {45, 24, 13, 30, 40},
                {58, 31, 20, 42, 75},
                {11, 0, 20, 15, 0, 1}
        };
        int[][] valorPorDia = matrizRegular(dias, produtos, matrizDeValor);

        imprimirTabela(dias, produtos, valorPorDia);

    }

    // Função: Regularizar a matriz, que inicialmente possui linhas de tamanhos variados.
    public static int[][] matrizRegular(String[] dias, String[] produtos, int[][] valorPorDia){

        int maiorLinha = produtos.length;

        int maiorColuna = dias.length;

        int[][] matrizRegular = new int[maiorColuna][maiorLinha];

        for(int i = 0; i < valorPorDia.length; i++){

            for(int j = 0; j < valorPorDia[i].length; j++){

                matrizRegular[i][j] = valorPorDia[i][j];
            }
        }

        return matrizRegular;
    }

    // Função: Processar os valores da matriz e retornar a quantidade de vendas por dia.
    public static int[] vendasPorDia (String[] dias, String[] produtos, int[][] valorPorDia){

        int[] soma = new int[dias.length];

        int tamanho = produtos.length;

        int count = 0;

        for(String dia : dias){

            for(int i = 0; i < tamanho; i++) {

                soma[count] += valorPorDia[count][i];
            }
            count++;
        }

        return soma;
    }

    // Função: Processar os valores da matriz e retornar a quantidade de vendas de cada produto.
    public static int[] vendasDeProdutos(String[] dias, String[] produtos, int[][] valorPorDia ){

        int count = 0;

        int tamanho = produtos.length;

        int[] soma = new int[tamanho];

        for (String produto : produtos){

            for(int i = 0; i < dias.length; i++){

                soma[count] += valorPorDia[i][count];
            }
            count++;
        }
        return soma;
    }

    // Função: Juntar as informações dos arrays e da matriz, com as que foram processadas pelos módulos
    // e imprimi-las de forma ordenada.
    public static void imprimirTabela(String[] dias, String[] produtos, int[][] valorPorDia){

        for (int i = 0; i < maiorDia(dias); i++) {
            System.out.print(" ");
        }

        for (String produto : produtos) {
            System.out.print(produto + " ");
        }

        System.out.println();

        int count = 0;
        for (String dia : dias) {

            int tamanhoDia = dia.length();
            System.out.printf("%s  ",dia);

            if( tamanhoDia < maiorDia(dias)){
                for (int i = tamanhoDia; i < maiorDia(dias); i++) {
                    System.out.print(" ");
                }
            }

            for(int i = 0; i < valorPorDia[count].length; i++) {

                System.out.print(valorPorDia[count][i]);

                if(i != produtos.length - 1){
                    for(int j = String.valueOf(valorPorDia[count][i]).length(); j < produtos[i + 1].length() + 1; j++) {
                        System.out.print(" ");
                    }
                }
            }

            System.out.println();

            count++;
        }

        System.out.println();


        int[] vendasPorDia = vendasDeProdutos(dias, produtos, valorPorDia);

        count = 0;

        String total = "Total:";
        int tamanhoDia = total.length();
        System.out.printf("%s ",total);

        if( tamanhoDia < maiorDia(dias)){
            for (int i = tamanhoDia; i < maiorDia(dias); i++) {
                System.out.print(" ");
            }
        }

        count = 0;
        for(int i = 0; i < valorPorDia[count].length; i++) {

            System.out.print(vendasPorDia[i]);

            if(i != produtos.length - 1){
                for(int j = String.valueOf(vendasPorDia[i]).length(); j < produtos[i + 1].length() + 1; j++) {
                    System.out.print(" ");
                }
            }
        }

        System.out.println();

        count = 0;

        System.out.print("\nSão vendidos diariamente em media: \n");
        for(String produto : produtos){

            System.out.print(vendasPorDia[count]/dias.length + " " + produto + "s\n");
            count++;
        }

        System.out.println();

        count = 0;

        int[] vendidosNoDia = vendasPorDia(dias, produtos, valorPorDia);

        System.out.print("Foram vendidos no total : " + Arrays.stream(vendidosNoDia).sum() + " produtos\n");
        for (String dia : dias){

            System.out.print("na " + dia + ": " + vendidosNoDia[count] + " produtos " + "\n");
            count++;
        }

        System.out.println();
    }

    // Função: Descobrir qual o dia com maior nome, para utilizá-lo como referência de espaçamento.
    public static int maiorDia(String[] dias) {
        int maior = 0;
        for(String dia : dias){
            if(maior < dia.length()){
                maior = dia.length();
            }
        }
        return maior;
    }
}