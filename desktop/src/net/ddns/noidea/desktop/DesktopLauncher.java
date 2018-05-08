package net.ddns.noidea.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import net.ddns.fquintana.ChatColor;
import net.ddns.fquintana.ConsoleCommands.Commands.HelpCommand;
import net.ddns.fquintana.ConsoleCommands.Commands.StopCommand;
import net.ddns.fquintana.ConsoleCommands.CommandsCore.ColoredConsole;
import net.ddns.fquintana.ConsoleCommands.CommandsCore.CommandManager;
import net.ddns.noidea.DamPoly;
import net.ddns.noidea.desktop.Commands.AddJugador;
import net.ddns.noidea.desktop.Commands.ConfiguraCommand;
import net.ddns.noidea.desktop.Commands.DadoCommand;
import net.ddns.noidea.desktop.Commands.JugarCommand;
import net.ddns.noidea.internal.Jugador;
import net.ddns.noidea.internal.Tablero;

import java.util.Arrays;

public class DesktopLauncher {
    private static DamPoly damPoly;
    private static CommandManager commandManager;
	public static void main (String[] arg) {
	    initCommandManager();
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		damPoly = new DamPoly();
		new LwjglApplication(damPoly, config);
        ColoredConsole coloredConsole = new ColoredConsole();
        coloredConsole.sendMessage(ChatColor.AQUA + "Bienvenido al DamPoly");
        coloredConsole.sendMessage("");
        coloredConsole.sendMessage("Añade jugadores con el comando añadirJugador, cualquier duda usa el comando help");
        coloredConsole.sendMessage("Configura el dinero inicial con el comando condigura ej(configura 10000)");
        coloredConsole.sendMessage("O si deseas empezar con la configuracion por defecto usa el comando jugar cuando hayas terminado de añadir jugadores");
        commandManager.setValidCommands(Arrays.asList("help","configura", "añadirJugador", "jugar"));
	}

	public static void iniciar() {
	    commandManager.setValidCommands(Arrays.asList("help", "dado"));
	    turno();
    }

    public static void turno() {
        ColoredConsole coloredConsole = new ColoredConsole();
        Tablero tablero = getDamPoly().getTablero();
        Jugador jugador = tablero.getJugadorActual();
        coloredConsole.sendMessage(ChatColor.MAGENTA + "Es el turno del jugador " + tablero.getJugadorActual().getFicha().name());
        coloredConsole.sendMessage("");
        coloredConsole.sendMessage(String.format("Estas en la casilla nº%d nombre: %s", jugador.getCasillaActual().getNumero(), jugador.getCasillaActual().getNombre()));
    }

    private static void initCommandManager() {
        commandManager = CommandManager.getManager();
        commandManager.addCommand(new StopCommand());
        commandManager.addCommand(new HelpCommand());
        commandManager.addCommand(new DadoCommand());
        commandManager.addCommand(new ConfiguraCommand());
        commandManager.addCommand(new JugarCommand());
        commandManager.addCommand(new AddJugador());
        commandManager.setRestricted(true);
        commandManager.start();
    }

    public static DamPoly getDamPoly() {
        return damPoly;
    }
}
