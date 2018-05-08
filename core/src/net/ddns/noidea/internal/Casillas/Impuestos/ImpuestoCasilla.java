package net.ddns.noidea.internal.Casillas.Impuestos;

import net.ddns.noidea.internal.Casillas.Casilla;

public class ImpuestoCasilla extends Casilla {

    public Integer dinero;

    public ImpuestoCasilla(String nombre, int dinero) {
        super(nombre);
        this.dinero = dinero;
    }
    public void cobrar() {
    }

}
