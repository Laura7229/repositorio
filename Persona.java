public class Persona {
    private String nombre;
    private String apellidos;
    private String NIF;
    private Direccion direccion;

   
    

    public Persona() {
        this.NIF = "";
        this.apellidos = "";
        this.direccion = new Direccion();
        this.nombre = "";
    }

    public Persona(String NIF, String apellidos, Direccion direccion, String nombre) {
        this.NIF = NIF;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.nombre = nombre;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

}
