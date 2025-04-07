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

        static class SubVector {
        int[] a;
        int prim;
        int ult;

        SubVector(int[] a, int prim, int ult) {
            this.a = a;
            this.prim = prim;
            this.ult = ult;
        }

        int length() {
            return ult - prim + 1;
        }
    }

    private static void pivote2(int[] array, int mediana, int prim, int ult, int[] izqDer) {
        int izq = prim;
        int der = ult;
        for (int i = prim; i <= der; ) {
            if (array[i] < mediana) {
                int temp = array[i];
                array[i] = array[izq];
                array[izq] = temp;
                izq++;
                i++;
            } else if (array[i] > mediana) {
                int temp = array[i];
                array[i] = array[der];
                array[der] = temp;
                der--;
            } else {
                i++;
            }
        }
        izqDer[0] = izq;
        izqDer[1] = der + 1;
    }

    public static int moda3(int[] a) {
        Queue<SubVector> heterogeneos = new LinkedList<>();
        List<SubVector> homogeneos = new ArrayList<>();

        heterogeneos.add(new SubVector(a, 0, a.length - 1));

        while (!heterogeneos.isEmpty()) {
            SubVector p = heterogeneos.poll();
            if (p.prim > p.ult) continue;

            int mediana = p.a[(p.prim + p.ult) / 2];
            int[] izqDer = new int[2];
            pivote2(p.a, mediana, p.prim, p.ult, izqDer);

            SubVector p1 = new SubVector(p.a, p.prim, izqDer[0] - 1);
            SubVector p2 = new SubVector(p.a, izqDer[0], izqDer[1] - 1);
            SubVector p3 = new SubVector(p.a, izqDer[1], p.ult);

            if (p1.prim < p1.ult) heterogeneos.add(p1);
            if (p3.prim < p3.ult) heterogeneos.add(p3);
            if (p2.prim <= p2.ult) homogeneos.add(p2);
        }

        if (homogeneos.isEmpty()) return a[0];

        SubVector moda = homogeneos.get(0);
        for (SubVector s : homogeneos) {
            if (s.length() > moda.length()) {
                moda = s;
            }
        }

        return moda.a[moda.prim];
    }
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