/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POS;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.LinkedList;


public class vendedores implements Serializable {
    
    public static LinkedList<vendedores> datos = new LinkedList<>();
    
    int codigo;
    String nombre;
    int caja;
    BigDecimal ventas;
    String genero;
    String contrasenia;

    public vendedores(int codigo, String nombre, int caja, BigDecimal ventas, String genero, String contrasenia) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.caja = caja;
        this.ventas = ventas;
        this.genero = genero;
        this.contrasenia = contrasenia;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
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

    public int getCaja() {
        return caja;
    }

    public void setCaja(int caja) {
        this.caja = caja;
    }

    public BigDecimal getVentas() {
        return ventas;
    }

    public void setVentas(BigDecimal ventas) {
        this.ventas = ventas;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    
    
    
}
