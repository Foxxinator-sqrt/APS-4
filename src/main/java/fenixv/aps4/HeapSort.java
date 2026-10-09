package fenixv.aps4;

// 3º DA ORDEM DE EXECUÇÃO (ID NA MATRIZ: 2)
public class HeapSort
{
    // As variaveis garantem o resultado no final da classe algoritmo.
    static int movimentacoes = 0; // Variável que armazena a quantidade de movimentações decorrer do método que pode deslocar ou trocar de posições.
    static int comparacoes = 0; // Variável que armazena a quantidade de elementos que são comparados durante a ordenação da lista.

    public static int[][] executar(int[][] matriz, int quantidade, int[] vetor)
    {
        movimentacoes = 0;
        comparacoes = 0;
        
        // Iniciando a contagem usando o método nanoTime() em nano segundos.
        long inicio = System.nanoTime();
        // Executando o algoritmo de HeapSort.
        vetor = heapSort(vetor);
        // Finalizando a contagem do tempo de execução.
        long fim = System.nanoTime();

         // Mostra o resultado do vetor completo já modificado em ordem crescente ao final da execução do algoritimo HeapSort.
        if (quantidade < 1001){
            System.out.println();
            for (int n : vetor) {
                System.out.print(n + " ");
            }
        }
        
        // Exibe os resultados obtidos durante a execução do algoritmo.
        // A quantidade de movimentações realizadas e a quantidade de comparações ao total.
        System.out.println();
        // fim - inicio calcula o tempo total de execução todo algoritmo em nanosegundos antes da conversão.
        // A divisão por 1.000.000 converte o resultado de nanosegundos para milissegundos.
        long tempo = (fim - inicio);
        System.out.printf("\nTempo: %.3fms%n", (tempo / 1_000_000.0));
        System.out.println("Movimentações: " + movimentacoes);
        System.out.println("Comparações: " + comparacoes);
        
        // Define a posição exata das informações dos resultados usando a matriz para serem exibidas no menu principal na opção "Tabelas de comparações".
        // Graças ao offset que são definidas as posições das quantidades de elementos que são colunas e linhas representadas pelos algoritmos.
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
        // Retorna a matriz contendo os resultados do algoritmo pelo os números de elementos definidos.
        return matriz;
    }
    
    // Chama a função para cada valor no vetor, e então inverte o vetor no final.
    static int[] heapSort(int arr[]){
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
    
    // Forma a estrutura de pilha dentro do vetor, e compara as duas "crianças" criadas com seu pai,
    // caso uma seja maior que o pai, ela é trocada, e a função é chamada novamente.
    static void heapify(int arr[], int length, int index){
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