package net.ddns.noidea.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import net.ddns.fquintana.ConsoleCommands.Commands.HelpCommand;
import net.ddns.fquintana.ConsoleCommands.Commands.StopCommand;
import net.ddns.fquintana.ConsoleCommands.CommandsCore.CommandManager;
import net.ddns.noidea.DamPoly;
import net.ddns.noidea.desktop.Commands.DadoCommand;

public class DesktopLauncher {
    private static DamPoly damPoly;
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		damPoly = new DamPoly();
		new LwjglApplication(damPoly, config);
        CommandManager commandManager = CommandManager.getManager();
        commandManager.addCommand(new StopCommand());
        commandManager.addCommand(new HelpCommand());
        commandManager.addCommand(new DadoCommand());
        commandManager.start();

	}

    public static DamPoly getDamPoly() {
        return damPoly;
    }
}
