package fenixv.aps4;

public class QuickSort
{
    public static int[] sort(int matriz[])
    {
        int pivo = 0; // Define o indice incial do pivo.
        int matrizCentral[] = new int [matriz.length];// matriz com o indice 
        int matrizAuxilio[] = new int [matriz.length];// matriz de cola
        
        for (int k = 0; k < matriz.length; k++)
        {
            int cont = 0; 
            for (int i = 0; i < matriz.length; i++){// pula o pivo
                if (matrizCentral[i] != 0){
                   i++;
                }else{
                    pivo = i;
                }
            } 

            for (int i = 0; i < matriz.length; i++){ // menor que
                if (matriz[i] < matriz[pivo]){
                    matrizAuxilio[cont] = matriz[i];
                    cont++;
                }
            }

            for (int i = 0; i < matriz.length; i++){ // Indice central
                if (matriz[i] == matriz[pivo]){
                    matrizAuxilio[cont] = matriz[pivo];// Lugar do pivo
                    matrizCentral[cont] = cont+1;
                    cont++;
                }
            }

            for (int i = 0; i < matriz.length; i++){ // maior que
                if (matriz[i] > matriz[pivo]){
                    matrizAuxilio[cont] = matriz[i];
                    cont++;
                }
            }

            for (int i = 0; i < matriz.length; i++){// cola na matriz central
                matriz[i] = matrizAuxilio[i];
            }

        }
        return matrizAuxilio;
    }
}