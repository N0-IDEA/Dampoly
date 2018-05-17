package net.ddns.noidea.internal.Casillas;

import net.ddns.noidea.internal.Casillas.Casilla;
import net.ddns.noidea.internal.Jugador;
import net.ddns.noidea.internal.Tablero;
import net.ddns.fquintana.ConsoleCommands.CommandsCore.ColoredConsole;

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

    public void comprarla(ColoredConsole coloredConsole, String[] strings) {
        if (casilla instanceof PropiedadCasilla) {
            PropiedadCasilla propiedadCasilla = (PropiedadCasilla) casilla;
            if (propietario != null)
                coloredConsole.error("Esta casilla ya le pertenece a alguien");
            else {
                if (precio > jugador.dinero)
                    coloredConsole.error("No tienes dinero suficiente, cuesta " + precio + " y tu tienes " + jugador.dinero);
                else {
                    jugador.dinero -= precio;
                    propietario = jugador;
                    coloredConsole.sendMessage("Has comprado la casilla: " + propiedadCasilla.getNombre());
                    propiedades.add(this);
                }
            }
        }
        else
        {
            coloredConsole.error("Esta casilla no se puede comprar");
        }
        }

    public void pagarAlquiler() {
    }

    public void desHipotecar() {
    }

}
