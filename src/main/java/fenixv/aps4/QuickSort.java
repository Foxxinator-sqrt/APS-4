package fenixv.aps4;

import java.util.Scanner;

public class QuickSort {

    static int movimentacoes = 0;
    static int comparacoes = 0;

    public static Integer[][] executar(Integer[][] matriz, Integer[] elementos, int quantidade) {
        Scanner sc = new Scanner(System.in);

        Integer[] v = {45, 0, 9, 8, 1, 9, 7, 1, -1, 9};

        movimentacoes = 0;
        comparacoes = 0;

        long inicio = System.nanoTime();

        quickSort(v, 0, v.length - 1);

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

        elementos[0] = (int) tempo;
        elementos[1] = movimentacoes;
        elementos[2] = comparacoes;

        if (quantidade == 1000) {
            matriz[0][0] = elementos[0];
            matriz[0][1] = elementos[1];
            matriz[0][2] = elementos[2];
            return matriz;
        }
        else if (quantidade == 10000) {
            matriz[0][3] = elementos[0];
            matriz[0][4] = elementos[1];
            matriz[0][5] = elementos[2];
            return matriz;
        }
        else if (quantidade == 100000) {
            matriz[0][6] = elementos[0];
            matriz[0][7] = elementos[1];
            matriz[0][8] = elementos[2];
            return matriz;
        }
        else if (quantidade == 500000) {
            matriz[0][9] = elementos[0];
            matriz[0][10] = elementos[1];
            matriz[0][11] = elementos[2];
            return matriz;
        }
        else if (quantidade == 1000000) {
            matriz[0][12] = elementos[0];
            matriz[0][13] = elementos[1];
            matriz[0][14] = elementos[2];
            return matriz;
        }
        else {
            return matriz;
        }
    }

    public static void quickSort(Integer[] matriz, int inicio, int fim) {

        if (inicio >= fim) {
            return;
        }

        int pivo = matriz[fim];
        int cont = inicio;

        for (int i = inicio; i < fim; i++) {

            comparacoes++;

            if (matriz[i] <= pivo) {
                int auxiliar = matriz[i];
                matriz[i] = matriz[cont];
                matriz[cont] = auxiliar;

                movimentacoes++;

                cont++;
            }
        }

        int auxiliar = matriz[cont];
        matriz[cont] = matriz[fim];
        matriz[fim] = auxiliar;

        movimentacoes++;

        quickSort(matriz, inicio, cont - 1);
        quickSort(matriz, cont + 1, fim);
    }
}