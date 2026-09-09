package fenixv.aps4;

import java.util.Random;
import java.util.Scanner;

public class APS4
{
    public static int tamanho = 10;
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
        
        switch (sc.nextInt())
        {
            case 1:
                int Sucesso[] = QuickSort.sort(numeros);
                for (int i = 0; i < Sucesso.length; i++){
                    System.out.print(Sucesso[i] + " ");
                }
                break;
            
            case 2:
                int result [] = MergeSort.sort(numeros);
                for (int i = 0; i < result.length; i++){
                    System.out.print(result[i] + " ");
                }
                break;
        
            default:
                break;
        }
    }
}