public class MainPisoTest {
    public static void main(String[] args) {
        int totalPisos = 5;

        Piso p1 = new Piso(1, totalPisos);
        Piso p2 = new Piso(3, totalPisos);
        Piso p3 = new Piso(5, totalPisos);

        System.out.println("Estados iniciales:");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        // probar presionar botones
        System.out.println("\nPresionando botones disponibles...");
        p1.presionarSubir(); // piso 1 solo tiene subir
        p2.presionarSubir();
        p2.presionarBajar();
        p3.presionarBajar(); // piso top solo tiene bajar

        System.out.println("\nEstados después de presionar:");
        System.out.println(p1);
        System.out.println("p1 subir presionado? " + (p1.hasSubir() ? p1.getSubir().isPresionado() : false));
        System.out.println(p2);
        System.out.println("p2 subir presionado? " + (p2.hasSubir() ? p2.getSubir().isPresionado() : false));
        System.out.println("p2 bajar presionado? " + (p2.hasBajar() ? p2.getBajar().isPresionado() : false));
        System.out.println(p3);
        System.out.println("p3 bajar presionado? " + (p3.hasBajar() ? p3.getBajar().isPresionado() : false));
    }
}
