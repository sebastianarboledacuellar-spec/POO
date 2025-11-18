import java.util.*;

public class ascensor {

    enum Direccion { ARRIBA, ABAJO, DETENIDO }

    static class Elevador {
        int id;
        int pisoActual = 1;
        Direccion direccion = Direccion.DETENIDO;
        TreeSet<Integer> destinos = new TreeSet<>();

        Elevador(int id) { this.id = id; }

        void agregarDestino(int piso) {
            destinos.add(piso);
            if (direccion == Direccion.DETENIDO) actualizarDireccion();
        }

        private void actualizarDireccion() {
            if (destinos.isEmpty()) { direccion = Direccion.DETENIDO; return; }
            int proximo = nearestDestino();
            if (proximo > pisoActual) direccion = Direccion.ARRIBA;
            else if (proximo < pisoActual) direccion = Direccion.ABAJO;
            else direccion = Direccion.DETENIDO;
        }

        private int nearestDestino() {
            int nearest = -1;
            int min = Integer.MAX_VALUE;
            for (int d : destinos) {
                int dist = Math.abs(d - pisoActual);
                if (dist < min) { min = dist; nearest = d; }
            }
            return nearest;
        }

        void mover() {
            if (destinos.isEmpty()) { direccion = Direccion.DETENIDO; return; }

            Integer proximo = null;
            if (direccion == Direccion.DETENIDO) {
                proximo = nearestDestino();
                if (proximo > pisoActual) direccion = Direccion.ARRIBA;
                else if (proximo < pisoActual) direccion = Direccion.ABAJO;
            }

            if (direccion == Direccion.ARRIBA) {
                proximo = destinos.ceiling(pisoActual);
                if (proximo == null) proximo = destinos.last();
            } else if (direccion == Direccion.ABAJO) {
                proximo = destinos.floor(pisoActual);
                if (proximo == null) proximo = destinos.first();
            }

            if (proximo == null) { direccion = Direccion.DETENIDO; return; }

            if (pisoActual < proximo) {
                pisoActual++;
                System.out.printf("[%d] Subiendo a... %d%n", id, pisoActual);
            } else if (pisoActual > proximo) {
                pisoActual--;
                System.out.printf("[%d] Bajando a... %d%n", id, pisoActual);
            }

            if (pisoActual == proximo) {
                destinos.remove(pisoActual);
                System.out.printf("*** ELEVADOR %d HA LLEGADO Y ABIERTO PUERTAS EN EL PISO %d ***%n", id, pisoActual);
                if (destinos.isEmpty()) direccion = Direccion.DETENIDO;
                else actualizarDireccion();
            }
        }

        public String toString() {
            return String.format("Elevador %d | Piso: %d | Dir: %s | Destinos: %s", id, pisoActual, direccion, destinos);
        }
    }

    static class SistemaControl {
        List<Elevador> elevadores = new ArrayList<>();

        SistemaControl(int num) { for (int i = 0; i < num; i++) elevadores.add(new Elevador(i + 1)); }

        void llamarElevador(int piso, Direccion direccionDeseada) {
            System.out.printf("%n--- LLAMADA RECIBIDA: Piso %d hacia %s --- %n", piso, direccionDeseada);
            Elevador mejor = null;
            int minDist = Integer.MAX_VALUE;
            for (Elevador e : elevadores) {
                int distancia = Math.abs(e.pisoActual - piso);
                boolean ok = (e.direccion == Direccion.DETENIDO)
                        || (e.direccion == direccionDeseada &&
                        ((direccionDeseada == Direccion.ARRIBA && e.pisoActual <= piso) ||
                                (direccionDeseada == Direccion.ABAJO && e.pisoActual >= piso)));
                if (ok && distancia < minDist) { minDist = distancia; mejor = e; }
            }
            if (mejor == null) {
                mejor = Collections.min(elevadores, Comparator.comparingInt(e -> Math.abs(e.pisoActual - piso)));
            }
            mejor.agregarDestino(piso);
            System.out.printf("Asignado al %d. Destinos: %s%n", mejor.id, mejor.destinos);
        }

        void simularCiclo() {
            System.out.println("\n--- CICLO DE SIMULACIÓN ---");
            for (Elevador e : elevadores) e.mover();
            for (Elevador e : elevadores) System.out.println(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("INICIANDO SIMULACIÓN DE 2 ELEVADORES");
        SistemaControl sistema = new SistemaControl(2);

        sistema.llamarElevador(8, Direccion.ABAJO);
        sistema.llamarElevador(2, Direccion.ARRIBA);

        for (int i = 1; i <= 9; i++) {
            System.out.printf("%n### PASO DE TIEMPO %d ###%n", i);
            sistema.simularCiclo();
            // Thread.sleep(500);
        }

        sistema.llamarElevador(5, Direccion.ARRIBA);
        sistema.llamarElevador(10, Direccion.ABAJO);

        for (int i = 10; i <= 19; i++) {
            System.out.printf("%n### PASO DE TIEMPO %d ###%n", i);
            sistema.simularCiclo();
        }
    }

}