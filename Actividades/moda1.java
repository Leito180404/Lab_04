import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class moda1 {
    private static int frecuencia(int []array, int first, int end, int ele) {
        if (first > end) return 0;
        int suma = 0;
        for (int i = first; i <= end; i++) {
            if (array[i] == ele)
                suma ++;
        }
        return suma;
    }    

    public static int modal1(int array[]) {
        int first = 0;
        int end = array.length - 1;
    
        if (first == end)
            return array[first];
        
        int moda = array[first];
        int maxfre = frecuencia(array, first, end, moda);
        
        for (int i = first + 1; i < end; i++) {
            int frec = frecuencia(array, i, end, array[i]);
            if (frec > maxfre) {
                maxfre = frec;
                moda = array[i];
            }
        }
        
        return moda;
    }

    public static int moda2(int array[]) {
        int first = 1;
        int p = 0;
        int end = array.length - 1;
        int moda = array[0];
        int frec = 1;
        int maxfrec = 0;
    
        while (first <= end) {
            if (array[p] == array[first]) {
                frec++;
                first++;
            } else {
                if (frec > maxfrec) {
                    maxfrec = frec;
                    moda = array[p];
                }
                p = first;
                first = p + 1;
                frec = 1;
            }
        }
    
        return moda;

    }
    

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 3, 2, 3, 1};

        // Ejemplo de llamada al método frecuencia
        int num = 3;
        int first = 0;
        int end = array.length - 1;
        int freq = frecuencia(array, first, end, num);
        System.out.println("El número " + num + " aparece " + freq + " veces.");

        // Ejemplo de llamada al método modal1
        int moda1Result = modal1(array);
        System.out.println("La moda del arreglo utilizando modal1 es: " + moda1Result);

        // Ejemplo de llamada al método moda2
        int moda2Result = moda2(array);
        System.out.println("La moda del arreglo utilizando moda2 es: " + moda2Result);
    }
}    