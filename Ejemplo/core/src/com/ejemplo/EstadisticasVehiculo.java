package com.ejemplo;

import com.badlogic.gdx.Gdx;

public class EstadisticasVehiculo {
	private float velocidadMaxima;
	private float velocidad;
    private int aceleracion;


    public EstadisticasVehiculo(int v, int a, int m) {
    	this.velocidadMaxima = v;
    	this.velocidad = 0;
    	this.aceleracion = a;
    }
    
    public float velocidadMaxima() {
    	return velocidadMaxima;
    }
    
    public int aceleracion() {
    	return aceleracion;
    }
    
    public float velocidad() {
    	return velocidad;
    }
    
    protected void setVelocidad() {
    	velocidad = velocidad + aceleracion * Gdx.graphics.getDeltaTime();
    }
    
    
    
}
