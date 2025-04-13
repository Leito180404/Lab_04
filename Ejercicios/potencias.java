package Ejercicios;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class potencias {

    public static boolean potencia2(int n) {
        return (n & (n - 1)) == 0 && n > 0;
    }

    public static boolean seleccionarSubconjunto(List<Integer> arr, int objetivo) {
        List<Integer> subconjunto = new ArrayList<>();


        for (int i = 0; i < arr.size(); i++) {
            int num = arr.get(i);
            if (potencia2(num)) {
                subconjunto.add(num);
            } else if (num % 5 == 0 && i + 1 < arr.size() && arr.get(i + 1) % 2 != 0) {
                continue;
            } else {
                subconjunto.add(num);
            }
        }
        boolean[] dp = new boolean[objetivo + 1];
        dp[0] = true;

        for (int num : subconjunto) {
            for (int j = objetivo; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[objetivo]; 
    }
    public static boolean resolverProblema(List<Integer> arr) {
        int N = arr.get(0);
        int objetivo = arr.get(arr.size() - 1);
        arr = arr.subList(1, arr.size() - 1);
        return seleccionarSubconjunto(arr, objetivo);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("¿Cuántos números quieres ingresar en el arreglo? ");
        int n = sc.nextInt();
        List<Integer> arr = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            System.out.print("Ingresa el número " + (i + 1) + ": ");
            arr.add(sc.nextInt());
        }
        
        System.out.println(resolverProblema(arr));
        sc.close();
    }
}
