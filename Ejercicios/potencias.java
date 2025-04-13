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
        int objetivo = arr.get(arr.size() - 1);
        arr = arr.subList(1, arr.size() - 1);
        return seleccionarSubconjunto(arr, objetivo);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
        System.out.print("¿Cuántos números quieres ingresar en el arreglo? ");
        int n = sc.nextInt();
        List<Integer> arr = new ArrayList<>(n);
        
        System.out.println("Ahora ingrese los elementos: ");
        for (int i = 0; i < n; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            arr.add(sc.nextInt());
        }

        System.out.println(resolverProblema(arr));
        sc.close();
        System.out.println("¿Deseas ingresar otro arreglo? (si/no): ");
        String respuesta = sc.next();
        if (respuesta.equalsIgnoreCase("no")) {
            System.out.println("Saliendo...");
            break; 
        }
    }
}
}
