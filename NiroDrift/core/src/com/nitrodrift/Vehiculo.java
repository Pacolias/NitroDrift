package com.nitrodrift;

import com.badlogic.gdx.graphics.Texture;

/**
 * Creo que aquí debería ir el dibujarVehiculo y también los controles
 */

public class Vehiculo {
    private int ID;
    private String nombre;
    private String descripcion;
    private int precio;

    private Texture imagen;
    private EstadisticasVehiculo estadisticas;

    /**
     * Constructor de la clase
     * @param id int que será el identificador del vehículo
     * @param nom String que indicará el nombre del vehículo
     * @param desc String que describirá brevemente la historia del vehículo
     * @param p int que reflejará el precio en tokens del vehículo
     * @param im Texture que representa la imagen del vehiculo
     * @param e Instancia de la clase EstadísticasVehiculo que serán las estadísticas de este vehículo
     */
    public Vehiculo(int id, String nom, String desc, int p, Texture im, EstadisticasVehiculo e){
        this.ID = id;
        this.descripcion = desc;
        this.imagen = im;
        this.nombre = nom;
        this.precio = p;
        this.estadisticas = e;
    }

    /**
     * Constructor secundario del vehículo
     * @param id int que será el identificador del vehículo
     * @param n String que indicará el nombre del vehículo
     * @param d String que describirá brevemente la historia del vehículo
     * @param p int que reflejará el precio en tokens del vehículo
     * @param di String que será la ruta de la imagen para crear la textura del vehículo
     * @param vm float que será la velocidad máxima que alcanzará el vehículo
     * @param a float que será la aceleración del vehículo
     * @param c float que será la cantidad de choques máximos del vehículo
     */
    public Vehiculo (int id, String n, String d, int p, String di, float vm, float a, int c){
        this.ID = id;
        this.nombre = n;
        this.descripcion = d;
        this.precio = p;
        this.imagen = new Texture(di);
        this.estadisticas = new EstadisticasVehiculo(vm, a, c);
    }

    //Getters and setters
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Texture getImagen() {
        return imagen;
    }

    public void setImagen(Texture imagen) {
        this.imagen = imagen;
    }

    public EstadisticasVehiculo getEstadisticas() {
        return estadisticas;
    }

    public void setEstadisticas(EstadisticasVehiculo estadisticas) {
        this.estadisticas = estadisticas;
    }
}
