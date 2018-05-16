package net.ddns.noidea.desktop.Commands;

import net.ddns.fquintana.ConsoleCommands.CommandsCore.ColoredConsole;
import net.ddns.fquintana.ConsoleCommands.CommandsCore.CommandSingle;
import net.ddns.noidea.desktop.DesktopLauncher;
import net.ddns.noidea.internal.Tablero;

public class JugarCommand extends CommandSingle {
    public JugarCommand() {
        super("jugar", "", "Inicia la partida", 0);
    }

    @Override
    public boolean run(ColoredConsole coloredConsole, String[] strings) {
        Tablero tablero = DesktopLauncher.getDamPoly().getTablero();
        tablero.empezarPartida();

        if (tablero.getJugadores().size() < 2) {
            coloredConsole.error("El numero minimo de jugadores es 2");
            return false;
        }
        coloredConsole.sendMessage("Iniciando partida...");
        DesktopLauncher.iniciar();
        return true;
    }
}
