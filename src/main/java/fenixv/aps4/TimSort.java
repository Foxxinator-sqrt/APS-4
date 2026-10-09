package fenixv.aps4;

// NÃO IMPLEMENTADO
// 4º DA ORDEM DE EXECUÇÃO (ID NA MATRIZ: 3)
public class TimSort {

    static final int RUN = 32;

    // As variaveis garantem o resultado no final da classe algoritmo.
    static int movimentacoes = 0; // Variável que armazena a quantidade de movimentações decorrer do método que pode deslocar ou trocar de posições.
    static int comparacoes = 0; // Variável que armazena a quantidade de elementos que são comparados durante a ordenação da lista.

    public static int[][] executar(int[][] matriz, int quantidade, int[] vetor) {

        movimentacoes = 0;
        comparacoes = 0;
        // Iniciando a contagem usando o método nanoTime() em nano segundos.
        long inicio = System.nanoTime();
        // Executando o algoritmo de TimSort.
        timSort(vetor, vetor.length);

        // Finalizando a contagem do tempo de execução.
        long fim = System.nanoTime();

        // Mostra o resultado do vetor completo já modificado em ordem crescente ao final da execução do algoritimo TimSort.
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
        matriz[3][offset] = (int)tempo;
        matriz[3][offset + 1] = movimentacoes;
        matriz[3][offset + 2] = comparacoes;
        // Retorna a matriz contendo os resultados do algoritmo pelo os números de elementos definidos.
        return matriz;
    }

    public static void insercao(int[] v, int inicio, int fim) {

        for (int i = inicio + 1; i <= fim; i++) {
            int temporario = v[i];
            int j = i - 1;
            while (j >= inicio) {
                comparacoes++;

                if (v[j] <= temporario) {
                    break;
                }
                v[j + 1] = v[j];
                movimentacoes++;
                j--;
            }
            v[j + 1] = temporario;
            movimentacoes++;
        }
    }

    public static void mesclar(int[] v, int inicio, int meio, int fim) {

        int tamanhoEsquerda = meio - inicio + 1;
        int tamanhoDireita = fim - meio;

        Integer[] esquerda = new Integer[tamanhoEsquerda];
        Integer[] direita = new Integer[tamanhoDireita];

        for (int i = 0; i < tamanhoEsquerda; i++) {
            esquerda[i] = v[inicio + i];
        }
        for (int i = 0; i < tamanhoDireita; i++) {
            direita[i] = v[meio + 1 + i];
        }

        int i = 0;
        int j = 0;
        int k = inicio;

        while (i < tamanhoEsquerda && j < tamanhoDireita) {
            comparacoes++;

            if (esquerda[i] <= direita[j]) {
                v[k] = esquerda[i];
                i++;
            } else {
                v[k] = direita[j];
                j++;
            }
            movimentacoes++;
            k++;
        }
        while (i < tamanhoEsquerda) {
            v[k] = esquerda[i];
            i++;
            k++;
            movimentacoes++;
        }
        while (j < tamanhoDireita) {
            v[k] = direita[j];
            j++;
            k++;
            movimentacoes++;
        }
    }

    public static void timSort(int[] v, int tamanho) {

        for (int inicio = 0; inicio < tamanho; inicio += RUN) {
            int fim = Math.min(inicio + RUN - 1, tamanho - 1);
            insercao(v, inicio, fim);
        }

        for (int tamanhoRun = RUN; tamanhoRun < tamanho; tamanhoRun *= 2) {
            for (int inicio = 0; inicio < tamanho; inicio += 2 * tamanhoRun) {
                int meio = inicio + tamanhoRun - 1;
                if (meio >= tamanho - 1) {
                    break;
                }

                int fim = Math.min(inicio + 2 * tamanhoRun - 1, tamanho - 1);
                mesclar(v, inicio, meio, fim);
            }
        }
    }
}
