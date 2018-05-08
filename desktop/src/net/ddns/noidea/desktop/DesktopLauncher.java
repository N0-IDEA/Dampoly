package net.ddns.noidea.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import net.ddns.fquintana.ChatColor;
import net.ddns.fquintana.ConsoleCommands.Commands.HelpCommand;
import net.ddns.fquintana.ConsoleCommands.Commands.StopCommand;
import net.ddns.fquintana.ConsoleCommands.CommandsCore.ColoredConsole;
import net.ddns.fquintana.ConsoleCommands.CommandsCore.CommandManager;
import net.ddns.noidea.DamPoly;
import net.ddns.noidea.desktop.Commands.ConfiguraCommand;
import net.ddns.noidea.desktop.Commands.DadoCommand;
import net.ddns.noidea.desktop.Commands.JugarCommand;

import java.util.Arrays;
import java.util.Collections;

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
        coloredConsole.sendMessage("Configura el dinero inicial con el comando condigura ej(configura 10000)");
        coloredConsole.sendMessage("O si deseas empezar con la configuracion por defecto usa el comando jugar");
        commandManager.setValidCommands(Arrays.asList("help","configura", "jugar"));

	}

    private static void initCommandManager() {
        commandManager = CommandManager.getManager();
        commandManager.addCommand(new StopCommand());
        commandManager.addCommand(new HelpCommand());
        commandManager.addCommand(new DadoCommand());
        commandManager.addCommand(new ConfiguraCommand());
        commandManager.addCommand(new JugarCommand());
        commandManager.setRestricted(true);
        commandManager.start();
    }

    public static DamPoly getDamPoly() {
        return damPoly;
    }
}
