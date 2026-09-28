package fenixv.aps4;

import java.util.Scanner;

public class MergeSort {

    static int movimentacoes = 0;
    static int comparacoes = 0;

    public static Integer[][] executar(Integer[][] matriz, Integer[] elementos , int quantidade){
        Scanner sc = new Scanner(System.in);
        Integer[] v = {45, 0, 9, 8, 1, 9, 7, 1, -1, 9};
        int[] w = new int[v.length];

        movimentacoes = 0;
        comparacoes = 0;

        long inicio = System.nanoTime();

        mergeSort(v, w, 0, v.length - 1);

        long fim = System.nanoTime();
        
        System.out.println();
        for (int n : v) {
            System.out.print(n + " ");
        }

        System.out.println();
        long tempo = (fim - inicio);
        System.out.printf("\nTempo: %.3fms%n", (tempo / 1_000_000.0));
        System.out.println("Movimentações: " + movimentacoes);
        System.out.println("Comparações: " + comparacoes);
        
        System.out.print("\nDigite qualquer tecla: ");
        String tecla = sc.nextLine();
        System.out.println("\033[H\033[2J");
        
        elementos[0] = (int)tempo;
        elementos[1] = movimentacoes;
        elementos[2] = comparacoes;
        
        if(quantidade == 1000){
            matriz[1][0] = elementos[0];
            matriz[1][1] = elementos[1];
            matriz[1][2] = elementos[2];
            return matriz;
        }
        else if(quantidade == 10000){
            matriz[1][3] = elementos[0];
            matriz[1][4] = elementos[1];
            matriz[1][5] = elementos[2];
            return matriz;
        }
        else if(quantidade == 100000){
            matriz[1][6] = elementos[0];
            matriz[1][7] = elementos[1];
            matriz[1][8] = elementos[2];
            return matriz;
        }
        else if(quantidade == 500000){
            matriz[1][9] = elementos[0];
            matriz[1][10] = elementos[1];
            matriz[1][11] = elementos[2];
            return matriz;
        }
        else if(quantidade == 1000000){
            matriz[1][12] = elementos[0];
            matriz[1][13] = elementos[1];
            matriz[1][14] = elementos[2];
            return matriz;
        }
        else{
            return matriz;
        }
    }

    public static void mergeSort(Integer[] v, int[] w, int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;

            mergeSort(v, w, inicio, meio);
            mergeSort(v, w, meio + 1, fim);

            insert(v, w, inicio, meio, fim);
        }
    }

    public static void insert(Integer[] v, int[] w, int inicio, int meio, int fim) {

        for (int k = inicio; k <= fim; k++) {
            w[k] = v[k];
        }

        int i = inicio;
        int j = meio + 1;

        for (int k = inicio; k <= fim; k++) {

            if (i > meio) {
                v[k] = w[j++];
                movimentacoes++;

            } else if (j > fim) {
                v[k] = w[i++];
                movimentacoes++;

            } else {
                comparacoes++;

                if (w[i] <= w[j]) {
                    v[k] = w[i++];
                    movimentacoes++;

                } else {
                    v[k] = w[j++];
                    movimentacoes++;
                }
            }
        }
    }
}