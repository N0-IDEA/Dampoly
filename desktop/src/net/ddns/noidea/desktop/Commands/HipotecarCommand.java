package net.ddns.noidea.desktop.Commands;

import net.ddns.fquintana.ConsoleCommands.CommandsCore.ColoredConsole;
import net.ddns.fquintana.ConsoleCommands.CommandsCore.CommandSingle;
import net.ddns.noidea.desktop.DesktopLauncher;
import net.ddns.noidea.internal.Casillas.Casilla;
import net.ddns.noidea.internal.Casillas.PropiedadCasilla;
import net.ddns.noidea.internal.Jugador;
import net.ddns.noidea.internal.Tablero;

public class HipotecarCommand  extends CommandSingle{
    public HipotecarCommand(){ super( "hipotecar", "", "Hipotecar propiedades",0); }

    @Override
    public boolean run (ColoredConsole coloredConsole, String[] strings) {
        Tablero tablero = DesktopLauncher.getDamPoly().getTablero();
        Jugador jugador = tablero.getJugadorActual();

        Casilla casilla = jugador.getCasillaActual();

        if(casilla instanceof PropiedadCasilla){
            PropiedadCasilla propiedadCasilla = (PropiedadCasilla) casilla;
            if(propiedadCasilla.propietario == null)
                coloredConsole.error("Esta propiedad no le pertenece, no puede hipotecarla ");
            else {
                propiedadCasilla.propietario = jugador;
                coloredConsole.sendMessage("Has hipotecado esta casilla " + propiedadCasilla.getNombre());
                jugador.dinero += propiedadCasilla.hipoteca;

            }

        }
        return true;
    }
}
