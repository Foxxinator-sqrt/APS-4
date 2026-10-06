package fenixv.aps4;

// 5º DA ORDEM DE EXECUÇÃO (ID NA MATRIZ: 4)
public class InsertionSort {
    
    // As variaveis garantem o resultado no final da classe algoritmo.
    static int movimentacoes = 0; // Variável que armazena a quantidade de movimentações decorrer do método que pode deslocar ou trocar de posições.
    static int comparacoes = 0; // Variável que armazena a quantidade de elementos que são comparados durante a ordenação da lista.

    public static Integer[][] executar(Integer[][] matriz, int quantidade, Integer[] vetor) {

        movimentacoes = 0;
        comparacoes = 0;

        // Iniciando a contagem usando o método nanoTime() em nano segundos.
        long inicio = System.nanoTime();
        // Executando o algoritmo de InsertionSort.
        insertionSorf(vetor, quantidade);
        // Finalizando a contagem do tempo de execução.
        long fim = System.nanoTime();

        // Mostra o resultado do vetor completo já modificado em ordem crescente ao final da execução do algoritimo InsertionSort.
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
        // Graças ao offset que são definidas as posições das quantidades de elementos  que são colunas e linhas representadas pelos algoritmos.
        int offset = 0;
        switch (quantidade) {
            case 10000 ->
                offset = 3;
            case 100000 ->
                offset = 6;
            case 500000 ->
                offset = 9;
            case 1000000 ->
                offset = 12;
            default -> {
            }
        }
        matriz[4][offset] = (int) tempo;
        matriz[4][offset + 1] = movimentacoes;
        matriz[4][offset + 2] = comparacoes;
        // Retorna a matriz contendo os resultados do algoritmo pelo os números de elementos definidos.
        return matriz;
    }

    //Metodo insertionSort.
    public static void insertionSorf(Integer[] lista, int quantidade) {

        //"quantidade" e o tamanho da lista definida pelo usuario.
        //Organizando a lista.
        //Iniciando pelo segundo elemento ds lista.
        for (int i = 1; i < quantidade; i++) {

            int elementoAtual = lista[i];

            // Definição da variável J como o valor do primero indice.
            int j = i - 1;

            comparacoes++;
            // Enquanto existirem elementos maiores que o inicial, será passado para uma casa a direita.
            while (j >= 0 && lista[j] > elementoAtual) {

                lista[j + 1] = lista[j];
                movimentacoes++;

                // A posição dele e zerada para passar por todos e checar o maior e seguir passando adiante
                j--;
            }

            // Colocando elemento na posição correta da lista 
            lista[j + 1] = elementoAtual;
            movimentacoes++;
        }
    }
}
