public class practicascondicionales {
    public static void main(String[] args) {

    }
    /*
     * ejercisio 4.1.a
     * requerimiento: si un angulo recto a 90 grados, imprimir el
     * mensaje "el angulo es un angulo recto" sino imprimir el
     * mensaje "el mensaje no es un angulo recto".
     * 
     * entrada angulo
     * proceso validar si el angulo es igual a 90 grados
     * salida: obtener el mensaje si es o no es un angulo recto:
     */

    int angulo = 90;

    if(angulo==90)
    {
        System.out.println("el angulo es un angulo recto");
    }else
    {
        System.out.println("el angulo no es un angulo recto");
    }

    // ----------------------------

    /*
     * ejercisio 4.1.b
     * Si la temperatura es superior a 100 grados, visualizar
     * el mensaje “por encima del punto de ebullición del agua” sino
     * visualizar el mensaje “por debajo del punto de ebullición del agua”
     * 
     * entrada: temperatura
     * proceso validar si la temperatura sea superior a 100 grados
     * salida: si alcanzo o no el punto de ebullicion
     */
    double temperatura = 30.0;if(temperatura>100)
    {
        System.out.println("por encima del punto de ebullicion");
    }else
    {
        System.out.println("por debajo del punto de ebullicion");

    }

    //------------------

    /*
     * ejercisio 4.1.c
     * Si el número es positivo, sumar el número a total
     * de positivos, sino sumar al total de negativos.
     * 
     * entrada:número
     * proceso: sumar número total positivos o negativos
     * salida: si el total es positivo o negativo
     */
    int numero = 19;
    int total_numero_positivo = 0;
    int total_numero_negativo = 0;

    // -----------------------

    /*
     * ejersicio 4.9
     * Un ángulo se considera agudo si es menor de 90
     * grados, obtuso si es mayor de 90 grados y recto si
     * es igual a 90 grados. Utilizando esta información,
     * escribir un algoritmo que acepte un ángulo en grados
     * y visualice el tipo de ángulo correspondiente a los
     * grados introducidos.
     * 
     * Entrada: angulo (a)
     * proceso: validar si el angulo esta entre los siguientes rangos
     * angulo < 90, angulo > 90, angulo = 90
     * salida: mostrar si es un angulo agudo, obtuso o recto.
     */

    int a = 90;if(a<90)
    {
        System.out.println("angulo agudo");
    }else
    {
        if (a > 90) {
            System.out.println("angulo obtuso");
        } else {
            System.out.println("angulo recto");
        }
    }
}

}

}