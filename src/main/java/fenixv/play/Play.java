package fenixv.algoritmos;



import java.io.File;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileNotFoundException;
import fenixv.ui.Menu;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class Play
{
    public static int[] numeros;
    public static int[][] dados;
    
    // Inicializa o vetor numeros, a matriz de dados, e a interface de usuário.
    public static void main(String[] args) throws IOException {
        executandoUTF();
        numeros = lerCSV();
        dados = new int[5][15];
        Menu ui = new Menu();
        ui.init();
    }
    
    // Lê o arquivo "numeros.csv", e armazena todos os seus numeros no vetor numeros[]
    public static int[] lerCSV() throws IOException {
        Scanner reader;
        try {reader = new Scanner(new File("numeros.csv"));}
        catch (FileNotFoundException ex){
            System.out.println("Arquivo não encontrado. Err: " + ex.getMessage());
            System.exit(0);
            return null;
        }
        
        int index = 0;
        reader.useDelimiter(",");
        int[] arr = new int[1000000];
        while (reader.hasNext()){
            arr[index] = reader.nextInt();
            index++;
        }
        return arr;
    }
    
    // Gera um vetor do tamanho especificado, com os numeros lidos do arquivo csv.
    public static int[] gerarVetor(int size){
        int[] arr = new int[size];
        for (int i = 0; i < size; i++){
            arr[i] = numeros[i];
        }
        return arr;
    }
    
    // Configura o programa para exibir corretamente caracteres especiais usando UTF-8 de forma manual nas saídas (out) e os erros (err).
    public static void executandoUTF(){
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out), true, StandardCharsets.UTF_8));
        System.setErr(new PrintStream(new FileOutputStream(FileDescriptor.err), true, StandardCharsets.UTF_8));
    }
}