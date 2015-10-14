package Beans;

/**
 * Created by Agustina on 08/10/2015.
 */
public class BeanEspecialidad
{
    private String id_espe;
    private String descripcion;

    public BeanEspecialidad(String descripcion) {
        this.descripcion = descripcion;
    }

   /* public BeanEspecialidad(String id_espe) {
        this.id_espe = id_espe;
    }*/

    public BeanEspecialidad(String id_espe, String descripcion) {
        this.id_espe = id_espe;
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getId_espe() {
        return id_espe;
    }

    public void setId_espe(String id_espe) {
        this.id_espe = id_espe;
    }

    @Override
    public String toString() {
        return this.descripcion;
    }
}
