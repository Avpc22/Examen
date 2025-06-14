public class Examen {
    public static void main(String[] args) {
        // Matriz de ejemplo con temperaturas
        int[][] temperaturas = {
            {25, 32, 18, 9, 36},
            {14, 22, 30, 28, 10},
            {8, 35, 20, 31, 40}
        };

        // Llamamos a los métodos y mostramos resultados
        System.out.println("Días calurosos (>30°C): " + contarDiasCalurosos(temperaturas));
        System.out.println("Promedio de días frescos (<20°C): " + promedioDiasFrescos(temperaturas));

        System.out.println("Temperaturas extremas:");
        imprimirTemperaturasExtremas(temperaturas);

        int[] posicion = posicionTemperaturaMasAlta(temperaturas);
        System.out.println("Temperatura más alta en posición [" + posicion[0] + "][" + posicion[1] + "]");
    }

    // Cuenta cuántos días hubo temperaturas mayores a 30°C
    public static int contarDiasCalurosos(int[][] matriz) {
        int contador = 0;
        for (int[] fila : matriz) {
            for (int temp : fila) {
                if (temp > 30) {
                    contador++;
                }
            }
        }
        return contador;
    }

    // Calcula el promedio de los días con temperaturas menores a 20°C
    public static double promedioDiasFrescos(int[][] matriz) {
        int suma = 0, contador = 0;
        for (int[] fila : matriz) {
            for (int temp : fila) {
                if (temp < 20) {
                    suma += temp;
                    contador++;
                }
            }
        }
        return contador > 0 ? (double) suma / contador : 0;
    }

    // Imprime las temperaturas menores a 10°C y mayores a 35°C junto con su posición
    public static void imprimirTemperaturasExtremas(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] < 10 || matriz[i][j] > 35) {
                    System.out.println("Temperatura extrema: " + matriz[i][j] + " en posición [" + i + "][" + j + "]");
                }
            }
        }
    }

    // Devuelve la posición [i][j] donde se registró la temperatura más alta
    public static int[] posicionTemperaturaMasAlta(int[][] matriz) {
        int maximaTemp = Integer.MIN_VALUE;
        int[] posicion = new int[2];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] > maximaTemp) {
                    maximaTemp = matriz[i][j];
                    posicion[0] = i;
                    posicion[1] = j;
                }
            }
        }
        return posicion;
    }
}