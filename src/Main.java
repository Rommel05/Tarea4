import java.util.Scanner;

/**
 * Clase principal que realiza la criba de Eratóstenes para encontrar números primos hasta un valor dado.
 */

public class Main {

    /**
     * Método principal que solicita al usuario un número y muestra el vector inicial y el vector de primos hasta ese número.
     * @param args Los argumentos de la línea de comandos (no se utilizan en este caso).
     */

    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        System.out.println("Introduce el número para la criba de Erastótenes:");
        int dato=teclado.nextInt();
        int vector[]=new int[dato];
        System.out.println("\nVector inicial hasta :"+dato);
        for (int i = 0; i < vector.length; i++) {
            if (i%10==0) System.out.println();
            System.out.print(i+1+"\t");
        }
        vector=generarPrimos(dato);
        System.out.println("\nVector de primos hasta:"+dato);
        for (int i = 0; i < vector.length; i++) {
            if (i%10==0) System.out.println();
            System.out.print(vector[i]+"\t");
        }
    }
    public static int[] generarPrimos (int max) {
        if (max < 2) {
            return new int[0];
        }
        int dim = max + 1;
        boolean[] esPrimo = new boolean[dim];
        inicializarEsPrimo(esPrimo);
        criba(esPrimo,dim);
        int cuenta = contar(esPrimo, dim);
        int[] primos = new int[cuenta];
        rellenarVectorPrimos(primos, esPrimo);
        return primos;
    }

    public static void inicializarEsPrimo(boolean[] esPrimo) {
        esPrimo[0] = esPrimo[1] = false;
        for (int i = 2; i < esPrimo.length; i++) {
            esPrimo[i] = true;
        }
    }

    public static void criba(boolean[] esPrimo, int dim) {
        for (int i = 2; i <= Math.sqrt(dim); i++) {
            if (esPrimo[i]) {
                eliminarMultiplos(i, esPrimo, dim);
            }
        }
    }

    public static void eliminarMultiplos(int i, boolean[] esPrimo, int dim) {
        for (int j = 2 * i; j < dim; j += i) {
            esPrimo[j] = false;
        }
    }

    public static int contar(boolean[] esPrimo, int dim) {
        int cuenta = 0;
        for (int i = 0; i < dim; i++) {
            if (esPrimo[i]) {
                cuenta++;
            }
        }
        return cuenta;
    }

    public static void rellenarVectorPrimos(int[] primos, boolean[] esPrimo) {
        for (int i = 0, j = 0; i < esPrimo.length; i++) {
            if (esPrimo[i]) primos[j++] = i;
        }
    }
}