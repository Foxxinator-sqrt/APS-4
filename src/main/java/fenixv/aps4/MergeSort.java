package fenixv.aps4;

import java.util.Scanner;


// 2º DA ORDEM DE EXECUÇÃO (ID NA MATRIZ: 1)
public class MergeSort {

    static int movimentacoes = 0;
    static int comparacoes = 0;

    public static Integer[][] executar(Integer[][] matriz, int quantidade){
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
        
        int offset = 0;
        switch (quantidade){
            case 10000 -> offset = 3;
            case 100000 -> offset = 6;
            case 500000 -> offset = 9;
            case 1000000 -> offset = 12;
            default -> {
            }
        }
        matriz[1][offset] = (int)tempo;
        matriz[1][offset + 1] = movimentacoes;
        matriz[1][offset + 2] = comparacoes;
        return matriz;
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