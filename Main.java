import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;

public class Main {
    private static final String FILE_NAME = "cuentas.ser";
    private Scanner sc = new Scanner(System.in);
    private ArrayList<Cuenta> cuentas;

    public Main() {
        // Cargar cuentas al iniciar
        this.cuentas = cargarCuentas();
        if (this.cuentas.isEmpty()) {
            System.out.println("No se encontraron cuentas guardadas. Inicie creando una cuenta.");
        } else {
            System.out.println("Cuentas cargadas exitosamente (" + this.cuentas.size() + " cuentas).");
        }
    }

    private void menuPrincipal() {
        while (true) {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Crear cuenta");
            System.out.println("2. Iniciar sesión");
            System.out.println("3. Salir y Guardar");
            System.out.print("Elige una opción: ");

            try {
                if (sc.hasNextInt()) {
                    int opcion = sc.nextInt();
                    sc.nextLine(); // Consumir nueva línea
                    
                    switch (opcion) {
                        case 1:
                            crearCuenta();
                            break;
                        case 2:
                            iniciarSesion();
                            break;
                        case 3:
                            guardarCuentas();
                            System.out.println("Datos guardados. ¡Adiós!");
                            return;
                        default:
                            System.out.println("Opción inválida.");
                    }
                } else {
                    System.out.println("Entrada inválida. Por favor, introduce un número.");
                    sc.next(); // Consumir la entrada inválida
                }
            } catch (Exception e) {
                System.out.println("Ocurrió un error inesperado: " + e.getMessage());
                sc.nextLine(); // Limpiar el buffer
            }
        }
    }

    private void crearCuenta() {
        System.out.println("\n--- Creación de Cuenta ---");
        System.out.print("Introduce tu Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Introduce tu Apellido: ");
        String apellido = sc.nextLine();
        System.out.print("Introduce tu NIF: ");
        String nif = sc.nextLine();

        String pin;
        do {
            System.out.print("Introduce tu PIN (4 cifras): ");
            pin = sc.nextLine();
            if (pin.length() != 4 || !pin.matches("\\d+")) {
                System.out.println("El PIN debe ser un número de 4 dígitos.");
            }
        } while (pin.length() != 4 || !pin.matches("\\d+"));

        System.out.print("Introduce el saldo inicial (mínimo 0): ");
        double saldoInicial;
        try {
            saldoInicial = sc.nextDouble();
            sc.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Saldo inicial inválido. Se usará 0.");
            saldoInicial = 0;
            sc.nextLine();
        }
        
        System.out.print("Introduce 1 (Cuenta Corriente) o 2 (Cuenta Ahorro): ");
        int tipoCuenta = 0;
        try {
            tipoCuenta = sc.nextInt();
            sc.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Tipo de cuenta inválido. Abortando creación.");
            sc.nextLine();
            return;
        }
        
        // Crear cliente y número de cuenta único
        Direccion dir = new Direccion(); // Dirección por defecto
        Persona nuevoCliente = new Persona(nif, apellido, dir, nombre, pin);
        int numeroCuenta = (int) (Math.random() * 9000000) + 1000000; // Número de 7 dígitos

        if (tipoCuenta == 1) {
            cuentas.add(new CuentaCorriente(nuevoCliente, numeroCuenta, saldoInicial));
            System.out.println("Cuenta Corriente creada con éxito. N° Cuenta: " + numeroCuenta);
        } else if (tipoCuenta == 2) {
            // Valores por defecto para Cuenta Ahorro
            cuentas.add(new CuentoAhorro(0.05, 100.0, nuevoCliente, numeroCuenta, saldoInicial));
            System.out.println("Cuenta Ahorro creada con éxito. N° Cuenta: " + numeroCuenta);
        } else {
            System.out.println("Opción de cuenta no válida. Abortando creación.");
        }
    }

    private void iniciarSesion() {
        System.out.print("Introduce tu NIF: ");
        String nif = sc.nextLine();
        System.out.print("Introduce tu PIN: ");
        String pin = sc.nextLine();

        Cuenta cuentaEncontrada = null;
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getCliente().getNIF().equals(nif) && cuenta.getCliente().getPin().equals(pin)) {
                cuentaEncontrada = cuenta;
                break;
            }
        }

        if (cuentaEncontrada != null) {
            System.out.println("\nInicio de sesión exitoso. ¡Bienvenido/a, " + cuentaEncontrada.getCliente().getNombre() + "!");
            menuOperaciones(cuentaEncontrada);
        } else {
            System.out.println("NIF o PIN incorrectos, o la cuenta no existe.");
        }
    }
    
    private void menuOperaciones(Cuenta cuenta) {
        while (true) {
            System.out.println("\n--- Menú de Operaciones ---");
            System.out.println("Cuenta: " + cuenta.getNumerocuenta());
            System.out.println("1. Consultar Saldo");
            System.out.println("2. Ingresar Dinero");
            System.out.println("3. Retirar Dinero");
            System.out.println("4. Actualizar Saldo (Intereses/Comisiones)");
            System.out.println("5. Cerrar Sesión");
            System.out.print("Elige una opción: ");

            try {
                int opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.println("Saldo actual: " + cuenta.getSaldo() + "€");
                        break;
                    case 2:
                        System.out.print("Cantidad a ingresar: ");
                        double ingreso = sc.nextDouble();
                        sc.nextLine();
                        cuenta.ingresar(ingreso);
                        break;
                    case 3:
                        System.out.print("Cantidad a retirar: ");
                        double retiro = sc.nextDouble();
                        sc.nextLine();
                        cuenta.retirar(retiro);
                        break;
                    case 4:
                        cuenta.actualizarSaldo();
                        break;
                    case 5:
                        System.out.println("Sesión cerrada.");
                        return;
                    default:
                        System.out.println("Opción inválida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, introduce un número.");
                sc.nextLine(); // Limpiar buffer
            }
        }
    }

    // --- Persistencia de Datos ---
    
    private void guardarCuentas() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(cuentas);
        } catch (IOException e) {
            System.out.println("Error al guardar cuentas: " + e.getMessage());
        }
    }

    private ArrayList<Cuenta> cargarCuentas() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (ArrayList<Cuenta>) ois.readObject();
        } catch (FileNotFoundException e) {
            // Es normal si el archivo no existe la primera vez
            return new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar cuentas. Creando lista vacía: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        Main a = new Main();
        a.menuPrincipal();
    }
}
