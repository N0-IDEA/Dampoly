package net.ddns.noidea.internal.Casillas;

import net.ddns.noidea.internal.Jugador;

import java.util.ArrayList;

public class Casilla {

    public Casilla(String nombre) {
        this.nombre = nombre;
        this.jugadores = new ArrayList<Jugador>();
    }

    private String nombre;

    private Integer numero;

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public ArrayList<Jugador> jugadores;

    public void addJugador(Jugador jugador) {
        Casilla casilla = jugador.getCasillaActual();
        if (casilla != null)
            casilla.removeJugador(jugador);
        jugador.setCasillaActual(this);
        jugadores.add(jugador);
    }

    public void removeJugador(Jugador jugador) {
        jugadores.remove(jugador);
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void alEntrar() {
    }

}



