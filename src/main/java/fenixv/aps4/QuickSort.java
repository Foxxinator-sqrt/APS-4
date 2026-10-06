package fenixv.aps4;

// 1º DA ORDEM DE EXECUÇÃO (ID NA MATRIZ: 0)
public class QuickSort {

    // As variaveis garantem o resultado no final da classe algoritmo.
    static int movimentacoes = 0; // Variável que armazena a quantidade de movimentações decorrer do método que pode deslocar ou trocar de posições.
    static int comparacoes = 0; // Variável que armazena a quantidade de elementos que são comparados durante a ordenação da lista.

    public static Integer[][] executar(Integer[][] matriz, int quantidade, Integer[] vetor) {
        movimentacoes = 0;
        comparacoes = 0;

        // Iniciando a contagem usando o método nanoTime() em nano segundos.
        long inicio = System.nanoTime();
        // Executando o algoritmo de QuickSort.
        quickSort(vetor, 0, vetor.length - 1);
        // Finalizando a contagem do tempo de execução.
        long fim = System.nanoTime();

        // Mostra o resultado do vetor completo já modificado em ordem crescente ao final da execução do algoritimo QuickSoft.
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
        matriz[0][offset] = (int)tempo;
        matriz[0][offset + 1] = movimentacoes;
        matriz[0][offset + 2] = comparacoes;
        // Retorna a matriz contendo os resultados do algoritmo pelo os números de elementos definidos.
        return matriz;
    }

    public static void quickSort(Integer[] vetor, int inicio, int fim)
    {
        // Verifica se o início é maior ou igual ao fim. Se caso for, o método será fechado com return.
        if (inicio >= fim)
            return;

        // Define o último valor no final do vetor como pivô.
        int pivo = vetor[fim];
        // Define a posição inicial para os valores menores.
        int cont = inicio;

        // Percorre todos os valores até antes do pivô usando a estrutura de repetição for.
        for (int i = inicio; i < fim; i++) {
            comparacoes++;
            
            // Verifica se o valor é menor ou igual ao pivô. Se for, o valor será ordenado para esquerda que representa o valor menor do que pivô.
            if (vetor[i] <= pivo) {
                int auxiliar = vetor[i];
                vetor[i] = vetor[cont];
                vetor[cont] = auxiliar;

                movimentacoes++;
                cont++;
            }
        }

        // Coloca o pivô na posição correta.
        int auxiliar = vetor[cont];
        vetor[cont] = vetor[fim];
        vetor[fim] = auxiliar;

        movimentacoes++;

        // Divide o vetor em duas partes menores inicio e meio.
        quickSort(vetor, inicio, cont - 1);
        // Divide e ordena a parte maior meio e fim.
        quickSort(vetor, cont + 1, fim);
    }
}