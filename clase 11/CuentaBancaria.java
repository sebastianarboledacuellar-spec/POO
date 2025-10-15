public class CuentaBancaria {
    // Atributos privados
    private String titular;
    private String numeroCuenta;
    private double saldo;

    // Constructor por defecto
    public CuentaBancaria() {
        this.titular = "Titular Generico";
        this.numeroCuenta = "000000";
        this.saldo = 0.0;
    }

    // Constructor parametrizado
    public CuentaBancaria(String titular, String numeroCuenta, double saldo) {
        setTitular(titular);
        setNumeroCuenta(numeroCuenta);
        setSaldo(saldo);
    }

    // Getters y Setters con validaciones
    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        if (titular != null && !titular.isEmpty()) {
            this.titular = titular;
        } else {
            throw new IllegalArgumentException("El titular no puede estar vacío.");
        }
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        if (numeroCuenta != null && numeroCuenta.length() >= 6) {
            this.numeroCuenta = numeroCuenta;
        } else {
            throw new IllegalArgumentException("El número de cuenta debe tener al menos 6 dígitos.");
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        if (saldo >= 0) {
            this.saldo = saldo;
        } else {
            throw new IllegalArgumentException("El saldo no puede ser negativo.");
        }
    }

    // Método depositar
    public void depositar(double monto) {
        if (monto > 0) {
            this.saldo += monto;
            System.out.println("Depósito exitoso. Nuevo saldo: " + this.saldo);
        } else {
            System.out.println("El monto a depositar debe ser mayor que 0.");
        }
    }

    // Método retirar
    public void retirar(double monto) {
        if (monto > 0 && monto <= saldo) {
            this.saldo -= monto;
            System.out.println("Retiro exitoso. Nuevo saldo: " + this.saldo);
        } else if (monto <= 0) {
            System.out.println("El monto a retirar debe ser mayor que 0.");
        } else {
            System.out.println("No tienes suficiente saldo para realizar el retiro.");
        }
    }

    // Método toString
    @Override
    public String toString() {
        return "Cuenta Bancaria [Titular: " + titular + ", Número de Cuenta: " + numeroCuenta + ", Saldo: " + saldo + "]";
    }

    // Método main para pruebas
    public static void main(String[] args) {
        CuentaBancaria cuenta = new CuentaBancaria("Sebastian Arboleda", "123456", 1000);
        System.out.println(cuenta);
        cuenta.depositar(500);
        cuenta.retirar(200);
        cuenta.retirar(2000); // Prueba de saldo insuficiente
        cuenta.depositar(-50); // Prueba de depósito inválido
        cuenta.retirar(-10); // Prueba de retiro inválido
        System.out.println(cuenta);
    }
}