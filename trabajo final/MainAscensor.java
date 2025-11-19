import java.util.Scanner; 

public class MainAscensor { 

    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
        SistemaControl sistema = new SistemaControl(10); 
        boolean salir = false; 

    // Menu principal donde el usuario puede interactuar con el sistema del ascensor
        System.out.println("----  SISTEMA DE ASCENSOR ----"); 

 
        while (!salir) { 
            System.out.println("\n Piso actual: " + sistema.getPisoActual()); 
            System.out.println("Seleccione una opción:"); 
            System.out.println("1. Llamar ascensor desde un piso"); 
            System.out.println("2. Seleccionar piso destino (desde el ascensor)"); 
            System.out.println("3. Salir"); 
            System.out.print(" Opción: "); 


            int opcion = sc.nextInt(); 

 
            switch (opcion) { 

                case 1: 

                    System.out.print("Ingrese el piso desde donde llama (1-10): "); 
                    int piso = sc.nextInt(); 
                    sistema.solicitarDesdePiso(piso); 
                    break; 

                case 2: 

                    System.out.print("Ingrese el piso destino (1-10): "); 
                    int destino = sc.nextInt(); 
                    sistema.solicitarDesdeCabina(destino); 
                    break; 

                case 3: 

                    salir = true; 
                    System.out.println(" Saliendo del sistema..."); 
                    break; 

                default: 

                    System.out.println(" Opción no válida."); 
            } 

        } 

        sc.close(); 

    } 

} 