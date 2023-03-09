
package POS;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.LinkedList;


public class productos implements Serializable{
    
    public static LinkedList<productos> datosProductos = new LinkedList<>();
    
    int codigo;
    String nombre;
    String descripcion;
    int cantidad;
    BigDecimal precio;

    public productos(int codigo, String nombre, String descripcion, int cantidad, BigDecimal ventas) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = ventas;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal ventas) {
        this.precio = ventas;
    }
    
    
}
