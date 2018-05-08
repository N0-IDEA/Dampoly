package net.ddns.noidea.internal.Casillas;

import net.ddns.noidea.internal.Casillas.Casilla;
import net.ddns.noidea.internal.Jugador;

public class PropiedadCasilla extends Casilla {

    public Integer precio;

    public Integer hipoteca;

    public Boolean hipotecado;

    public Jugador propietario;

    public Jugador tiene;

    public PropiedadCasilla(String nombre, Integer precio, Integer hipoteca) {
        super(nombre);
    }

    public Boolean isHipotecable() {
        return false;
    }

    public void hipotecarPropiedad() {
    }

    public void comprarla() {
    }

    public void pagarAlquiler() {
    }

    public void desHipotecar() {
    }

}
