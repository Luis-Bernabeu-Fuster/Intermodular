public class Developer extends Empresa{
    public Developer(int idEmpresa, String nombre, String pais) {
        super(idEmpresa, nombre, pais);
    }

    @Override
    public String toString() {
        return "Developer{" +
                "idEmpresa=" + idEmpresa +
                ", nombre='" + nombre + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }
}
