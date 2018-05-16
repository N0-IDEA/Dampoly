package net.ddns.noidea.internal;

import net.ddns.noidea.Dado;
import net.ddns.noidea.Utils.MathUtils;
import net.ddns.noidea.internal.Casillas.Casilla;

public class Jugador {

    public Jugador(Ficha ficha) {
        this.ficha = ficha;
        tiradaDisponible = true;
        tiradaTerminada = false;
        nTiradasDobles = 0;
    }

    private Boolean tiradaDisponible;
    private Boolean tiradaTerminada;

    public Integer dinero;

    private Integer nTiradasDobles;

    private Casilla casillaActual;

    public Integer nTurnosEncarcelado;

    public Tarjeta tarjetas;

    public Boolean encarcelado;

    private Ficha ficha;

    public Ficha getFicha() {
        return ficha;
    }

    public Casilla getCasillaActual() {
        return casillaActual;
    }

    public void setCasillaActual(Casilla casillaActual) {
        this.casillaActual = casillaActual;
    }

    public Boolean getTiradaDisponible() {
        return tiradaDisponible;
    }

    public Integer lanzarDados() {
        int tirada = 0;
        Dado dados[] = Tablero.getInstance().getDamPoly().getDados();

        for (int i = 0; i < 2; i++) {
            Dado dado = dados[i];
            int random = MathUtils.ramdon(1,6);
            dado.setNumber(random);
            tirada += random;
        }
        if (dados[0].getNumber() == dados[1].getNumber()) {
            nTiradasDobles++;
            //TODO Evento al ocurrir una tirada doble
        }

        Tablero.getInstance().getDamPoly().setShowDados(true);
        Tablero.getInstance().moverJugador(tirada);

        tiradaTerminada = true;

        return tirada;
    }

    public boolean terminarTurno() {
        if (tiradaTerminada)
            Tablero.getInstance().siguienteTurno();
        return tiradaTerminada;
    }

    public void declararBancarrota() {
    }

    public void notificarTurno() {

    }

    public void acabarTurno() {
    }

    public void usarTarjeta() {
    }

}

