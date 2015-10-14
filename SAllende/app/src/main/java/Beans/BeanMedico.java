package Beans;

/**
 * Created by Usuario on 14/10/2015.
 */
public class BeanMedico {

    private int id;
    private String nombre;
    private String sucursal;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BeanMedico(String nombre, String sucursal) {
        this.nombre = nombre;
        this.sucursal = sucursal;
    }

    @Override
    public String toString() {
        return "BeanMedico{" +
                "sucursal='" + sucursal + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
