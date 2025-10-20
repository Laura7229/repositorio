import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
    ArrayList<Persona> personas = new ArrayList<>();
    personas.add(new Estudiante(0, "812", "la", new Direccion(), "mar"));
    personas.add(new Profesor(0, "null", "le", new Direccion(), "sol"));
            for (Persona persona : personas) {
                System.out.println(persona.getNombre());
                
            }
    }
    
}
