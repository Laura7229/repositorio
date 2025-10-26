import java.io.Serializable;

public abstract class Cuenta implements Serializable {
    private static final long serialVersionUID = 1L;
    private int numerocuenta;
    private double saldo;
    private Persona cliente; // CORREGIDO: Ya no es 'static'

    public Cuenta(Persona cliente, int numerocuenta, double saldo) {
        this.cliente = cliente;
        this.numerocuenta = numerocuenta;
        this.saldo = saldo;
    }

    public int getNumerocuenta() { return numerocuenta; }
    public void setNumerocuenta(int numerocuenta) { this.numerocuenta = numerocuenta; }
    public double getSaldo() { return saldo; }
    public void setSaldo(double saldo) { this.saldo = saldo; }
    public Persona getCliente() { return cliente; }
    public void setCliente(Persona cliente) { this.cliente = cliente; }

    public void ingresar(double cantidad){
        if(cantidad > 0){
            saldo += cantidad;
            System.out.println("Ingreso exitoso. Nuevo saldo: " + saldo);
        } else {
            System.out.println("Debe ingresar una cantidad mayor que 0");
        }
    }
    
    @Override
    public String toString() {
        return "Cuenta [Número de cuenta=" + numerocuenta + ", Saldo=" + saldo + ", Cliente=" + cliente.getNombre() + "]";
    }

    public abstract void retirar(double cantidad);
    public abstract void actualizarSaldo();
}