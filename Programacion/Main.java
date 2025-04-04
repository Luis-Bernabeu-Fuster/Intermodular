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
        int tpe;

        id = Validar.IdEmpresa();
        nombre = Validar.Nombre();
        pais = Validar.Pais();
        tpe = tipoEmpresa();

        funciones.addNewEmpresa(Developer.createEmpresa(id,nombre,pais),Editor.createEmpresa(id,nombre,pais),tpe);
        System.out.println("\n================================================");
    }


    public static void printEmpresa(Funciones funciones){
        funciones.printEmpresas();
    }

    public static void consultarEmpresa(Funciones funciones){

        int id = Validar.IdEmpresa();

        if (funciones.queryEmpresa(id) == null){
            System.out.println("No existe la empresa indicada");
        } else {
            System.out.println(funciones.queryEmpresa(id));
        }
    }

    public static void opciones(){
        System.out.println("================================================\n");
        System.out.println("1. Añadir Empresa\n" +
                            "2. Eliminar Empresa\n" +
                            "3. Actualizar Empresa\n" +
                            "4. Consultar Empresa\n" +
                            "5. Imprimir todas las Empresas\n" +
                            "6. Generar archivo XML\n" +
                            "7. Leer archivo XML\n" +
                            "8. Salir.");
        System.out.println("\n================================================\n");
    }

    public static void menu(Funciones funciones){

        boolean continuar = true;
        int opcion;
        while (continuar) {
            opciones();
            opcion = Validar.opcionMenu();
            System.out.println("\n================================================\n");

            switch (opcion) {
                case 1:
                    System.out.println("--- Añadir Empresa ---");
                    addEmpresa(funciones);
                    break;

                case 2:
                    System.out.println("--- Eliminar Empresa ---");
                    opcion = Validar.IdEmpresa();

                    Empresa borrar = funciones.queryEmpresa(opcion);

                    if (funciones.removeEmpresa(borrar)){
                        System.out.println("Se elimino la empresa");
                    } else {
                        System.out.println("Error no existe esa empresa");
                    }
                    break;

                case 3:
                    System.out.println("--- Actualizar Empresa ---");
                    opcion = Validar.IdEmpresa();

                    if (funciones.queryEmpresa(opcion) == null){
                        System.out.println("La empresa no existe");
                    } else {
                        Empresa anteUp = funciones.queryEmpresa(opcion);

                        int id = opcion;
                        String name = Validar.Nombre();
                        String pais = Validar.Pais();

                        if (tipoEmpresa() == 1){
                            Empresa postUp = new Developer(id,name,pais);
                            funciones.updateEmpresa(anteUp,postUp);
                        } else {
                            Empresa postUp = new Editor(id,name,pais);
                            funciones.updateEmpresa(anteUp,postUp);
                        }

                    }
                    break;

                case 4:
                    System.out.println("--- Consultar Empresa---");
                    consultarEmpresa(funciones);
                    break;

                case 5:
                    System.out.println("Lista actual: ");
                    printEmpresa(funciones);
                    break;

                case 6:
                    System.out.println("--- Formato XML ---");
                    funciones.generarXML();
                    break;

                case 7:
                    System.out.println("--- Leer XML ---");
                    funciones.leerXML();
                    break;

                case 8:
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
