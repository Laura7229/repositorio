import java.io.Serializable;

public class Direccion implements Serializable {
    private static final long serialVersionUID = 1L;
    private String calle;
    private String ciudad;
    private int codigo_postal;
    private String pais;

    public Direccion(String calle, String ciudad, int codigo_postal, String pais) {
        this.calle = calle;
        this.ciudad = ciudad;
        this.codigo_postal = codigo_postal;
        this.pais = pais;
    }
    public Direccion() {
        this.calle = "calle playa samil";
        this.ciudad = "madrid";
        this.codigo_postal = 20125;
        this.pais = "españa";
    }

    // Getters
    public String getCalle() { return calle; }
    public String getCiudad() { return ciudad; }
    public int getCodigo_postal() { return codigo_postal; }
    public String getPais() { return pais; }

    // Setters
    public void setCalle(String calle) { this.calle = calle; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }
    public void setCodigo_postal(int codigo_postal) { this.codigo_postal = codigo_postal; }
    public void setPais(String pais) { this.pais = pais; }

    @Override
    public String toString() {
        return "Direccion [calle=" + calle + ", ciudad=" + ciudad + ", codigo_postal=" + codigo_postal + ", pais=" + pais + "]";
    }
}
