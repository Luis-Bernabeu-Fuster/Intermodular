public class Developer extends Empresa{ //Luis Bernabeu Fuster
    public Developer(int idEmpresa, String nombre, String pais) {
        super(idEmpresa, nombre, pais);
    }

    public static Developer createEmpresa(int idEmpresa,String nombre,String pais){
        Developer developer = new Developer(idEmpresa,nombre,pais);
        return developer;
    }

    @Override
    public String toString() {
        return "Developer: " +
                "idEmpresa: " + idEmpresa +
                ", nombre: '" + nombre + '\'' +
                ", pais: '" + pais + '\'';
    }
}
