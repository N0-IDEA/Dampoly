package net.ddns.noidea.internal.Casillas;

import net.ddns.noidea.internal.Jugador;
import net.ddns.noidea.internal.Tablero;

public class Casilla {

    public Casilla(String nombre) {
        this.nombre = nombre;
    }

    public String nombre;

    public Integer numero;

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Jugador jugadores;

    public void alEntrar() {
    }

}



