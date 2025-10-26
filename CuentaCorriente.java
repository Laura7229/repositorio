import java.io.Serializable;

public class CuentaCorriente extends Cuenta implements Serializable {
    private static final long serialVersionUID = 1L;
    private double interes_fijo = 0.015;

    public CuentaCorriente(Persona cliente, int numerocuenta, double saldo) {
        super(cliente, numerocuenta, saldo);
    }
    
    // Sobrecargado del constructor original
    public CuentaCorriente(double interes, Persona cliente, int numerocuenta, double saldo) {
        super(cliente, numerocuenta, saldo);
        this.interes_fijo = interes;
    }

    @Override
    public void retirar(double cantidad){
        if (cantidad > 0 && cantidad <= getSaldo()) {
            setSaldo(getSaldo() - cantidad);
            System.out.println("Retiro exitoso. Nuevo saldo: " + getSaldo());
        } else {
            System.out.println("Retiro denegado: La cantidad es mayor que el saldo disponible.");
        }
    }

    @Override
    public void actualizarSaldo() {
        double interesGanado = getSaldo() * interes_fijo;
        setSaldo(getSaldo() + interesGanado);
        System.out.println("Saldo actualizado con interés fijo (" + (interes_fijo*100) + "%). Nuevo saldo: " + getSaldo());
    }
    
    @Override
    public String toString() {
        return "CuentaCorriente [" + super.toString() + ", Interés Fijo=" + (interes_fijo*100) + "%]";
    }
}