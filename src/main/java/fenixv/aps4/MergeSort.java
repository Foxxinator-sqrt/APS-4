package fenixv.aps4;

public class MergeSort
{
    public static int[] sort(int input[]){
        int[] helper = new int[input.length];
        mergeSort(input, helper, 0, input.length - 1);
        return input;
    }
    
    public static void exibir() {
        int[] v = {45, 0, 9, 8, 1, 9, 7, 1, -1, 9};
        int[] w = new int[v.length];
    
        long tempo_inicio = System.nanoTime();
        mergeSort(v, w, 0, v.length - 1);
        long tempo_fim = System.nanoTime();
    
        for (int n : v) {
            System.out.print(n + " ");
        }
    
        System.out.println();
        System.out.println("Tempo: " + (tempo_fim - tempo_inicio) + " ns");
    }

    public static void mergeSort(int[] v, int[] w, int inicio, int fim) {
        if (inicio < fim)
        {
            int meio = (inicio + fim) / 2;

            mergeSort(v, w, inicio, meio);
            mergeSort(v, w, meio + 1, fim);
            
            insert(v, w, inicio, meio, fim);
        }
    }

    public static void insert(int[] v, int[] w, int inicio, int meio, int fim) {
        
        for (int k = inicio; k <= fim; k++) {
            w[k] = v[k];
        }
        
        int i = inicio;
        int j = meio + 1;

        for (int k = inicio; k <= fim; k++) {
            
            if (i > meio) {
                v[k] = w[j++];

            } else if (j > fim) {
                v[k] = w[i++];

            } else if (w[i] <= w[j]) {
                v[k] = w[i++];

            } else {
                v[k] = w[j++];
            }
        }
    }
}