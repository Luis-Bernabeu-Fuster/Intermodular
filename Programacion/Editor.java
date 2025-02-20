public class Editor extends Empresa{ //Luis Bernabeu Fuster
    public Editor(int idEmpresa, String nombre, String pais) {
        super(idEmpresa, nombre, pais);
    }

    public static Editor createEmpresa(int idEmpresa,String nombre,String pais){
        Editor editor = new Editor(idEmpresa,nombre,pais);
        return editor;
    }

    @Override
    public String toString() {
        return "Editor: " +
                "idEmpresa: " + idEmpresa +
                ", nombre: '" + nombre + '\'' +
                ", pais: '" + pais + '\'';
    }
}
