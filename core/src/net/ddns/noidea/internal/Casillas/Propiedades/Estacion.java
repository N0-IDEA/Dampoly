package net.ddns.noidea.internal.Casillas.Propiedades;

import net.ddns.noidea.internal.Casillas.PropiedadCasilla;

public class Estacion extends PropiedadCasilla {

    public Integer alquilerUnaEstacion;

    public Integer alquilerDosEstaciones;

    public Integer alquilerTresEstaciones;

    public Integer alquilerCuatroEstaciones;

    public Estacion(String nombre, Integer precio, Integer hipoteca,Integer alquilerUnaEstacion, Integer alquilerDosEstaciones, Integer alquilerTresEstaciones, Integer alquilerCuatroEstaciones) {
        super(nombre, precio, hipoteca);
    }
}
