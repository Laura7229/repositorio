import java.util.Scanner;
public class ejtres10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el número de un mes");
        int mes = sc.nextInt();
        System.out.println("Introduce el año");
        int a = sc.nextInt();
        boolean esBisiesto = (a % 4 == 0 && a % 100 != 0) || (a % 400 == 0);

        switch (mes) {
            case 1: case 3: case 5: case 7: case 8: case 10 : case 12:
                System.out.println("Este mes tiene 31 días");
                break;
            case 4: case 6: case 9: case 11:
            System.out.println("Este mes tiene 30 días");
            break;
            case 2:
            if(esBisiesto){
                System.out.println("Este mes tiene 29 días");
            }
            else{
                System.out.println("Este mes tiene 28 días");

            }
            break;
            default:
                System.out.println("Mes inválido");
        }  
        sc.close();
    }
    
}
