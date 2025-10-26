import java.io.Serializable;

public class CuentoAhorro extends Cuenta implements Serializable { // Nombre original del archivo mantenido
    private static final long serialVersionUID = 1L;
    private double interes_variable;
    private double saldo_minimo;

    public CuentoAhorro(double interes_variable, double saldo_minimo, Persona cliente, int numerocuenta, double saldo) {
        super(cliente, numerocuenta, saldo);
        this.interes_variable = interes_variable;
        this.saldo_minimo = saldo_minimo;
    }

    public double getInteres_variable() { return interes_variable; }
    public void setInteres_variable(double interes_variable) { this.interes_variable = interes_variable; }
    public double getSaldo_minimo() { return saldo_minimo; }
    public void setSaldo_minimo(double saldo_minimo) { this.saldo_minimo = saldo_minimo; }

    @Override
    public void retirar(double cantidad){
        if (cantidad <= 0) {
            System.out.println("La cantidad a retirar debe ser positiva.");
        } else if (getSaldo() - cantidad >= saldo_minimo) {
            setSaldo(getSaldo() - cantidad);
            System.out.println("Retiro exitoso. Nuevo saldo: " + getSaldo());
        } else {
            System.out.println("Retiro denegado: el saldo restante sería inferior al mínimo (" + saldo_minimo + ").");
        }
    }

    @Override
    public void actualizarSaldo() {
        double interesGanado = getSaldo() * interes_variable;
        setSaldo(getSaldo() + interesGanado);
        System.out.println("Saldo actualizado con interés variable (" + (interes_variable*100) + "%). Nuevo saldo: " + getSaldo());
    }
    
    @Override
    public String toString() {
        return "CuentaAhorro [" + super.toString() + ", Interés=" + (interes_variable*100) + "%, Saldo Mínimo=" + saldo_minimo + "]";
    }
}