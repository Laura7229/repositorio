import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        
        Direccion dir1 = new Direccion("Avenida Luna", "Sevilla", 41001, "España");
        Direccion dir2 = new Direccion("Rue du Soleil", "Paris", 75001, "Francia");
        
        ArrayList<Persona> personas = new ArrayList<>();
        
        personas.add(new Estudiante(
            1001, 
            "12345678A", 
            "Martínez", 
            dir1, 
            "Ana"
        ));
        
        personas.add(new Profesor(
            305, 
            "87654321B", 
            "García", 
            dir2, 
            "Javier"
        ));
        
        System.out.println("--- Lista de Personas ---");
        for (Persona persona : personas) {
            System.out.println(persona.toString());
        }
        
        System.out.println("\n--- Acceso a campos específicos ---");
        
        System.out.println("El nombre del primer estudiante es: " + personas.get(0).getNombre());
     
        if (personas.get(1) instanceof Profesor) {
            Profesor profesor = (Profesor) personas.get(1);
            System.out.println("El despacho del profesor es: " + profesor.getDespacho());
        }
    }
}
