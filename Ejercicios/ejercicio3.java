package Ejercicios;
public class ejercicio3 {
    public static int calcularCostoMinimo(int[][] T, int n) {
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++) {
            C[i][i] = 0;
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                C[i][j] = Integer.MAX_VALUE; 

                for (int k = i; k < j; k++) {
                    int costo = T[i][k] + C[k + 1][j];
                    if (costo < C[i][j]) {
                        C[i][j] = costo;
                    }
                }
            }
        }

        return C[0][n - 1]; 
    }

    public static void main(String[] args) {
        int[][] T1 = {
            {0, 10, 75, 94, 50},
            {0, 0, 35, 50, 100},
            {0, 0, 0, 80, 125},
            {0, 0, 0, 0, 40},
            {0, 0, 0, 0, 0}
        };

        int n1 = T1.length;
        int costoMinimo1 = calcularCostoMinimo(T1, n1);
        System.out.println("Ejemplo 1 - Costo minimo entre el primer y ultimo embarcadero: " + costoMinimo1);

        int[][] T2 = {
            {110, 200, 450, 600},
            {40, 50, 150, 300},
            {20, 0, 0, 100},
            {40, 70, 10, 10}
        };

        int n2 = T2.length;
        int costoMinimo2 = calcularCostoMinimo(T2, n2);
        System.out.println("Ejemplo 2 - Costo minimo entre el primer y ultimo embarcadero: " + costoMinimo2);

        int[][] T3 = {
            {10, 20, 40},
            {230, 500, 10},
            {100, 10, 110}
        };

        int n3 = T3.length;
        int costoMinimo3 = calcularCostoMinimo(T3, n3);
        System.out.println("Ejemplo 3 - Costo minimo entre el primer y ltimo embarcadero: " + costoMinimo3);
    }
}
