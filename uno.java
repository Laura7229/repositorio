
import java.util.Scanner;

public class uno{
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce la base:");
        int base = sc.nextInt();
        System.out.print("Introduce la altura:");
        int altura = sc.nextInt();

        double perimetro= 2*(base+altura);
        System.out.print("El perimetro es :"+perimetro);

    }
}