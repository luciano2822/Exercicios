package faculdade.unidade3.modulo3;

import java.util.Arrays;

// declaração da classe Lanchonete
public class Lanchonete{

    // metodo principal, esta armazenando os arrays e ira executar os metodos auxiliares
    public static void main(String[] args){

        // armazenamento dos dias da semana
        String[] dias = { "Segunda-feira", "Terça-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira", "Sabado", "Domingo" };

        // armazenamento dos produtos
        String[] produtos = {"Café", "Suco", "Bolo", "Sanduíche", "Torta", "Cookie"};


        // armazenamento das vendas
        int[][] matrizDeValor = {
                {35, 18, 12, 22, 5, 1},
                {40, 21, 15, 25, 10},
                {32, 20, 17, 0, 16, 19},
                {45, 24, 13, 30, 40},
                {58, 31, 20, 42, 75},
                {11, 0, 20, 15, 0, 1}
        };

        // transforma a matriz irregular numa matriz regular compativel com os produtos e dias
        int[][] valorPorDia = matrizRegular(dias, produtos, matrizDeValor);

        // impressão
        imprimirTabela(dias, produtos, valorPorDia);

    }

    // se for recebida uma matriz irregular o sistema ira transformá-la, numa matriz regular.
    public static int[][] matrizRegular(String[] dias, String[] produtos, int[][] valorPorDia){

        // armazenara a quantidade de produtos
        int maiorLinha = produtos.length;

        // armazenara a quantidade de dias
        int maiorColuna = dias.length;

        // criamos uma matriz regular de acordo com a quantidade de dias e produtos
        int[][] matrizRegular = new int[maiorColuna][maiorLinha];


        // ‘loop’ pelos dias, que formaram as linhas
        for(int i = 0; i < valorPorDia.length; i++){

            // loop pelas colunas de cada produto
            for(int j = 0; j < valorPorDia[i].length; j++){

                // transfirindo o valor das casas ocupadas, para a matriz regular
                matrizRegular[i][j] = valorPorDia[i][j];
            }
        }

        //retorno da matriz
        return matrizRegular;
    }

    // calcula quantas vendas foram realizadas por dia.
    public static int[] vendasPorDia (String[] dias, String[] produtos, int[][] valorPorDia){

        // encontroSincrono.array que armazenara as vendas por dia
        int[] soma = new int[dias.length];

        // quantidade de produtos a serem somados
        int tamanho = produtos.length;


        int count = 0;

        // ‘loop’ entre os dias
        for(String dia : dias){
            // ‘loop’ entre os produtos, para somar as vendas diarias
            for(int i = 0; i < tamanho; i++) {
                // armazenamento na variavel
                soma[count] += valorPorDia[count][i];
            }
            count++;
        }

        //retorno da variavel
        return soma;
    }

    // calcula as vendas de cada produto por semana
    public static int[] vendasDeProdutos(String[] dias, String[] produtos, int[][] valorPorDia ){

        int count = 0;

        // quantidade de produtos
        int tamanho = produtos.length;

        // criação do encontroSincrono.array para reter as somas de vendas de cada produto
        int[] soma = new int[tamanho];

        // loop para somar os valores dos produtos e armazenar no encontroSincrono.array
        for (String produto : produtos){
            for(int i = 0; i < dias.length; i++){
                soma[count] += valorPorDia[i][count];
            }
            count++;
        }
        // retorno do encontroSincrono.array
        return soma;
    }

    // imprime as tabelas na tela
    public static void imprimirTabela(String[] dias, String[] produtos, int[][] valorPorDia){

        // Realiza uma identaçao para começar a tabela
        for (int i = 0; i < maiorDia(dias); i++) {
            System.out.print(" ");
        }

        // Imprimi os produtos na linha 1 da tabela definindo as coluna
        for (String produto : produtos) {
            System.out.print(produto + " ");
        }

        // quebra de linha
        System.out.println();

        // Ira imprimir linha por linha, colocando o dia da semana e em sequência as vendas
        int count = 0;
        for (String dia : dias) {

            // Pega o tamanho do dia atual
            int tamanhoDia = dia.length();
            System.out.printf("%s  ",dia);

            // define a identação dos dias de acordo com o maior dia
            if( tamanhoDia < maiorDia(dias)){
                for (int i = tamanhoDia; i < maiorDia(dias); i++) {
                    System.out.print(" ");
                }
            }

            //Ira imprimir os valores na linha atual, com identação correspondente as colunas
            for(int i = 0; i < valorPorDia[count].length; i++) {

                // imprimi o valor dessa iteração
                System.out.print(valorPorDia[count][i]);

                // imprimi espaçamento correspondendo a coluna
                if(i != produtos.length - 1){
                    for(int j = String.valueOf(valorPorDia[count][i]).length(); j < produtos[i + 1].length() + 1; j++) {
                        System.out.print(" ");
                    }
                }

            }

            // Quebra de linha
            System.out.println();

            count++;
        }

        // Quebra de linha. Fim de uma impressão
        System.out.println();


        // imprimi o total de vendas de cada produto
        // armazena em um encontroSincrono.array o total de vendas diaria de cada produto
        int[] vendasPorDia = vendasDeProdutos(dias, produtos, valorPorDia);

        count = 0;

        // Pega o tamanho da ‘string’ total
        String total = "Total:";
        int tamanhoDia = total.length();
        System.out.printf("%s ",total);

        // define a identação de "total: " de acordo com o maior dia
        if( tamanhoDia < maiorDia(dias)){
            for (int i = tamanhoDia; i < maiorDia(dias); i++) {
                System.out.print(" ");
            }
        }

        //‘loop’ na quantidade de valores, no encontroSincrono.array, para a impressão dos valores individualmente
        count = 0;
        for(int i = 0; i < valorPorDia[count].length; i++) {

            // imprimi o valor dessa iteração
            System.out.print(vendasPorDia[i]);

            // imprimi espaçamento correspondendo a coluna
            if(i != produtos.length - 1){
                for(int j = String.valueOf(vendasPorDia[i]).length(); j < produtos[i + 1].length() + 1; j++) {
                    System.out.print(" ");
                }
            }

        }

        // Quebra de linha. Fim de uma impressão
        System.out.println();

        count = 0;

        // imprimi a média de venda diaria de cada produto.
        System.out.print("\nSão vendidos diariamente em media: \n");
        for(String produto : produtos){
            // imprimi a média de venda diaria de cada produto.
            System.out.print(vendasPorDia[count]/dias.length + " " + produto + "s\n");
            count++;
        }

        //Quebra de linha. Fim de uma impressão
        System.out.println();

        count = 0;

        // armazena em um encontroSincrono.array o total de vendas no dia
        int[] vendidosNoDia = vendasPorDia(dias, produtos, valorPorDia);

        // imprimi a venda total de cada dia
        System.out.print("Foram vendidos no total : " + Arrays.stream(vendidosNoDia).sum() + " produtos\n");
        for (String dia : dias){
            // imprimi para cada dia quantos produtos foram vendios naquele dia
            System.out.print("na " + dia + ": " + vendidosNoDia[count] + " produtos " + "\n");
            count++;
        }

        //Quebra de linha. Fim de uma impressão
        System.out.println();
    }

    //Responsavel por identificar o maior nome dos dias da semana, para determinar identação
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