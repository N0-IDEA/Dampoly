package net.ddns.noidea.internal.Casillas.Impuestos;

public class ImpuestoEspecialCasilla extends ImpuestoCasilla {

    public Integer porcentaje;

    public ImpuestoEspecialCasilla(String nombre, int dinero, int porcentaje) {
        super(nombre, dinero);
        this.porcentaje = porcentaje;
    }
}
