package net.ddns.noidea.desktop.Commands;

import net.ddns.fquintana.ConsoleCommands.CommandsCore.ColoredConsole;
import net.ddns.fquintana.ConsoleCommands.CommandsCore.CommandSingle;
import net.ddns.noidea.desktop.DesktopLauncher;
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

        return false;
    }
}
