class CuentaBancaria {
    double saldo;

    public CuentaBancaria(double saldo) {
        this.saldo = saldo;
    }
    public void depositar(double dinero){
        if (dinero >0) { 
            saldo+=dinero;
        }
    }
    public void retirar(double dinero){
        if (saldo >= dinero) { 
            saldo-=dinero;
        }else{
            System.out.println("fondos insuficientes");
        }

    }
    public void mostrarSaldo(){
        System.out.println("El saldo es: "+saldo);
    }
}
