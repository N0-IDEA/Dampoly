package net.ddns.noidea.desktop.Commands;

import net.ddns.fquintana.ConsoleCommands.CommandsCore.ColoredConsole;
import net.ddns.fquintana.ConsoleCommands.CommandsCore.CommandSingle;
import net.ddns.noidea.DamPoly;
import net.ddns.noidea.Utils.MathUtils;
import net.ddns.noidea.desktop.DesktopLauncher;

public class DadoCommand extends CommandSingle {
    public DadoCommand() {
        super("Dado", "", "tira un dado", 0);
    }

    @Override
    public boolean run(ColoredConsole coloredConsole, String[] strings) {
        DamPoly damPoly = DesktopLauncher.getDamPoly();
        damPoly.getDado().setNumber(MathUtils.ramdon(1,6));
        return false;
    }
}
