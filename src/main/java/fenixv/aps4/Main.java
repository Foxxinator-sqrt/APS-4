package fenixv.aps4;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

interface Executando<A, B, C, R> {
    R executar(A a, B b, C c);
}

public class Main {
    
    static Map <Integer, Executando<Integer[][], Integer[], Integer, Integer[][]>> algortimos = new HashMap<>();
    
    static {
        algortimos.put(1, QuickSort::executar);
        algortimos.put(2, MergeSort::executar);
        algortimos.put(3, HeapSort::executar);
        algortimos.put(4, TimSort::executar);
        algortimos.put(5, InsertionSort::executar);
    }
        
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer[] elementos = new Integer[3];
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
            try{
                int opcao = sc.nextInt();
            
                switch (opcao){
                    default -> {
                        System.out.println("\nOpção inválida\n");
                        break;
                    }
                    
                    case 1 -> {
                        quantidadeElementos(sc, elementos, opcao, todosElementos);
                        break;
                    }
                    case 2 -> {
                        quantidadeElementos(sc, elementos, opcao, todosElementos);
                        break;
                    }
                    case 3 -> {
                        quantidadeElementos(sc, elementos, opcao, todosElementos);
                        break;
                    }
                    case 4 -> {
                        quantidadeElementos(sc, elementos, opcao, todosElementos);
                        break;
                    }
                    case 5 -> {
                        quantidadeElementos(sc, elementos, opcao, todosElementos);
                        break;
                    }
                    case 6 -> {
                        exibir(sc, todosElementos);
                        break;
                    }
                    case 7 -> {
                        ativo = false;
                        break;
                    }
                }
            }
            catch(InputMismatchException e){
                System.out.println("\nError: A opção deve ser inteiro!");
                sc.next();
            }
        }
        
        System.out.println("\nPrograma encerrado!!!\n");
        sc.close();
    }
    
    public static Integer[][] quantidadeElementos(Scanner sc, Integer[] elementos, int opcao, Integer[][] matriz){
        
        System.out.println("\nEscolha a capacidade\n");
        System.out.println(" [1] - 1.000 elementos");
        System.out.println(" [2] - 10.000 elementos");
        System.out.println(" [3] - 100.000 elementos");
        System.out.println(" [4] - 500.000 elementos");
        System.out.println(" [5] - 1.000.000 elementos");
        System.out.println(" [6] - Voltar");
        System.out.print("\nEscolha: ");
        try{
            int tamanhoCapacidade = sc.nextInt();
            int capacidade = 0;
            switch (tamanhoCapacidade){
                default -> {
                    System.out.println("\nOpção Inválida\n");
                    return matriz;
                }
                case 1 -> {
                    capacidade = 1000;
                    break;
                }
                case 2 -> {
                    capacidade = 10000;
                    break;
                }
                case 3 -> {
                    capacidade = 100000;
                    break;
                }
                case 4 -> {
                    capacidade = 500000;
                    break;
                }
                case 5 -> {
                    capacidade = 1000000;
                    break;
                }
                case 6 -> {
                    return matriz;
                }
            }
            return matriz = algortimos.get(opcao).executar(matriz, elementos, capacidade);
        }
        catch(InputMismatchException e){
            System.out.println("\nError: A opção deve ser inteiro!");
            sc.next();
        }
        return null;
    }

    public static void exibir(Scanner sc, Integer[][] matriz){
        
        do{
            System.out.println("\nEscolha o tamanho para visualizar todos os algoritmos\n");
            System.out.println(" [1] - 1.000 elementos");
            System.out.println(" [2] - 10.000 elementos");
            System.out.println(" [3] - 100.000 elementos");
            System.out.println(" [4] - 500.000 elementos");
            System.out.println(" [5] - 1.000.000 elementos");
            System.out.println(" [6] - Voltar");
            System.out.print("\nEscolha: ");
            
            try{
                int opcao = sc.nextInt();
                String exibirTamanho = "";
                switch (opcao){
                    default -> {
                        System.out.println("\nOpção inválida\n");
                        break;
                    }
                    case 1 -> {
                        exibirTamanho = "1.000";
                        opcao = 0;
                        break;
                    }
                    case 2 -> {
                        exibirTamanho = "10.000";
                        opcao = 3;
                        break;
                    }
                    case 3 -> {
                        exibirTamanho = "100.000";
                        opcao = 6;
                        break;
                    }
                    case 4 -> {
                        exibirTamanho = "500.000";
                        opcao = 9;
                        break;
                    }
                    case 5 -> {
                        exibirTamanho = "1.000.000";
                        opcao = 12;
                        break;
                    }
                    case 6 -> {
                        return;
                    }
                }
                System.out.println("\n---------------Tabelas--------------\n");
                System.out.println("         " + exibirTamanho + " elementos\n");

                System.out.println("--------------QuickSort-------------\n");

                if (matriz[0][opcao] != null) {
                    System.out.printf("Tempo: %.3f ms%n", matriz[0][opcao] / 1_000_000.0);
                } else {
                    System.out.println("Tempo: Sem valor");
                }
                
                System.out.println("Movimentações: " + (matriz[0][opcao + 1] != null ? matriz[0][opcao + 1] : "Sem valor"));
                System.out.println("Comparações: " + (matriz[0][opcao + 2] != null ? matriz[0][opcao + 2] : "Sem valor") + "\n");
                
                
                System.out.println("--------------MergeSort-------------\n");
                
                if (matriz[1][opcao] != null) {
                    System.out.printf("Tempo: %.3f ms%n", matriz[1][opcao] / 1_000_000.0);
                }else {
                    System.out.println("Tempo: Sem valor");
                }
                System.out.println("Movimentações: " + (matriz[1][opcao + 1] != null ? matriz[1][opcao + 1] : "Sem valor"));
                System.out.println("Comparações: " + (matriz[1][opcao + 2] != null ? matriz[1][opcao + 2] : "Sem valor") + "\n");
                
                
                System.out.println("--------------HeapSort--------------\n");
                
                if (matriz[2][opcao] != null) {
                    System.out.printf("Tempo: %.3f ms%n", matriz[2][opcao] / 1_000_000.0);
                }else {
                    System.out.println("Tempo: Sem valor");
                }
                System.out.println("Movimentações: " + (matriz[2][opcao + 1] != null ? matriz[2][opcao + 1] : "Sem valor"));
                System.out.println("Comparações: " + (matriz[2][opcao + 2] != null ? matriz[2][opcao + 2] : "Sem valor") + "\n");
                
                
                System.out.println("--------------TimSort--------------\n");
                
                if (matriz[3][opcao] != null) {
                    System.out.printf("Tempo: %.3f ms%n", matriz[3][opcao] / 1_000_000.0);
                }else {
                    System.out.println("Tempo: Sem valor");
                }
                System.out.println("Movimentações: " + (matriz[3][opcao + 1] != null ? matriz[3][opcao + 1] : "Sem valor"));
                System.out.println("Comparações: " + (matriz[3][opcao + 2] != null ? matriz[3][opcao + 2] : "Sem valor") + "\n");
                
                
                System.out.println("-------------InsertionSort----------\n");
                
                if (matriz[4][opcao] != null) {
                    System.out.printf("Tempo: %.3f ms%n", matriz[4][opcao] / 1_000_000.0);
                }else {
                    System.out.println("Tempo: Sem valor");
                }
                System.out.println("Movimentações: " + (matriz[4][opcao + 1] != null ? matriz[4][opcao + 1] : "Sem valor"));
                System.out.println("Comparações: " + (matriz[4][opcao + 2] != null ? matriz[4][opcao + 2] : "Sem valor") + "\n");
                
                System.out.println("------------------------------------\n");
            }
            catch(InputMismatchException e){
                System.out.println("\nError: A opção deve ser inteiro!");
                sc.next();
            }
            
        }
        while(true);
    }
}