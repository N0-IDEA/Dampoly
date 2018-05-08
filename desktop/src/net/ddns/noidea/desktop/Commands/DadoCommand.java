package net.ddns.noidea.desktop.Commands;

import net.ddns.fquintana.ConsoleCommands.CommandsCore.ColoredConsole;
import net.ddns.fquintana.ConsoleCommands.CommandsCore.CommandSingle;
import net.ddns.noidea.DamPoly;
import net.ddns.noidea.desktop.DesktopLauncher;

public class DadoCommand extends CommandSingle {
    public DadoCommand() {
        super("Dado", "{numero}", "tira un dado");
    }

    @Override
    public boolean onCommand(ColoredConsole coloredConsole, String[] strings) {
        DamPoly damPoly = DesktopLauncher.getDamPoly();
        damPoly.getDado().setNumber(Integer.parseInt(strings[0]));
        return false;
    }
}
