package net.ddns.noidea.desktop.Commands;

import net.ddns.fquintana.ConsoleCommands.CommandsCore.CommandSingle;
import net.ddns.fquintana.ConsoleCommands.Console.ColoredConsole;
import net.ddns.noidea.desktop.DesktopLauncher;
import net.ddns.noidea.internal.Casillas.Casilla;
import net.ddns.noidea.internal.Casillas.PropiedadCasilla;
import net.ddns.noidea.internal.Jugador;
import net.ddns.noidea.internal.Tablero;

public class ComprarCommand extends CommandSingle {
    public ComprarCommand() {
        super("comprar", "", "Si es posible compra la propiedad", 0);
    }

    @Override
    public boolean run(ColoredConsole coloredConsole, String[] strings) {
        Tablero tablero = DesktopLauncher.getDamPoly().getTablero();
        Jugador jugador = tablero.getJugadorActual();

        Casilla casilla = jugador.getCasillaActual();

        if (casilla instanceof PropiedadCasilla) {
            PropiedadCasilla propiedadCasilla = (PropiedadCasilla) casilla;
            if (propiedadCasilla.propietario != null)
                coloredConsole.error("Esta casilla ya le pertenece a alguien");
            else {
                if (propiedadCasilla.precio > jugador.dinero)
                    coloredConsole.error("No tienes dinero suficiente, cuesta " + propiedadCasilla.precio + " y tu tienes " + jugador.dinero);
                else {
                    jugador.dinero -= propiedadCasilla.precio;
                    propiedadCasilla.propietario = jugador;
                    coloredConsole.sendMessage("Has comprado la casilla: " + propiedadCasilla.getNombre());
                }
            }
        }
        else
        {
            coloredConsole.error("Esta casilla no se puede comprar");
        }
        return true;

    }
}
