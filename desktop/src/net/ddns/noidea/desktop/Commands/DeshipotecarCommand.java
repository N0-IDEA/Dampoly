package net.ddns.noidea.desktop.Commands;

import net.ddns.fquintana.ConsoleCommands.Console.ColoredConsole;
import net.ddns.fquintana.ConsoleCommands.CommandsCore.CommandSingle;
import net.ddns.noidea.desktop.DesktopLauncher;
import net.ddns.noidea.internal.Casillas.Casilla;
import net.ddns.noidea.internal.Casillas.PropiedadCasilla;
import net.ddns.noidea.internal.Jugador;
import net.ddns.noidea.internal.Tablero;

public class DeshipotecarCommand  extends CommandSingle{
    private static final Object HipotecarCommand = true;

    public DeshipotecarCommand(){ super( "Deshipotecar", "", "Deshipotecar propiedades",0); }

    @Override
    public boolean run (ColoredConsole coloredConsole, String[] strings) {
        Tablero tablero = DesktopLauncher.getDamPoly().getTablero();
        Jugador jugador = tablero.getJugadorActual();

        Casilla casilla = jugador.getCasillaActual();

        if(casilla instanceof PropiedadCasilla) {
            PropiedadCasilla propiedadCasilla = (PropiedadCasilla) casilla;
            coloredConsole.sendMessage("Has deshipotecado esta casilla " + propiedadCasilla.getNombre() + "  -  " + propiedadCasilla.hipoteca + "$");
            jugador.dinero -= propiedadCasilla.hipoteca;
        }else {
            PropiedadCasilla propiedadCasilla = (PropiedadCasilla) casilla;
            propiedadCasilla.propietario = jugador;
                coloredConsole.error("No puedesdeshipotecar esta casilla porque no esta previamente hipotecada" );




        }
        return true;
    }
}
