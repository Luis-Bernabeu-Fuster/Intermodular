import java.util.Scanner;

public class Main { //Luis Bernabeu Fuster

    private final static Scanner scanner = new Scanner(System.in);

    public static int tipoEmpresa(){
        System.out.println("Escoja de que tipo es la empresa: ");
        System.out.println("1. DEVELOPER\n" + "2. EDITOR");
        int opc = Validar.opcionEmpresa();
        if (opc == 1){
            System.out.println("Empresa de tipo DEVELOPER");
            return 1;
        }else {
            System.out.println("Empresa de tipo EDITOR");
            return 2;
        }
    }
    public static void addEmpresa(Funciones funciones){


        boolean fin = true;
        int id;
        String nombre;
        String pais;

        String resp;
        while (fin){
            System.out.print("Desa añadir una nueva empresa (S/N): ");
            resp = scanner.next();

            if (resp.equalsIgnoreCase("S")){

                id = Validar.IdEmpresa();
                nombre = Validar.Nombre();
                pais = Validar.Pais();

                if (tipoEmpresa() == 1) {
                    funciones.addNewEmpresa(Developer.createEmpresa(id,nombre,pais));
                } else {
                    funciones.addNewEmpresa(Editor.createEmpresa(id,nombre,pais));
                }
            } else {
                System.out.println("Saliendo");
                fin = false;

            }
        }
    }

    public static void printEmpresa(Funciones funciones){
        funciones.printEmpresas();
    }

    public static void consultarEmpresa(){
        Validar validar = new Validar();
        Funciones funciones = new Funciones();
        int id;

        System.out.print("Introduzca el id para hacer la consulta: ");
        id = validar.IdEmpresa();
        funciones.findEmpresa(id);
    }

    public static void menu(Funciones funciones){

        boolean continuar = true;
        int opcion;
        while (continuar) {
            opcion = Validar.opcionMenu();

            switch (opcion) {
                case 1:
                    addEmpresa(funciones);
                    break;

                case 2:
                    funciones.printEmpresas();
                    break;

                case 4:
                    consultarEmpresa();
                    break;

                case 11:
                    System.out.println("Saliendo del programa");
                    continuar = false;
                    break;
            }
        }
    }

    public static void main(String[] args) {
        Funciones funciones = new Funciones();
       menu(funciones);
    }

}
