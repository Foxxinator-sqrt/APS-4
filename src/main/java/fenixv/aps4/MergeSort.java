package fenixv.aps4;

// 2º DA ORDEM DE EXECUÇÃO (ID NA MATRIZ: 1)
public class MergeSort {

    // As variaveis garantem o resultado no final da classe algoritmo.
    static int movimentacoes = 0; // Variável que armazena a quantidade de movimentações decorrer do método que pode deslocar ou trocar de posições.
    static int comparacoes = 0; // Variável que armazena a quantidade de elementos que são comparados durante a ordenação da lista.

    public static Integer[][] executar(Integer[][] matriz, int quantidade, Integer[] vetor)
    {
        int[] listaInicial = new int[vetor.length]; // Um novo objeto é instanciado com tamanho exato de elementos dentro da Lista Inicial (vetor).

        movimentacoes = 0;
        comparacoes = 0;

         // Iniciando a contagem usando o método nanoTime() em nano segundos.
        long inicio = System.nanoTime();
        // Executando o algoritmo de MergeSort.
        mergeSort(vetor,  listaInicial, 0, vetor.length - 1);
        // Finalizando a contagem do tempo de execução.
        long fim = System.nanoTime();
        
        // Mostra o resultado do vetor completo já modificado em ordem crescente ao final da execução do algoritimo MergeSoft.
        
        /*
        System.out.println();
        for(int n : vetor){
            System.out.print(n + " ");
        }
        */
        

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
        matriz[1][offset] = (int)tempo;
        matriz[1][offset + 1] = movimentacoes;
        matriz[1][offset + 2] = comparacoes;
        // Retorna a matriz contendo os resultados do algoritmo pelo os números de elementos definidos.
        return matriz;
    }

    //Metodo MergeSort.
    public static void mergeSort(Integer[] vetor, int[] listaInicial, int inicio, int fim){
        // Verifica se o início é menor do que o fim para dividir.
        if (inicio < fim) {
            // Calcula o meio entre o início e o fim.
            int meio = (inicio + fim) / 2;

            // Ordena a primeira metade início até o meio.
            mergeSort(vetor, listaInicial, inicio, meio);
            
            // Ordena a segunda metade meio até o fim..
            mergeSort(vetor, listaInicial, meio + 1, fim);

            // Junta as duas metades.
            insert(vetor, listaInicial, inicio, meio, fim);
        }
    }

    public static void insert(Integer[] vetor, int[] listaInicial, int inicio, int meio, int fim){

        // Copia os valores de vetor para Lista Inicial.
        for(int k = inicio; k <= fim; k++){
            listaInicial[k] = vetor[k];
        }

        // Define i como o início da primeira metade.
        int i = inicio;
        // Define j como o início da segunda metade.
        int j = meio + 1;

        // Percorre os valores do início até o fim para ordena-las na ordem crescente.
        for(int k = inicio; k <= fim; k++){

            // Verifica se a primeira metade acabou.
            if(i > meio){
                vetor[k] = listaInicial[j++];
                movimentacoes++;

            }
            // Verifica se a segunda metade acabou.
            else if (j > fim){
                vetor[k] = listaInicial[i++];
                movimentacoes++;

            }
            // Caso contrario. vai comparar os valores.
            else{
                comparacoes++;

                // Verifica se o índice i é menor ou igual índice j.
                if(listaInicial[i] <= listaInicial[j]){
                    vetor[k] = listaInicial[i++];
                    movimentacoes++;

                }
                // Se o índice j for menor, coloca ele no vetor.
                else{
                    vetor[k] = listaInicial[j++];
                    movimentacoes++;
                }
            }
        }
    }
}