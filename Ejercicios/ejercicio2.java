package Ejercicios;
import java.util.Random;
public class ejercicio2 {
        public static int partition(int[] arr, int low, int high) {
            int pivot = arr[high];
            int i = low - 1;

            for (int j = low; j < high; j++) {
                if (arr[j] <= pivot) {
                    i++;
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }

            int temp = arr[i + 1];
            arr[i + 1] = arr[high];
            arr[high] = temp;
            
            return i + 1; 
        }

        public static int quickSelect(int[] arr, int low, int high, int k) {
            if (low <= high) {

                int pivotIndex = partition(arr, low, high);
                if (pivotIndex == k) {
                    return arr[pivotIndex];
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
            int[] arr1 = {4, 2, 7, 10, 4, 17};
            int k = 3;
            System.out.println("El " + k + "-esimo elemento mas pequenio es: " + quickSelect(arr1, 0, arr1.length - 1, k - 1));
            int[] arr2 = {4, 2, 7, 10, 4, 17};
        }
    }
