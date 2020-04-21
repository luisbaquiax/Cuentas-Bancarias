package com.jgranados.cuentasbancarias;

/**
 * CuentasBancarias
 * @author jose - 11.03.2020 
 * @Title: Persona
 * @Description: description
 *
 * Changes History
 */
public class Persona {
    private String nombre;
    private String cui;
    
    public Persona(String nombre, String cui) {
        this.nombre = nombre;
        this.cui = cui;
    }

    public void mostrarDatos() {
        System.out.printf("Datos -> Nombre: %s, CUI: %s\n", this.nombre, this.cui);
    }
    
    public String obtenerNombre() {
        return this.nombre;
    }

}