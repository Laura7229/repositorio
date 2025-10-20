public class Profesor extends Persona {
    private int despacho;

    public Profesor(){
        super();
        this.despacho=0;
    }

    public Profesor(int despacho, String NIF, String apellidos, Direccion direccion, String nombre) {
        super(NIF, apellidos, direccion, nombre);
        this.despacho = despacho;
    }

    public int getDespacho() {
        return despacho;
    }

    public void setDespacho(int despacho) {
        this.despacho = despacho;
    }
    @Override
    public String toString() {
        return super.toString();
    }
}
