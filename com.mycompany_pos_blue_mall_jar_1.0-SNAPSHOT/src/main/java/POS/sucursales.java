/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POS;

import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 * @author NELSON
 */
public class sucursales implements Serializable{
    
     public static LinkedList<sucursales> datosSucursales = new LinkedList<>();
     
        int codigo;
        String nombre;
        String direccion;
        String correo;
        String telefono;

    public sucursales(int codigo, String nombre, String direccion, String correo, String telefono) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
    }

    public static LinkedList<sucursales> getDatosSucursales() {
        return datosSucursales;
    }

    public static void setDatosSucursales(LinkedList<sucursales> datosSucursales) {
        sucursales.datosSucursales = datosSucursales;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
        
        
}
