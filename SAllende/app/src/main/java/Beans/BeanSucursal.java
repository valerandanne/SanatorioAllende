package Beans;

/**
 * Created by Usuario on 03/11/2015.
 */
public class BeanSucursal {
    public String id;
    public String nombre;

    public BeanSucursal(String id, String nombre){
        this.id=id;
        this.nombre=nombre;
    }
    public String getId_Sucu(){
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
}
