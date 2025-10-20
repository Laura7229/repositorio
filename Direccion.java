public class Direccion {
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


}
