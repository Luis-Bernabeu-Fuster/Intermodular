public class Editor extends Empresa{
    public Editor(int idEmpresa, String nombre, String pais) {
        super(idEmpresa, nombre, pais);
    }

    @Override
    public String toString() {
        return "Editor{" +
                "idEmpresa=" + idEmpresa +
                ", nombre='" + nombre + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }
}
