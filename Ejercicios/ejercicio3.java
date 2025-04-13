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
        int[][] T = {
            {0, 10, 75, 94, 50},
            {0, 0, 35, 50, 100},
            {0, 0, 0, 80, 125},
            {0, 0, 0, 0, 40},
            {0, 0, 0, 0, 0}
        };

        int n = T.length; 
        int costoMinimo = calcularCostoMinimo(T, n);
        System.out.println("El costo minimo de viajar entre el primer y utimo embarcadero es: " + costoMinimo);
    }
}
