package fenixv.aps4;

import java.util.Scanner;
import java.io.FileReader;
import java.io.PrintStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.InputMismatchException;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

public class APS4
{
    static int[] numeros;
    
    public static void main(String[] args) throws IOException, CsvValidationException
    {
        // Foi criado o scanner.
        Scanner sc = new Scanner(System.in);
        // Guarda os resultados como uma forma de matriz[5][15].
        // 5 linhas representam os 5 algoritmos e 15 colunas representam os resultados de cada capacidade de forma organizada.
        int[][] todosElementos = new int[5][15];
        numeros = lerCSV();
        
        boolean ativo = true;
        executandoUTF();  // Arruma os caracteres especiais.
        
        while(ativo){
            System.out.println("-------------Algoritmos------------");
            System.out.println("\n [1] - QuickSort");
            System.out.println(" [2] - MergeSort");
            System.out.println(" [3] - HeapSort");
            System.out.println(" [4] - TimSort");
            System.out.println(" [5] - InsertionSort");
            System.out.println(" [6] - Tabelas de Comparações");
            System.out.println(" [7] - Sair");
            System.out.print("\nEscolha: ");
            
            try {
                // Pega a opção digitada.
                int opcao = sc.nextInt();
                
                // Verifica se escolheu um algoritmo de forma válida.
                if (opcao > 0 && opcao < 6){
                    quantidadeElementos(sc, opcao, todosElementos);
                    sc.nextLine();
                    System.out.println("\033[H\033[2J");  // Limpa a tela.
                }
                else if (opcao == 6) exibir(sc, todosElementos);  // Mostra os resultados.
                else if (opcao == 7) ativo = false;  // Sai do programa
                else System.out.println("\nOpção inválida\n");  // Mostra que a opção não existe.
            }
            catch(InputMismatchException e){
                System.out.println("\nError: A opção deve ser inteiro!");
                // Limpa o scanner.
                sc.next();
            }
        }
        
        System.out.println("\nPrograma encerrado!!!\n");
        // Fecha o Scanner.
        sc.close();
    }
    
    public static void quantidadeElementos(Scanner sc, int opcao, int[][] matriz) throws IOException, CsvValidationException
    {
        System.out.println("\nEscolha a capacidade\n");
        System.out.println(" [1] - 1.000 elementos");
        System.out.println(" [2] - 10.000 elementos");
        System.out.println(" [3] - 100.000 elementos");
        System.out.println(" [4] - 500.000 elementos");
        System.out.println(" [5] - 1.000.000 elementos");
        System.out.println(" [6] - Voltar");
        System.out.print("\nEscolha: ");
        
        try {
            // Pega o tamanho escolhido pelo usuário.
            int tamanhoCapacidade = sc.nextInt();
            // Uma variável que será atualizada quando usuário escolher a capacidade para continuar o programa.
            // Quando voltar o método, a variável será 0 novamente.
            int capacidade = 0;
            switch (tamanhoCapacidade){
                case 1 -> capacidade = 1000;
                case 2 -> capacidade = 10000;
                case 3 -> capacidade = 100000;
                case 4 -> capacidade = 500000;
                case 5 -> capacidade = 1000000;
                case 6 -> {return;}  // Volta para o menu.
                default -> System.out.println("\nOpção Inválida\n");
            }
            // Carrega os números do CSV.
            int[] vetor = new int[capacidade];
            for (int i = 0; i < capacidade; i++){
                vetor[i] = numeros[i];
            }
            
            // Executa o algoritmo escolhido pela chave para acessar o nome do método algoritmo.
            switch (opcao){
                case 1 -> QuickSort.executar(matriz, capacidade, vetor);
                case 2 -> MergeSort.executar(matriz, capacidade, vetor);
                case 3 -> HeapSort.executar(matriz, capacidade, vetor);
                case 4 -> TimSort.executar(matriz, capacidade, vetor);
                case 5 -> InsertionSort.executar(matriz, capacidade, vetor);
            }
            System.out.print("\nPressione [Enter] para retornar.");
            sc.nextLine();
        }
        catch(InputMismatchException e){
            System.out.println("\nError: A opção deve ser inteiro!");
            // Limpa o scanner.
            sc.next();
        }
    }

    public static void exibir(Scanner sc, int[][] matriz)
    {
        // Mostra os resultados dos algoritmos organizados em matriz.
        do {
            System.out.println("\nEscolha o tamanho para visualizar todos os algoritmos\n");
            System.out.println(" [1] - 1.000 elementos");
            System.out.println(" [2] - 10.000 elementos");
            System.out.println(" [3] - 100.000 elementos");
            System.out.println(" [4] - 500.000 elementos");
            System.out.println(" [5] - 1.000.000 elementos");
            System.out.println(" [6] - Voltar");
            System.out.print("\nEscolha: ");
            
            try {
                int opcao = sc.nextInt();
                String exibirTamanho = "";
                switch (opcao){
                    case 1 -> exibirTamanho = "1.000";
                    case 2 -> exibirTamanho = "10.000";
                    case 3 -> exibirTamanho = "100.000";
                    case 4 -> exibirTamanho = "500.000";
                    case 5 -> exibirTamanho = "1.000.000";
                    case 6 -> {return;}
                    default -> {
                        System.out.println("\nOpção inválida\n");
                        return;
                    }
                }
                opcao = 3 * (opcao - 1);
                
                System.out.println("\n---------------Tabelas--------------\n");
                System.out.println("         " + exibirTamanho + " elementos\n");
                for (int i = 0; i < 5; i++){
                    switch(i){
                        case 0: System.out.println("--------------QuickSort-------------\n"); break;
                        case 1: System.out.println("--------------MergeSort-------------\n"); break;
                        case 2: System.out.println("--------------HeapSort-------------\n"); break;
                        case 3: System.out.println("--------------TimSort-------------\n"); break;
                        case 4: System.out.println("--------------InsertionSort-------------\n"); break;
                    }
                    // Mostra os resultados se tiver algum valor. Caso contrário, será exibido "sem valor".
                    if (matriz[i][opcao] != 0) System.out.printf("Tempo: %.3f ms%n", matriz[i][opcao] / 1_000_000.0);
                    else System.out.println("Tempo: Sem valor");
                    System.out.println("Movimentações: " + (matriz[i][opcao + 1] != 0 ? matriz[i][opcao + 1] : "Sem valor"));
                    System.out.println("Comparações: " + (matriz[i][opcao + 2] != 0 ? matriz[i][opcao + 2] : "Sem valor") + "\n");
                }
                System.out.println("------------------------------------\n");
            }
            catch(InputMismatchException e){
                System.out.println("\nError: A opção deve ser inteiro!");
                sc.next();
            }
        }
        while(true);
    }
    
    public static int[] lerCSV() throws IOException, CsvValidationException
    {
        // Lê os números do arquivo CSV na raiz do projeto e coloca no vetor com o tamanho escolhido pelo usuário de forma automática.
        CSVReader reader;
        try {reader = new CSVReaderBuilder(new FileReader("numeros.csv")).build();}
        catch (FileNotFoundException ex){
            System.out.println("Conjunto de números não encontrado.");
            System.exit(0);
            return null;
        }
        
        int[] arr = new int[1000000];
        String[] numbers = reader.readNext();
        for (int i = 0; i < 1000000; i++){
            arr[i] = Integer.valueOf(numbers[i]);
        }
        return arr;
    }
    
    // Configura o programa para exibir corretamente caracteres especiais usando UTF-8 de forma manual nas saídas (out) e os erros (err).
    public static void executandoUTF(){
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out), true, StandardCharsets.UTF_8));
        System.setErr(new PrintStream(new FileOutputStream(FileDescriptor.err), true, StandardCharsets.UTF_8));
    }
}