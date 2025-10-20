public class Estudiante extends Persona{
    private int ID_estudiante;


    public Estudiante(){
        super();
        this.ID_estudiante=0;
    }
    public Estudiante(int ID_estudiante, String NIF, String apellidos, Direccion direccion, String nombre) {
        super(NIF, apellidos, direccion, nombre);
        this.ID_estudiante = ID_estudiante;
    }

    public int getID_estudiante() {
        return ID_estudiante;
    }

    public void setID_estudiante(int ID_estudiante) {
        this.ID_estudiante = ID_estudiante;
    }
    @Override
    public String toString() {

        return super.toString();
    }


}
