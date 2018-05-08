package net.ddns.noidea.desktop.Commands;

import net.ddns.fquintana.ConsoleCommands.CommandsCore.ColoredConsole;
import net.ddns.fquintana.ConsoleCommands.CommandsCore.CommandSingle;
import net.ddns.noidea.DamPoly;
import net.ddns.noidea.Utils.MathUtils;
import net.ddns.noidea.desktop.DesktopLauncher;

public class JugarCommand extends CommandSingle {
    public JugarCommand() {
        super("jugar", "", "Inicia la partida", 0);
    }

    @Override
    public boolean run(ColoredConsole coloredConsole, String[] strings) {
        return false;
    }
}
