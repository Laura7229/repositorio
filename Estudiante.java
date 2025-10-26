import java.io.Serializable;

public class Estudiante extends Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    private int ID_estudiante;

    public Estudiante(){
        super();
        this.ID_estudiante=0;
    }
    // Constructor actualizado para Persona
    public Estudiante(int ID_estudiante, String NIF, String apellidos, Direccion direccion, String nombre, String pin) {
        super(NIF, apellidos, direccion, nombre, pin);
        this.ID_estudiante = ID_estudiante;
    }

    public int getID_estudiante() { return ID_estudiante; }
    public void setID_estudiante(int ID_estudiante) { this.ID_estudiante = ID_estudiante; }
    
    @Override
    public String toString() {
        return "Estudiante [ID_estudiante=" + ID_estudiante + ", " + super.toString() + "]";
    }
}

