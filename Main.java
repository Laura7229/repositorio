public class Main {
    public static void main(String[] args) {
        CuentaBancaria cb = new CuentaBancaria(100);
        cb.retirar(50);
        cb.depositar(50);
        cb.mostrarSaldo();
    }
}