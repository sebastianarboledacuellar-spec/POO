public class EstructurasRepeticionCiclos {
    public static void main(String[] args) {
        
        //for (para)
        //for(inicio; condición; incremento)
        for(int i = 1; i <= 5; i++){
            System.out.println("i = " + i);
        }

        /*
         * Prueba de escritorio
         * i    i <= 5      i++     "i = " + i
         * 1    1 <= 5 V    2        i = 1
         *      2 <= 5 V    3        i = 2
         *      3 <= 5 V    4        i = 3
         *      4 <= 5 V    5        i = 4
         *      5 <= 5 V    6        i = 5
         *      6 <= 5 F X
         */

        System.out.println("*******************************");
        //while (Mientras)
        //Paso1: declaración de la variable
        int j = 1;
        //Paso2: el while con la condición
        while(j <= 5){
            System.out.println("j = " + j);
            //Paso3: incrementar la j
            j++;
        }

        System.out.println("*******************************");
        //do-while (Haga - Mientras) - Garantiza que por lo menos entra una vez al ciclo
        // cumpla o no cumpla la condición
        int x = 1;
        do{
            System.out.println("x = " + x);
            x++;
        }while(x <= 5);


    }
}