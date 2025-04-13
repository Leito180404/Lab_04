package Ejercicios;
import java.util.ArrayList;
import java.util.Scanner;
public class ejercicio2 {

    public static int particion(ArrayList<Integer> arr, int low, int high) {
        int pivot = arr.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr.get(j) <= pivot) {
                i++;
                int temp = arr.get(i);
                arr.set(i, arr.get(j)); 
                arr.set(j, temp);
            }
        }

        int temp = arr.get(i + 1);
        arr.set(i + 1, arr.get(high));
        arr.set(high, temp);
        
        return i + 1; 
    }

    public static int quickSelect(ArrayList<Integer> arr, int low, int high, int k) {
        if (low <= high) {

            int pivotIndex = particion(arr, low, high);
            if (pivotIndex == k) {
                return arr.get(pivotIndex); 
            } 
            else if (pivotIndex > k) {
                return quickSelect(arr, low, pivotIndex - 1, k);
            } 
            else {
                return quickSelect(arr, pivotIndex + 1, high, k);
            }
        }
        return -1;
    }
    
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            while (true){
                System.out.println("ingrese el tamanio del arreglo: ");
                int n = sc.nextInt();
                System.out.println("ahora ingrese los elementos: ");
                ArrayList<Integer> arr = new ArrayList<>(n);
                for(int i = 0; i<n; i++){
                    System.out.print("Elemento " + (i + 1) + ": ");
                    arr.add(sc.nextInt()); 
                }
                System.out.println("ahora ingrese el valor de k: ");
                int k = sc.nextInt();
                System.out.println("El " + k + "-esimo elemento mas pequenio es: " + quickSelect(arr, 0, arr.size() - 1, k - 1));
                
                System.out.println("¿Deseas ingresar otro arreglo? (si/no): ");
                String respuesta = sc.next();
                if (respuesta.equalsIgnoreCase("no")) {
                    System.out.println("Saliendo...");
                    break; 
            }
            sc.close();
        }
    }
}