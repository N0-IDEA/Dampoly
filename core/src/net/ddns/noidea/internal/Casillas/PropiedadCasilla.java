package net.ddns.noidea.internal.Casillas;

import net.ddns.noidea.internal.Casillas.Casilla;
import net.ddns.noidea.internal.Jugador;
import net.ddns.noidea.internal.Tablero;


public class PropiedadCasilla extends Casilla {

    public Integer precio;

    public Integer hipoteca;

    public Boolean hipotecado;

    public Jugador propietario;

    public Jugador tiene;

    public PropiedadCasilla(String nombre, Integer precio, Integer hipoteca) {
        super(nombre);
        this.precio = precio;
        this.hipoteca = hipoteca;
    }

    public Boolean isHipotecable() {
        return false;
    }

    public void hipotecarPropiedad() {
    }

    public void comprarla() {
        if (casilla instanceof PropiedadCasilla) {
            PropiedadCasilla propiedadCasilla = (PropiedadCasilla) casilla;
            if (propietario != null)
                System.out.println();
            else {
                if (precio > Jugador.dinero)
                    System.out.println();
                else {
                    Jugador.dinero -= precio;
                    propietario = Jugador.;
                    System.out.println();
                    Jugador.haz(this);
                    }
            }
        }
        else
        {
            System.out.println();
        }
        }

    public void pagarAlquiler() {
    }

    public void desHipotecar() {
    }

}
