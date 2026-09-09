package fenixv.aps4;

public class QuickSort{
    
    public static int[] sort(int matriz[]) {
        quickSort(matriz, 0, matriz.length - 1);
        return matriz;
    }

    private static void quickSort(int matriz[], int inicio, int fim) {
        if (inicio >= fim) {
            return;
        }

        int pivo = matriz[fim];
        int cont = inicio;

        for (int i = inicio; i < fim; i++) {
            if (matriz[i] <= pivo) {
                int auxiliar = matriz[i];
                matriz[i] = matriz[cont];
                matriz[cont] = auxiliar;
                cont++;
            }
        }

        int auxiliar = matriz[cont];
        matriz[cont] = matriz[fim];
        matriz[fim] = auxiliar;

        quickSort(matriz, inicio, cont - 1);
        quickSort(matriz, cont + 1, fim);
    }
}