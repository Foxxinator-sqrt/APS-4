package fenixv.aps4;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


// 3º DA ORDEM DE EXECUÇÃO (ID NA MATRIZ: 2)
public class HeapSort
{
    public static Integer[][] executar(Integer[][] matriz, int quantidade)
    {
        int movimentacoes = 0;
        int comparacoes = 0;
        
        Integer[] v = {45, 0, 9, 8, 1, 9, 7, 1, -1, 9};

        movimentacoes = 0;
        comparacoes = 0;

        long inicio = System.nanoTime();
        List<Integer> elements = Arrays.asList(v);
        List<Integer> sortedElements = Heap.sort(elements);
        v = sortedElements.toArray(new Integer[v.length]);
        long fim = System.nanoTime();
        long tempo = (fim - inicio);
        
        // Mostra o vetor ordenado.
        System.out.println();
        for (int n : v) {
            System.out.print(n + " ");
        }

        // Mostra as estatisticas da operação
        // INCOMPLETO -> MOVIMENTAÇÕES E COMPARAÇÕES NÃO SÃO ATUALIZADOS
        System.out.println();
        System.out.printf("\nTempo: %.3fms%n", (tempo / 1_000_000.0));
        System.out.println("Movimentações: " + movimentacoes);
        System.out.println("Comparações: " + comparacoes);
        
        int offset = 0;
        switch (quantidade){
            case 10000 -> offset = 3;
            case 100000 -> offset = 6;
            case 500000 -> offset = 9;
            case 1000000 -> offset = 12;
            default -> {
            }
        }
        matriz[2][offset] = (int)tempo;
        matriz[2][offset + 1] = movimentacoes;
        matriz[2][offset + 2] = comparacoes;
        return matriz;
    }
}

class Heap<E extends Comparable<E>>
{
    List<E> elements = new ArrayList<>();
    
    static <E extends Comparable<E>> List<E> sort(Iterable<E> elements){
        Heap<E> heap = of(elements);
        List<E> result = new ArrayList<>();
        while (!heap.isEmpty()){
            result.add(heap.pop());
        }
        return result;
    }
    
    static <E extends Comparable<E>> Heap<E> of(Iterable<E> elements){
        Heap<E> result = new Heap<>();
        for (E element : elements){
            result.add(element);
        }
        return result;
    }
    
    // Adiciona novos elementos no fim da pilha.
    void add(E e){
        elements.add(e);
        int elementIndex = elements.size() - 1;
        while (!isRoot(elementIndex) && !isCorrectChild(elementIndex)){
            int parentIndex = parentIndex(elementIndex);
            swap(elementIndex, parentIndex);
            elementIndex = parentIndex;
        }
    }
    
    E pop(){
        if (isEmpty()){
            throw new IllegalStateException("Can't pop from an empty heap!");
        }
        
        E result = elementAt(0);
        int lastElementIndex = elements.size() - 1;
        swap(0, lastElementIndex);
        elements.remove(lastElementIndex);
        
        int elementIndex = 0;
        while(!isLeaf(elementIndex) && !isCorrectParent(elementIndex)){
            int smallerChildIndex = smallerChildIndex(elementIndex);
            swap(elementIndex, smallerChildIndex);
            elementIndex = smallerChildIndex;
        }
        
        return result;
    }
    
    void swap(int index1, int index2){
        E element1 = elementAt(index1);
        E element2 = elementAt(index2);
        elements.set(index1, element2);
        elements.set(index2, element1);
    }
    
    boolean isEmpty() {return elements.isEmpty();}
    boolean isRoot(int index) {return index == 0;}
    boolean isLeaf(int index) {return !isValidIndex(leftChildIndex(index));}
    boolean isValidIndex(int index) {return index < elements.size();}
    boolean isCorrect(int parentIndex, int childIndex){
        if (!isValidIndex(parentIndex) || !isValidIndex(childIndex)){
            return true;
        }
        return elementAt(parentIndex).compareTo(elementAt(childIndex)) < 0;
    }
    boolean isCorrectChild(int index) {return isCorrect(parentIndex(index), index);}
    boolean isCorrectParent(int index) {return isCorrect(index, leftChildIndex(index)) && isCorrect(index, rightChildIndex(index));}
    
    E elementAt(int index) {return elements.get(index);}
    int parentIndex(int index) {return (index - 1) / 2;}
    int leftChildIndex(int index) {return 2 * index + 1;}
    int rightChildIndex(int index) {return 2 * index + 2;}
    int smallerChildIndex(int index){
        int leftChildIndex = leftChildIndex(index);
        int rightChildIndex = rightChildIndex(index);
        
        if(!isValidIndex(rightChildIndex)){
            return leftChildIndex;
        }
        
        if(elementAt(leftChildIndex).compareTo(elementAt(rightChildIndex)) < 0){
            return leftChildIndex;
        }
        
        return rightChildIndex;
    }
}