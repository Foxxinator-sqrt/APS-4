package fenixv.aps4;


// 3º DA ORDEM DE EXECUÇÃO (ID NA MATRIZ: 2)
public class HeapSort
{
    static int movimentacoes = 0;
    static int comparacoes = 0;

    public static Integer[][] executar(Integer[][] matriz, int quantidade, Integer[] vetor)
    {
        long inicio = System.nanoTime();
        vetor = sort(vetor);
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
        matriz[2][offset] = (int)tempo;
        matriz[2][offset + 1] = movimentacoes;
        matriz[2][offset + 2] = comparacoes;
        return matriz;
    }
    
    static Integer[] sort(Integer arr[]){
        int length = arr.length;
        
        for (int i = length / 2 - 1; i >= 0; i--)
            heapify(arr, length, i);
        
        for (int i = length - 1; i >= 0; i--){
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            movimentacoes++;
            heapify(arr, i, 0);
        }
        
        return arr;
    }
    
    static void heapify(Integer arr[], int length, int index){
        int largest = index;
        int l = 2 * index + 1;
        int r = 2 * index + 2;
        comparacoes += 3;

        if (l < length && arr[l] > arr[largest])
            largest = l;

        if (r < length && arr[r] > arr[largest])
            largest = r;

        if (largest != index){
            int swap = arr[index];
            arr[index] = arr[largest];
            arr[largest] = swap;
            movimentacoes++;
            heapify(arr, length, largest);
        }
    }
}