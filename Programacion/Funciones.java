import java.util.ArrayList;

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
        if (this.empresas.isEmpty()){
            System.out.println("De momento esta vacio");
        } else {
            System.out.println("<listado_empresas>\n");
            for (int i = 0; i < this.empresas.size();i++){
                System.out.println("    <empresa>");
                System.out.println("        <id>" + this.empresas.get(i).idEmpresa + "</id>");
                System.out.println("        <nombre>" + this.empresas.get(i).nombre + "</nombre>");
                System.out.println("        <pais>" + this.empresas.get(i).pais + "</pais>");
                if (this.empresas.get(i).toString().contains("Developer")){
                    System.out.println("        <tipo>Developer</tipo>");
                }else {
                    System.out.println("        <tipo>Editor</tipo>");
                }
                System.out.println("    </empresa>\n");

            }
            System.out.println("</listado_empresas>");
        }
    }

}
