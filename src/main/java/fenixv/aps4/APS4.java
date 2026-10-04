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

interface Executando<A, B, C, R> { R executar(A a, B b, C c); }

public class APS4
{
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
        Scanner sc = new Scanner(System.in);
        Integer[][] todosElementos = new Integer[5][15];
        
        boolean ativo = true;
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
                int opcao = sc.nextInt();
                if (opcao > 0 && opcao < 6){
                    quantidadeElementos(sc, opcao, todosElementos);
                    System.out.print("\nPressione [Enter] para retornar.");
                    sc.nextLine();
                    sc.nextLine();
                    System.out.println("\033[H\033[2J");
                }
                else if (opcao == 6) exibir(sc, todosElementos);
                else if (opcao == 7) ativo = false;
                else System.out.println("\nOpção inválida\n");
            }
            catch(InputMismatchException e){
                System.out.println("\nError: A opção deve ser inteiro!");
                sc.next();
            }
        }
        
        System.out.println("\nPrograma encerrado!!!\n");
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
            int tamanhoCapacidade = sc.nextInt();
            int capacidade = 0;
            switch (tamanhoCapacidade){
                case 1 -> capacidade = 1000;
                case 2 -> capacidade = 10000;
                case 3 -> capacidade = 100000;
                case 4 -> capacidade = 500000;
                case 5 -> capacidade = 1000000;
                case 6 -> {return;}
                default -> System.out.println("\nOpção Inválida\n");
            }
            Integer[] vetor = lerCSV(capacidade);
            algortimos.get(opcao).executar(matriz, capacidade, vetor);
        }
        catch(InputMismatchException e){
            System.out.println("\nError: A opção deve ser inteiro!");
            sc.next();
        }
    }

    public static void exibir(Scanner sc, Integer[][] matriz)
    {
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
}