package fenixv.aps4;

// 1º DA ORDEM DE EXECUÇÃO (ID NA MATRIZ: 0)
public class QuickSort {

    static int movimentacoes = 0;
    static int comparacoes = 0;

    public static Integer[][] executar(Integer[][] matriz, int quantidade, Integer[] vetor) {
        movimentacoes = 0;
        comparacoes = 0;

        long inicio = System.nanoTime();
        quickSort(vetor, 0, vetor.length - 1);
        long fim = System.nanoTime();

        /*
        System.out.println();
        for (int n : vetor) {
            System.out.print(n + " ");
        }
        */

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
        matriz[0][offset] = (int)tempo;
        matriz[0][offset + 1] = movimentacoes;
        matriz[0][offset + 2] = comparacoes;
        return matriz;
    }

    public static void quickSort(Integer[] matriz, int inicio, int fim)
    {
        if (inicio >= fim)
            return;

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