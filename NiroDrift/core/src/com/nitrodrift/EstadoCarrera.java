package com.nitrodrift;

public class EstadoCarrera  implements  Estado{
    tipoEstado tipo;
    Carrera carrera;

    public EstadoCarrera(){
        tipo = tipoEstado.CARRERA;
    }
    @Override
    public void dibujarEstado(NitroDrift game) {

    }
}
