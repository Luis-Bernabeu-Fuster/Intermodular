public class Empresa {  //Luis Bernabeu Fuster
    protected int idEmpresa;
    protected String nombre;
    protected String pais;


    public Empresa(int idEmpresa, String nombre, String pais) {
        this.idEmpresa = idEmpresa;
        this.nombre = nombre;
        this.pais = pais;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public static Empresa createEmpresa(int idEmpresa,String nombre,String pais){
        Empresa empresa = new Empresa(idEmpresa,nombre,pais);
        return empresa;
    }

    @Override
    public String toString() {
        return "\nEmpresa: " +
                "Id Empresa: " + idEmpresa +
                " , Nombre: " + nombre +
                " , País: " + pais;
    }
}