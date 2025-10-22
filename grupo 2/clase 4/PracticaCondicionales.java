public class PracticaCondicionales {
    public static void main(String[] args) {
        /*
         * Ejercicio 4.1.a)
         * Requerimiento: Si un ángulo es igual a 90 grados, imprimir el
         * mensaje "El ángulo es un ángulo recto" sino imprimir el
         * mensaje "El ángulo no es un ángulo recto".
         * 
         * Entrada: ángulo
         * Proceso: validar si el ángulo es igual a 90 grados
         * Salida: obtener el mensaje si es o no es un angulo recto.
         */

        int angulo = 90;

        if (angulo == 90) {
            System.out.println("El ángulo es un ángulo recto");
        } else {
            System.out.println("El ángulo no es un ángulo recto");
        }

        /*
         * Si la temperatura es superior a 100 grados, visualizar el
         * mensaje "por encima del punto de ebullición del agua" sino
         * visualizar el mensaje "por debajo del punto de ebullición del agua".
         * 
         * Entrada: temperatura
         * Proceso: validar que la temperatura sea superior a 100 grados
         * Salida: si alcanza o no el punto de ebullición.
         */

        double temperatura = 100.0;
        if (temperatura > 100) {
            System.out.println("por encima del punto de ebullición del agua");
        } else {
            System.out.println("por debajo del punto de ebullición del agua");
        }

        /*
         * Ejercicio 4.9
         * Un ángulo se considera agudo si es menor de 90 grados, obtuso
         * si es mayor de 90 grados y recto si es igual a 90 grados.
         * Utilizando esta información, escribir un algoritmo que acepte
         * un ángulo en grados y visualice el tipo de ángulo correspondiente
         * a los grados introducidos.
         * 
         * Entrada: angulo (a)
         * Proceso: validar si el angulo está entre los siguientes rangos
         * angulo menor que 90, angulo mayor que 90, angulo igual a 90
         * Salida: mostrar si es un angulo agudo, obtuso u recto.
         */

        int a = 90;
        if (a < 90) {
            System.out.println("Ángulo Agudo");
        } else {
            if (a > 90) {
                System.out.println("Ángulo Obtuso");
            } else {
                System.out.println("Ángulo Recto");
            }
        }
    }
}