package fenixv.aps4;

import java.util.Random;
import java.util.Scanner;

public class APS4
{
    public static int tamanho = 20;
    public static int Aleatoriedade = 100;

    public static void main(String[] args)
    {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        
        int[] numeros = new int[tamanho];
        for (int i = 0; i < tamanho; i++){
            numeros[i] = rand.nextInt(Aleatoriedade);
            System.out.print(numeros[i] + " ");
        }
        
        System.out.println(" (Tamanho: " + tamanho + ")\n");
        System.out.println("1 - QuickSort\n2 - MergeSort\n");
        System.out.print("Escolha o Algoritmo: ");
        
        int input = sc.nextInt();
        boolean success = false;
        int result[] = new int[tamanho];
        long start_time = System.nanoTime();
        switch(input)
        {
            case 1:
                result = QuickSort.sort(numeros);
                success = true;
                break;
            
            case 2:
                result = MergeSort.sort(numeros);
                success = true;
                break;
        
            default:
                break;
        }
        
        long end_time = System.nanoTime();
        if (success){
            for (int i = 0; i < result.length; i++){
                System.out.print(result[i] + " ");
            }
            long elapsed = (end_time - start_time);
            System.out.println("\nTempo da operação: " + elapsed + "ns (" + elapsed * 0.000001 + "ms)");
        }
        else System.out.println("Erro.");
    }
}