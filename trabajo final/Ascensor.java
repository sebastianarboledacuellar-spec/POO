import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

class Ascensor {

    private int pisoActual;
    private String direccion;
    private Puerta puerta;
    private Sensor sensor;
    private List<Integer> solicitudes;

    public Ascensor() {
        pisoActual = 1;
        direccion = "detenido";
        puerta = new Puerta();
        sensor = new Sensor();
        solicitudes = new LinkedList<>();
    }

    public void solicitarPiso(int destino) {
        if (!solicitudes.contains(destino)) {
            solicitudes.add(destino);
            System.out.println(led("verde", " Solicitud recibida para el piso " + destino));
            organizarSolicitudes();
            moverAutomatico();
        }
    }

    private void organizarSolicitudes() {
        if (direccion.equals("bajando")) {
            solicitudes.sort(Comparator.reverseOrder());
        } else {
            solicitudes.sort(Comparator.naturalOrder());
        }
    }

    // Función para mostrar texto con un LED de color específico
    private String led(String color, String texto) {
        switch (color.toLowerCase()) {
            case "verde":
                return "🟢 " + texto;
            case "rojo":
                return "🔴 " + texto;
            case "azul":
                return "🔵 " + texto;
            case "amarillo":
                return "🟡 " + texto;
            default:
                return "⚪ " + texto;
        }
    }

    // panel que muestra el estado del ascensor con su respectiva iluminacion.
    private void mostrarPanel(int pisoActual, String direccion, int destino) {
        System.out.println("\n======= PANEL DEL ASCENSOR =======");
        System.out.println(led("azul", "Piso actual: " + pisoActual));

        if (direccion.equals("subiendo"))
            System.out.println(led("verde", "Dirección: ▲ Subiendo"));
        else if (direccion.equals("bajando"))
            System.out.println(led("amarillo", "Dirección: ▼ Bajando"));
        else
            System.out.println(led("azul", "Dirección: ■ Detenido"));

        System.out.println(led("verde", "Atendiendo solicitud al piso: " + destino));
        System.out.println("===================================\n");
    }

    private int siguienteDestino() {
        if (direccion.equals("subiendo")) {
            for (int piso : solicitudes) {
                if (piso >= pisoActual)
                    return piso;
            }
        }

        if (direccion.equals("bajando")) {
            for (int piso : solicitudes) {
                if (piso <= pisoActual)
                    return piso;
            }
        }

        if (solicitudes.get(0) > pisoActual)
            direccion = "subiendo";
        else
            direccion = "bajando";

        organizarSolicitudes();
        return solicitudes.get(0);
    }

    private void moverAutomatico() {
        while (!solicitudes.isEmpty()) {
            int destino = siguienteDestino();
            
            // activacion del sensor de fallas con una probabilidad baja
            if (sensor.detectarFalla()) {
                System.out.println(led("rojo", " Falla detectada. Ascensor detenido en piso " + pisoActual));
                puerta.abrir();
                solicitudes.clear();
                return;
            }
                //movimiento del ascensor
            if (pisoActual < destino) {
                direccion = "subiendo";
                pisoActual++;
            } else if (pisoActual > destino) {
                direccion = "bajando";
                pisoActual--;
            } else {
                //llega al destino
                direccion = "detenido";
                puerta.abrir();
                System.out.println(led("azul", " Llegó al piso " + pisoActual));
                solicitudes.remove(Integer.valueOf(destino));

                try {
                    Thread.sleep(800);
                } catch (Exception e) {
                }
                puerta.cerrar();
                continue;
            }

            mostrarPanel(pisoActual, direccion, destino);

            try {
                Thread.sleep(700);
            } catch (Exception e) {
            }
        }

        direccion = "detenido";
        System.out.println(led("azul", " No hay más solicitudes."));
    }

    public int getPisoActual() {
        return pisoActual;
    }

}