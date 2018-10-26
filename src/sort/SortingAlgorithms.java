package sort;

import java.util.Arrays;

public class SortingAlgorithms {

    /**
     * -------------------------------------------------------------------------------
     * Algoritmo    Operaciones m�ximas
     * -------------------------------------------------------------------------------
     * Burbuja      O(n2) 
     * Inserci�n    O(n2/4) 
     * Selecci�n    O(n2) 
     * Shell        O(n log2n) 
     * Merge        O(n logn) 
     * Quick        O(n2) en peor de los casos y O(n logn) en el promedio de los casos.
     */
    public static void main(String[] args) {
        int [] arr = {55,128,36,45,12,97,258,37};
        
//        bubbleSort(arr);
        insertionSort(arr);
//        shellSort(arr);
//        mergeSort(arr,0,arr.length);
//        quickSort(arr, 0, arr.length-1); // va mal??
                
        System.out.println(Arrays.toString(arr));
    }

    /*
     * La Ordenaci�n de burbuja (Bubble Sort en ingl�s) es un sencillo algoritmo de ordenamiento. 
     * Funciona revisando cada elemento de la lista que va a ser ordenada con el siguiente, 
     * intercambi�ndolos de posici�n si est�n en el orden equivocado. Es necesario revisar varias 
     * veces toda la lista hasta que no se necesiten m�s intercambios, lo cual significa que la 
     * lista est� ordenada. Este algoritmo obtiene su nombre de la forma con la que suben por la 
     * lista los elementos durante los intercambios, como si fueran peque�as "burbujas". Tambi�n es 
     * conocido como el m�todo del intercambio directo. Dado que solo usa comparaciones para operar 
     * elementos, se lo considera un algoritmo de comparaci�n, siendo uno de los m�s sencillos de 
     * implementar.
     */
    public static void bubbleSort(int[] vector) {
        int aux;
        for (int i = 2; i < vector.length; i++) {
            for (int j = 0; j < vector.length - 1; j++) {
                if (vector[j] > vector[j + 1]) {
                    aux = vector[j];
                    vector[j] = vector[j + 1];
                    vector[j + 1] = aux;
                }
            }
//            System.out.println(Arrays.toString(vector));
        }
    }

    /*
     * El ordenamiento por inserci�n (insertion sort en ingl�s) es una manera muy natural de ordenar 
     * para un ser humano, y puede usarse f�cilmente para ordenar un mazo de cartas numeradas en 
     * forma arbitraria. Requiere O(n�) operaciones para ordenar una lista de n elementos.
     * Inicialmente se tiene un solo elemento, que obviamente es un conjunto ordenado. Despu�s, 
     * cuando hay k elementos ordenados de menor a mayor, se toma el elemento k+1 y se compara con 
     * todos los elementos ya ordenados, deteni�ndose cuando se encuentra un elemento menor (todos 
     * los elementos mayores han sido desplazados una posici�n a la derecha) o cuando ya no se 
     * encuentran elementos (todos los elementos fueron desplazados y este es el m�s peque�o). 
     * En este punto se inserta el elemento k+1 debiendo desplazarse los dem�s elementos.
     */
    public static void insertionSort (int[] vector) {
        for (int i=1; i < vector.length; i++) {
            int aux = vector[i];
            int j;
            for (j=i-1; j >=0 && vector[j] > aux; j--){
                vector[j+1] = vector[j];
            }
            vector[j+1] = aux;
//            System.out.println(Arrays.toString(vector));
        }
     }

    /*
     * Su implementaci�n original, requiere O(n2) comparaciones e intercambios en el peor caso. 
     * Un cambio menor presentado en el libro de V. Pratt produce una implementaci�n con un 
     * rendimiento de O(n log2 n) en el peor caso. Esto es mejor que las O(n2) comparaciones 
     * requeridas por algoritmos simples pero peor que el �ptimo O(n log n). Aunque es f�cil 
     * desarrollar un sentido intuitivo de c�mo funciona este algoritmo, es muy dif�cil analizar 
     * su tiempo de ejecuci�n.

     * El Shell sort es una generalizaci�n del ordenamiento por inserci�n, teniendo en cuenta dos 
     * observaciones:
     *    - El ordenamiento por inserci�n es eficiente si la entrada est� "casi ordenada".
     *    - El ordenamiento por inserci�n es ineficiente, en general, porque mueve los valores s�lo 
     *      una posici�n cada vez.
     * 
     * El algoritmo Shell sort mejora el ordenamiento por inserci�n comparando elementos separados 
     * por un espacio de varias posiciones. Esto permite que un elemento haga "pasos m�s grandes" 
     * hacia su posici�n esperada. Los pasos m�ltiples sobre los datos se hacen con tama�os de 
     * espacio cada vez m�s peque�os. El �ltimo paso del Shell sort es un simple ordenamiento por 
     * inserci�n, pero para entonces, ya est� garantizado que los datos del vector est�n casi ordenados.
     */
    public static void shellSort(int[] matrix) {
        for (int increment = matrix.length / 2;increment > 0;increment = (increment == 2 ? 1 : (int) Math.round(increment / 2.2))) {
            for (int i = increment; i < matrix.length; i++) {
                for (int j = i; j >= increment && matrix[j - increment] > matrix[j]; j -= increment) {
                    int temp = matrix[j];
                    matrix[j] = matrix[j - increment];
                    matrix[j - increment] = temp;
                }
            }
        }
    }

    /*
     * El ordenamiento por mezcla es un algoritmo recursivo que divide continuamente una lista por 
     * la mitad. Si la lista est� vac�a o tiene un solo �tem, se ordena por definici�n (el caso base). 
     * Si la lista tiene m�s de un �tem, dividimos la lista e invocamos recursivamente un ordenamiento 
     * por mezcla para ambas mitades. Una vez que las dos mitades est�n ordenadas, se realiza la 
     * operaci�n fundamental, denominada mezcla. La mezcla es el proceso de tomar dos listas ordenadas 
     * m�s peque�as y combinarlas en una sola lista nueva y ordenada.
     */
    // The left and right are indexes into the array to be sorted for the current 
    // invocation of the mergeSort call.
    public static void mergeSort(int[] matrix, int init, int n) {
        int n1;
        int n2;
        if (n > 1) {
            n1 = n / 2;
            n2 = n - n1;
            mergeSort(matrix, init, n1);
            mergeSort(matrix, init + n1, n2);
            merge(matrix, init, n1, n2);
        }
    }

    private static void merge(int[] matrix, int init, int n1, int n2) {
        int[] buffer = new int[n1 + n2];
        int temp = 0;
        int temp1 = 0;
        int temp2 = 0;
        int i;
        while ((temp1 < n1) && (temp2 < n2)) {
            if (matrix[init + temp1] < matrix[init + n1 + temp2]) {
                buffer[temp++] = matrix[init + (temp1++)];
            } else {
                buffer[temp++] = matrix[init + n1 + (temp2++)];
            }
        }
        while (temp1 < n1) {
            buffer[temp++] = matrix[init + (temp1++)];
        }
        while (temp2 < n2) {
            buffer[temp++] = matrix[init + n1 + (temp2++)];
        }
        for (i = 0; i < n1 + n2; i++) {
            matrix[init + i] = buffer[i];
        }
    }

    /*
     * El algoritmo trabaja de la siguiente forma:
     *    - Elegir un elemento de la lista de elementos a ordenar, al que llamaremos pivote.
     *    
     *    - Resituar los dem�s elementos de la lista a cada lado del pivote, de manera que a un lado 
     *      queden todos los menores que �l, y al otro los mayores. Los elementos iguales al pivote 
     *      pueden ser colocados tanto a su derecha como a su izquierda, dependiendo de la 
     *      implementaci�n deseada. En este momento, el pivote ocupa exactamente el lugar que le 
     *      corresponder� en la lista ordenada.
     *      
     *    - La lista queda separada en dos sublistas, una formada por los elementos a la izquierda 
     *      del pivote, y otra por los elementos a su derecha.
     *      
     *    - Repetir este proceso de forma recursiva para cada sublista mientras �stas contengan m�s 
     *      de un elemento. Una vez terminado este proceso todos los elementos estar�n ordenados.
     *      
     * Como se puede suponer, la eficiencia del algoritmo depende de la posici�n en la que termine 
     * el pivote elegido.
     *    - En el mejor caso, el pivote termina en el centro de la lista, dividi�ndola en dos 
     *      sublistas de igual tama�o. En este caso, el orden de complejidad del algoritmo es O(n�log n).
     *      
     *    - En el peor caso, el pivote termina en un extremo de la lista. El orden de complejidad 
     *      del algoritmo es entonces de O(n�). El peor caso depender� de la implementaci�n del 
     *      algoritmo, aunque habitualmente ocurre en listas que se encuentran ordenadas, o casi 
     *      ordenadas. Pero principalmente depende del pivote, si por ejemplo el algoritmo 
     *      implementado toma como pivote siempre el primer elemento del array, y el array que le 
     *      pasamos est� ordenado, siempre va a generar a su izquierda un array vac�o, lo que es 
     *      ineficiente.
     *      
     *    - En el caso promedio, el orden es O(n�log n).
     *    
     * No es extra�o, pues, que la mayor�a de optimizaciones que se aplican al algoritmo se centren 
     * en la elecci�n del pivote.
     */
    // The left and right are indexes into the array to be sorted for the current 
    // invocation of the quickSort call.
    public static void quickSort(int matrix[], int a, int b){
        matrix = new int[matrix.length];
        int buf;
        int from = a;
        int to = b;
        int pivot = matrix[(from+to)/2];
        do{
            while(matrix[from] < pivot){
                from++;
            }
            while(matrix[to] > pivot){
                to--;
            }
            if(from <= to){
                buf = matrix[from];
                matrix[from] = matrix[to];
                matrix[to] = buf;
                from++; to--;
            }
        }while(from <= to);
        if(a < to){
            quickSort(matrix, a, to);
        }
        if(from < b){
            quickSort(matrix, from, b);
        }
    }

}
