
import java.util.Scanner;

public class dos {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce un número:");
        int num = sc.nextInt();
        for (int i = 0; i <= 10; i++) {
            int j = i * num;
            System.out.println(num+" x "+i+" = "+j);
        }
    }
}
