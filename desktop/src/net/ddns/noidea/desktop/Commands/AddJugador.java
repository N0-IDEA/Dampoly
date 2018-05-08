package net.ddns.noidea.desktop.Commands;

import net.ddns.fquintana.ConsoleCommands.CommandsCore.ColoredConsole;
import net.ddns.fquintana.ConsoleCommands.CommandsCore.CommandSingle;
import net.ddns.noidea.DamPoly;
import net.ddns.noidea.desktop.DesktopLauncher;
import net.ddns.noidea.internal.Ficha;
import net.ddns.noidea.internal.Jugador;
import net.ddns.noidea.internal.Tablero;

public class AddJugador extends CommandSingle {
    public AddJugador() {
        super("añadirJugador", "{ficha}", "añade jugadores", 1);
    }

    @Override
    public boolean run(ColoredConsole coloredConsole, String[] strings) {
        Ficha ficha = Ficha.fromStr(strings[0]);
        if (ficha == null) {
            coloredConsole.sendMessage("Esa ficha no existe.");
            StringBuilder stringBuilder = new StringBuilder("Las fichas disponibles son ");
            for (Ficha ficha1 : Ficha.values()) {
                stringBuilder.append(ficha1);
                stringBuilder.append(", ");
            }
            stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
            coloredConsole.sendMessage(stringBuilder.toString());
            return false;
        }
        else
        {
            DamPoly damPoly = DesktopLauncher.getDamPoly();
            Tablero tablero = damPoly.getTablero();
            boolean done = tablero.addJugador(new Jugador(ficha));
            if (done)
                coloredConsole.sendMessage("Jugador añadido con exito.");
            else
                coloredConsole.error("Ya existe un jugador con esa ficha");
            return done;
        }

    }
}
