package net.ddns.noidea.desktop.Commands;

import net.ddns.fquintana.ChatColor;
import net.ddns.fquintana.ConsoleCommands.CommandsCore.ColoredConsole;
import net.ddns.fquintana.ConsoleCommands.CommandsCore.CommandSingle;
import net.ddns.noidea.DamPoly;
import net.ddns.noidea.Utils.MathUtils;
import net.ddns.noidea.desktop.DesktopLauncher;
import net.ddns.noidea.internal.Tablero;

public class ConfiguraCommand extends CommandSingle {
    public ConfiguraCommand() {
        super("configura", "{dinero inicial}", "configura la partida",1);
    }

    @Override
    public boolean run(ColoredConsole coloredConsole, String[] strings) {
        Tablero tablero = DesktopLauncher.getDamPoly().getTablero();
        tablero.configurarPartida(Integer.parseInt(strings[0]));
        coloredConsole.sendMessage(ChatColor.GRAY + "El dinero inicial ahora es de: " + tablero.dineroInicial);
        return false;
    }
}
