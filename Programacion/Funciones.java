import java.util.ArrayList;

public class Funciones {
    ArrayList<Empresa> empresas = new ArrayList<>();

    public Funciones() {
        this.empresas = new ArrayList<Empresa>();
    }

    private boolean findEmpresa(Empresa empresa){
        return this.empresas.contains(empresa);
    }

    public boolean findEmpresa(int clave){
        for (int i = 0 ; i < this.empresas.size(); i++){
            if (this.empresas.get(i).idEmpresa == clave){
                return true;
            }
        }
        System.out.println("Empresa no encontrada");
        return false;
    }

    public boolean addNewEmpresa(Empresa empresa){
        if (this.empresas.contains(empresa)){
            System.out.println("Error empresa ya existente !!!");
            return false;
        } else {
            System.out.println("Empresa agregada con exito 😃");
            this.empresas.add(empresa);
            return true;
        }
    }

    public void  printEmpresas(){
        for (int i = 0; i < this.empresas.size(); i++ ){
            System.out.println(this.empresas.get(i).toString());
        }
    }

}
