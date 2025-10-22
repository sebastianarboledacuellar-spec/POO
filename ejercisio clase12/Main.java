// Clase base
class Persona {
    protected String nombre;
    protected int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
    }
}

// Subclase Empleado
class Empleado extends Persona {
    protected double salario;

    public Empleado(String nombre, int edad, double salario) {
        super(nombre, edad); // Llama al constructor de Persona
        this.salario = salario;
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion(); // Llama al método de la clase base
        System.out.println("Salario: $" + salario);
    }
}

// Subclase Gerente
class Gerente extends Empleado {
    private String departamento;

    public Gerente(String nombre, int edad, double salario, String departamento) {
        super(nombre, edad, salario);
        this.departamento = departamento;
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Departamento: " + departamento);
    }
}

// Clase principal
public class Main {
    public static void main(String[] args) {
        Persona persona = new Persona("Ana", 30);
        Empleado empleado = new Empleado("Carlos", 40, 2500.0);
        Gerente gerente = new Gerente("Laura", 45, 4000.0, "Recursos Humanos");

        System.out.println("=== Persona ===");
        persona.mostrarInformacion();

        System.out.println("\n=== Empleado ===");
        empleado.mostrarInformacion();

        System.out.println("\n=== Gerente ===");
        gerente.mostrarInformacion();
    }
}
