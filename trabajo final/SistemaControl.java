import java.util.ArrayList;
import java.util.List;

// Sistema de control del ascensor que maneja las solicitudes desde pisos y adentro del ascensor
class SistemaControl {
    private Ascensor ascensor;
    private List<Piso> pisos;

    //contructor del Sistema de control del ascensor con la cantidad de pisos
    public SistemaControl(int cantidadPisos) {
        ascensor = new Ascensor();
        pisos = new ArrayList<>();
        for (int i = 1; i <= cantidadPisos; i++) {
            pisos.add(new Piso(i, cantidadPisos));
        }
    }

    public void solicitarDesdePiso(int piso) {
        System.out.println(" Llamada desde el piso " + piso);
        ascensor.solicitarPiso(piso);
    }

    public void solicitarDesdeCabina(int destino) {
        System.out.println(" Destino seleccionado: piso " + destino);
        ascensor.solicitarPiso(destino);
    }

    public int getPisoActual() {
        return ascensor.getPisoActual();
    }
}