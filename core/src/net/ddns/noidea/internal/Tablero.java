package net.ddns.noidea.internal;

import net.ddns.noidea.internal.Casillas.Casilla;
import net.ddns.noidea.internal.Casillas.Impuestos.ImpuestoCasilla;
import net.ddns.noidea.internal.Casillas.Impuestos.ImpuestoEspecialCasilla;
import net.ddns.noidea.internal.Casillas.Propiedades.Calle;
import net.ddns.noidea.internal.Casillas.Propiedades.Estacion;
import net.ddns.noidea.internal.Casillas.Propiedades.Servicio;
import net.ddns.noidea.internal.Casillas.SalidaCasilla;

import java.util.ArrayList;

public class Tablero {

    public Integer dineroInicial;

    public ArrayList<Jugador> jugadores;

    public Integer jugadorActual;

    private ArrayList<Casilla> casillas;

    public Tablero() {
        casillas = new ArrayList<Casilla>();
        cargarCasillas();
        jugadores = new ArrayList<Jugador>();
        dineroInicial = 20000;
    }

    public void siguienteTurno() {
    }

    public void empezarPartida() {
    }

    public void configurarPartida(Integer dineroInicial) {
        this.dineroInicial = dineroInicial;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void addJugador(Jugador jugador) {
        this.jugadores.add(jugador);
    }

    private void addCasilla(Casilla casilla) {
        casillas.add(casilla);
        casilla.setNumero(casillas.indexOf(casilla));
    }

    private void cargarCasillas() {
        addCasilla(new SalidaCasilla());
        addCasilla(new Calle("Calle Ejemplo",0, 0, 0, 0, 0, 0, 0, 0, 0 ,0));
        addCasilla(new ImpuestoCasilla("Impuesto", 5000));
        addCasilla(new ImpuestoEspecialCasilla("Impuesto Porcentaje", 10000, 25));
        addCasilla(new Estacion("Estacion sur", 20000, 10000));
        addCasilla(new Servicio("Servicio", 20000, 10000));
    }

}
