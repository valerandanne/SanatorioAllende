package Beans;

/**
 * Created by Agustina on 08/10/2015.
 */
public class BeanEspecialidad
{

    private String descripcion;

    public BeanEspecialidad( String descripcion) {

        this.descripcion = descripcion;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    @Override
    public String toString() {
        return this.descripcion;
    }
}
