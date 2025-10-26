import java.io.Serializable;

public class Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nombre;
    private String apellidos;
    private String NIF;
    private Direccion direccion; // Asumo que este campo existe por los constructores de Estudiante/Profesor
    private String pin; // Agregado para el inicio de sesión

    public Persona() {
        this.NIF = "";
        this.apellidos = "";
        this.direccion = new Direccion();
        this.nombre = "";
        this.pin = "0000";
    }

    public Persona(String NIF, String apellidos, Direccion direccion, String nombre, String pin) {
        this.NIF = NIF;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.nombre = nombre;
        this.pin = pin;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }
    public String getNIF() { return NIF; }
    public void setNIF(String NIF) { this.NIF = NIF; }
    public Direccion getDireccion() { return direccion; }
    public void setDireccion(Direccion direccion) { this.direccion = direccion; }
    public String getPin() { return pin; }
    public void setPin(String pin) { this.pin = pin; }
    
    @Override
    public String toString() {
        return "Persona [nombre=" + nombre + ", apellidos=" + apellidos + ", NIF=" + NIF + ", direccion=" + direccion + "]";
    }
}

