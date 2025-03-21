import java.util.InputMismatchException;
import java.util.Scanner;

public class Validar { //Luis Bernabeu Fuster

    private final static Scanner scanner  = new Scanner(System.in);

    public static int IdEmpresa(){
        boolean fin = false;
        System.out.print("Introduce la id: ");
        int id = tryCatch();
        while (!fin){
            if (id < 0){
                System.out.println("El id de la empresa no puede ser negativa");
                System.out.print("Introduc una nueva id: ");
                scanner.nextLine();
                id = tryCatch();
            } else {
                fin = true;
            }
        }
        return id;
    }

    public static int tryCatch(){
        int id = -1;
        boolean fin = false;
        while (!fin) {

            try {
                id = scanner.nextInt();
                scanner.nextLine();
                fin = true;
            } catch (InputMismatchException e) {
                System.out.println("Solo se permiten digitos");
                System.out.print("Introduzca la id: ");
                scanner.nextLine();
            }
        }
        return id;
    }

    public static String Nombre(){
        String name = "Pi";
        boolean fin = false;

        while (!fin){
            System.out.print("Introduzca el nuevo nombre: ");
            name = scanner.nextLine();
            if (name.length() > 32){
                System.out.println("El nombre no puede contener mas de 32 caracteres ");

            } else if (name.isEmpty()) {
                System.out.println("El nombre no puede estar vacio");
            } else {
                fin = true;
            }
        }
        return name;
    }

    public static String Pais(){
        boolean fin = false;
        String p = "World";
        char c1;

        while (!fin){
            System.out.print("Introduzca el nombre del país: ");
            p = scanner.nextLine();
            if (p.isEmpty()){
                System.out.println("El país no puede estar vacio");
            }else {
                c1 = p.charAt(0);
                if (Character.isDigit(c1)) {
                    System.out.println("No existe país que inicie mediante digito");

                } else if (p.length() > 32) {
                    System.out.println("El nombre del país no puede contener más de 32 digitos");

                } else {
                    fin = true;
                }
            }
        }
        return p;
    }

    public static int opcionMenu(){
        boolean fin = false;
        int opc = 0;
        while (!fin){
            System.out.print("Elige una opción: ");
            try {
                opc = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Escoja una opcion valida (1 - 7)");
                System.out.println("=============================================\n");
                scanner.nextLine();
                break;
            }
            if (opc <= 0 || opc > 7){
                System.out.println("Opción no valida (1 - 7)");
                System.out.println("=============================================\n");
                scanner.nextLine();
            } else {
                fin = true;
            }
        }
        return opc;
    }

    public static int opcionEmpresa(){
        boolean fin = false;
        int opc = 0;
        while (!fin){
            System.out.print("Elige una opción: ");
            try {
                opc = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Escoja una opcion valida (1 o 2)");
                System.out.println("=============================================\n");
                scanner.nextLine();
                break;
            }
            if (opc <= 0 || opc > 11){
                System.out.println("Opción no valida (1 o 2)");
                System.out.println("=============================================\n");
                scanner.nextLine();
            } else {
                fin = true;
            }
        }
        return opc;
    }

}
