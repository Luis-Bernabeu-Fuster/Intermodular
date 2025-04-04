import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Scanner;

public class Funciones { //Luis Bernabeu Fuster
    ArrayList<Empresa> empresas = new ArrayList<>();

    public Funciones() {
        this.empresas = new ArrayList<Empresa>();
    }

    private boolean findEmpresa(Empresa empresa){
        for (int i = 0; i < this.empresas.size(); i++){
            if (this.empresas.get(i).equals(empresa)){
                return true;
            }
        }
        return false;
    }

    public boolean findEmpresa(int clave){
        for (int i = 0 ; i < this.empresas.size(); i++){
            if (this.empresas.get(i).idEmpresa == clave){
                System.out.println(this.empresas.get(i).toString());
                return true;
            }
        }
        return false;
    }

    public boolean addNewEmpresa(Developer developer, Editor editor,int tpe){

        if (tpe == 1) {
            if (findEmpresa(developer.getIdEmpresa())) {
                System.out.println("Error empresa ya existente !!!");
                return false;
            } else {
                System.out.println("Empresa agregada con exito 😃");
                this.empresas.add(developer);
                return true;
            }
        }else {
            if (findEmpresa(editor.getIdEmpresa())){
                System.out.println("Error empresa ya existente !!!");
                return false;
            } else {
                System.out.println("Empresa agregada con exito 😃");
                this.empresas.add(editor);
                return true;
                }
            }
    }

    public void  printEmpresas(){
        for (int i = 0; i < this.empresas.size(); i++ ){
            System.out.println(this.empresas.get(i).toString());
        }
    }

    public Empresa queryEmpresa(int id){
        for (int i = 0; i < this.empresas.size(); i++){
            if (this.empresas.get(i).getIdEmpresa() == id){
                return  this.empresas.get(i);
            }
        }
        return null;
    }

    public boolean removeEmpresa( Empresa empresa){
        if (this.empresas.contains(empresa)){
            this.empresas.remove(empresa);
            return true;
        } else {
            return false;
        }
    }

    public boolean updateEmpresa( Empresa anteUp, Empresa postUp){
        if (this.empresas.contains(anteUp) && !this.empresas.contains(postUp)){
            int a =this.empresas.indexOf(anteUp);
            this.empresas.set(a,postUp);
            System.out.println("Actualizado exitosamente ");
            return true;
        } else {
            System.out.println("Error algo salio mal");
            return false;
        }
    }

    public void generarXML(){
        String nombrecalss = Empresa.class.getSimpleName();
        Field[] clase = Empresa.class.getDeclaredFields();
        String tipo1 = Developer.class.getSimpleName();
        String tipo2 = Editor.class.getSimpleName();
        String etiqueta1 = clase[0].getName();
        String etiqueta2 = clase[1].getName();
        String etiqueta3 = clase[2].getName();

        if (this.empresas.isEmpty()){
            System.out.println("Actualmente no existe información para guardar");
        } else {
            try {
                FileWriter f = new FileWriter("listadoEmpresas.xml");
                BufferedWriter buf = new BufferedWriter(f);
                buf.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
                buf.write("<listado_empresas>\n");
                for (int i = 0; i < this.empresas.size(); i++) {
                    buf.write("    <" + nombrecalss + ">\n");
                    buf.write("        <" + etiqueta1 + ">" + this.empresas.get(i).idEmpresa + "</" + etiqueta1 + ">\n");
                    buf.write("        <" + etiqueta2 + ">" + this.empresas.get(i).nombre + "</" + etiqueta2 + ">\n");
                    buf.write("        <" + etiqueta3 + ">" + this.empresas.get(i).pais + "</" + etiqueta3 + ">\n");
                    if (this.empresas.get(i).toString().contains("Developer")) {
                        buf.write("        <tipo>" + tipo1 + "</tipo>\n");
                    } else {
                        buf.write("        <tipo>" + tipo2 + "</tipo>\n");
                    }
                    buf.write("    </" + nombrecalss + ">\n");
                }
                buf.write("</listado_empresas>");
                buf.close();
                System.out.println("XML generado con exito");
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void leerXML(){

            File f = new File("listadoEmpresas.xml");
            String contet;
            Scanner lee;
        try {
            lee = new Scanner(f);
                while (lee.hasNextLine()) {
                    contet = lee.nextLine();
                    System.out.println(contet);
                }
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }



}
