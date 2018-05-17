package net.ddns.noidea.desktop.Commands;

import net.ddns.fquintana.ConsoleCommands.CommandsCore.ColoredConsole;
import net.ddns.fquintana.ConsoleCommands.CommandsCore.CommandSingle;
import net.ddns.noidea.desktop.DesktopLauncher;
import net.ddns.noidea.internal.Casillas.Casilla;
import net.ddns.noidea.internal.Casillas.PropiedadCasilla;
import net.ddns.noidea.internal.Jugador;
import net.ddns.noidea.internal.Tablero;
import java.util.ArrayList;

public class ComprarCommand extends CommandSingle {
    public ComprarCommand() {
        super("comprar", "", "Si es posible compra la propiedad", 0);
    }


    @Override
    public boolean run(ColoredConsole coloredConsole, String[] strings) {
        Tablero tablero = DesktopLauncher.getDamPoly().getTablero();
        Jugador jugador = tablero.getJugadorActual();
        propiedades = new ArrayList<Jugador>();

        Casilla casilla = jugador.getCasillaActual();


        return true;

    }
}
