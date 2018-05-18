package net.ddns.noidea.internal.Casillas;

import net.ddns.noidea.internal.Casillas.Casilla;
import net.ddns.noidea.internal.Jugador;
import net.ddns.noidea.internal.Tablero;

import java.util.ArrayList;

import static net.ddns.noidea.internal.Jugador.*;


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

    // Es necesario tener un objeto jugador para tomar el dinero
    // Jugador j1 = new Jogador()
    // una vez que lo tenga, lo llamo con j1.getDinerio();
    public void comprarla(Jugador jugador) {
            if (propietario != null)
                System.out.println();
            else {
                if (precio > jugador.dinero)
                    System.out.println();
                else {
                    jugador.dinero -= precio;
                    propietario = jugador;
                    System.out.println();
                    jugador.addPropiedad(this);
                    }
            }

    }

    public void pagarAlquiler() {
    }

    public void desHipotecar() {
    }

}
