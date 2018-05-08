package net.ddns.noidea.desktop.Commands;

import net.ddns.fquintana.ConsoleCommands.CommandsCore.ColoredConsole;
import net.ddns.fquintana.ConsoleCommands.CommandsCore.CommandSingle;
import net.ddns.noidea.desktop.DesktopLauncher;
import net.ddns.noidea.internal.Casillas.PropiedadCasilla;
import net.ddns.noidea.internal.Jugador;
import net.ddns.noidea.internal.Tablero;

public class DadoCommand extends CommandSingle {
    public DadoCommand() {
        super("Dado", "", "tira un dado", 0);
    }

    @Override
    public boolean run(ColoredConsole coloredConsole, String[] strings) {
        Tablero tablero = DesktopLauncher.getDamPoly().getTablero();
        Jugador jugador = tablero.getJugadorActual();

        Integer tirada = jugador.lanzarDados();

        coloredConsole.sendMessage("Te vas a mover " + tirada + " casillas.");

        if (jugador.getCasillaActual() instanceof PropiedadCasilla) {
            PropiedadCasilla propiedadCasilla = (PropiedadCasilla) jugador.getCasillaActual();
            if (propiedadCasilla.propietario == null)
                coloredConsole.sendMessage("Esta casilla cuesta " + propiedadCasilla.precio );
            else
                coloredConsole.sendMessage("Esta casilla pertenece a " + propiedadCasilla.propietario.getFicha().name());
        }
        DesktopLauncher.alCaer();

        return false;
    }
}
