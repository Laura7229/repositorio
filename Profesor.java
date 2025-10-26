import java.io.Serializable;

public class Profesor extends Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    private int despacho;

    public Profesor(){
        super();
        this.despacho=0;
    }

    // Constructor actualizado para Persona
    public Profesor(int despacho, String NIF, String apellidos, Direccion direccion, String nombre, String pin) {
        super(NIF, apellidos, direccion, nombre, pin);
        this.despacho = despacho;
    }

    public int getDespacho() { return despacho; }
    public void setDespacho(int despacho) { this.despacho = despacho; }
    
    @Override
    public String toString() {
        return "Profesor [despacho=" + despacho + ", " + super.toString() + "]";
    }
}
