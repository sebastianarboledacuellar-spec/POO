public class Producto {

    private String codigo;
    private String descripcion;
    private int cantidad;
    private double precioUnitario;

    public Producto() {
        this.codigo = "0000";
        this.descripcion = "Sin descripción";
        this.cantidad = 1;
        this.precioUnitario = 0.0;
    }

    public Producto(String codigo, String descripcion, int cantidad, double precioUnitario) {
        // Validar código
        if (codigo == null || codigo.trim().isEmpty()) {
            this.codigo = "0000";
        } else {
            this.codigo = codigo;
        }

        if (descripcion == null || descripcion.trim().isEmpty()) {
            this.descripcion = "Sin descripción";
        } else {
            this.descripcion = descripcion;
        }

        if (cantidad < 1) {
            this.cantidad = 1;
        } else {
            this.cantidad = cantidad;
        }

        if (precioUnitario < 0) {
            this.precioUnitario = 0.0;
        } else {
            this.precioUnitario = precioUnitario;
        }
    }

    public double calcularSubtotal() {
        return cantidad * precioUnitario;
    }

    public void aplicarDescuento(double porcentaje) {
        if (porcentaje > 0 && porcentaje <= 50) {
            double descuento = precioUnitario * (porcentaje / 100);
            precioUnitario -= descuento;
            System.out.println("Descuento aplicado del " + porcentaje + "%. Nuevo precio unitario: $" + precioUnitario);
        } else {
            System.out.println("Error: el porcentaje de descuento debe estar entre 0 y 50.");
        }
    }

    public void incrementarCantidad(int valor) {
        if (valor > 0) {
            cantidad += valor;
            System.out.println("Cantidad incrementada. Nueva cantidad: " + cantidad);
        } else {
            System.out.println("Error: el valor a incrementar debe ser mayor que 0.");
        }
    }

    @Override
    public String toString() {
        return "Código: " + codigo +
               "\nDescripción: " + descripcion +
               "\nCantidad: " + cantidad +
               "\nPrecio unitario: $" + String.format("%.2f", precioUnitario) +
               "\nSubtotal: $" + String.format("%.2f", calcularSubtotal());
    }

    public static void main(String[] args) {
        System.out.println("=== Producto por defecto ===");
        Producto p1 = new Producto();
        System.out.println(p1);

        System.out.println("\n=== Producto parametrizado ===");
        Producto p2 = new Producto("A123", "Mouse inalámbrico", 3, 25000);
        System.out.println(p2);

        System.out.println("\n--- Operaciones ---");
        p2.aplicarDescuento(20);
        p2.incrementarCantidad(2);
        System.out.println("\n=== Estado final del producto ===");
        System.out.println(p2);
    }
}