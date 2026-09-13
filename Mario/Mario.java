/*
* Programa para imprimir pirâmides no estilo do jogo Mario
* utilizado para exercitar os conceitos de ‘loops’ aninhados,
* modularização e validação de input
* */

import java.util.Scanner;


public class Mario {
    public static void main(String[] args){

        System.out.println("Escolha o tamanho da pirâmide, podendo ser entre 1 a 20!");

        int tamanho = validacao();

        impressao(tamanho);

    }

    // Função: Validar a entrada do usuário, para que o mesmo só possa inserir números entre 1 e 20.
    public static int validacao(){
        Scanner ler = new Scanner(System.in);
        int tamanho;

        while(true){
            if(ler.hasNextInt()){
                tamanho =  ler.nextInt();
                if(tamanho < 1 || tamanho > 20){
                    System.out.println("O tamanho deve estar entre 1 a 20, insira outro valor!");
                }else{
                    break;
                }
            }
            else {
                System.out.println("Entrada inválida, insira um número entre 1 e 20!");
                ler.next();
            }
        }
        return tamanho;
    }

    // Função: Impressão da pirâmide utilizando loops aninhados para a formação da mesma.
    public static void impressao(int tamanho){
        System.out.println("Sua pirâmide de tamanho: " + tamanho);
        for(int i = 0 ; i < tamanho; i++){
            for(int j = 0; j < tamanho - i - 1; j++){
                System.out.print(" ");
            }
            for(int j = 0; j < i + 1; j++){
                System.out.print("#");
            }
            System.out.print("  ");
            for(int j = 0; j < i + 1; j++){
                System.out.print("#");
            }
            System.out.println();
        }
    }
}
