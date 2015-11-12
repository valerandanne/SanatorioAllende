package Beans;

/**
 * Created by Agustina on 14/10/2015.
 */
public class BeanCobertura
{
    private String id_Cob;
    private String nombre;

    public BeanCobertura(String id_Cob, String nombre) {
        this.id_Cob = id_Cob;
        this.nombre = nombre;
    }

    public BeanCobertura(String nombre)
    {
        this.nombre=nombre;
    }

    public String getId_Cob() {
        return id_Cob;
    }

    public void setId_Cob(String id_Cob) {
        this.id_Cob = id_Cob;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String toString() {

        return this.nombre;
    }
}
