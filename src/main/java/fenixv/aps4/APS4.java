package fenixv.aps4;

import java.io.FileReader;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import com.opencsv.exceptions.CsvValidationException;
import java.io.PrintStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;


// A interface define os métodos que cada classe deve implementar, usando os tipos genéricos A, B e C como parâmetros e R como tipo de retorno.
// A interface Executando é implementado na bliblioteca Map e HashMap que são Dicionário ou Mapa que serve para chamar os metodos correpondente de cada algoritmo.
// O dicionário funciona como chave para acessar o valor.
interface Executando<A, B, C, R> { R executar(A a, B b, C c); }

public class APS4
{
    // É definido dicionário com os parâmentros.
    // Guarda os algoritmos com suas chaves que retorna os nomes dos algoritmos e os parâmentros que devem seguir.
    static Map<Integer, Executando<Integer[][], Integer, Integer[], Integer[][]>> algortimos = new HashMap<>();
    static {
        algortimos.put(1, QuickSort::executar);
        algortimos.put(2, MergeSort::executar);
        algortimos.put(3, HeapSort::executar);
        algortimos.put(4, TimSort::executar);
        algortimos.put(5, InsertionSort::executar);
    }
    
    public static void main(String[] args) throws IOException, CsvValidationException
    {
         // Foi criado o scanner.
        Scanner sc = new Scanner(System.in);
        // Guarda os resultados como  uma forma de matriz[5][15].
        // 5 linhas representam os 5 algoritmos e 15 colunas representam os resultados de cada capacidade de forma organizada.
        Integer[][] todosElementos = new Integer[5][15];
        
        boolean ativo = true;
        
        // Arruma os caracteres especiais.
        executandoUTF();
        
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
                    System.out.print("\nPressione [Enter] para retornar.");
                    sc.nextLine();
                    sc.nextLine();
                    
                    // Limpa a tela.
                    System.out.println("\033[H\033[2J");
                }
                // Mostra os resultados.
                else if (opcao == 6) exibir(sc, todosElementos);
                // Sai do programa
                else if (opcao == 7) ativo = false;
                // Mostra que a opção não existe.
                else System.out.println("\nOpção inválida\n");
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
    
    public static void quantidadeElementos(Scanner sc, int opcao, Integer[][] matriz) throws IOException, CsvValidationException
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
            // Uma variável que será atualizada quando usuário escolher a capaciadade para continuar o programa.
            //  Quando voltar o método, a variável será 0 novamente.
            int capacidade = 0;
            switch (tamanhoCapacidade){
                case 1 -> capacidade = 1000;
                case 2 -> capacidade = 10000;
                case 3 -> capacidade = 100000;
                case 4 -> capacidade = 500000;
                case 5 -> capacidade = 1000000;
                // Volta para o menu.
                case 6 -> {return;}
                default -> System.out.println("\nOpção Inválida\n");
            }
            // Carrega os números do CSV.
            Integer[] vetor = lerCSV(capacidade);
            // Executa o algoritmo escolhido pela chave para acessar o nome do método algoritmo.
            // Executar é definido pela interface no início do código com os parâmetros definidos.
            algortimos.get(opcao).executar(matriz, capacidade, vetor);
        }
        catch(InputMismatchException e){
            System.out.println("\nError: A opção deve ser inteiro!");
            // Limpa o scanner.
            sc.next();
        }
    }

    public static void exibir(Scanner sc, Integer[][] matriz)
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
                    if (matriz[i][opcao] != null) System.out.printf("Tempo: %.3f ms%n", matriz[i][opcao] / 1_000_000.0);
                    else System.out.println("Tempo: Sem valor");
                    System.out.println("Movimentações: " + (matriz[i][opcao + 1] != null ? matriz[i][opcao + 1] : "Sem valor"));
                    System.out.println("Comparações: " + (matriz[i][opcao + 2] != null ? matriz[i][opcao + 2] : "Sem valor") + "\n");
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
    
    public static Integer[] lerCSV(int tamanho) throws IOException, CsvValidationException
    {
        // Lê os números do arquivo CSV na raiz projeto e coloca no vetor com o tamanho escolhido pelo usuário de forma automática.
        CSVReader reader;
        try {reader = new CSVReaderBuilder(new FileReader("numeros.csv")).build();}
        catch (FileNotFoundException ex){
            System.out.println("Conjunto de números não encontrado.");
            System.exit(0);
            return null;
        }
        
        Integer[] arr = new Integer[tamanho];
        String[] numbers = reader.readNext();
        System.out.println("Generated array of size: " + tamanho);
        System.out.println("Size of read array: " + numbers.length);
        for (int i = 0; i < tamanho; i++){
            //System.out.print(numbers[i] + ", ");
            arr[i] = Integer.valueOf(numbers[i]);
        }
        System.out.println("Vetor carregado: " + tamanho);
        return arr;
    }
    // Configura o programa para exibir corretamente caracteres especiais usando UTF-8 de forma manual nas saídas (out) e os erros (err).
    public static void executandoUTF(){
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out), true, StandardCharsets.UTF_8));
        System.setErr(new PrintStream(new FileOutputStream(FileDescriptor.err), true, StandardCharsets.UTF_8));
    }
}