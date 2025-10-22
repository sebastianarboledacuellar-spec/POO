import java.util.Scanner;

public class CincoPuntoUno {
    public static void main(String[] args) {
        /*
         * Determinar la media de una lista indefinida de números positivos,
         * terminados con un número negativo.
         */
        Scanner leer = new Scanner(System.in); // Pedir datos por teclado

        int n = 0, contador = 0, suma = 0;
        do {
            System.out.println("Digite un número positivo o negativo");
            n = leer.nextInt();
            if (n > 0) {
                suma += n;
                contador++;
            }
        } while (n > 0);

        if (suma == 0) {
            System.out.println("No hubo valores postivos para hacer los cálculos");
        } else {
            System.out.println("La media de los números positivos es: " + (suma / contador));
        }
        //Cerrar el objeto de la clase Scanner
        leer.close();
    }
}