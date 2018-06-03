package net.ddns.noidea.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import net.ddns.fquintana.ChatColor;
import net.ddns.fquintana.ConsoleCommands.Commands.HelpCommand;
import net.ddns.fquintana.ConsoleCommands.Commands.StopCommand;
import net.ddns.fquintana.ConsoleCommands.Console.ColoredConsole;
import net.ddns.fquintana.ConsoleCommands.CommandsCore.CommandManager;
import net.ddns.noidea.DamPoly;
import net.ddns.noidea.Graphics.GameScene;
import net.ddns.noidea.desktop.Commands.*;
import net.ddns.noidea.internal.Casillas.Casilla;
import net.ddns.noidea.internal.Ficha;
import net.ddns.noidea.internal.Jugador;
import net.ddns.noidea.internal.Tablero;

import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

public class DesktopLauncher {
    private static DamPoly damPoly;
    private static CommandManager commandManager;
	public static void main (String[] arg) {
	    initCommandManager();
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 213 + GameScene.width;
		config.height = GameScene.height;
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
	    turno();
    }

    public static void turno() {
        commandManager.setValidCommands(Arrays.asList("help", "dado","hipotecar"));
        ColoredConsole coloredConsole = new ColoredConsole();
        Tablero tablero = getDamPoly().getTablero();
        Jugador jugador = tablero.getJugadorActual();
        coloredConsole.sendMessage(ChatColor.MAGENTA + "Es el turno del jugador " + tablero.getJugadorActual().getFicha().name());
        coloredConsole.sendMessage(ChatColor.MAGENTA + "Tienes : " + jugador.dinero + "$");
        coloredConsole.sendMessage("");
        coloredConsole.sendMessage(String.format("Estas en la casilla nº%d nombre: %s", jugador.getCasillaActual().getNumero(), jugador.getCasillaActual().getNombre()));
    }

    public static void alCaer() {
        ColoredConsole coloredConsole = new ColoredConsole();
        Tablero tablero = getDamPoly().getTablero();
        Jugador jugador = tablero.getJugadorActual();
        coloredConsole.sendMessage(String.format("Has caido en la casilla nº%d nombre: %s", jugador.getCasillaActual().getNumero(), jugador.getCasillaActual().getNombre()));
        commandManager.setValidCommands(Arrays.asList("help", "terminar", "comprar","hipotecar","deshipotecar"));
    }

    private static void initCommandManager() {
        commandManager = CommandManager.getManager();
        commandManager.addCommand(new StopCommand());
        commandManager.addCommand(new HelpCommand());
        commandManager.addCommand(new DadoCommand());
        commandManager.addCommand(new ConfiguraCommand());
        commandManager.addCommand(new JugarCommand());
        commandManager.addCommand(new AddJugador());
        commandManager.addCommand(new TerminarTurnoCommand());
        commandManager.addCommand(new ComprarCommand());
        commandManager.addCommand(new HipotecarCommand());
        commandManager.addCommand(new DeshipotecarCommand());
        commandManager.setRestricted(true);
        commandManager.start();
    }

    public static DamPoly getDamPoly() {
        return damPoly;
    }
}
