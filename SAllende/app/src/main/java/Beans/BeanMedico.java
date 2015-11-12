package Beans;

/**
 * Created by Usuario on 14/10/2015.
 */
public class BeanMedico implements Comparable<BeanMedico>{

    private String nombre;
    private String sucursal;

    public BeanMedico(String nombre, String sucursal) {
        this.nombre = nombre;
        this.sucursal = sucursal;
    }

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

    @Override
    public String toString() {
        return this.nombre;
    }

    @Override
    public int compareTo(BeanMedico another) {
        return 0;
    }
}